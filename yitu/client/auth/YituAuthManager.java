package com.yitu.vms.client.auth;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * 依图 VMS 独立登录与 Token 管理器
 * 使用独立 HTTP 客户端 (RestTemplate) 发起登录，完美避开 Feign 拦截器死循环和 Spring 循环依赖。
 */
@Slf4j
@Component
public class YituAuthManager {

    @Value("${yitu.vms.base-url:http://192.168.106.23:30081}")
    private String baseUrl;

    private static final String USERNAME = "videobrain_api";
    private static final String PASSWORD = "videobrain_api@968";

    // 双重检查锁缓存
    private volatile String cachedToken = null;
    private volatile long expireTime = 0;

    // Token 缓存时长 (例如: 110分钟，略短于常见的 2 小时过期)
    private static final long CACHE_DURATION_MS = 110 * 60 * 1000L;

    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 获取有效的 bodhi_token，如果过期则重新登录
     */
    public String getValidToken() {
        if (cachedToken != null && System.currentTimeMillis() < expireTime) {
            return cachedToken;
        }
        
        synchronized (this) {
            // double-check
            if (cachedToken != null && System.currentTimeMillis() < expireTime) {
                return cachedToken;
            }
            log.info("本地 Token 已过期或不存在，准备调用独立客户端向依图进行登录授权...");
            cachedToken = fetchNewToken();
            expireTime = System.currentTimeMillis() + CACHE_DURATION_MS;
            return cachedToken;
        }
    }

    /**
     * 独立发起的登录请求
     */
    private String fetchNewToken() {
        String loginUrl = baseUrl + "/api/v1/auth/login";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, String> body = new HashMap<>();
        body.put("username", USERNAME);
        body.put("password", PASSWORD);

        HttpEntity<Map<String, String>> request = new HttpEntity<>(body, headers);

        try {
            ResponseEntity<String> response = restTemplate.postForEntity(loginUrl, request, String.class);
            if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
                JsonNode jsonNode = objectMapper.readTree(response.getBody());
                if (jsonNode.has("token")) {
                    String token = jsonNode.get("token").asText();
                    log.info("独立授权登录成功！获取到新的 bodhi_token。");
                    return token;
                }
            }
            throw new RuntimeException("登录依图失败，未获取到 Token: " + response.getBody());
        } catch (Exception e) {
            log.error("独立 HTTP 登录依图 VMS 发生异常!", e);
            throw new RuntimeException("独立授权登录依图失败: " + e.getMessage());
        }
    }
    
    /**
     * 外部可以主动调用清除缓存 (例如遇到 401 时)
     */
    public synchronized void invalidateToken() {
        this.cachedToken = null;
        this.expireTime = 0;
        log.warn("依图 Token 缓存已被强制清除。");
    }
}

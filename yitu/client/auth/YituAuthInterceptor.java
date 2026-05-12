package com.yitu.vms.client.auth;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 依图 VMS Feign 拦截器
 * 拦截所有发往依图的请求，自动向 Header 注入 bodhi_token。
 */
@Slf4j
public class YituAuthInterceptor implements RequestInterceptor {

    private final YituAuthManager authManager;

    public YituAuthInterceptor(YituAuthManager authManager) {
        this.authManager = authManager;
    }

    @Override
    public void apply(RequestTemplate template) {
        // 如果是独立的登录接口，放行 (虽然我们换成了 RestTemplate，此判断可作为双保险防止未来的 Feign 登录调用)
        if (template.url().contains("/api/v1/auth/login")) {
            return;
        }

        try {
            // 获取并注入 Token
            String token = authManager.getValidToken();
            template.header("Cookie", "bodhi_token=" + token + "; currentLanguage=cn");
            log.debug("Feign 拦截器已成功注入依图 bodhi_token: {}", token.substring(0, Math.min(10, token.length())) + "...");
        } catch (Exception e) {
            log.error("注入依图 Token 失败，请求可能会被拦截", e);
        }
    }
}

package com.yitu.vms.client.config;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yitu.vms.client.exception.YituVmsException;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StreamUtils;

import java.nio.charset.StandardCharsets;

/**
 * 依图 VMS Feign 异常解码器
 * 负责拦截非 200 的请求，解析依图的标准 ErrorResponse 并抛出业务异常。
 */
@Slf4j
public class YituFeignErrorDecoder implements ErrorDecoder {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Exception decode(String methodKey, Response response) {
        String bodyStr = "";
        try {
            if (response.body() != null) {
                bodyStr = StreamUtils.copyToString(response.body().asInputStream(), StandardCharsets.UTF_8);
                JsonNode jsonNode = objectMapper.readTree(bodyStr);
                
                Integer rtn = jsonNode.has("rtn") ? jsonNode.get("rtn").asInt() : response.status();
                String error = jsonNode.has("error") ? jsonNode.get("error").asText() : "unknown_error";
                String message = jsonNode.has("message") ? jsonNode.get("message").asText() : "调用依图接口失败";
                String requestId = jsonNode.has("request_id") ? jsonNode.get("request_id").asText() : "";
                
                log.warn("调用依图接口 {} 失败，返回状态码: {}，报文: {}", methodKey, response.status(), bodyStr);
                
                return new YituVmsException(response.status(), rtn, error, message, requestId);
            }
        } catch (Exception e) {
            log.error("反序列化依图异常报文失败, body: {}", bodyStr, e);
        }
        
        // 兜底：如果解析失败或者没有 body，走默认的异常抛出机制
        return new ErrorDecoder.Default().decode(methodKey, response);
    }
}

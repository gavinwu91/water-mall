package com.yitu.vms.client.config;

import com.yitu.vms.client.auth.YituAuthInterceptor;
import com.yitu.vms.client.auth.YituAuthManager;
import feign.Logger;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;

/**
 * 依图 VMS Feign 客户端的专属配置
 * 注意：不要在这里加 @Configuration，否则会变成全局默认配置，影响项目中其他的 FeignClient。
 */
public class YituFeignConfig {

    /**
     * 自动鉴权拦截器
     */
    @Bean
    public YituAuthInterceptor yituAuthInterceptor(YituAuthManager authManager) {
        return new YituAuthInterceptor(authManager);
    }

    /**
     * 配置使用自定义的 ErrorDecoder
     */
    @Bean
    public ErrorDecoder errorDecoder() {
        return new YituFeignErrorDecoder();
    }

    /**
     * （可选）开发调试时可以开启全量日志
     */
    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}

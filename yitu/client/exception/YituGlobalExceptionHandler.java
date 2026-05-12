package com.yitu.vms.client.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.HashMap;
import java.util.Map;

/**
 * 全局异常处理器
 * 捕获从 Feign 抛出的 YituVmsException，将其统一转换为前端可读的结构。
 * 这样您在 Service 层的代码里就不需要写任何 try-catch 了！
 */
@Slf4j
@RestControllerAdvice
public class YituGlobalExceptionHandler {

    @ExceptionHandler(YituVmsException.class)
    public Map<String, Object> handleYituVmsException(YituVmsException e) {
        log.error("拦截到依图 VMS 业务异常: rtn={}, error={}, message={}", e.getRtn(), e.getError(), e.getMessage());

        // 这里可以将依图的错误映射成你们公司自己的 BaseResponse
        // 比如：return BaseResponse.error(e.getRtn(), "依图接口报错: " + e.getMessage());
        
        // 为了演示，这里用 Map 简单返回给前端
        Map<String, Object> response = new HashMap<>();
        response.put("code", 500); // 你们系统自定义的状态码
        response.put("msg", "第三方视觉系统报错: " + e.getMessage());
        response.put("yitu_rtn", e.getRtn());
        response.put("yitu_error", e.getError());
        
        return response;
    }
}

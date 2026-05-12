package com.yitu.vms.client.exception;

import lombok.Getter;

/**
 * 依图 VMS 专属业务异常
 * 当调用依图接口返回非 2xx 状态码时，ErrorDecoder 会将其包装为该异常抛出。
 */
@Getter
public class YituVmsException extends RuntimeException {
    
    /** HTTP 状态码 (例如 400, 401, 500) */
    private final int status;
    
    /** 依图业务返回码 (例如 400) */
    private final Integer rtn;
    
    /** 依图错误代码枚举 (例如 "bad_request") */
    private final String error;
    
    /** 依图请求流水号 */
    private final String requestId;

    public YituVmsException(int status, Integer rtn, String error, String message, String requestId) {
        super(message);
        this.status = status;
        this.rtn = rtn;
        this.error = error;
        this.requestId = requestId;
    }
}

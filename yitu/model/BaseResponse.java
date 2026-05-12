package com.yitu.vms.model;

import lombok.Data;

/**
 * 依图 API 统一基础响应格式
 * 包含全局错误码 rtn 和 描述信息 message
 */
@Data
public class BaseResponse<T> {
    /**
     * 接收状态。0表示接收正常，非0表示接收异常
     */
    private Integer rtn;

    /**
     * 接收状态描述
     */
    private String message;

    /**
     * 业务数据载体
     */
    private T data;

    /**
     * 请求追踪 ID (审计用)
     */
    private String request_id;

    public boolean isSuccess() {
        return rtn != null && rtn == 0;
    }
}

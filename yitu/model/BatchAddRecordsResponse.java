package com.yitu.vms.model;

import lombok.Data;

/**
 * 批量导入记录响应
 */
@Data
public class BatchAddRecordsResponse {
    /**
     * 接收状态。0表示接收正常，非0表示接收异常
     */
    private Integer rtn;

    /**
     * 接收状态描述
     */
    private String message;

    /**
     * 成功导入数量
     */
    private Integer imported_count;

    public boolean isSuccess() {
        return rtn != null && rtn == 0;
    }
}

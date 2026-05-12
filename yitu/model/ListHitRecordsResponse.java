package com.yitu.vms.model;

import lombok.Data;
import java.util.List;

/**
 * 报警记录列表响应
 */
@Data
public class ListHitRecordsResponse {
    private Integer rtn;
    private String message;
    private List<HitRecord> hit_records;
    private Pagination pagination;

    public boolean isSuccess() {
        return rtn != null && rtn == 0;
    }
}

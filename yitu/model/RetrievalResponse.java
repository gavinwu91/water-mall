package com.yitu.vms.model;

import lombok.Data;
import java.util.List;
import java.util.Map;

/**
 * 检索响应
 */
@Data
public class RetrievalResponse {
    private Integer rtn;
    private String message;

    /**
     * 检索查询ID（用于翻页/缓存）
     */
    private Long retrieval_query_id;

    /**
     * 检索结果总数
     */
    private Integer total;

    /**
     * 检索结果列表
     */
    private List<RetrievalResultItem> results;

    /**
     * 耗时统计 (ms)
     */
    private Map<String, Integer> profiling;

    public boolean isSuccess() {
        return rtn != null && rtn == 0;
    }
}

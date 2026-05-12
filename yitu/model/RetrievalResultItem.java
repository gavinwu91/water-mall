package com.yitu.vms.model;

import lombok.Data;

/**
 * 检索结果项
 */
@Data
public class RetrievalResultItem {
    /**
     * 关联的记录信息
     */
    private CaptureFaceRecordOutput record;

    /**
     * 相似度分数 (0-100)
     */
    private Double similarity;
}

package com.yitu.vms.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * L2 动态库检索请求 - 查询过人记录/轨迹数据
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DynamicRetrievalRequest {
    /**
     * 数据类型：face（人脸）、body（人体）
     */
    private String data_type;

    /**
     * 集群 ID
     */
    private String cluster_id;

    /**
     * 特征检索参数
     */
    private RetrievalParams retrieval;

    /**
     * 分页起始位置
     */
    private Integer start;

    /**
     * 分页大小
     */
    private Integer limit;

    /**
     * 是否记录检索日志
     */
    private Boolean enable_log_query_result;
}

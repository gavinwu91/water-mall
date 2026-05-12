package com.yitu.vms.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Map;

/**
 * 搜索库请求模型
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SearchReposRequest {
    /**
     * 过滤条件，key 为字段名，value 为过滤值
     */
    private Map<String, Object> filters;

    /**
     * 页码（从1开始）
     */
    private Integer page;

    /**
     * 每页数量
     */
    private Integer limit;
}

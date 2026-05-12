package com.yitu.vms.model;

import lombok.Data;

/**
 * 分页信息模型
 */
@Data
public class Pagination {
    /**
     * 当前页码
     */
    private Integer page;

    /**
     * 每页数量
     */
    private Integer limit;

    /**
     * 总记录数
     */
    private Integer total;

    /**
     * 总页数
     */
    private Integer total_pages;

    /**
     * 是否有下一页
     */
    private Boolean has_next;
}

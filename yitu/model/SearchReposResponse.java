package com.yitu.vms.model;

import lombok.Data;
import java.util.List;

/**
 * 搜索库响应模型
 */
@Data
public class SearchReposResponse {
    /**
     * 接收状态
     */
    private Integer rtn;

    /**
     * 接收状态描述
     */
    private String message;

    /**
     * 库列表
     */
    private List<RepositoryOutput> repositories;

    /**
     * 分页信息
     */
    private Pagination pagination;

    public boolean isSuccess() {
        return rtn != null && rtn == 0;
    }
}

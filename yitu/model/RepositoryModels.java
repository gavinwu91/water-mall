package com.yitu.vms.model;

import lombok.Data;
import java.util.List;

/**
 * 库管理全量模型 (对齐 vms.json line 27269+)
 */
public class RepositoryModels {

    /**
     * 创建库的输入模型
     */
    @Data
    public static class RepositoryInput {
        private String name;
        private String comment;
        private String repo_type; // static, dynamic
        private String data_type; // face, body, vehicle
        private Integer security_level;
    }

    /**
     * 库详情返回模型
     */
    @Data
    public static class RepositoryOutput {
        private String uri;
        private String name;
        private String comment;
        private String repo_type;
        private String data_type;
        private Integer record_count;
        private String created_at;
        private String updated_at;
    }

    /**
     * 库列表响应封装
     */
    @Data
    public static class ListReposResponse {
        private List<RepositoryOutput> repositories;
        private Pagination pagination;
    }

    /**
     * 资源引用响应 (如创建库后返回的 URI)
     */
    @Data
    public static class ResourceReferenceResponse {
        private String uri;
        private String type;
    }
}

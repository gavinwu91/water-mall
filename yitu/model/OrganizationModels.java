package com.yitu.vms.model;

import lombok.Data;
import java.util.List;

/**
 * 组织架构模块 (区域、集群)
 */
public class OrganizationModels {

    @Data
    public static class RegionOutput {
        private String uri;
        private String name;
        private String parent_uri;
        private Integer level;
        private List<RegionOutput> children;
    }

    @Data
    public static class ClusterInfo {
        private String uri;
        private String name;
        private String endpoint;
        private String status;
        private String version;
    }
}

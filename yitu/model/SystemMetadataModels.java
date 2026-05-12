package com.yitu.vms.model;

import lombok.Data;
import java.util.Map;

/**
 * 系统元数据与健康检查 (对应 vms.json /api/v1/health, /api/v1/metadata)
 */
public class SystemMetadataModels {

    @Data
    public static class SystemHealth {
        private String status; // healthy, unhealthy
        private Map<String, String> services; // 各子服务状态
        private String version;
        private Long timestamp;
    }

    @Data
    public static class SystemMetadata {
        private String cluster_id;
        private String region_id;
        private Map<String, Object> capabilities; // 系统能力集
        private String license_status;
        private Long license_expiry;
    }
}

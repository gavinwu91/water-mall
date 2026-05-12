package com.yitu.vms.model;

import lombok.Data;
import java.util.List;
import java.util.Map;

/**
 * 数据集管理模块 (对应 vms.json 数据集相关接口)
 */
public class DatasetModels {

    @Data
    public static class DatasetInput {
        private String name;
        private String description;
        private String type; // train, test
        private List<String> tags;
    }

    @Data
    public static class DatasetOutput {
        private String uri;
        private String name;
        private String description;
        private String type;
        private Integer sample_count;
        private String created_at;
        private String updated_at;
    }

    @Data
    public static class DatasetSample {
        private String uri;
        private String image_uri;
        private String mark; // 标注结果
        private Map<String, Object> metadata;
    }

    @Data
    public static class ChunkUploadRequest {
        private String hash;
        private String fileName;
        private Integer chunkNo;
        private String chunkHash;
        private byte[] chunk; // 二进制分片
        private String customPath;
    }
}

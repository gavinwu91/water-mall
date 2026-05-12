package com.yitu.vms.model;

import lombok.Data;
import java.util.List;
import java.util.Map;

/**
 * 批量操作相关模型 (对应 vms.json line 12673-13197)
 */
public class BatchModels {

    @Data
    public static class BatchAddRecordsRequest {
        private List<CaptureFaceRecordInput> records;
    }

    @Data
    public static class BatchAddRecordsResponse {
        private Integer rtn;
        private String message;
        private Integer imported_count;
    }

    @Data
    public static class BatchDeleteRecordsRequest {
        private List<Long> record_ids;
    }

    @Data
    public static class BatchFeatureExtractionRequest {
        private String type; // face, body
        private List<BatchImageInput> images;
        private Map<String, Object> options;
    }

    @Data
    public static class BatchImageInput {
        private String image_id;
        private String image_data;
        private String image_url;
    }

    @Data
    public static class BatchFeatureExtractionResponse {
        private Integer rtn;
        private String message;
        private BatchFeatureExtractionData data;
    }

    @Data
    public static class BatchFeatureExtractionData {
        private List<BatchResultItem> results;
        private BatchSummary summary;
    }

    @Data
    public static class BatchResultItem {
        private String image_id;
        private Boolean success;
        private Object result; // 提取结果
        private String error;
    }

    @Data
    public static class BatchSummary {
        private Integer total;
        private Integer success;
        private Integer failed;
        private Double total_time_ms;
        private Double avg_time_ms;
    }

    @Data
    public static class BatchUpdateRecordTagsRequest {
        private List<Long> record_ids;
        private String action; // set, add, remove
        private List<Integer> tags;
    }
}

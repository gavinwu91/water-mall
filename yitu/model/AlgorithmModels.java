package com.yitu.vms.model;

import lombok.Data;
import java.util.List;
import java.util.Map;

/**
 * 算法相关模型集合 (补全版)
 */
public class AlgorithmModels {

    @Data
    public static class AlgorithmInput {
        private ResourceReference reference;
        private String uri;
        private String created_at;
        private String updated_at;
        private String type = "algorithm";
        private String name;
        private String detObj;
        private String detObjCn;
        private Integer latestVersion;
        private String status;
        private Double accuracy;
        private Long startTrainTime;
        private Long endTrainTime;
        private Long trainCostTime;
        private String publishStatus;
    }

    @Data
    public static class AlgorithmModel {
        private String uri;
        private String name;
        private String model_type;
        private String version;
        private String status;
        private String algorithm_framework;
        private Integer model_size;
        private Double accuracy;
        private List<Map<String, Object>> thresholds;
        private Map<String, Object> parameters;
        private List<String> tags;
        private String author;
        private Boolean is_public;
        private String training_dataset;
        private Map<String, Object> performance_metrics;
        private String created_at;
        private String updated_at;
    }

    @Data
    public static class AlgorithmModelListResponse {
        private Integer rtn;
        private String message;
        private List<AlgorithmModel> models;
        private Pagination pagination;
    }

    @Data
    public static class AlgorithmModelQueryRequest {
        private String name;
        private String model_type;
        private String status;
        private List<String> tags;
        private Double min_accuracy;
        private Double max_accuracy;
        private String author;
        private Boolean is_public;
        private String order_by;
        private String order_direction;
        private Integer page;
        private Integer limit;
    }

    @Data
    public static class AlgorithmResponse {
        private Integer rtn;
        private String message;
        private AlgorithmInput data;
    }
}

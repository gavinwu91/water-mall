package com.yitu.vms.model;

import lombok.Data;
import java.util.List;
import java.util.Map;

/**
 * 视觉计算任务相关模型 (对应 vms.json line 12380-12599)
 */
public class TaskModels {

    /**
     * 原子任务定义
     */
    @Data
    public static class AtomicTask {
        private String uri;
        private String name;
        private String task_model_name;
        private String description;
        private Boolean built_in;
        private List<AtomicTaskAlgorithmBinding> algorithms;
        private String status;
        private String training_duration;
        private Integer related_task_count;
        private List<Integer> tags;
        private String created_at;
        private String updated_at;
    }

    /**
     * 原子任务算法绑定
     */
    @Data
    public static class AtomicTaskAlgorithmBinding {
        private Map<String, String> algorithm;
        private Map<String, Object> parameter_overrides;
    }

    /**
     * 原子任务列表响应
     */
    @Data
    public static class AtomicTaskListResponse {
        private Integer rtn;
        private String message;
        private List<AtomicTask> tasks;
        private Pagination pagination;
    }

    /**
     * 原子任务查询请求
     */
    @Data
    public static class AtomicTaskQueryRequest {
        private String name;
        private String model_id;
        private String status;
        private Integer page;
        private Integer limit;
    }
}

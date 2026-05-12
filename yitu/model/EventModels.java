package com.yitu.vms.model;

import lombok.Data;
import java.util.List;
import java.util.Map;

/**
 * 报警事件模块
 */
public class EventModels {

    @Data
    public static class EventQueryRequest {
        private List<String> camera_uris;
        private List<String> task_uris;
        private String start_time;
        private String end_time;
        private List<Integer> event_types;
        private Integer status; // 0:未处理, 1:已处理
    }

    @Data
    public static class EventOutput {
        private String uri;
        private String event_type;
        private String event_time;
        private String camera_uri;
        private String camera_name;
        private Map<String, Object> details;
        private Integer status;
    }

    @Data
    public static class BatchUpdateEventStatusRequest {
        private List<String> event_uris;
        private Integer status;
        private String comment;
    }
}

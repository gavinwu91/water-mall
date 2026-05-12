package com.yitu.vms.model;

import lombok.Data;
import java.util.List;
import java.util.Map;

/**
 * 战法分析模块 (同行、碰撞、关联分析等)
 */
public class TacticalModels {

    @Data
    public static class TacticalRequest {
        private List<String> target_uris;
        private List<String> camera_uris;
        private String start_time;
        private String end_time;
        private Map<String, Object> params;
    }

    @Data
    public static class TacticalResponse {
        private String task_id;
        private List<Map<String, Object>> results;
    }

    @Data
    public static class AreaScreeningRequest {
        private List<String> camera_uris;
        private List<TimeRange> time_ranges;
        private List<Integer> tags;
        private String match_mode;
    }

    @Data
    public static class TimeRange {
        private String start_time;
        private String end_time;
    }
}

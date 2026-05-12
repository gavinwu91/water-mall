package com.yitu.vms.model;

import lombok.Data;
import java.util.List;

/**
 * 视觉分析与摸排相关模型 (对应 vms.json line 12131-12379)
 */
public class AnalysisModels {

    /**
     * 标注告警记录请求
     */
    @Data
    public static class AnnotateHitRecordsRequest {
        private List<String> hit_record_uris;
        private Integer annotation; // -1:不同人, 0:未标注, 1:同一人
    }

    /**
     * 标注告警记录响应
     */
    @Data
    public static class AnnotateHitRecordsResponse {
        private Integer rtn;
        private String message;
        private Integer annotated_count;
    }

    /**
     * 区域摸排请求
     */
    @Data
    public static class AreaScreeningRequest {
        private List<String> camera_list;
        private Long time_start;
        private Long time_end;
        private List<String> tag_list;
        private String tag_match_mode; // any, all
    }

    /**
     * 区域摸排响应
     */
    @Data
    public static class AreaScreeningResponse {
        private Integer rtn;
        private String message;
        private String request_id;
        private Double execution_time_ms;
        private List<AreaScreeningItem> data;
    }

    /**
     * 区域摸排结果项
     */
    @Data
    public static class AreaScreeningItem {
        private String dossier_id;
        private Integer trajectory_count;
        private Map<String, Object> dossier_info; // 档案简要信息
    }
}

package com.yitu.vms.model;

import lombok.Data;
import java.util.List;

/**
 * 特征抽取响应
 */
@Data
public class FeatureExtractionResponse {
    private Integer rtn;
    private String message;
    private FeatureExtractionData data;

    @Data
    public static class FeatureExtractionData {
        private String frame_id;
        private Double timestamp;
        private String camera_id;
        private Double processing_time_ms;
        private String task_id;
        private List<FaceResult> face_results;
        // body_results 可按需添加
    }

    public boolean isSuccess() {
        return rtn != null && rtn == 0;
    }
}

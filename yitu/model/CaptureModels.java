package com.yitu.vms.model;

import lombok.Data;
import java.util.List;
import java.util.Map;

/**
 * 抓拍记录相关属性 (对应 vms.json line 14200+)
 */
public class CaptureModels {

    /**
     * 通用抓拍记录输出
     */
    @Data
    public static class CaptureRecordOutput {
        private String uri;
        private String capture_time;
        private String camera_uri;
        private String camera_name;
        private String image_uri;
        private String thumbnail_uri;
        private Rect2D rect;
        private Double quality_score;
        private Map<String, Object> attributes; // 动态属性
    }

    /**
     * 人脸抓拍详情
     */
    @Data
    public static class FaceCaptureDetail {
        private Integer gender; // 1:男, 2:女
        private Integer age;
        private Integer mask; // 0:无, 1:有
        private Integer glass; // 0:无, 1:有
        private Integer expression;
        private Double pitch;
        private Double yaw;
        private Double roll;
    }

    /**
     * 人体抓拍详情 (对应您刚才看到的 BodyRecordCondition)
     */
    @Data
    public static class BodyCaptureDetail {
        private Integer upper_body_color;
        private Integer lower_body_color;
        private Integer bag;
        private Integer hat;
        private Integer umbrella;
        private Integer orientation;
    }
}

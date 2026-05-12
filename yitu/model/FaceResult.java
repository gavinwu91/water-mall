package com.yitu.vms.model;

import lombok.Data;

/**
 * 人脸检测与特征结果
 */
@Data
public class FaceResult {
    /**
     * 人脸坐标框
     */
    private Rect2D rect;

    /**
     * 置信度 (0-100)
     */
    private Double confidence;

    /**
     * 人脸质量分数
     */
    private Double face_quality;

    /**
     * 特征向量数据
     */
    private Feature feature;

    @Data
    public static class Feature {
        /**
         * Base64编码的特征向量（可以直接传给检索接口）
         */
        private String feature_data;
        /**
         * 特征维度
         */
        private Integer dimension;
    }
}

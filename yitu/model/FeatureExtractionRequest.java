package com.yitu.vms.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 特征抽取请求 - 从图片中检测人脸/人体并抽取特征
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FeatureExtractionRequest {
    /**
     * 抽取类型：face_det_fe（人脸）、body_det_fe（人体）
     */
    private String type;

    /**
     * 图片输入模型
     */
    private ImageInput image;

    /**
     * 相机ID（可选）
     */
    private String camera_id;

    /**
     * 帧ID（可选）
     */
    private Integer frame_id;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ImageInput {
        /**
         * Base64编码的图片数据（必须提供）
         */
        private String image_data;
    }
}

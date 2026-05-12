package com.yitu.vms.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Map;

/**
 * 检索参数（通用）
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RetrievalParams {
    /**
     * 检索图片 (Base64) - 若未提供特征，后端会尝试提取
     */
    private String image_content_base64;

    /**
     * 检索特征 (Base64) - 优先使用
     */
    private String feature_base64;

    /**
     * 多算法特征映射
     */
    private Map<String, String> rec_feature_base64;

    /**
     * 相似度阈值 (0-100)
     */
    private Double threshold;

    /**
     * 返回最多结果数
     */
    private Integer topk;
}

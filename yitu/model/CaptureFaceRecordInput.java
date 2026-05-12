package com.yitu.vms.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import java.util.Map;

/**
 * 导入静态库记录输入模型（人脸）
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CaptureFaceRecordInput {
    /**
     * 人脸特征（Base64编码）
     */
    private String face_feature_base64;

    /**
     * 多算法特征映射，key 为算法标识，value 为 Base64 编码特征
     */
    private Map<String, String> rec_feature_base64;

    /**
     * 场景图 URI
     */
    private String scene_image_uri;

    /**
     * 场景图 Base64 编码数据
     */
    private String scene_image_content_base64;

    /**
     * 人脸小图 URI
     */
    private String capture_image_uri;

    /**
     * 人脸小图 Base64 编码数据
     */
    private String capture_image_content_base64;

    /**
     * 外部数据源 ID
     */
    private String external_id;

    /**
     * 图片类型，0 表示其他，1 表示证件照
     */
    private Integer face_image_type;

    /**
     * 姓名
     */
    private String name;

    /**
     * 证件号
     */
    private String person_id;

    /**
     * 出生日期，格式 YYYY-MM-DD
     */
    private String birthday;

    /**
     * 性别，0 未知，1 男，2 女
     */
    private Integer gender;

    /**
     * 民族
     */
    private Integer nation;

    /**
     * 区域编号
     */
    private Integer region;

    /**
     * 抓拍时间戳（秒）
     */
    private Long capture_at;

    /**
     * 人员标签
     */
    private List<String> person_flag;
}

package com.yitu.vms.model;

import lombok.Data;
import java.util.List;

/**
 * 抓拍/库记录输出模型（人脸）
 */
@Data
public class CaptureFaceRecordOutput {
    /**
     * 资源全局唯一标识符
     */
    private String uri;

    /**
     * 创建时间 (ISO 8601)
     */
    private String created_at;

    /**
     * 更新时间
     */
    private String updated_at;

    /**
     * 场景图 URI/URL
     */
    private String scene_image_uri;

    /**
     * 抓拍小图 URI/URL
     */
    private String capture_image_uri;

    /**
     * 外部数据源 ID
     */
    private String external_id;

    /**
     * 记录类型 (record.face)
     */
    private String type;

    /**
     * 人脸特征 (Base64)
     */
    private String face_feature_base64;

    /**
     * 姓名
     */
    private String name;

    /**
     * 证件号
     */
    private String person_id;

    /**
     * 出生日期
     */
    private String birthday;

    /**
     * 性别 (0:未知; 1:男; 2:女)
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
     * 发型
     */
    private Integer hair_style;

    /**
     * 抓拍时间戳
     */
    private Long timestamp;
}

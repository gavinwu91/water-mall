package com.yitu.vms.model;

import lombok.Data;

/**
 * 布控报警记录模型
 */
@Data
public class HitRecord {
    /**
     * 报警 URI
     */
    private String uri;

    /**
     * 抓拍时间
     */
    private String created_at;

    /**
     * 布控任务名称
     */
    private String task_name;

    /**
     * 摄像头地址/名称
     */
    private String camera_address;

    /**
     * 抓拍时间戳
     */
    private Long timestamp;

    /**
     * 抓拍小图 URI
     */
    private String face_image_uri;

    /**
     * 场景图 URI
     */
    private String picture_uri;

    // --- 命中底库信息 ---

    /**
     * 命中的底库 URI
     */
    private String hit_repository_uri;

    /**
     * 相似度分数 (0-100)
     */
    private Double hit_similarity;

    /**
     * 命中的底库记录 URI
     */
    private String hit_record_uri;

    /**
     * 命中的姓名
     */
    private String hit_name;

    /**
     * 命中的证件号
     */
    private String hit_person_id;

    /**
     * 命中性别 (1:男, 2:女)
     */
    private Integer hit_gender;
}

package com.yitu.vms.model;

import lombok.Data;
import java.util.Date;

/**
 * 库详情输出实体
 */
@Data
public class RepositoryOutput {
    /**
     * 库的全局唯一 URI
     */
    private String uri;

    /**
     * 库 ID
     */
    private String id;

    /**
     * 库名称
     */
    private String name;

    /**
     * 备注
     */
    private String comment;

    /**
     * 库类型
     */
    private Enums.RepositoryType repo_type;

    /**
     * 数据类型
     */
    private Enums.DataType data_type;

    /**
     * 记录总数
     */
    private Integer record_count;

    /**
     * 安全级别
     */
    private String security_level;

    /**
     * 创建时间
     */
    private String created_at;

    /**
     * 更新时间
     */
    private String updated_at;
}

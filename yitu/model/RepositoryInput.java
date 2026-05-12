package com.yitu.vms.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 创建库请求实体
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RepositoryInput {
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
     * 安全级别
     */
    private String security_level;
}

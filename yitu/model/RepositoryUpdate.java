package com.yitu.vms.model;

import lombok.Data;
import java.util.Map;

/**
 * 更新库的输入模型（用于 PATCH 部分更新）
 */
@Data
public class RepositoryUpdate {
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
     * 保密等级 (A/B/C)
     */
    private String security_level;
}

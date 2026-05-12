package com.yitu.vms.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

/**
 * 布控任务创建输入模型
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SurveillanceTaskInput {
    /**
     * 任务名称
     */
    private String name;

    /**
     * 备注
     */
    private String comment;

    /**
     * 关联的布控底库 URI 列表
     */
    private List<String> repository_uris;

    /**
     * 关联的摄像头 URI 列表
     */
    private List<String> camera_uris;

    /**
     * 报警阈值 (0-100)
     */
    private Double threshold;

    /**
     * 任务优先级
     */
    private Integer priority;

    /**
     * 是否启用
     */
    private Boolean enabled;
}

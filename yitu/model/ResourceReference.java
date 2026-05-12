package com.yitu.vms.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

/**
 * 资源引用全模型
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResourceReference {
    /**
     * 资源的全局唯一标识符 (type:id@cluster_id)
     */
    private String uri;

    /**
     * 资源在集群内的唯一标识符 (局部ID)
     */
    private Object id;

    /**
     * 集群的唯一标识符
     */
    private String cluster_id;

    /**
     * 资源类型标识 (如：camera, repository 等)
     */
    private String type;
}

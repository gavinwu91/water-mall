package com.yitu.vms.model;

import lombok.Data;
import java.util.Map;

/**
 * 自然语言编排模块 (对应 vms.json /aip/v1/orchestrate)
 */
public class OrchestrationModels {

    @Data
    public static class OrchestrationRequest {
        private String text; // 自然语言描述
        private Boolean stream; // 是否流式返回
        private Map<String, Object> context; // 上下文信息
    }

    @Data
    public static class OrchestrationResponse {
        private String task_str; // 生成的任务表达式
        private String algo_desc; // 算法描述
        private Map<String, String> object_map; // 目标映射关系
    }
}

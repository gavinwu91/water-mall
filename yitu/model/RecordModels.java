package com.yitu.vms.model;

import lombok.Data;
import java.util.Map;

/**
 * 库内记录(档案)更新模型 (对应 vms.json line 31216+)
 */
public class RecordModels {

    /**
     * 单条记录更新请求 (PATCH)
     */
    @Data
    public static class UpdateRecordRequest {
        private String name;
        private String person_id;
        private String card_id;
        private String comment;
        private Map<String, Object> custom_tags;
    }
}

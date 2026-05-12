package com.yitu.vms.model;

import lombok.Data;
import java.util.List;
import java.util.Map;

/**
 * 档案库模块 (对应 vms.json line 19835+)
 */
public class DossierModels {

    @Data
    public static class DossierInput {
        private String dossier_no;
        private String dossier_type; // person, vehicle, etc.
        private String name;
        private List<String> tags;
        private Map<String, Object> metadata;
        private ResourceReference reference;
    }

    @Data
    public static class DossierOutput {
        private String uri;
        private String dossier_no;
        private String dossier_type;
        private String name;
        private List<TagOutput> tags;
        private Map<String, Object> metadata;
        private String created_at;
        private String updated_at;
    }

    @Data
    public static class DossierQueryRequest {
        private String dossier_type;
        private String dossier_no;
        private String name;
        private List<String> tags;
        private Integer page;
        private Integer limit;
    }

    @Data
    public static class TagOutput {
        private String uri;
        private String name;
        private String color;
        private String category;
    }
}

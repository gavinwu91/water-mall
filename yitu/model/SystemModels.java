package com.yitu.vms.model;

import lombok.Data;
import java.util.List;

/**
 * 系统管理模块 (用户、角色、权限)
 */
public class SystemModels {

    @Data
    public static class UserOutput {
        private String uri;
        private String username;
        private String nickname;
        private String email;
        private String phone;
        private Boolean is_active;
        private List<RoleOutput> roles;
        private String created_at;
    }

    @Data
    public static class RoleOutput {
        private String uri;
        private String name;
        private String description;
        private List<Permission> permissions;
    }

    @Data
    public static class Permission {
        private String resource_type;
        private String action; // create, read, update, delete
        private String effect; // allow, deny
    }

    @Data
    public static class LoginRequest {
        private String username;
        private String password;
    }

    @Data
    public static class LoginResponse {
        private Integer rtn;
        private String message;
        private String access_token;
        private String token_type;
    }
}

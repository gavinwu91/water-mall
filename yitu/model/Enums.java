package com.yitu.vms.model;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class Enums {

    /**
     * 库类型
     */
    @Getter
    @AllArgsConstructor
    public enum RepositoryType {
        STATIC("static", "静态库"),
        DYNAMIC("dynamic", "动态库");

        @JsonValue
        private final String value;
        private final String description;
    }

    /**
     * 数据类型
     */
    @Getter
    @AllArgsConstructor
    public enum DataType {
        FACE("face", "人脸"),
        BODY("body", "人体"),
        VEHICLE("vehicle", "车辆");

        @JsonValue
        private final String value;
        private final String description;
    }

    /**
     * 任务状态
     */
    @Getter
    @AllArgsConstructor
    public enum TaskStatus {
        PENDING(0, "等待中"),
        RUNNING(1, "运行中"),
        SUCCESS(2, "成功"),
        FAILED(3, "失败"),
        CANCELLED(4, "已取消");

        @JsonValue
        private final Integer value;
        private final String description;
    }
}

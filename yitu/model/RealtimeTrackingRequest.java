package com.yitu.vms.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

/**
 * 实时追踪请求
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RealtimeTrackingRequest {
    /**
     * 人员标识符列表 (Dossier URI 或 Record URI)
     */
    private List<String> person_uris;

    /**
     * 相机范围列表 (为空表示全局)
     */
    private List<String> camera_uris;

    /**
     * 区域范围列表
     */
    private List<String> region_uris;

    /**
     * 相似度阈值
     */
    private Double threshold;

    /**
     * 追踪任务配置
     */
    private TrackingOptions options;

    @Data
    public static class TrackingOptions {
        /**
         * 是否开启轨迹预测
         */
        private Boolean enable_prediction;
        /**
         * 是否推送实时报警
         */
        private Boolean push_realtime_alarm;
    }
}

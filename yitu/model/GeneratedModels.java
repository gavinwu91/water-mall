package com.yitu.vms.model;



import lombok.Data;

import lombok.NoArgsConstructor;

import lombok.AllArgsConstructor;

import com.fasterxml.jackson.annotation.JsonProperty;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.List;

import java.util.Map;



public class GeneratedModels {

    /** 操作类型枚举 */
    public enum ActionEnum {
        CREATE("create"),
        READ("read"),
        UPDATE("update"),
        DELETE("delete");

        private final Object value;
        ActionEnum(Object value) { this.value = value; }
        @JsonValue
        public Object getValue() { return value; }
    }

    /** 算法资源  算法是模型的定义，包含检测目标、版本等元信息。 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AlgorithmInput {
        private ResourceReferenceFull reference;
        /** 资源全局唯一标识符（type:id@cluster_id） */
        private String uri;
        @JsonProperty("created_at")
        private String createdAt;
        @JsonProperty("updated_at")
        private String updatedAt;
        /** 资源类型标识（如：camera、region、repository 等） */
        private String type;
        /** 算法名称 */
        private String name;
        /** 检测对象标识 */
        private String detObj;
        /** 检测对象中文名 */
        private String detObjCn;
        /** 最新版本号 */
        private Integer latestVersion;
        /** 训练状态（UN_TRAIN/TRAINING/TRAINED/TRAIN_FAILED） */
        private String status;
        /** 模型准确率/质量评分（0-1） */
        private Double accuracy;
        /** 训练开始时间戳（毫秒） */
        private Integer startTrainTime;
        /** 训练结束时间戳（毫秒），即最后更新时间 */
        private Integer endTrainTime;
        /** 训练耗时（毫秒） */
        private Integer trainCostTime;
        /** 发布状态（UN_PUBLISH/PUBLISHING/PUBLISHED） */
        private String publishStatus;
    }

    /** 算法资源  算法是模型的定义，包含检测目标、版本等元信息。 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AlgorithmOutput {
        /** 资源全局唯一标识符（type:id@cluster_id） */
        private String uri;
        @JsonProperty("created_at")
        private String createdAt;
        @JsonProperty("updated_at")
        private String updatedAt;
        /** 资源类型标识（如：camera、region、repository 等） */
        private String type;
        /** 算法名称 */
        private String name;
        /** 检测对象标识 */
        private String detObj;
        /** 检测对象中文名 */
        private String detObjCn;
        /** 最新版本号 */
        private Integer latestVersion;
        /** 训练状态（UN_TRAIN/TRAINING/TRAINED/TRAIN_FAILED） */
        private String status;
        /** 模型准确率/质量评分（0-1） */
        private Double accuracy;
        /** 训练开始时间戳（毫秒） */
        private Integer startTrainTime;
        /** 训练结束时间戳（毫秒），即最后更新时间 */
        private Integer endTrainTime;
        /** 训练耗时（毫秒） */
        private Integer trainCostTime;
        /** 发布状态（UN_PUBLISH/PUBLISHING/PUBLISHED） */
        private String publishStatus;
    }

    /** 算法数据集列表响应 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AlgorithmDatasetListResponse {
        /** 接收状态。0表示接收正常，非0表示接收异常 */
        private Integer rtn;
        /** 接收状态描述 */
        private String message;
        /** 数据集列表 */
        private List<TrainDatasetRef> data;
    }

    /** 算法数据集引用 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AlgorithmDatasetRef {
        /** 算法 URI */
        private String uri;
        /** 算法ID */
        private String id;
        /** 算法名称 */
        private String name;
        /** 算法版本 */
        private Integer version;
        /** 训练数据集 */
        private List<TrainDatasetRef> trainDatasets;
        /** 测试数据集 */
        private List<TrainDatasetRef> testDatasets;
    }

    /** 检查模型包请求 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AlgorithmImportCheckRequest {
        /** 文件 MD5 */
        private String hash;
        /** 文件名 */
        private String fileName;
        /** 模型类型 */
        private String modelType;
    }

    /** 导入模型包请求 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AlgorithmImportRequest {
        /** 文件 MD5 */
        private String hash;
        /** 文件名 */
        private String fileName;
        /** 目标算法 */
        private String algorithmUri;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AlgorithmModel {
        private String uri;
        private String name;
        @JsonProperty("model_type")
        private String modelType;
        private String version;
        private String status;
        @JsonProperty("algorithm_framework")
        private String algorithmFramework;
        @JsonProperty("model_size")
        private Integer modelSize;
        private Double accuracy;
        private List<ModelThreshold> thresholds;
        private Object parameters;
        private List<String> tags;
        private String author;
        @JsonProperty("is_public")
        private Boolean isPublic;
        @JsonProperty("training_dataset")
        private String trainingDataset;
        @JsonProperty("performance_metrics")
        private Object performanceMetrics;
        @JsonProperty("created_at")
        private String createdAt;
        @JsonProperty("updated_at")
        private String updatedAt;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AlgorithmModelListResponse {
        /** 接收状态。0表示接收正常，非0表示接收异常 */
        private Integer rtn;
        /** 接收状态描述 */
        private String message;
        private List<AlgorithmModel> models;
        private Pagination pagination;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AlgorithmModelQueryRequest {
        private String name;
        @JsonProperty("model_type")
        private String modelType;
        private String status;
        private List<String> tags;
        @JsonProperty("min_accuracy")
        private Double minAccuracy;
        @JsonProperty("max_accuracy")
        private Double maxAccuracy;
        private String author;
        @JsonProperty("is_public")
        private Boolean isPublic;
        @JsonProperty("order_by")
        private String orderBy;
        @JsonProperty("order_direction")
        private String orderDirection;
        private Integer page;
        private Integer limit;
    }

    /** 算法响应 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AlgorithmResponse {
        /** 接收状态。0表示接收正常，非0表示接收异常 */
        private Integer rtn;
        /** 接收状态描述 */
        private String message;
        /** 算法详情 */
        private AlgorithmOutput data;
    }

    /** 标注告警记录请求 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AnnotateHitRecordsRequest {
        /** 告警记录URI列表 */
        @JsonProperty("hit_record_uris")
        private List<String> hitRecordUris;
        /** 标注结果（-1:不同人，0:未标注，1:同一人） */
        private Integer annotation;
    }

    /** 标注告警记录响应 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AnnotateHitRecordsResponse {
        /** 接收状态。0表示接收正常，非0表示接收异常 */
        private Integer rtn;
        /** 接收状态描述 */
        private String message;
        /** 成功标注的数量 */
        @JsonProperty("annotated_count")
        private Integer annotatedCount;
    }

    /** 标注项 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AnnotationItem {
        /** 样本 ID */
        private String id;
        private AnnotationLabel mark;
    }

    /** 标注标签 */
    public enum AnnotationLabel {
        __("正例"),
        __("负例"),
        ____("无法判断"),
        _____("非检测对象");

        private final Object value;
        AnnotationLabel(Object value) { this.value = value; }
        @JsonValue
        public Object getValue() { return value; }
    }

    /** 区域摸排结果项  表示一个在指定区域和时间范围内符合标签条件的人员 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AreaScreeningItem {
        /** 档案 ID */
        @JsonProperty("dossier_id")
        private String dossierId;
        /** 轨迹数量（在查询范围内的出现次数） */
        @JsonProperty("trajectory_count")
        private Integer trajectoryCount;
        /** 档案详细信息 */
        @JsonProperty("dossier_info")
        private DossierInfo dossierInfo;
    }

    /** 区域摸排请求  功能：在指定区域（camera_list）和时间范围内，筛选符合标签条件的人员  字段说明： - camera_list: 地点列表（Gateway 使用 URI 格式，转换后为 ID） - time_start/time_end: 时间范围（Unix 秒） - tag_list: 标签列表 - tag_match_mode: 标签匹配模式（any=任一匹配，all=全部匹配） */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AreaScreeningRequest {
        /** 地点 URI 列表，最多 100 个 */
        @JsonProperty("camera_list")
        private List<String> cameraList;
        /** 开始时间（Unix 秒） */
        @JsonProperty("time_start")
        private Integer timeStart;
        /** 结束时间（Unix 秒） */
        @JsonProperty("time_end")
        private Integer timeEnd;
        /** 标签列表，最多 20 个 */
        @JsonProperty("tag_list")
        private List<String> tagList;
        /** 匹配模式：any（任一匹配）或 all（全部匹配） */
        @JsonProperty("tag_match_mode")
        private String tagMatchMode;
    }

    /** 区域摸排响应  data 字段为符合条件的人员列表 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AreaScreeningResponse {
        /** 接收状态。0表示接收正常，非0表示接收异常 */
        private Integer rtn;
        /** 接收状态描述 */
        private String message;
        /** 请求追踪 ID */
        @JsonProperty("request_id")
        private String requestId;
        /** 执行耗时（毫秒） */
        @JsonProperty("execution_time_ms")
        private Double executionTimeMs;
        /** 摸排结果列表 */
        private List<AreaScreeningItem> data;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AtomicTask {
        private String uri;
        private String name;
        @JsonProperty("task_model_name")
        private String taskModelName;
        private String description;
        /** 是否内置任务（VisionFlow atomicTaskMeta.buildIn） */
        @JsonProperty("built_in")
        private Boolean builtIn;
        private List<AtomicTaskAlgorithmBinding> algorithms;
        private String status;
        @JsonProperty("training_duration")
        private String trainingDuration;
        @JsonProperty("related_task_count")
        private Integer relatedTaskCount;
        private List<Integer> tags;
        @JsonProperty("created_at")
        private String createdAt;
        @JsonProperty("updated_at")
        private String updatedAt;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AtomicTaskAlgorithmBinding {
        private Object algorithm;
        @JsonProperty("parameter_overrides")
        private Object parameterOverrides;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AtomicTaskListResponse {
        /** 接收状态。0表示接收正常，非0表示接收异常 */
        private Integer rtn;
        /** 接收状态描述 */
        private String message;
        private List<AtomicTask> tasks;
        private Pagination pagination;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AtomicTaskQueryRequest {
        private String name;
        @JsonProperty("model_id")
        private String modelId;
        private String status;
        /** 标签过滤，传入权限标签ID */
        private List<Integer> tags;
        @JsonProperty("order_by")
        private String orderBy;
        @JsonProperty("order_direction")
        private String orderDirection;
        private Integer page;
        private Integer limit;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BasicResponse {
        /** 接收状态。0表示接收正常，非0表示接收异常 */
        private Integer rtn;
        /** 接收状态描述 */
        private String message;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BatchAddRecordsRequest {
        /** 待导入记录列表 */
        private List<CaptureFaceRecordInput2> records;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BatchAddRecordsResponse {
        /** 接收状态。0表示接收正常，非0表示接收异常 */
        private Integer rtn;
        /** 接收状态描述 */
        private String message;
        /** 成功导入数量 */
        @JsonProperty("imported_count")
        private Integer importedCount;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BatchDeleteRecordsRequest {
        /** 需要删除的记录 ID 列表 */
        @JsonProperty("record_ids")
        private List<Integer> recordIds;
    }

    /** 批量事件状态更新请求 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BatchEventStatusUpdateRequest {
        /** 事件 URI 列表 */
        @JsonProperty("event_uris")
        private List<String> eventUris;
        /** 新状态 */
        private EventStatus status;
        /** 备注信息 */
        private String remark;
    }

    /** 批量特征抽取响应数据 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BatchFeatureExtractionDataInput {
        private List<BatchResultItemInput> results;
        private BatchSummary summary;
    }

    /** 批量特征抽取响应数据 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BatchFeatureExtractionDataOutput {
        private List<BatchResultItemOutput> results;
        private BatchSummary summary;
    }

    /** 批量特征抽取选项 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BatchFeatureExtractionOptions {
        /** 最大检测目标数 */
        @JsonProperty("max_object_num")
        private Integer maxObjectNum;
        /** 选择策略: center_point, largest */
        @JsonProperty("select_policy")
        private String selectPolicy;
        /** 最小人脸尺寸 */
        @JsonProperty("min_face_size")
        private Integer minFaceSize;
        /** 检测阈值 */
        private Double threshold;
        /** 是否并行处理 */
        private Boolean parallel;
        /** 是否快速失败（遇到错误立即返回） */
        @JsonProperty("fail_fast")
        private Boolean failFast;
    }

    /** 批量特征抽取请求 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BatchFeatureExtractionRequest {
        /** 抽取类型 */
        private FeatureExtractionType type;
        /** 图片列表 */
        private List<BatchImageInput> images;
        /** 选项配置 */
        private BatchFeatureExtractionOptions options;
    }

    /** 批量特征抽取响应 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BatchFeatureExtractionResponse {
        private String message;
        private Integer rtn;
        private BatchFeatureExtractionDataOutput data;
    }

    /** 批量图片输入 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BatchImageInput {
        /** 图片标识符 */
        @JsonProperty("image_id")
        private String imageId;
        /** Base64编码的图片数据 */
        @JsonProperty("image_data")
        private String imageData;
        /** 图片URL */
        @JsonProperty("image_url")
        private String imageUrl;
    }

    /** 批量处理单个结果 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BatchResultItemInput {
        @JsonProperty("image_id")
        private String imageId;
        private Boolean success;
        private FeatureExtractionDataInput result;
        private String error;
    }

    /** 批量处理单个结果 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BatchResultItemOutput {
        @JsonProperty("image_id")
        private String imageId;
        private Boolean success;
        private FeatureExtractionDataOutput result;
        private String error;
    }

    /** 批量处理汇总 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BatchSummary {
        private Integer total;
        private Integer success;
        private Integer failed;
        @JsonProperty("total_time_ms")
        private Double totalTimeMs;
        @JsonProperty("avg_time_ms")
        private Double avgTimeMs;
    }

    /** 批量更新记录标签请求 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BatchUpdateRecordTagsRequest {
        /** 要更新的记录 ID 列表 */
        @JsonProperty("record_ids")
        private List<Integer> recordIds;
        /** 操作类型：set(覆盖), add(追加), remove(移除) */
        private TagAction action;
        /** 标签 ID 列表 */
        private List<Integer> tags;
    }

    /** 批量上传响应 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BatchUploadResponse {
        /** 接收状态。0表示接收正常，非0表示接收异常 */
        private Integer rtn;
        /** 接收状态描述 */
        private String message;
        /** 批量上传结果 */
        private Object data;
    }

    /** 人体记录过滤条件  支持的字段分类： - 基础识别：gender, age_code - 上衣属性：upper_body_color, coat_length, coat_texture - 下衣属性：lower_body_color, trousers_length, trousers_texture - 配饰：bag, handbag, hat, glass, mask - 行为/状态：umbrella, hold_child, orientation, hair_style, calling - 其他外观/行为：helmet, sunglass, occlusion, multipeople, upperbody_style, ur - 时间条件：created_at_start/end */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BodyRecordCondition {
        /** 性别：0=未知，1=男，2=女 */
        private Integer gender;
        /** 年龄段：-1=未知，0=小孩，1=青年，2=中年，3=老年 */
        @JsonProperty("age_code")
        private Integer ageCode;
        /** 上衣颜色编码：-1=未知，其他值表示具体颜色编码 */
        @JsonProperty("upper_body_color")
        private Integer upperBodyColor;
        /** 上衣长度：-1=未知，0=长袖，1=短袖 */
        @JsonProperty("coat_length")
        private Integer coatLength;
        /** 上衣纹理：-1=未知，0=条纹，1=格子，2=花纹，3=纯色 */
        @JsonProperty("coat_texture")
        private Integer coatTexture;
        /** 下衣颜色编码：-1=未知，其他值表示具体颜色编码 */
        @JsonProperty("lower_body_color")
        private Integer lowerBodyColor;
        /** 下衣长度：-1=未知，0=短裤/裙，1=长裤/裙，2=短裙，3=长裙 */
        @JsonProperty("trousers_length")
        private Integer trousersLength;
        /** 下衣纹理：-1=未知，0=纯色，1=条纹，2=格子 */
        @JsonProperty("trousers_texture")
        private Integer trousersTexture;
        /** 背包：-1=未知，0=无，1=有 */
        private Integer bag;
        /** 手提包：-1=未知，0=无，1=有 */
        private Integer handbag;
        /** 帽子：-1=未知，0=无，1=有 */
        private Integer hat;
        /** 眼镜：-1=未知，0=无，1=有 */
        private Integer glass;
        /** 口罩：-1=未知，0=无，1=有 */
        private Integer mask;
        /** 打伞：-1=未知，0=无，1=有 */
        private Integer umbrella;
        /** 抱小孩：-1=未知，0=无，1=有 */
        @JsonProperty("hold_child")
        private Integer holdChild;
        /** 朝向：-1=未知，0=前，1=后，2=侧，3=侧后 */
        private Integer orientation;
        /** 发型：-1=未知，0=长发，1=短发，2=光头 */
        @JsonProperty("hair_style")
        private Integer hairStyle;
        /** 打电话：-1=未知，0=无，1=有 */
        private Integer calling;
        /** 遮挡：-1=未知，0=无，1=有 */
        private Integer occlusion;
        /** 多人：-1=未知，0=否，1=是 */
        private Integer multipeople;
        /** 头盔：-1=未知，0=无，1=有 */
        private Integer helmet;
        /** 太阳镜：-1=未知，0=无，1=有 */
        private Integer sunglass;
        /** 上衣风格/纹理编码：-1=未知，其余为算法编码 */
        @JsonProperty("upperbody_style")
        private Integer upperbodyStyle;
        /** 有关民族：-1=未知，0=非，1=是 */
        private Integer ur;
        /** 创建开始时间（ISO 8601格式，如：2024-01-01T00:00:00Z） */
        @JsonProperty("created_at_start")
        private String createdAtStart;
        /** 创建结束时间（ISO 8601格式，如：2024-01-31T23:59:59Z） */
        @JsonProperty("created_at_end")
        private String createdAtEnd;
    }

    /** 人体检测结果 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BodyResult {
        private Rect2D rect;
        /** 置信度，内部RPC返回0-1，API返回0-100 */
        private Double confidence;
        @JsonProperty("track_id")
        private String trackId;
        @JsonProperty("entity_id")
        private String entityId;
        private Feature feature;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BodyUploadFileChunkApiV1DatasetsDatasetUriFilesChunksPost {
        /** 文件 MD5 */
        private String hash;
        /** 文件名 */
        private String fileName;
        /** 分片序号 */
        private Integer chunkNo;
        /** 分片 MD5 */
        private String chunkHash;
        /** 分片内容 */
        private String chunk;
        /** 自定义路径 */
        private String customPath;
        /** 不使用 hash 前缀 */
        private Boolean noHashPre;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BodyUploadImageToDatasetApiV1DatasetsDatasetUriSamplesUploadImagePost {
        /** 图片文件 */
        private String image;
        /** 标注标签：正例/负例/无法判断/非检测对象 */
        private String mark;
        /** 样本 ID，不填则自动生成 */
        @JsonProperty("sample_id")
        private String sampleId;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BodyUploadImagesToDatasetApiV1DatasetsDatasetUriSamplesUploadImagesPost {
        /** 图片文件列表（支持多个） */
        private List<String> images;
    }

    /** 摄像头资源模型  继承自 StandardResourceBase，包含 reference、created_at、updated_at 等基础字段。 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CameraInput {
        private ResourceReferenceFull reference;
        /** 资源全局唯一标识符（type:id@cluster_id） */
        private String uri;
        @JsonProperty("created_at")
        private String createdAt;
        @JsonProperty("updated_at")
        private String updatedAt;
        /** 摄像头名称 */
        private String name;
        /** 摄像头编码 */
        private String code;
        private CameraStatus status;
        /** 视频流地址 */
        @JsonProperty("stream_url")
        private String streamUrl;
        /** 快照地址 */
        @JsonProperty("snapshot_url")
        private String snapshotUrl;
        /** 视频回放地址 */
        @JsonProperty("playback_url")
        private String playbackUrl;
        private Location location;
        /** 所属区域名称 */
        @JsonProperty("region_name")
        private String regionName;
        @JsonProperty("location_type")
        private LocationType locationType;
        @JsonProperty("device_type")
        private Integer deviceType;
        /** 摄像机类型 */
        @JsonProperty("camera_type")
        private Integer cameraType;
        @JsonProperty("checkpoint_type")
        private CheckpointType checkpointType;
        @JsonProperty("identification_type")
        private IdentificationType identificationType;
        /** 昨日抓拍数量 */
        @JsonProperty("yesterday_capture_count")
        private Integer yesterdayCaptureCount;
        /** 取流地址（RTSP/HTTP等） */
        @JsonProperty("stream_address")
        private String streamAddress;
        /** 设备IP地址 */
        @JsonProperty("device_ip")
        private String deviceIp;
        @JsonProperty("transport_protocol")
        private TransportProtocol transportProtocol;
        /** 终端设备国标编码 */
        @JsonProperty("terminal_gb_code")
        private String terminalGbCode;
        /** 平台国标编码 */
        @JsonProperty("platform_gb_code")
        private String platformGbCode;
        private Resolution resolution;
        /** 边缘设备ID */
        @JsonProperty("edge_device_id")
        private String edgeDeviceId;
        @JsonProperty("point_type")
        private PointType pointType;
        /** 管理单位名称 */
        @JsonProperty("management_unit")
        private String managementUnit;
        /** 建设单位名称 */
        @JsonProperty("construction_unit")
        private String constructionUnit;
        /** 管理人员姓名 */
        @JsonProperty("manager_name")
        private String managerName;
        /** 联系方式（电话/邮箱等） */
        @JsonProperty("contact_info")
        private String contactInfo;
        /** 公安机关代码 */
        @JsonProperty("police_org_code")
        private String policeOrgCode;
        /** 公安机构名称 */
        @JsonProperty("police_org_name")
        private String policeOrgName;
        /** 权限标签ID列表 */
        private List<Integer> tags;
        /** 附加自定义信息列表 */
        @JsonProperty("additional_info")
        private List<Object> additionalInfo;
        /** 自定义元数据 */
        private Object metadata;
    }

    /** 摄像头资源模型  继承自 StandardResourceBase，包含 reference、created_at、updated_at 等基础字段。 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CameraOutput {
        /** 资源全局唯一标识符（type:id@cluster_id） */
        private String uri;
        @JsonProperty("created_at")
        private String createdAt;
        @JsonProperty("updated_at")
        private String updatedAt;
        /** 摄像头名称 */
        private String name;
        /** 摄像头编码 */
        private String code;
        private CameraStatus status;
        /** 视频流地址 */
        @JsonProperty("stream_url")
        private String streamUrl;
        /** 快照地址 */
        @JsonProperty("snapshot_url")
        private String snapshotUrl;
        /** 视频回放地址 */
        @JsonProperty("playback_url")
        private String playbackUrl;
        private Location location;
        /** 所属区域名称 */
        @JsonProperty("region_name")
        private String regionName;
        @JsonProperty("location_type")
        private LocationType locationType;
        @JsonProperty("device_type")
        private Integer deviceType;
        /** 摄像机类型 */
        @JsonProperty("camera_type")
        private Integer cameraType;
        @JsonProperty("checkpoint_type")
        private CheckpointType checkpointType;
        @JsonProperty("identification_type")
        private IdentificationType identificationType;
        /** 昨日抓拍数量 */
        @JsonProperty("yesterday_capture_count")
        private Integer yesterdayCaptureCount;
        /** 取流地址（RTSP/HTTP等） */
        @JsonProperty("stream_address")
        private String streamAddress;
        /** 设备IP地址 */
        @JsonProperty("device_ip")
        private String deviceIp;
        @JsonProperty("transport_protocol")
        private TransportProtocol transportProtocol;
        /** 终端设备国标编码 */
        @JsonProperty("terminal_gb_code")
        private String terminalGbCode;
        /** 平台国标编码 */
        @JsonProperty("platform_gb_code")
        private String platformGbCode;
        private Resolution resolution;
        /** 边缘设备ID */
        @JsonProperty("edge_device_id")
        private String edgeDeviceId;
        @JsonProperty("point_type")
        private PointType pointType;
        /** 管理单位名称 */
        @JsonProperty("management_unit")
        private String managementUnit;
        /** 建设单位名称 */
        @JsonProperty("construction_unit")
        private String constructionUnit;
        /** 管理人员姓名 */
        @JsonProperty("manager_name")
        private String managerName;
        /** 联系方式（电话/邮箱等） */
        @JsonProperty("contact_info")
        private String contactInfo;
        /** 公安机关代码 */
        @JsonProperty("police_org_code")
        private String policeOrgCode;
        /** 公安机构名称 */
        @JsonProperty("police_org_name")
        private String policeOrgName;
        /** 权限标签ID列表 */
        private List<Integer> tags;
        /** 附加自定义信息列表 */
        @JsonProperty("additional_info")
        private List<Object> additionalInfo;
        /** 自定义元数据 */
        private Object metadata;
    }

    /** 创建摄像头请求 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CameraCreate {
        /** 摄像头名称 */
        private String name;
        /** 摄像头编码 */
        private String code;
        /** 视频流地址 */
        @JsonProperty("stream_url")
        private String streamUrl;
        /** 快照地址 */
        @JsonProperty("snapshot_url")
        private String snapshotUrl;
        /** 视频回放地址 */
        @JsonProperty("playback_url")
        private String playbackUrl;
        /** 地理位置信息 */
        private Location location;
        /** 所属区域ID */
        @JsonProperty("region_id")
        private Integer regionId;
        /** 所属区域名称 */
        @JsonProperty("region_name")
        private String regionName;
        /** 设备类型 */
        @JsonProperty("device_type")
        private Integer deviceType;
        /** 摄像机类型 */
        @JsonProperty("camera_type")
        private Integer cameraType;
        /** 卡口类型: unknown, face, security */
        @JsonProperty("checkpoint_type")
        private CheckpointType checkpointType;
        /** 识别内容类型: 0=人像, 1=人体, 2=人像+人体, 3=车牌, 6=非机动车, 8=人脸, 13=综合, 14=其他 */
        @JsonProperty("identification_type")
        private IdentificationType identificationType;
        /** 设备IP地址 */
        @JsonProperty("device_ip")
        private String deviceIp;
        /** 传输协议: UDP, TCP */
        @JsonProperty("transport_protocol")
        private TransportProtocol transportProtocol;
        /** 边缘设备ID */
        @JsonProperty("edge_device_id")
        private String edgeDeviceId;
        /** 权限标签ID列表（必填，至少一个）。通过 GET /api/v1/tags?resource_type=camera 获取可用标签，使用返回的 uri 中的 ID（如 tag:1@xxx 则填 1） */
        private List<Integer> tags;
        /** 分辨率: 720P, 1080P, 540*960/540960, 1440*2560/14402560, 2160*3840 */
        private Resolution resolution;
        /** 点位类型: entrance, corridor, parking, perimeter, lobby, office */
        @JsonProperty("point_type")
        private PointType pointType;
        /** 位置类型: indoor, outdoor, semi_outdoor */
        @JsonProperty("location_type")
        private LocationType locationType;
        /** 终端国标编码 */
        @JsonProperty("terminal_gb_code")
        private String terminalGbCode;
        /** 平台国标编码 */
        @JsonProperty("platform_gb_code")
        private String platformGbCode;
        /** 管理单位 */
        @JsonProperty("management_unit")
        private String managementUnit;
        /** 建设单位 */
        @JsonProperty("construction_unit")
        private String constructionUnit;
        /** 管理员姓名 */
        @JsonProperty("manager_name")
        private String managerName;
        /** 联系方式 */
        @JsonProperty("contact_info")
        private String contactInfo;
        /** 公安机关代码 */
        @JsonProperty("police_org_code")
        private String policeOrgCode;
        /** 公安机关名称 */
        @JsonProperty("police_org_name")
        private String policeOrgName;
        /** 附加自定义信息列表 */
        @JsonProperty("additional_info")
        private List<Object> additionalInfo;
        /** 其他自定义元数据 */
        private Object metadata;
    }

    /** 摄像头查询响应 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CameraResponse {
        /** 接收状态。0表示接收正常，非0表示接收异常 */
        private Integer rtn;
        /** 接收状态描述 */
        private String message;
        /** 摄像头详情 */
        private CameraOutput camera;
        /** 摄像头列表 */
        private List<CameraOutput> cameras;
        /** 分页信息 */
        private Pagination pagination;
    }

    /** 摄像头排序字段  - name: 名称 - type: 设备类型 - region_id: 区域 - checkpoint_type: 卡口类型 - identification_type: 识别内容 - enabled: 运行情况 - updated_at: 更新时间 */
    public enum CameraSortField {
        NAME("name"),
        TYPE("type"),
        REGION_ID("region_id"),
        CHECKPOINT_TYPE("checkpoint_type"),
        IDENTIFICATION_TYPE("identification_type"),
        ENABLED("enabled"),
        UPDATED_AT("updated_at");

        private final Object value;
        CameraSortField(Object value) { this.value = value; }
        @JsonValue
        public Object getValue() { return value; }
    }

    /** 摄像头状态  - active: 正常使用 - inactive: 已禁用 - trashed: 回收站 */
    public enum CameraStatus {
        ACTIVE("active"),
        INACTIVE("inactive"),
        TRASHED("trashed");

        private final Object value;
        CameraStatus(Object value) { this.value = value; }
        @JsonValue
        public Object getValue() { return value; }
    }

    /** 更新摄像头请求 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CameraUpdate {
        /** 摄像头名称 */
        private String name;
        /** 摄像头编码 */
        private String code;
        /** 摄像头状态: active, inactive, trashed */
        private String status;
        /** 视频流地址 */
        @JsonProperty("stream_url")
        private String streamUrl;
        /** 快照地址 */
        @JsonProperty("snapshot_url")
        private String snapshotUrl;
        /** 视频回放地址 */
        @JsonProperty("playback_url")
        private String playbackUrl;
        /** 地理位置信息 */
        private Location location;
        /** 所属区域ID */
        @JsonProperty("region_id")
        private Integer regionId;
        /** 所属区域名称 */
        @JsonProperty("region_name")
        private String regionName;
        /** 设备类型 */
        @JsonProperty("device_type")
        private Integer deviceType;
        /** 摄像机类型 */
        @JsonProperty("camera_type")
        private Integer cameraType;
        /** 卡口类型: unknown, face, security */
        @JsonProperty("checkpoint_type")
        private CheckpointType checkpointType;
        /** 识别内容类型: 0=人像, 1=人体, 2=人像+人体, 3=车牌, 6=非机动车, 8=人脸, 13=综合, 14=其他 */
        @JsonProperty("identification_type")
        private IdentificationType identificationType;
        /** 设备IP地址 */
        @JsonProperty("device_ip")
        private String deviceIp;
        /** 传输协议: UDP, TCP */
        @JsonProperty("transport_protocol")
        private TransportProtocol transportProtocol;
        /** 边缘设备ID */
        @JsonProperty("edge_device_id")
        private String edgeDeviceId;
        /** 权限标签ID列表。通过 GET /api/v1/tags?resource_type=camera 获取可用标签，使用返回的 uri 中的 ID（如 tag:1@xxx 则填 1） */
        private List<Integer> tags;
        /** 分辨率: 720P, 1080P, 540*960/540960, 1440*2560/14402560, 2160*3840 */
        private Resolution resolution;
        /** 点位类型: entrance, corridor, parking, perimeter, lobby, office */
        @JsonProperty("point_type")
        private PointType pointType;
        /** 位置类型: indoor, outdoor, semi_outdoor */
        @JsonProperty("location_type")
        private LocationType locationType;
        /** 终端国标编码 */
        @JsonProperty("terminal_gb_code")
        private String terminalGbCode;
        /** 平台国标编码 */
        @JsonProperty("platform_gb_code")
        private String platformGbCode;
        /** 管理单位 */
        @JsonProperty("management_unit")
        private String managementUnit;
        /** 建设单位 */
        @JsonProperty("construction_unit")
        private String constructionUnit;
        /** 管理员姓名 */
        @JsonProperty("manager_name")
        private String managerName;
        /** 联系方式 */
        @JsonProperty("contact_info")
        private String contactInfo;
        /** 公安机关代码 */
        @JsonProperty("police_org_code")
        private String policeOrgCode;
        /** 公安机关名称 */
        @JsonProperty("police_org_name")
        private String policeOrgName;
        /** 附加自定义信息列表 */
        @JsonProperty("additional_info")
        private List<Object> additionalInfo;
        /** 其他自定义元数据 */
        private Object metadata;
    }

    /** 行人抓拍/静态记录  可用于静态库与动态抓拍库 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CaptureBodyRecordInput {
        private ResourceReferenceFull reference;
        /** 资源全局唯一标识符（type:id@cluster_id） */
        private String uri;
        @JsonProperty("created_at")
        private String createdAt;
        @JsonProperty("updated_at")
        private String updatedAt;
        /** 场景图URL/URI（完整的原始场景图片） */
        @JsonProperty("scene_image_uri")
        private String sceneImageUri;
        /** 抓拍小图URL/URI（裁剪后的目标图片） */
        @JsonProperty("capture_image_uri")
        private String captureImageUri;
        /** 外部数据源ID */
        @JsonProperty("external_id")
        private String externalId;
        private String type;
        /** 行人特征（加密后Base64） */
        @JsonProperty("body_feature_base64")
        private String bodyFeatureBase64;
        /** 人体框信息，包含x/y/w/h */
        @JsonProperty("pedestrian_rect")
        private ModelsCaptureRecordFaceRect pedestrianRect;
        /** 性别：0=未知，1=男，2=女 */
        private Integer gender;
        /** 年龄段：-1=未知，0=小孩，1=青年，2=中年，3=老年 */
        @JsonProperty("age_code")
        private Integer ageCode;
        /** 上衣颜色编码 */
        @JsonProperty("upper_body_color")
        private Integer upperBodyColor;
        /** 上衣长度：-1=未知，0=长袖，1=短袖 */
        @JsonProperty("coat_length")
        private Integer coatLength;
        /** 上衣纹理：-1=未知，0=纯色，1=条纹，2=格子 */
        @JsonProperty("coat_texture")
        private Integer coatTexture;
        /** 上衣风格/纹理编码：-1=未知，其他为算法编码 */
        @JsonProperty("upper_body_style")
        private Integer upperBodyStyle;
        /** 下衣颜色编码 */
        @JsonProperty("lower_body_color")
        private Integer lowerBodyColor;
        /** 下衣长度：-1=未知，0=短裤，1=长裤，2=短裙，3=长裙 */
        @JsonProperty("trousers_length")
        private Integer trousersLength;
        /** 下衣纹理：-1=未知，0=纯色，1=条纹，2=格子 */
        @JsonProperty("trousers_texture")
        private Integer trousersTexture;
        /** 背包：-1=未知，0=无，1=有 */
        private Integer bag;
        /** 手提包：-1=未知，0=无，1=有 */
        private Integer handbag;
        /** 帽子：-1=未知，0=无，1=有 */
        private Integer hat;
        /** 眼镜：-1=未知，0=无，1=有 */
        private Integer glass;
        /** 口罩：-1=未知，0=无，1=有 */
        private Integer mask;
        /** 头盔：-1=未知，0=无，1=有 */
        private Integer helmet;
        /** 太阳镜：-1=未知，0=无，1=有 */
        private Integer sunglass;
        /** 打伞：-1=未知，0=无，1=有 */
        private Integer umbrella;
        /** 抱小孩：-1=未知，0=无，1=有 */
        @JsonProperty("hold_child")
        private Integer holdChild;
        /** 朝向：-1=未知，0=前，1=后，2=侧，3=侧后 */
        private Integer orientation;
        /** 发型：-1=未知，0=长发，1=短发，2=光头 */
        @JsonProperty("hair_style")
        private Integer hairStyle;
        /** 打电话：-1=未知，0=无，1=有 */
        private Integer calling;
        /** 遮挡：-1=未知，0=无，1=有 */
        private Integer occlusion;
        /** 多人：-1=未知，0=否，1=是 */
        private Integer multipeople;
        /** 有关民族：-1=未知，0=非，1=是 */
        private Integer ur;
        /** 质量分（范围：0-100） */
        private Double quality;
        /** 是否低质量抓拍 */
        @JsonProperty("is_low_quality")
        private Boolean isLowQuality;
        /** 摄像头URI标识，格式：camera:ID@cluster_id */
        @JsonProperty("camera_uri")
        private String cameraUri;
        /** 抓拍时间戳（Unix时间戳，秒级） */
        @JsonProperty("capture_at")
        private Integer captureAt;
        /** 数据处理链路时间戳profiling信息 */
        private Object profiling;
        /** 轨迹元数据类型：0=正常，1=其他 */
        @JsonProperty("track_meta_type")
        private Integer trackMetaType;
    }

    /** 行人抓拍/静态记录  可用于静态库与动态抓拍库 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CaptureBodyRecordOutput {
        /** 资源全局唯一标识符（type:id@cluster_id） */
        private String uri;
        @JsonProperty("created_at")
        private String createdAt;
        @JsonProperty("updated_at")
        private String updatedAt;
        /** 场景图URL/URI（完整的原始场景图片） */
        @JsonProperty("scene_image_uri")
        private String sceneImageUri;
        /** 抓拍小图URL/URI（裁剪后的目标图片） */
        @JsonProperty("capture_image_uri")
        private String captureImageUri;
        /** 外部数据源ID */
        @JsonProperty("external_id")
        private String externalId;
        private String type;
        /** 行人特征（加密后Base64） */
        @JsonProperty("body_feature_base64")
        private String bodyFeatureBase64;
        /** 人体框信息，包含x/y/w/h */
        @JsonProperty("pedestrian_rect")
        private ModelsCaptureRecordFaceRect pedestrianRect;
        /** 性别：0=未知，1=男，2=女 */
        private Integer gender;
        /** 年龄段：-1=未知，0=小孩，1=青年，2=中年，3=老年 */
        @JsonProperty("age_code")
        private Integer ageCode;
        /** 上衣颜色编码 */
        @JsonProperty("upper_body_color")
        private Integer upperBodyColor;
        /** 上衣长度：-1=未知，0=长袖，1=短袖 */
        @JsonProperty("coat_length")
        private Integer coatLength;
        /** 上衣纹理：-1=未知，0=纯色，1=条纹，2=格子 */
        @JsonProperty("coat_texture")
        private Integer coatTexture;
        /** 上衣风格/纹理编码：-1=未知，其他为算法编码 */
        @JsonProperty("upper_body_style")
        private Integer upperBodyStyle;
        /** 下衣颜色编码 */
        @JsonProperty("lower_body_color")
        private Integer lowerBodyColor;
        /** 下衣长度：-1=未知，0=短裤，1=长裤，2=短裙，3=长裙 */
        @JsonProperty("trousers_length")
        private Integer trousersLength;
        /** 下衣纹理：-1=未知，0=纯色，1=条纹，2=格子 */
        @JsonProperty("trousers_texture")
        private Integer trousersTexture;
        /** 背包：-1=未知，0=无，1=有 */
        private Integer bag;
        /** 手提包：-1=未知，0=无，1=有 */
        private Integer handbag;
        /** 帽子：-1=未知，0=无，1=有 */
        private Integer hat;
        /** 眼镜：-1=未知，0=无，1=有 */
        private Integer glass;
        /** 口罩：-1=未知，0=无，1=有 */
        private Integer mask;
        /** 头盔：-1=未知，0=无，1=有 */
        private Integer helmet;
        /** 太阳镜：-1=未知，0=无，1=有 */
        private Integer sunglass;
        /** 打伞：-1=未知，0=无，1=有 */
        private Integer umbrella;
        /** 抱小孩：-1=未知，0=无，1=有 */
        @JsonProperty("hold_child")
        private Integer holdChild;
        /** 朝向：-1=未知，0=前，1=后，2=侧，3=侧后 */
        private Integer orientation;
        /** 发型：-1=未知，0=长发，1=短发，2=光头 */
        @JsonProperty("hair_style")
        private Integer hairStyle;
        /** 打电话：-1=未知，0=无，1=有 */
        private Integer calling;
        /** 遮挡：-1=未知，0=无，1=有 */
        private Integer occlusion;
        /** 多人：-1=未知，0=否，1=是 */
        private Integer multipeople;
        /** 有关民族：-1=未知，0=非，1=是 */
        private Integer ur;
        /** 质量分（范围：0-100） */
        private Double quality;
        /** 是否低质量抓拍 */
        @JsonProperty("is_low_quality")
        private Boolean isLowQuality;
        /** 摄像头URI标识，格式：camera:ID@cluster_id */
        @JsonProperty("camera_uri")
        private String cameraUri;
        /** 抓拍时间戳（Unix时间戳，秒级） */
        @JsonProperty("capture_at")
        private Integer captureAt;
        /** 数据处理链路时间戳profiling信息 */
        private Object profiling;
        /** 轨迹元数据类型：0=正常，1=其他 */
        @JsonProperty("track_meta_type")
        private Integer trackMetaType;
    }

    /** 人脸抓拍/静态记录  可用于静态库与动态抓拍库 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CaptureFaceRecordInput {
        private ResourceReferenceFull reference;
        /** 资源全局唯一标识符（type:id@cluster_id） */
        private String uri;
        @JsonProperty("created_at")
        private String createdAt;
        @JsonProperty("updated_at")
        private String updatedAt;
        /** 场景图URL/URI（完整的原始场景图片） */
        @JsonProperty("scene_image_uri")
        private String sceneImageUri;
        /** 抓拍小图URL/URI（裁剪后的目标图片） */
        @JsonProperty("capture_image_uri")
        private String captureImageUri;
        /** 外部数据源ID */
        @JsonProperty("external_id")
        private String externalId;
        private String type;
        /** 人脸特征（加密后再进行base64编码） */
        @JsonProperty("face_feature_base64")
        private String faceFeatureBase64;
        /** 姓名（静态库常见，动态抓拍可为空） */
        private String name;
        /** 证件号（身份证等），静态库常见 */
        @JsonProperty("person_id")
        private String personId;
        /** 出生日期，格式为"YYYY-mm-dd" */
        private String birthday;
        /** 性别，0:未知；1:男；2:女 */
        private Integer gender;
        /** 民族，0表示未知 */
        private Integer nation;
        /** 区域编号 */
        private Integer region;
        /** 发型：-1=未知，0=长发，1=短发，2=光头 */
        @JsonProperty("hair_style")
        private Integer hairStyle;
        /** 图片类型，0表示未知 */
        @JsonProperty("face_image_type")
        private Integer faceImageType;
        /** 表示框类型，0:脸框；1:头框 */
        @JsonProperty("face_rect_type")
        private Integer faceRectType;
        /** 脸框信息，与 raw_head_rect 二选一 */
        @JsonProperty("raw_face_rect")
        private ModelsCaptureRecordFaceRect rawFaceRect;
        /** 头框信息，与 raw_face_rect 二选一 */
        @JsonProperty("raw_head_rect")
        private ModelsCaptureRecordFaceRect rawHeadRect;
        /** 人脸角度 */
        @JsonProperty("face_angle")
        private FaceAngle faceAngle;
        /** 质量分（范围：0-100） */
        private Double quality;
        /** 是否低质量抓拍（过滤用） */
        @JsonProperty("is_low_quality")
        private Boolean isLowQuality;
        /** 口罩，-1未知；0无；1有 */
        @JsonProperty("rec_mask")
        private Integer recMask;
        /** 打电话：-1=未知，0=无，1=有 */
        private Integer calling;
        /** 摄像头URI标识，格式：camera:ID@cluster_id */
        @JsonProperty("camera_uri")
        private String cameraUri;
        /** 摄像头名称/位置名称（如：小区大门、地铁站入口等） */
        @JsonProperty("camera_name")
        private String cameraName;
        /** 抓拍时间戳（Unix时间戳，秒级） */
        @JsonProperty("capture_at")
        private Integer captureAt;
        /** 数据处理链路时间戳profiling信息 */
        private Object profiling;
        /** 轨迹元数据类型：0=正常，1=其他 */
        @JsonProperty("track_meta_type")
        private Integer trackMetaType;
    }

    /** 人脸抓拍/静态记录  可用于静态库与动态抓拍库 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CaptureFaceRecordOutput {
        /** 资源全局唯一标识符（type:id@cluster_id） */
        private String uri;
        @JsonProperty("created_at")
        private String createdAt;
        @JsonProperty("updated_at")
        private String updatedAt;
        /** 场景图URL/URI（完整的原始场景图片） */
        @JsonProperty("scene_image_uri")
        private String sceneImageUri;
        /** 抓拍小图URL/URI（裁剪后的目标图片） */
        @JsonProperty("capture_image_uri")
        private String captureImageUri;
        /** 外部数据源ID */
        @JsonProperty("external_id")
        private String externalId;
        private String type;
        /** 人脸特征（加密后再进行base64编码） */
        @JsonProperty("face_feature_base64")
        private String faceFeatureBase64;
        /** 姓名（静态库常见，动态抓拍可为空） */
        private String name;
        /** 证件号（身份证等），静态库常见 */
        @JsonProperty("person_id")
        private String personId;
        /** 出生日期，格式为"YYYY-mm-dd" */
        private String birthday;
        /** 性别，0:未知；1:男；2:女 */
        private Integer gender;
        /** 民族，0表示未知 */
        private Integer nation;
        /** 区域编号 */
        private Integer region;
        /** 发型：-1=未知，0=长发，1=短发，2=光头 */
        @JsonProperty("hair_style")
        private Integer hairStyle;
        /** 图片类型，0表示未知 */
        @JsonProperty("face_image_type")
        private Integer faceImageType;
        /** 表示框类型，0:脸框；1:头框 */
        @JsonProperty("face_rect_type")
        private Integer faceRectType;
        /** 脸框信息，与 raw_head_rect 二选一 */
        @JsonProperty("raw_face_rect")
        private ModelsCaptureRecordFaceRect rawFaceRect;
        /** 头框信息，与 raw_face_rect 二选一 */
        @JsonProperty("raw_head_rect")
        private ModelsCaptureRecordFaceRect rawHeadRect;
        /** 人脸角度 */
        @JsonProperty("face_angle")
        private FaceAngle faceAngle;
        /** 质量分（范围：0-100） */
        private Double quality;
        /** 是否低质量抓拍（过滤用） */
        @JsonProperty("is_low_quality")
        private Boolean isLowQuality;
        /** 口罩，-1未知；0无；1有 */
        @JsonProperty("rec_mask")
        private Integer recMask;
        /** 打电话：-1=未知，0=无，1=有 */
        private Integer calling;
        /** 摄像头URI标识，格式：camera:ID@cluster_id */
        @JsonProperty("camera_uri")
        private String cameraUri;
        /** 摄像头名称/位置名称（如：小区大门、地铁站入口等） */
        @JsonProperty("camera_name")
        private String cameraName;
        /** 抓拍时间戳（Unix时间戳，秒级） */
        @JsonProperty("capture_at")
        private Integer captureAt;
        /** 数据处理链路时间戳profiling信息 */
        private Object profiling;
        /** 轨迹元数据类型：0=正常，1=其他 */
        @JsonProperty("track_meta_type")
        private Integer trackMetaType;
    }

    /** 导入静态库记录（人脸） */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CaptureFaceRecordInput2 {
        /** 人脸特征（Base64编码） */
        @JsonProperty("face_feature_base64")
        private String faceFeatureBase64;
        /** 多算法特征映射，key 为算法标识，value 为 Base64 编码特征 */
        @JsonProperty("rec_feature_base64")
        private Object recFeatureBase64;
        /** 场景图 URI */
        @JsonProperty("scene_image_uri")
        private String sceneImageUri;
        /** 场景图 Base64 编码数据 */
        @JsonProperty("scene_image_content_base64")
        private String sceneImageContentBase64;
        /** 人脸小图 URI */
        @JsonProperty("capture_image_uri")
        private String captureImageUri;
        /** 人脸小图 Base64 编码数据 */
        @JsonProperty("capture_image_content_base64")
        private String captureImageContentBase64;
        /** 外部数据源 ID */
        @JsonProperty("external_id")
        private String externalId;
        /** 图片类型，0 表示其他，1 表示证件照 */
        @JsonProperty("face_image_type")
        private Integer faceImageType;
        /** 姓名 */
        private String name;
        /** 证件号 */
        @JsonProperty("person_id")
        private String personId;
        /** 出生日期，格式 YYYY-MM-DD */
        private String birthday;
        /** 性别，0 未知，1 男，2 女 */
        private Integer gender;
        /** 民族 */
        private Integer nation;
        /** 区域编号 */
        private Integer region;
        /** 抓拍时间戳（秒） */
        @JsonProperty("capture_at")
        private Integer captureAt;
        /** 人员标签 */
        @JsonProperty("person_flag")
        private List<String> personFlag;
    }

    /** 聊天请求 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ChatRequest {
        /** 用户输入的自然语言 */
        @JsonProperty("user_input")
        private String userInput;
        /** 会话 ID（用于多轮对话） */
        @JsonProperty("session_id")
        private String sessionId;
        /** 额外上下文信息 */
        private Object context;
    }

    /** 聊天响应（非流式） */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ChatResponse {
        /** 助手回复 */
        private String response;
        /** 会话 ID */
        @JsonProperty("session_id")
        private String sessionId;
        /** 工具调用记录 */
        @JsonProperty("tool_calls")
        private List<Object> toolCalls;
        /** 前端动作 */
        private List<Object> actions;
    }

    /** 卡口类型（枚举值）  - unknown: 未知 - face: 人像 - security: 治安 */
    public enum CheckpointType {
        UNKNOWN("unknown"),
        FACE("face"),
        SECURITY("security");

        private final Object value;
        CheckpointType(Object value) { this.value = value; }
        @JsonValue
        public Object getValue() { return value; }
    }

    /** 集群信息对象 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ClusterInfo {
        /** 集群的唯一标识符 */
        @JsonProperty("cluster_id")
        private String clusterId;
        /** 集群名称 */
        @JsonProperty("cluster_name")
        private String clusterName;
        /** SaaS 后端版本号 */
        @JsonProperty("saas_version")
        private String saasVersion;
        /** 集群所在区域 */
        private String region;
        /** 集群状态         - active: 正常运行         - inactive: 停用         - maintenance: 维护中 */
        private String status;
        /** 集群描述信息 */
        private String description;
        /** 创建时间 */
        @JsonProperty("created_at")
        private String createdAt;
        /** 最后更新时间 */
        @JsonProperty("updated_at")
        private String updatedAt;
    }

    /** 集群信息响应对象 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ClusterInfoResponse {
        /** 返回码         - 0: 成功         - 非0: 失败（具体错误码见错误码表） */
        private Integer rtn;
        /** 返回消息 */
        private String message;
        /** 集群信息 */
        private ClusterInfo cluster;
    }

    /** 时空碰撞结果项  表示在多个时空区域都出现过的人员，用于串并案分析 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CollisionItem {
        /** 档案 ID */
        @JsonProperty("dossier_id")
        private String dossierId;
        /** 匹配区域数（出现在多少个查询区域） */
        @JsonProperty("matched_zones")
        private Integer matchedZones;
        /** 总出现次数（所有区域累计） */
        @JsonProperty("total_appearances")
        private Integer totalAppearances;
        /** 出现记录列表 [[timestamp, camera_id], ...]，最多 100 条 */
        private List<List<Object>> appearances;
        /** 碰撞得分（0-100，综合匹配度和出现频率） */
        @JsonProperty("collision_score")
        private Double collisionScore;
        /** 档案详细信息 */
        @JsonProperty("dossier_info")
        private DossierInfo dossierInfo;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Companion {
        private String id;
        private String name;
        private String avatar;
        private String idNumber;
        private String database;
        private List<String> tags;
    }

    /** 同行分析请求  功能：查询指定目标人员的同行者及伴随次数（时空窗口内的共现分析）  字段说明： - target_dossier_uri: 目标人员档案 URI（转换后为 target_dossier_id） - time_start/time_end: 时间范围 - camera_list: 地点过滤（可选） - time_window_seconds: 时间窗口（±秒） */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CompanionAnalysisRequest {
        /** 目标人员档案 URI */
        @JsonProperty("target_dossier_uri")
        private String targetDossierUri;
        /** 开始时间（Unix 秒） */
        @JsonProperty("time_start")
        private Integer timeStart;
        /** 结束时间（Unix 秒） */
        @JsonProperty("time_end")
        private Integer timeEnd;
        /** 地点 URI 列表（可选） */
        @JsonProperty("camera_list")
        private List<String> cameraList;
        /** 时间窗口（±秒），默认 300 */
        @JsonProperty("time_window_seconds")
        private Integer timeWindowSeconds;
    }

    /** 同行分析响应  data 字段为同行者列表，包含伴随次数和共现记录 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CompanionAnalysisResponse {
        /** 接收状态。0表示接收正常，非0表示接收异常 */
        private Integer rtn;
        /** 接收状态描述 */
        private String message;
        /** 请求追踪 ID */
        @JsonProperty("request_id")
        private String requestId;
        /** 执行耗时（毫秒） */
        @JsonProperty("execution_time_ms")
        private Double executionTimeMs;
        /** 同行者列表 */
        private List<CompanionItem> data;
    }

    /** 同行者信息  表示与目标人员有同行关系的人员，包含伴随次数和共现记录 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CompanionItem {
        /** 同行者档案 ID */
        @JsonProperty("companion_id")
        private String companionId;
        /** 伴随次数（共现次数） */
        @JsonProperty("co_appearance_count")
        private Integer coAppearanceCount;
        /** 共现记录列表 [[timestamp, camera_id], ...] */
        @JsonProperty("co_appearances")
        private List<List<Object>> coAppearances;
        /** 同行者档案信息 */
        @JsonProperty("dossier_info")
        private DossierInfo dossierInfo;
    }

    /** 任务控制输入 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ControlTaskInput {
        private String action;
    }

    /** 任务控制响应 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ControlTaskResponse {
        /** 接收状态。0表示接收正常，非0表示接收异常 */
        private Integer rtn;
        /** 接收状态描述 */
        private String message;
        @JsonProperty("new_status")
        private String newStatus;
    }

    /** Copilot 聊天请求（OpenAI 兼容格式） */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CopilotChatRequest {
        /** 消息历史 */
        private List<CopilotMessage> messages;
        /** 会话 ID */
        @JsonProperty("session_id")
        private String sessionId;
        /** 是否流式响应 */
        private Boolean stream;
        /** 温度参数 */
        private Double temperature;
        /** 最大 token 数 */
        @JsonProperty("max_tokens")
        private Integer maxTokens;
    }

    /** Copilot 消息格式（OpenAI 兼容） */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CopilotMessage {
        /** 角色: system, user, assistant, tool */
        private String role;
        /** 消息内容，可以是文本或多模态内容数组 */
        private String content;
        /** 工具调用（assistant 消息） */
        @JsonProperty("tool_calls")
        private List<Object> toolCalls;
        /** 工具调用 ID（tool 消息） */
        @JsonProperty("tool_call_id")
        private String toolCallId;
    }

    /** 消息内容部分（支持多模态） */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CopilotMessageContentPart {
        /** 内容类型: text 或 image_url */
        private String type;
        /** 文本内容（type=text 时） */
        private String text;
        /** 图片 URL 或 base64（type=image_url 时） */
        @JsonProperty("image_url")
        private Object imageUrl;
    }

    /** 创建权限请求 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreatePermissionBody {
        /** 角色引用 */
        @JsonProperty("role_reference")
        private ResourceByURI roleReference;
        /** 标签引用 */
        @JsonProperty("tag_reference")
        private ResourceByURI tagReference;
        /** 操作类型 */
        private ActionEnum action;
    }

    /** 添加区域请求 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreateResourceSetRequest {
        @JsonProperty("cluster_id")
        private String clusterId;
        private String name;
        private String comment;
    }

    /** 创建角色请求 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreateRoleBody {
        /** 角色名称（可包含中文，用于显示） */
        @JsonProperty("role_name")
        private String roleName;
        /** 角色描述 */
        private String description;
    }

    /** 创建标签请求 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreateTagBody {
        /** 资源类型 */
        @JsonProperty("resource_type")
        private String resourceType;
        /** 父标签ID（None表示根节点） */
        @JsonProperty("parent_id")
        private Integer parentId;
        /** 标签显示名称 */
        @JsonProperty("tag_name")
        private String tagName;
        /** 标签描述 */
        private String description;
        /** 同级排序权重（数值越大越靠前） */
        @JsonProperty("sort_order")
        private Integer sortOrder;
        /** 扩展元数据（可选，用于存储额外信息） */
        private Object metadata;
    }

    /** 创建任务响应 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreateTaskResponse {
        /** 接收状态。0表示接收正常，非0表示接收异常 */
        private Integer rtn;
        /** 接收状态描述 */
        private String message;
        @JsonProperty("task_id")
        private String taskId;
    }

    /** 创建用户请求 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreateUserBody {
        /** 用户名 */
        private String username;
        /** 邮箱（可选，提供时需唯一） */
        private String email;
        /** 全名 */
        @JsonProperty("full_name")
        private String fullName;
        /** 电话号码 */
        private String phone;
        /** 头像URL */
        @JsonProperty("avatar_url")
        private String avatarUrl;
        /** 用户状态（active/inactive/suspended） */
        private String status;
        /** 角色ID列表 */
        private List<Integer> roles;
        /** 权限标签ID列表（必填，至少一个） */
        private List<Integer> tags;
        /** 扩展元数据（可选，用于存储额外信息） */
        private Object metadata;
        /** 初始密码（必填） */
        private String password;
    }

    /** 创建用户响应 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreateUserResponse {
        /** 接收状态。0表示接收正常，非0表示接收异常 */
        private Integer rtn;
        /** 接收状态描述 */
        private String message;
        private UserOutput user;
    }

    /** 数据集状态 */
    public enum DataSetStatus {
        CREATING("CREATING"),
        UPLOADING("UPLOADING"),
        EDITING("EDITING"),
        COMMITTED("COMMITTED"),
        DELETED("DELETED"),
        UN_LOCK("UN_LOCK");

        private final Object value;
        DataSetStatus(Object value) { this.value = value; }
        @JsonValue
        public Object getValue() { return value; }
    }

    /** 库的数据类型 */
    public enum DataType {
        FACE("face"),
        BODY("body"),
        VEHICLE("vehicle");

        private final Object value;
        DataType(Object value) { this.value = value; }
        @JsonValue
        public Object getValue() { return value; }
    }

    /** 数据库类型 */
    public enum DatabaseType {
        _0(0),
        _1(1);

        private final Object value;
        DatabaseType(Object value) { this.value = value; }
        @JsonValue
        public Object getValue() { return value; }
    }

    /** 数据集资源  用于模型训练的数据集，包含样本采集、标注等。 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DatasetInput {
        private ResourceReferenceFull reference;
        /** 资源全局唯一标识符（type:id@cluster_id） */
        private String uri;
        @JsonProperty("created_at")
        private String createdAt;
        @JsonProperty("updated_at")
        private String updatedAt;
        /** 资源类型标识（如：camera、region、repository 等） */
        private String type;
        /** 数据集名称 */
        private String name;
        /** 关联的算法 */
        private String algorithmUri;
        /** 正例数量 */
        private Integer positiveCount;
        /** 负例数量 */
        private Integer negativeCount;
        /** 总数量 */
        private Integer totalCount;
        /** 是否已提交 */
        private Boolean committed;
    }

    /** 数据集资源  用于模型训练的数据集，包含样本采集、标注等。 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DatasetOutput {
        /** 资源全局唯一标识符（type:id@cluster_id） */
        private String uri;
        @JsonProperty("created_at")
        private String createdAt;
        @JsonProperty("updated_at")
        private String updatedAt;
        /** 资源类型标识（如：camera、region、repository 等） */
        private String type;
        /** 数据集名称 */
        private String name;
        /** 关联的算法 */
        private String algorithmUri;
        /** 正例数量 */
        private Integer positiveCount;
        /** 负例数量 */
        private Integer negativeCount;
        /** 总数量 */
        private Integer totalCount;
        /** 是否已提交 */
        private Boolean committed;
    }

    /** 数据集算法列表响应 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DatasetAlgorithmListResponse {
        /** 接收状态。0表示接收正常，非0表示接收异常 */
        private Integer rtn;
        /** 接收状态描述 */
        private String message;
        /** 使用此数据集的算法列表 */
        private List<AlgorithmDatasetRef> data;
    }

    /** 批量标注请求 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DatasetAnnotateRequest {
        /** 标注列表 */
        private List<AnnotationItem> markList;
    }

    /** 创建数据集请求（对接 Moss Dataset: POST /v1|v2/dataSet/create） */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DatasetCreateRequest {
        /** 数据集名称 */
        private String name;
        /** 数据集描述 */
        private String description;
        /** 是否为场景数据集 */
        private Boolean isScene;
    }

    /** 数据集列表项 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DatasetListItem {
        /** 数据集 URI */
        private String uri;
        /** 数据集ID */
        private String id;
        /** 数据集名称 */
        private String name;
        /** 所属节点ID */
        private String nodeId;
        /** 当前版本号 */
        private Integer version;
        /** 状态 */
        private DataSetStatus status;
        /** 是否已提交 */
        private Boolean committed;
        /** 正例数量 */
        private Integer positiveCount;
        /** 负例数量 */
        private Integer negativeCount;
        /** 总数量 */
        private Integer totalCount;
        /** 创建时间戳 */
        private Integer creationTime;
        /** 更新时间戳 */
        private Integer updateTime;
    }

    /** 数据集列表响应 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DatasetListResponse {
        /** 接收状态。0表示接收正常，非0表示接收异常 */
        private Integer rtn;
        /** 接收状态描述 */
        private String message;
        /** 数据集列表 */
        private List<DatasetListItem> data;
        /** 总数 */
        private Integer total;
    }

    /** 数据集资源（样本） */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DatasetResource {
        /** 资源ID */
        private String id;
        /** 图片URL */
        private String url;
        /** 资源类型 */
        private Object type;
        /** 分类标注结果 */
        private String classifyResult;
        /** 检测标注结果 */
        private List<DetectResult> detectResults;
        /** 是否场景图 */
        private Boolean isScene;
        /** 裁剪区域 */
        private Object cropRect;
        /** 创建时间戳 */
        private Integer creationTime;
    }

    /** 数据集资源列表响应 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DatasetResourceListResponse {
        /** 接收状态。0表示接收正常，非0表示接收异常 */
        private Integer rtn;
        /** 接收状态描述 */
        private String message;
        /** 资源列表 */
        private List<DatasetResource> data;
        /** 总数 */
        private Integer total;
        /** 是否需要训练 */
        private Boolean needTrain;
    }

    /** 数据集资源查询请求 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DatasetResourceSearchRequest {
        /** 开始时间戳（毫秒） */
        private Integer startTime;
        /** 结束时间戳（毫秒） */
        private Integer endTime;
        /** 按标注标签过滤 */
        private List<String> markTags;
        /** 按数据源过滤 */
        private List<String> dataSources;
        /** 按设备ID过滤 */
        private List<String> deviceIds;
        /** 排序字段 */
        private String orderBy;
        /** 排序方向 */
        private String orderDirection;
    }

    /** 数据集响应 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DatasetResponse {
        /** 接收状态。0表示接收正常，非0表示接收异常 */
        private Integer rtn;
        /** 接收状态描述 */
        private String message;
        /** 数据集详情 */
        private DatasetOutput data;
    }

    /** 样本推荐请求 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DatasetSampleRecommendRequest {
        /** 模型 ID 列表 */
        @JsonProperty("model_id_list")
        private List<String> modelIdList;
        /** 组合模型 ID 列表 */
        @JsonProperty("compose_model_id_list")
        private List<String> composeModelIdList;
        /** 是否文本模型 */
        private Boolean isTextModel;
        /** 样本类型 */
        private SampleType type;
        /** 是否反转 */
        private Boolean reverse;
        /** 起始位置 */
        private Integer start;
        /** 每页数量 */
        private Integer limit;
    }

    /** 数据集版本 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DatasetVersion {
        /** 版本号 */
        private Integer version;
        /** 创建时间戳（毫秒） */
        private Integer creationTime;
        /** 状态 */
        private DataSetStatus status;
        /** 标注标签列表 */
        private List<String> markTags;
        /** 统计计数 */
        private Object counter;
    }

    /** 数据集版本列表响应 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DatasetVersionsResponse {
        /** 接收状态。0表示接收正常，非0表示接收异常 */
        private Integer rtn;
        /** 接收状态描述 */
        private String message;
        /** 版本列表 */
        private List<DatasetVersion> data;
    }

    /** 删除权限请求 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DeletePermissionBody {
        /** 角色引用 */
        @JsonProperty("role_reference")
        private ResourceByURI roleReference;
        /** 标签引用 */
        @JsonProperty("tag_reference")
        private ResourceByURI tagReference;
        /** 操作类型 */
        private ActionEnum action;
    }

    /** 单个依赖的健康状态 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DependencyStatus {
        /** 依赖名称 */
        private String name;
        /** 状态: healthy, unhealthy, unknown */
        private String status;
        /** 检查延迟（毫秒） */
        @JsonProperty("latency_ms")
        private Integer latencyMs;
        /** 错误信息（如果有） */
        private String error;
    }

    /** 检测结果 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DetectResult {
        /** 标签 */
        private String label;
        /** 矩形框 {x, y, w, h} */
        private Object rect;
        /** 置信度 */
        private Double confidence;
    }

    /** 发现远程任务响应 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DiscoverRemoteTasksResponse {
        /** 接收状态。0表示接收正常，非0表示接收异常 */
        private Integer rtn;
        /** 接收状态描述 */
        private String message;
        @JsonProperty("remote_tasks")
        private List<RemoteTask> remoteTasks;
        @JsonProperty("total_count")
        private Integer totalCount;
    }

    /** 档案完整模型 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DossierInput {
        /** 资源的全局唯一标识符 */
        private String uri;
        /** 集群ID */
        @JsonProperty("cluster_id")
        private String clusterId;
        /** 档案编号 */
        @JsonProperty("dossier_no")
        private String dossierNo;
        /** 档案名称 */
        private String name;
        /** 档案类型 */
        @JsonProperty("dossier_type")
        private String dossierType;
        /** 档案状态 */
        private String status;
        /** 档案优先级 */
        private String priority;
        /** 档案描述 */
        private String description;
        /** 档案包含的记录总数 */
        @JsonProperty("record_count")
        private Integer recordCount;
        /** 档案关联的抓拍记录预览（仅返回最近 20 条，完整记录请参考 record_count） */
        private List<Object> records;
        /** 档案关联的图片URI列表 */
        private List<String> images;
        /** 档案关联的视频URI列表 */
        private List<String> videos;
        /** 档案关联的标签ID列表 */
        @JsonProperty("tag_ids")
        private List<Integer> tagIds;
        /** 档案扩展元数据 */
        private DossierMetadata metadata;
        /** 创建人 */
        @JsonProperty("created_by")
        private String createdBy;
        /** 最后更新人 */
        @JsonProperty("updated_by")
        private String updatedBy;
        /** 创建时间 */
        @JsonProperty("created_at")
        private String createdAt;
        /** 更新时间 */
        @JsonProperty("updated_at")
        private String updatedAt;
    }

    /** 档案完整模型 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DossierOutput {
        /** 资源的全局唯一标识符 */
        private String uri;
        /** 集群ID */
        @JsonProperty("cluster_id")
        private String clusterId;
        /** 档案编号 */
        @JsonProperty("dossier_no")
        private String dossierNo;
        /** 档案名称 */
        private String name;
        /** 档案类型 */
        @JsonProperty("dossier_type")
        private String dossierType;
        /** 档案状态 */
        private String status;
        /** 档案优先级 */
        private String priority;
        /** 档案描述 */
        private String description;
        /** 档案包含的记录总数 */
        @JsonProperty("record_count")
        private Integer recordCount;
        /** 档案关联的抓拍记录预览（仅返回最近 20 条，完整记录请参考 record_count） */
        private List<Object> records;
        /** 档案关联的图片URI列表 */
        private List<String> images;
        /** 档案关联的视频URI列表 */
        private List<String> videos;
        /** 档案关联的标签ID列表 */
        @JsonProperty("tag_ids")
        private List<Integer> tagIds;
        /** 档案扩展元数据 */
        private DossierMetadata metadata;
        /** 创建人 */
        @JsonProperty("created_by")
        private String createdBy;
        /** 最后更新人 */
        @JsonProperty("updated_by")
        private String updatedBy;
        /** 创建时间 */
        @JsonProperty("created_at")
        private String createdAt;
        /** 更新时间 */
        @JsonProperty("updated_at")
        private String updatedAt;
    }

    /** 档案过滤条件 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DossierCondition {
        /** 档案类型：1为实名档案，0为非实名档案 */
        @JsonProperty("dossier_type")
        private Integer dossierType;
        /** 档案姓名 */
        private String name;
        /** 档案身份证 */
        @JsonProperty("citizen_id")
        private String citizenId;
        /** 档案ID */
        @JsonProperty("dossier_id")
        private String dossierId;
        /** 档案的姓名或档案身份证，精准匹配 */
        @JsonProperty("name_or_id")
        private String nameOrId;
        /** 档案来源库列表 */
        @JsonProperty("source_repos")
        private List<String> sourceRepos;
        /** 开始时间（ISO 8601格式） */
        @JsonProperty("time_start")
        private String timeStart;
        /** 结束时间（ISO 8601格式） */
        @JsonProperty("time_end")
        private String timeEnd;
        /** 摄像头ID列表 */
        @JsonProperty("camera_ids")
        private List<String> cameraIds;
    }

    /** 档案基础信息  包含人员的基本信息，由外部服务从档案库查询返回 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DossierInfo {
        /** 姓名 */
        private String name;
        /** 标签列表 */
        private List<String> tags;
        /** 性别 */
        private String gender;
        /** 年龄 */
        private Integer age;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DossierListResponse {
        /** 接收状态。0表示接收正常，非0表示接收异常 */
        private Integer rtn;
        /** 接收状态描述 */
        private String message;
        /** 档案列表 */
        private List<DossierOutput> dossiers;
        /** 分页信息 */
        private Pagination pagination;
    }

    /** 档案扩展元数据 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DossierMetadata {
        /** 头像图片地址 */
        private String avatar;
        /** 性别 */
        private String gender;
        /** 年龄 */
        private Integer age;
        /** 手机号码 */
        private String phone;
        /** 号码数量 */
        private Integer phoneCount;
        /** 查看更多号码的链接 */
        private String phoneLink;
        /** 居住地址 */
        private String residenceAddress;
        /** 出生地 */
        private String birthPlace;
        /** 籍贯 */
        private String nativePlace;
        /** 户籍地址 */
        private String registeredAddress;
        /** 职业 */
        private String occupation;
        /** 文化程度 */
        private String education;
        /** 婚姻状况 */
        private String maritalStatus;
        /** 所在库名称 */
        private String database;
        /** 关联的案件/违规类型 */
        private List<String> caseTypes;
        /** 备注信息 */
        private String notes;
        /** 网络资产信息 */
        private NetworkInfo networkInfo;
        /** 标签信息 */
        private List<String> tags;
        /** 同行人员列表 */
        private List<Companion> companions;
        /** IMSI 信息 */
        private List<ImsiInfo> imsiInfo;
        /** MAC 信息 */
        private List<MacInfo> macInfo;
        /** 网吧出入记录 */
        private List<InternetCafeRecord> internetCafeRecords;
        /** 宾馆出入记录 */
        private List<HotelRecord> hotelRecords;
        /** 机动车信息 */
        private VehicleInfo vehicle;
        /** 社会关系 */
        private List<Relation> relations;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DossierQueryRequest {
        /** 档案类型过滤: realname 或 anonymous */
        @JsonProperty("dossier_type")
        private String dossierType;
        /** 档案状态过滤 */
        private String status;
        /** 档案优先级过滤 */
        private String priority;
        /** 档案编号（精确匹配） */
        @JsonProperty("dossier_no")
        private String dossierNo;
        /** 档案名称（模糊匹配） */
        private String name;
        /** 标签ID列表 */
        @JsonProperty("tag_ids")
        private List<Integer> tagIds;
        /** 标签匹配模式 */
        @JsonProperty("tag_match_mode")
        private String tagMatchMode;
        /** 创建开始时间 */
        @JsonProperty("created_at_start")
        private String createdAtStart;
        /** 创建结束时间 */
        @JsonProperty("created_at_end")
        private String createdAtEnd;
        /** 排序参数 */
        private Object order;
        /** 页码 */
        private Integer page;
        /** 每页数量 */
        private Integer limit;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DossierResponse {
        /** 接收状态。0表示接收正常，非0表示接收异常 */
        private Integer rtn;
        /** 接收状态描述 */
        private String message;
        /** 档案详细信息 */
        private DossierOutput dossier;
    }

    /** L5 档案检索请求  **检索模式**： - 特征检索：提供 retrieval.image_content_base64 或 retrieval.feature_base64 - 结构化检索：提供 condition（可不提供 retrieval） - 混合检索：同时提供 retrieval 和 condition */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DossierRetrievalRequest {
        /** 数据类型：face=人脸（默认），body=人体 */
        @JsonProperty("data_type")
        private String dataType;
        /** 集群标识符 */
        @JsonProperty("cluster_id")
        private String clusterId;
        /** 特征检索参数（以图搜档时必填） */
        private RetrievalParams retrieval;
        /** 结构化过滤条件 */
        private DossierCondition condition;
        /** 排序参数 */
        private OrderParams order;
        /** 分页偏移量 */
        private Integer offset;
        /** 返回结果数量 */
        private Integer limit;
    }

    /** 档案检索响应 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DossierRetrievalResponse {
        /** 接收状态。0表示接收正常，非0表示接收异常 */
        private Integer rtn;
        /** 接收状态描述 */
        private String message;
        /** 检索查询ID */
        @JsonProperty("retrieval_query_id")
        private Integer retrievalQueryId;
        /** 检索结果总数 */
        private Integer total;
        /** 档案检索结果列表 */
        private List<DossierRetrievalResultItem> results;
    }

    /** 单条档案检索结果 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DossierRetrievalResultItem {
        /** 档案ID */
        @JsonProperty("dossier_id")
        private String dossierId;
        /** 相似度分数 */
        private Double similarity;
        /** 档案的过人记录数量 */
        @JsonProperty("face_record_num")
        private Integer faceRecordNum;
        /** 最后出现时间戳 */
        @JsonProperty("last_appear_timestamp")
        private Integer lastAppearTimestamp;
        /** 档案姓名 */
        private String name;
        /** 身份证号 */
        @JsonProperty("citizen_id")
        private String citizenId;
        /** 档案类型：1为实名，0为非实名 */
        @JsonProperty("dossier_type")
        private Integer dossierType;
        /** 档案来源库 */
        @JsonProperty("source_repos")
        private List<String> sourceRepos;
        /** 档案封面图URL */
        @JsonProperty("cover_image_url")
        private String coverImageUrl;
        /** 是否实名档案 */
        @JsonProperty("is_realname_dossier")
        private Boolean isRealnameDossier;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DossierTagUpdateBody {
        @JsonProperty("set_tag_ids")
        private List<Integer> setTagIds;
        @JsonProperty("add_tag_ids")
        private List<Integer> addTagIds;
        @JsonProperty("remove_tag_ids")
        private List<Integer> removeTagIds;
    }

    /** L2动态库检索 - 查询过人记录/轨迹数据  **用途**：查询摄像头抓拍的人脸/人体过人记录，支持按时间、摄像头筛选。  **两种检索模式**： 1. 结构化检索（查询过人记录）：使用 spatial_temporal_condition 指定时间和摄像头 2. 特征检索（以图搜图）：使用 retrieval.feature_base64 提供人脸/人体特征  **调用示例**：  1. 查询今天上午9点的过人记录： ```json {   "data_type": "face",   "cluster_id": "bodhi-229-dev",   "spatial_temporal_condition": {     "time_start": "2026-01-27T09:00:00",     "time_end": "2026-01-27T10:00:00"   } } ```  2. 查询指定摄像头的过人记录： ```json {   "data_type": "face",   "cluster_id": "bodhi-229-dev",   "spatial_temporal_condition": {     "time_start": "2026-01-27T00:00:00",     "time_end": "2026-01-27T23:59:59",     "camera_uris": ["camera:2@bodhi-229-dev"]   } } ``` */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DynamicRetrievalRequest {
        /** 数据类型：face=人脸（默认），body=人体 */
        @JsonProperty("data_type")
        private String dataType;
        /** 集群ID（如 bodhi-229-dev），可通过 /api/v1/cluster 获取 */
        @JsonProperty("cluster_id")
        private String clusterId;
        /** 检索查询ID（用于获取缓存结果） */
        @JsonProperty("retrieval_query_id")
        private Integer retrievalQueryId;
        /** 特征检索参数（以图搜图时必填，纯结构化检索时可省略） */
        private RetrievalParams retrieval;
        /** 时空检索条件（查询过人记录时使用，指定时间范围和/或摄像头） */
        @JsonProperty("spatial_temporal_condition")
        private SpatialTemporalCondition spatialTemporalCondition;
        /** 结构化过滤条件（按性别、年龄等属性筛选） */
        private FaceRecordCondition condition;
        /** 排序参数 */
        private OrderParams order;
        /** 分页起始位置 */
        private Integer start;
        /** 分页大小（每页返回数量） */
        private Integer limit;
        /** 检索附加元信息 */
        @JsonProperty("query_meta")
        private Object queryMeta;
        /** 是否记录检索日志 */
        @JsonProperty("enable_log_query_result")
        private Boolean enableLogQueryResult;
    }

    /** 通用错误响应模型 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ErrorResponse {
        /** 接收状态。0表示接收正常，非0表示接收异常 */
        private Integer rtn;
        /** 错误代码 */
        private String error;
        /** 错误描述 */
        private String message;
        /** 请求追踪ID */
        @JsonProperty("request_id")
        private String requestId;
        /** 详细错误信息 */
        private Object detail;
    }

    /** 事件类别 */
    public enum EventClass {
        ATOMIC("atomic"),
        COMPOSITE("composite");

        private final Object value;
        EventClass(Object value) { this.value = value; }
        @JsonValue
        public Object getValue() { return value; }
    }

    /** 事件详情响应 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class EventDetailResponse {
        /** 接收状态。0表示接收正常，非0表示接收异常 */
        private Integer rtn;
        /** 接收状态描述 */
        private String message;
        /** 事件详情 */
        private Object event;
    }

    /** 事件级别 */
    public enum EventLevel {
        CRITICAL("critical"),
        HIGH("high"),
        MEDIUM("medium"),
        LOW("low"),
        INFO("info");

        private final Object value;
        EventLevel(Object value) { this.value = value; }
        @JsonValue
        public Object getValue() { return value; }
    }

    /** 事件搜索请求 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class EventSearchRequest {
        /** 事件类别（原子事件或组合事件） */
        @JsonProperty("event_class")
        private EventClass eventClass;
        /** 事件类型列表 */
        private List<EventType> type;
        /** 事件级别列表 */
        private List<EventLevel> level;
        /** 事件状态列表（仅组合事件） */
        private List<EventStatus> status;
        /** 设备 ID */
        @JsonProperty("device_id")
        private String deviceId;
        /** 关联档案 ID */
        @JsonProperty("dossier_id")
        private String dossierId;
        /** 关联布控任务 ID */
        @JsonProperty("surveillance_task_id")
        private String surveillanceTaskId;
        /** 事件时间范围-开始 */
        @JsonProperty("start_time")
        private String startTime;
        /** 事件时间范围-结束 */
        @JsonProperty("end_time")
        private String endTime;
        /** 关键词搜索（标题、描述） */
        private String keyword;
        /** 处理人 ID */
        private String assignee;
        /** 页码（从1开始） */
        private Integer page;
        /** 每页数量 */
        @JsonProperty("page_size")
        private Integer pageSize;
        /** 排序字段 */
        @JsonProperty("order_by")
        private String orderBy;
        /** 排序方向 */
        private String order;
    }

    /** 事件搜索响应 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class EventSearchResponse {
        /** 接收状态。0表示接收正常，非0表示接收异常 */
        private Integer rtn;
        /** 接收状态描述 */
        private String message;
        /** 事件列表 */
        private List<Object> events;
        /** 总数 */
        private Integer total;
        /** 分页信息 */
        private Pagination pagination;
    }

    /** 事件状态 */
    public enum EventStatus {
        NEW("new"),
        ACKNOWLEDGED("acknowledged"),
        PROCESSING("processing"),
        RESOLVED("resolved"),
        CLOSED("closed"),
        IGNORED("ignored");

        private final Object value;
        EventStatus(Object value) { this.value = value; }
        @JsonValue
        public Object getValue() { return value; }
    }

    /** 事件状态更新请求 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class EventStatusUpdateRequest {
        /** 新状态 */
        private EventStatus status;
        /** 备注信息 */
        private String remark;
    }

    /** 事件类型 */
    public enum EventType {
        FACE_DETECTED("face_detected"),
        PERSON_DETECTED("person_detected"),
        VEHICLE_DETECTED("vehicle_detected"),
        INTRUSION("intrusion"),
        LOITERING("loitering"),
        CROSSING_LINE("crossing_line"),
        ENTERING_REGION("entering_region"),
        LEAVING_REGION("leaving_region"),
        OBJECT_LEFT("object_left"),
        OBJECT_REMOVED("object_removed"),
        CROWD_GATHERING("crowd_gathering"),
        RUNNING("running"),
        FALLING("falling"),
        FIGHTING("fighting"),
        SURVEILLANCE_HIT("surveillance_hit"),
        FREQUENT_APPEARANCE("frequent_appearance"),
        SUSPICIOUS_WANDERING("suspicious_wandering"),
        TRAJECTORY_ANALYSIS("trajectory_analysis"),
        GROUP_ACTIVITY("group_activity"),
        ABNORMAL_BEHAVIOR("abnormal_behavior"),
        STALKING("stalking"),
        THEFT_RISK("theft_risk");

        private final Object value;
        EventType(Object value) { this.value = value; }
        @JsonValue
        public Object getValue() { return value; }
    }

    /** 模型导出任务  从算法版本导出可部署的模型包。 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ExportTaskInput {
        private ResourceReferenceFull reference;
        /** 资源全局唯一标识符（type:id@cluster_id） */
        private String uri;
        @JsonProperty("created_at")
        private String createdAt;
        @JsonProperty("updated_at")
        private String updatedAt;
        /** 资源类型标识（如：camera、region、repository 等） */
        private String type;
        /** 算法 URI */
        private String algorithmUri;
        /** 算法版本 */
        private Integer version;
        /** 任务状态 */
        private ExportTaskStatus status;
        /** 模型名称 */
        private String modelName;
        /** 导出文件路径 */
        private String filePath;
    }

    /** 模型导出任务  从算法版本导出可部署的模型包。 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ExportTaskOutput {
        /** 资源全局唯一标识符（type:id@cluster_id） */
        private String uri;
        @JsonProperty("created_at")
        private String createdAt;
        @JsonProperty("updated_at")
        private String updatedAt;
        /** 资源类型标识（如：camera、region、repository 等） */
        private String type;
        /** 算法 URI */
        private String algorithmUri;
        /** 算法版本 */
        private Integer version;
        /** 任务状态 */
        private ExportTaskStatus status;
        /** 模型名称 */
        private String modelName;
        /** 导出文件路径 */
        private String filePath;
    }

    /** 导出任务列表响应 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ExportTaskListResponse {
        /** 接收状态。0表示接收正常，非0表示接收异常 */
        private Integer rtn;
        /** 接收状态描述 */
        private String message;
        /** 导出任务列表 */
        private List<ExportTaskOutput> data;
        /** 分页信息 */
        private Pagination pagination;
    }

    /** 导出任务响应 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ExportTaskResponse {
        /** 接收状态。0表示接收正常，非0表示接收异常 */
        private Integer rtn;
        /** 接收状态描述 */
        private String message;
        /** 导出任务详情 */
        private ExportTaskOutput data;
    }

    /** 导出任务状态 */
    public enum ExportTaskStatus {
        PREPARING("PREPARING"),
        DOWNLOADING_MODEL("DOWNLOADING_MODEL"),
        DOWNLOADING_CONFIG("DOWNLOADING_CONFIG"),
        DOWNLOADING_DATA("DOWNLOADING_DATA"),
        PACKAGING("PACKAGING"),
        COMPLETED("COMPLETED"),
        EXPORTING("EXPORTING"),
        FAILED("FAILED");

        private final Object value;
        ExportTaskStatus(Object value) { this.value = value; }
        @JsonValue
        public Object getValue() { return value; }
    }

    /** 人脸关键点 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FaceAlignment {
        private Point2D chin;
        @JsonProperty("left_eye_center")
        private Point2D leftEyeCenter;
        @JsonProperty("right_eye_center")
        private Point2D rightEyeCenter;
        @JsonProperty("nose_center")
        private Point2D noseCenter;
        @JsonProperty("mouth_left")
        private Point2D mouthLeft;
        @JsonProperty("mouth_right")
        private Point2D mouthRight;
    }

    /** 人脸角度信息 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FaceAngle {
        /** X轴角度 */
        private Double x;
        /** Y轴角度 */
        private Double y;
        /** Z轴角度 */
        private Double z;
    }

    /** 人脸记录过滤条件  支持的字段分类： - 人员信息：name, person_id（仅L1静态库） - 基础识别：gender, age_min/max, age_range - 质量相关：quality_min, is_low_quality - 外观特征：mask, glasses, hat, hat_color, hair_style - 上衣/下衣：upperbody_color, upperbody_length, upperbody_texture, upperbody_style, lowerbody_color, lowerbody_length - 穿戴物品：backpack, shoulderbag, carrythings - 其他外观/行为：smiley_face, fs_color, occlusion, multipeople, direction, beard, beard_style, helmet, sunglass, ur - 行为/状态：calling - 时间条件：created_at_start/end */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FaceRecordCondition {
        /** 姓名（模糊匹配）- 仅L1静态库支持 */
        private String name;
        /** 证件号 - 仅L1静态库支持 */
        @JsonProperty("person_id")
        private String personId;
        /** 性别：0=未知，1=男，2=女 */
        private Integer gender;
        /** 最小年龄（识别年龄，非实际年龄） */
        @JsonProperty("age_min")
        private Integer ageMin;
        /** 最大年龄（识别年龄，非实际年龄） */
        @JsonProperty("age_max")
        private Integer ageMax;
        /** 年龄段：-1=未知，0=小孩，1=青年，2=中年，3=老年 */
        @JsonProperty("age_range")
        private Integer ageRange;
        /** 最小质量分（范围：0-100） */
        @JsonProperty("quality_min")
        private Double qualityMin;
        /** 是否低质量 */
        @JsonProperty("is_low_quality")
        private Boolean isLowQuality;
        /** 口罩：-1=未知，0=无，1=有 */
        private Integer mask;
        /** 眼镜：-1=未知，0=不戴眼镜，1=戴眼镜，2=太阳镜 */
        private Integer glasses;
        /** 帽子：-1=未知，0=不戴帽子，1=戴帽子 */
        private Integer hat;
        /** 帽子颜色：-1=未知，其他值表示具体颜色编码 */
        @JsonProperty("hat_color")
        private Integer hatColor;
        /** 发型：-1=未知，0=长发，1=短发，2=光头 */
        @JsonProperty("hair_style")
        private Integer hairStyle;
        /** 打电话：-1=未知，0=无，1=有 */
        private Integer calling;
        /** 上衣颜色：-1=未知，其他值表示具体颜色编码 */
        @JsonProperty("upperbody_color")
        private Integer upperbodyColor;
        /** 下衣颜色：-1=未知，其他值表示具体颜色编码 */
        @JsonProperty("lowerbody_color")
        private Integer lowerbodyColor;
        /** 上衣长度：-1=未知，0=长袖，1=短袖 */
        @JsonProperty("upperbody_length")
        private Integer upperbodyLength;
        /** 上衣纹理：-1=未知，0=条纹，1=格子，2=花纹，3=纯色 */
        @JsonProperty("upperbody_texture")
        private Integer upperbodyTexture;
        /** 下衣长度：-1=未知，0=短裤/短裙，1=长裤/长裙，2=短裙，3=长裙 */
        @JsonProperty("lowerbody_length")
        private Integer lowerbodyLength;
        /** 背包：-1=未知，0=无，1=有 */
        private Integer backpack;
        /** 肩包：-1=未知，0=无，1=有 */
        private Integer shoulderbag;
        /** 携带物品：-1=未知，0=无，1=有 */
        private Integer carrythings;
        /** 是否微笑：-1=未知，0=否，1=是 */
        @JsonProperty("smiley_face")
        private Integer smileyFace;
        /** 肤色编码：-1=未知，0=白 1=黑 2=黄 3=粽 */
        @JsonProperty("fs_color")
        private Integer fsColor;
        /** 遮挡：-1=未知，0=无，1=有 */
        private Integer occlusion;
        /** 多人：-1=未知，0=否，1=是 */
        private Integer multipeople;
        /** 朝向：-1=未知，0=左，1=右，2=正面，3=背面（以算法定义为准） */
        private Integer direction;
        /** 胡须：-1=未知，0=无，1=有 */
        private Integer beard;
        /** 胡须类型编码：-1=未知，其余为算法类型编码 */
        @JsonProperty("beard_style")
        private Integer beardStyle;
        /** 头盔：-1=未知，0=无，1=有 */
        private Integer helmet;
        /** 太阳镜：-1=未知，0=无，1=有 */
        private Integer sunglass;
        /** 上衣风格/纹理编码：-1=未知，其余为算法编码 */
        @JsonProperty("upperbody_style")
        private Integer upperbodyStyle;
        /** 有关民族：-1=未知，0=非，1=是 */
        private Integer ur;
        /** 创建开始时间（ISO 8601格式，如：2024-01-01T00:00:00Z） */
        @JsonProperty("created_at_start")
        private String createdAtStart;
        /** 创建结束时间（ISO 8601格式，如：2024-01-31T23:59:59Z） */
        @JsonProperty("created_at_end")
        private String createdAtEnd;
    }

    /** 人脸检测结果 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FaceResultInput {
        private Rect2D rect;
        /** 置信度，内部RPC返回0-1，API返回0-100 */
        private Double confidence;
        @JsonProperty("face_quality")
        private Double faceQuality;
        private Double quality;
        @JsonProperty("angle_x")
        private Double angleX;
        @JsonProperty("angle_y")
        private Double angleY;
        @JsonProperty("angle_z")
        private Double angleZ;
        @JsonProperty("rec_mask")
        private Boolean recMask;
        @JsonProperty("rec_mask_confidence")
        private Double recMaskConfidence;
        @JsonProperty("track_id")
        private String trackId;
        @JsonProperty("entity_id")
        private String entityId;
        @JsonProperty("face_alignment")
        private FaceAlignment faceAlignment;
        private Feature feature;
    }

    /** 人脸检测结果 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FaceResultOutput {
        private Rect2D rect;
        /** 置信度，内部RPC返回0-1，API返回0-100 */
        private Double confidence;
        @JsonProperty("face_quality")
        private Double faceQuality;
        private Double quality;
        @JsonProperty("angle_x")
        private Double angleX;
        @JsonProperty("angle_y")
        private Double angleY;
        @JsonProperty("angle_z")
        private Double angleZ;
        @JsonProperty("rec_mask")
        private Boolean recMask;
        @JsonProperty("rec_mask_confidence")
        private Double recMaskConfidence;
        @JsonProperty("track_id")
        private String trackId;
        @JsonProperty("entity_id")
        private String entityId;
        @JsonProperty("face_alignment")
        private FaceAlignment faceAlignment;
        private Feature feature;
    }

    /** 特征向量  **用法**：将 feature_data 用于检索接口的 feature_base64 参数 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Feature {
        /** Base64编码的特征向量（用于检索接口的 feature_base64 参数） */
        @JsonProperty("feature_data")
        private String featureData;
        /** 特征维度 */
        private Integer dimension;
    }

    /** 特征抽取响应数据 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FeatureExtractionDataInput {
        @JsonProperty("frame_id")
        private String frameId;
        private Double timestamp;
        @JsonProperty("camera_id")
        private String cameraId;
        @JsonProperty("processing_time_ms")
        private Double processingTimeMs;
        @JsonProperty("task_id")
        private String taskId;
        @JsonProperty("face_results")
        private List<FaceResultInput> faceResults;
        @JsonProperty("body_results")
        private List<BodyResult> bodyResults;
    }

    /** 特征抽取响应数据 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FeatureExtractionDataOutput {
        @JsonProperty("frame_id")
        private String frameId;
        private Double timestamp;
        @JsonProperty("camera_id")
        private String cameraId;
        @JsonProperty("processing_time_ms")
        private Double processingTimeMs;
        @JsonProperty("task_id")
        private String taskId;
        @JsonProperty("face_results")
        private List<FaceResultOutput> faceResults;
        @JsonProperty("body_results")
        private List<BodyResult> bodyResults;
    }

    /** 特征抽取选项 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FeatureExtractionOptions {
        /** 最大检测目标数 */
        @JsonProperty("max_object_num")
        private Integer maxObjectNum;
        /** 选择策略: center_point, largest */
        @JsonProperty("select_policy")
        private String selectPolicy;
        /** 最小人脸尺寸 */
        @JsonProperty("min_face_size")
        private Integer minFaceSize;
        /** 检测阈值 */
        private Double threshold;
    }

    /** 特征抽取请求 - 从图片中检测人脸/人体并抽取特征  **重要**：必须使用 image.image_data 传入 Base64 图片数据，不支持 image_url！  **调用示例**： ```json {   "type": "face_det_fe",   "image": {     "image_data": "/9j/4AAQSkZJRgABAQAAAQABAAD..."   } } ```  **返回结果**： - data.face_results[].feature.feature_data: 人脸特征向量 - data.body_results[].feature.feature_data: 人体特征向量 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FeatureExtractionRequest {
        /** 抽取类型：face_det_fe（人脸，最常用）、body_det_fe（人体） */
        private FeatureExtractionType type;
        /** 【必填】图片数据，必须使用 image_data 字段传入 Base64 数据 */
        private ImageInput image;
        /** 选项配置（一般不需要） */
        private FeatureExtractionOptions options;
        /** 相机ID（可选） */
        @JsonProperty("camera_id")
        private String cameraId;
        /** 帧ID（可选） */
        @JsonProperty("frame_id")
        private Integer frameId;
    }

    /** 特征抽取响应 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FeatureExtractionResponse {
        private String message;
        private Integer rtn;
        private FeatureExtractionDataOutput data;
    }

    /** 特征抽取类型  **常用类型**： - face_det_fe: 人脸检测+特征抽取（最常用，用于以图搜图） - body_det_fe: 人体检测+特征抽取  **仅检测**： - face_det: 仅人脸检测（不抽取特征） - body_det: 仅人体检测（不抽取特征）  **仅抽取特征**（需要已裁剪的人脸/人体图）： - face_fe: 仅人脸特征抽取 - body_fe: 仅人体特征抽取 */
    public enum FeatureExtractionType {
        FACE_FE("face_fe"),
        BODY_FE("body_fe"),
        FACE_DET_FE("face_det_fe"),
        BODY_DET_FE("body_det_fe"),
        FACE_DET_FE_CENTER("face_det_fe_center"),
        BODY_DET_FE_CENTER("body_det_fe_center"),
        FACE_DET("face_det"),
        BODY_DET("body_det");

        private final Object value;
        FeatureExtractionType(Object value) { this.value = value; }
        @JsonValue
        public Object getValue() { return value; }
    }

    /** 报警数据拉取请求 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FetchHitRequest {
        @JsonProperty("cluster_id")
        private String clusterId;
        private Integer offset;
        private Integer limit;
    }

    /** 人像拉取请求 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FetchLogRequest {
        @JsonProperty("cluster_id")
        private String clusterId;
        @JsonProperty("repository_id")
        private Integer repositoryId;
        private String offset;
        private Integer limit;
    }

    /** 路人数据拉取请求 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FetchTrackRequest {
        @JsonProperty("cluster_id")
        private String clusterId;
        private Integer offset;
        private Integer limit;
    }

    /** 文件上传检查请求 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FileUploadCheckRequest {
        /** 文件 MD5 */
        private String hash;
        /** 文件名 */
        private String fileName;
        /** 自定义路径 */
        private String customPath;
        /** 不使用 hash 前缀 */
        private Boolean noHashPre;
    }

    /** 合并分片请求 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FileUploadMergeRequest {
        /** 文件 MD5 */
        private String hash;
        /** 文件名 */
        private String fileName;
        /** 分片总数 */
        private Integer chunkTotal;
        /** 自定义路径 */
        private String customPath;
        /** 不使用 hash 前缀 */
        private Boolean noHashPre;
    }

    /** 初次入圈响应数据  包含首次入圈人员列表，按首次出现时间升序排列 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FirstEntryData {
        /** 首次入圈人员总数 */
        private Integer total;
        /** 初次入圈人员列表 */
        private List<FirstEntryItem> results;
    }

    /** 初次入圈人员信息  表示在目标时间段首次进入指定区域的人员 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FirstEntryItem {
        /** 档案 ID */
        @JsonProperty("dossier_id")
        private String dossierId;
        /** 首次出现时间（Unix 秒） */
        @JsonProperty("first_appearance_time")
        private Integer firstAppearanceTime;
        /** 首次出现时间（可读格式 YYYY-MM-DD HH:MM:SS） */
        @JsonProperty("first_appearance_datetime")
        private String firstAppearanceDatetime;
        /** 首次出现地点 ID */
        @JsonProperty("first_camera")
        private String firstCamera;
    }

    /** 初次入圈请求  功能：筛选在早期时间段未出现、在目标时间段首次进入指定区域的新进人员  时间轴定义： - T3（最早）→ T2 → T1（最晚） - 早期时间段：[T3, T2] - 在此时间段内未出现 - 目标时间段：[T2, T1] - 在此时间段内首次出现  字段说明： - camera_list: 区域点位 URI 列表 - early_period_start: 早期时间段起始 T3 - early_period_end: 早期时间段结束 T2 - target_period_start: 目标时间段起始 T2（应等于 early_period_end） - target_period_end: 目标时间段结束 T1 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FirstEntryRequest {
        /** 区域点位 URI 列表，最多 200 个 */
        @JsonProperty("camera_list")
        private List<String> cameraList;
        /** 早期时间段起始 T3（Unix 秒） */
        @JsonProperty("early_period_start")
        private Integer earlyPeriodStart;
        /** 早期时间段结束 T2（Unix 秒） */
        @JsonProperty("early_period_end")
        private Integer earlyPeriodEnd;
        /** 目标时间段起始 T2（Unix 秒），应等于 early_period_end */
        @JsonProperty("target_period_start")
        private Integer targetPeriodStart;
        /** 目标时间段结束 T1（Unix 秒） */
        @JsonProperty("target_period_end")
        private Integer targetPeriodEnd;
    }

    /** 初次入圈响应  data 字段为首次入圈人员列表 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FirstEntryResponse {
        /** 接收状态。0表示接收正常，非0表示接收异常 */
        private Integer rtn;
        /** 接收状态描述 */
        private String message;
        /** 请求追踪 ID */
        @JsonProperty("request_id")
        private String requestId;
        /** 执行耗时（毫秒） */
        @JsonProperty("execution_time_ms")
        private Double executionTimeMs;
        /** 初次入圈数据 */
        private FirstEntryData data;
    }

    /** 落脚点分析响应数据  包含聚集热点地点列表，按不同人数降序排列 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FootholdAnalysisData {
        /** 聚集地点总数 */
        private Integer total;
        /** 落脚点列表 */
        private List<FootholdItem> results;
    }

    /** 落脚点分析请求  功能：分析特定人群在夜间等时段的聚集热点地点  字段说明： - date_start/date_end: 日期范围（YYYY-MM-DD 格式） - hour_list: 分析的小时列表（0-23） - person_uris: 目标人群档案 URI 列表（转换后为 person_list） */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FootholdAnalysisRequest {
        /** 开始日期（YYYY-MM-DD） */
        @JsonProperty("date_start")
        private String dateStart;
        /** 结束日期（YYYY-MM-DD），最大跨度 30 天 */
        @JsonProperty("date_end")
        private String dateEnd;
        /** 小时列表（0-23），如夜间 [22, 23, 0, 1, 2, 3, 4, 5] */
        @JsonProperty("hour_list")
        private List<Integer> hourList;
        /** 目标人群档案 URI 列表，最多 10 人 */
        @JsonProperty("person_uris")
        private List<String> personUris;
    }

    /** 落脚点分析响应  data 字段为聚集热点地点列表 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FootholdAnalysisResponse {
        /** 接收状态。0表示接收正常，非0表示接收异常 */
        private Integer rtn;
        /** 接收状态描述 */
        private String message;
        /** 请求追踪 ID */
        @JsonProperty("request_id")
        private String requestId;
        /** 执行耗时（毫秒） */
        @JsonProperty("execution_time_ms")
        private Double executionTimeMs;
        /** 落脚点分析数据 */
        private FootholdAnalysisData data;
    }

    /** 落脚点信息  表示一个聚集热点地点的统计信息 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FootholdItem {
        /** 地点 ID */
        @JsonProperty("camera_id")
        private String cameraId;
        /** 不同人数（去重后的人员数量） */
        @JsonProperty("distinct_persons")
        private Integer distinctPersons;
        /** 总出现次数 */
        @JsonProperty("total_hits")
        private Integer totalHits;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class GetRepoResponse {
        /** 接收状态。0表示接收正常，非0表示接收异常 */
        private Integer rtn;
        /** 接收状态描述 */
        private String message;
        private RepositoryOutput repository;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class GetTaskResponse {
        /** 接收状态。0表示接收正常，非0表示接收异常 */
        private Integer rtn;
        /** 接收状态描述 */
        private String message;
        private SurveillanceTaskOutput task;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class HTTPValidationError {
        private List<ValidationError> detail;
    }

    /** 健康检查响应 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class HealthResponse {
        /** 服务状态 */
        private String status;
        /** 服务版本 */
        private String version;
        /** 是否为调试模式 */
        private Boolean debug;
        /** Git 分支 */
        @JsonProperty("git_branch")
        private String gitBranch;
        /** Git 提交哈希 */
        @JsonProperty("git_commit")
        private String gitCommit;
        /** 构建时间 */
        @JsonProperty("build_info")
        private String buildInfo;
        /** 上次检查时间戳（毫秒） */
        @JsonProperty("checked_at_ms")
        private Integer checkedAtMs;
        /** 依赖总体状态: healthy, unhealthy, unknown */
        @JsonProperty("dependencies_status")
        private String dependenciesStatus;
        /** 依赖是否全部健康 */
        @JsonProperty("dependencies_healthy")
        private Boolean dependenciesHealthy;
        /** 各依赖的详细状态 */
        private Object dependencies;
    }

    /** 告警记录模型 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class HitRecordInput {
        private ResourceReferenceFull reference;
        /** 资源全局唯一标识符（type:id@cluster_id） */
        private String uri;
        @JsonProperty("created_at")
        private String createdAt;
        @JsonProperty("updated_at")
        private String updatedAt;
        /** 资源类型标识（如：camera、region、repository 等） */
        private String type;
        /** 布控任务ID */
        @JsonProperty("surveillance_id")
        private Integer surveillanceId;
        /** 布控任务URI */
        @JsonProperty("surveillance_uri")
        private String surveillanceUri;
        /** 布控任务名称 */
        @JsonProperty("task_name")
        private String taskName;
        /** 摄像头URI */
        @JsonProperty("camera_uri")
        private String cameraUri;
        /** 摄像头地址 */
        @JsonProperty("camera_address")
        private String cameraAddress;
        /** 抓拍时间（Unix时间戳） */
        private Integer timestamp;
        /** 场景图URI */
        @JsonProperty("picture_uri")
        private String pictureUri;
        /** 抓拍记录URI */
        @JsonProperty("capture_record_uri")
        private String captureRecordUri;
        /** 人脸框位置 */
        @JsonProperty("face_rect")
        private ModelsSurveillanceTaskFaceRect faceRect;
        /** 抓拍小图URI */
        @JsonProperty("face_image_uri")
        private String faceImageUri;
        /** 轨迹开始时间 */
        @JsonProperty("timestamp_begin")
        private Integer timestampBegin;
        /** 轨迹结束时间 */
        @JsonProperty("timestamp_end")
        private Integer timestampEnd;
        /** 抓拍特征（base64） */
        @JsonProperty("face_feature_base64")
        private String faceFeatureBase64;
        /** 命中的人像库URI */
        @JsonProperty("hit_repository_uri")
        private String hitRepositoryUri;
        /** 相似度分数（范围：0-100） */
        @JsonProperty("hit_similarity")
        private Double hitSimilarity;
        /** 命中类型 */
        @JsonProperty("hit_type")
        private Integer hitType;
        /** 命中的底库记录URI */
        @JsonProperty("hit_record_uri")
        private String hitRecordUri;
        /** 命中身份证号 */
        @JsonProperty("hit_person_id")
        private String hitPersonId;
        /** 命中姓名 */
        @JsonProperty("hit_name")
        private String hitName;
        /** 命中性别（0:未知，1:男，2:女） */
        @JsonProperty("hit_gender")
        private Integer hitGender;
        /** 命中国籍 */
        @JsonProperty("hit_nation")
        private Integer hitNation;
        /** 命中出生年份 */
        @JsonProperty("hit_born_year")
        private Integer hitBornYear;
        /** 命中底库图URI */
        @JsonProperty("hit_picture_uri")
        private String hitPictureUri;
        /** 命中人脸图URI */
        @JsonProperty("hit_face_image_uri")
        private String hitFaceImageUri;
        /** 命中记录入库时间 */
        @JsonProperty("hit_timestamp")
        private Integer hitTimestamp;
        /** 命中特征（base64） */
        @JsonProperty("hit_face_feature_base64")
        private String hitFaceFeatureBase64;
        /** 图片MD5是否相同 */
        @JsonProperty("md5_same")
        private Boolean md5Same;
        /** 身份证号是否相同 */
        @JsonProperty("person_id_same")
        private Boolean personIdSame;
        /** 标注结果（-1:不同人，0:未标注，1:同一人） */
        private Integer annotation;
        /** 是否命中（0:计算中，1:命中，2:未命中） */
        @JsonProperty("same_hit")
        private Integer sameHit;
        /** 性能分析时间戳（各处理阶段的耗时记录） */
        private Object profiling;
        /** 抓拍数据来源类型（0:视频流，>=1:图片流） */
        @JsonProperty("track_meta_type")
        private Integer trackMetaType;
    }

    /** 告警记录模型 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class HitRecordOutput {
        /** 资源全局唯一标识符（type:id@cluster_id） */
        private String uri;
        @JsonProperty("created_at")
        private String createdAt;
        @JsonProperty("updated_at")
        private String updatedAt;
        /** 资源类型标识（如：camera、region、repository 等） */
        private String type;
        /** 布控任务ID */
        @JsonProperty("surveillance_id")
        private Integer surveillanceId;
        /** 布控任务URI */
        @JsonProperty("surveillance_uri")
        private String surveillanceUri;
        /** 布控任务名称 */
        @JsonProperty("task_name")
        private String taskName;
        /** 摄像头URI */
        @JsonProperty("camera_uri")
        private String cameraUri;
        /** 摄像头地址 */
        @JsonProperty("camera_address")
        private String cameraAddress;
        /** 抓拍时间（Unix时间戳） */
        private Integer timestamp;
        /** 场景图URI */
        @JsonProperty("picture_uri")
        private String pictureUri;
        /** 抓拍记录URI */
        @JsonProperty("capture_record_uri")
        private String captureRecordUri;
        /** 人脸框位置 */
        @JsonProperty("face_rect")
        private ModelsSurveillanceTaskFaceRect faceRect;
        /** 抓拍小图URI */
        @JsonProperty("face_image_uri")
        private String faceImageUri;
        /** 轨迹开始时间 */
        @JsonProperty("timestamp_begin")
        private Integer timestampBegin;
        /** 轨迹结束时间 */
        @JsonProperty("timestamp_end")
        private Integer timestampEnd;
        /** 抓拍特征（base64） */
        @JsonProperty("face_feature_base64")
        private String faceFeatureBase64;
        /** 命中的人像库URI */
        @JsonProperty("hit_repository_uri")
        private String hitRepositoryUri;
        /** 相似度分数（范围：0-100） */
        @JsonProperty("hit_similarity")
        private Double hitSimilarity;
        /** 命中类型 */
        @JsonProperty("hit_type")
        private Integer hitType;
        /** 命中的底库记录URI */
        @JsonProperty("hit_record_uri")
        private String hitRecordUri;
        /** 命中身份证号 */
        @JsonProperty("hit_person_id")
        private String hitPersonId;
        /** 命中姓名 */
        @JsonProperty("hit_name")
        private String hitName;
        /** 命中性别（0:未知，1:男，2:女） */
        @JsonProperty("hit_gender")
        private Integer hitGender;
        /** 命中国籍 */
        @JsonProperty("hit_nation")
        private Integer hitNation;
        /** 命中出生年份 */
        @JsonProperty("hit_born_year")
        private Integer hitBornYear;
        /** 命中底库图URI */
        @JsonProperty("hit_picture_uri")
        private String hitPictureUri;
        /** 命中人脸图URI */
        @JsonProperty("hit_face_image_uri")
        private String hitFaceImageUri;
        /** 命中记录入库时间 */
        @JsonProperty("hit_timestamp")
        private Integer hitTimestamp;
        /** 命中特征（base64） */
        @JsonProperty("hit_face_feature_base64")
        private String hitFaceFeatureBase64;
        /** 图片MD5是否相同 */
        @JsonProperty("md5_same")
        private Boolean md5Same;
        /** 身份证号是否相同 */
        @JsonProperty("person_id_same")
        private Boolean personIdSame;
        /** 标注结果（-1:不同人，0:未标注，1:同一人） */
        private Integer annotation;
        /** 是否命中（0:计算中，1:命中，2:未命中） */
        @JsonProperty("same_hit")
        private Integer sameHit;
        /** 性能分析时间戳（各处理阶段的耗时记录） */
        private Object profiling;
        /** 抓拍数据来源类型（0:视频流，>=1:图片流） */
        @JsonProperty("track_meta_type")
        private Integer trackMetaType;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class HotelRecord {
        private String checkIn;
        private String checkOut;
        private String hotelName;
        private String hotelAddress;
        private String roomNumber;
    }

    /** 识别内容类型（枚举值）  0: 人像识别 1: 人体识别 2: 人像+人体 3: 车牌识别 6: 非机动车识别 8: 人脸识别 13: 综合识别 14: 其他 */
    public enum IdentificationType {
        _0(0),
        _1(1),
        _2(2),
        _3(3),
        _6(6),
        _8(8),
        _13(13),
        _14(14);

        private final Object value;
        IdentificationType(Object value) { this.value = value; }
        @JsonValue
        public Object getValue() { return value; }
    }

    /** 已识别的同行人信息  同行反查中作为查询起点的已知同行人 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class IdentifiedCompanion {
        /** 已知同行人档案 ID */
        @JsonProperty("person_id")
        private String personId;
        /** 档案信息 */
        @JsonProperty("dossier_info")
        private DossierInfo dossierInfo;
    }

    /** 异步图片流批量导入 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ImageFlowBatchRequest {
        @JsonProperty("cluster_id")
        private String clusterId;
        private List<Object> images;
    }

    /** 图片输入（必须使用 image_data，不支持 image_url） */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ImageInput {
        /** 【必填】Base64编码的图片数据，不要包含 data:image 前缀 */
        @JsonProperty("image_data")
        private String imageData;
        /** 【不支持】暂不支持URL，请使用 image_data */
        @JsonProperty("image_url")
        private String imageUrl;
    }

    /** 单个图片上传响应 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ImageUploadResponse {
        /** 接收状态。0表示接收正常，非0表示接收异常 */
        private Integer rtn;
        /** 接收状态描述 */
        private String message;
        /** 上传结果 */
        private ImageUploadResult data;
    }

    /** 单次图片上传结果 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ImageUploadResult {
        /** KV 存储 URI */
        private String uri;
        /** 样本 ID */
        @JsonProperty("sample_id")
        private String sampleId;
        /** 标注标签 */
        private String mark;
    }

    /** 导入检查响应 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ImportCheckResponse {
        /** 接收状态。0表示接收正常，非0表示接收异常 */
        private Integer rtn;
        /** 接收状态描述 */
        private String message;
        /** 检查结果 */
        private Object data;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ImsiInfo {
        private String imsiAddress;
        /** 匹配类型（recent/high） */
        private String matchType;
        private Integer matchSiteCount;
        private Double matchCount;
        private String lastMatchTime;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class InternetCafeRecord {
        private String startTime;
        private String endTime;
        private String duration;
        private String cafeName;
        private String cafeAddress;
    }

    /** L4 档案结构化检索请求 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class L4DossierRetrievalRequest {
        /** 地点标签表达式 */
        @JsonProperty("ocod_expr")
        private String ocodExpr;
        /** 时间表达式 */
        @JsonProperty("time_expr")
        private String timeExpr;
        /** 人员标签表达式 */
        @JsonProperty("opod_expr")
        private String opodExpr;
        /** 图片检索参数 */
        private Object image;
        /** 页码 */
        private Integer page;
        /** 每页数量 */
        private Integer limit;
    }

    /** L4 档案检索响应 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class L4DossierRetrievalResponse {
        /** 接收状态。0表示接收正常，非0表示接收异常 */
        private Integer rtn;
        /** 接收状态描述 */
        private String message;
        /** 操作类型 */
        private String action;
        /** 总数 */
        private Integer total;
        /** 档案检索结果 */
        private List<Object> result;
    }

    /** L4o 任务下发请求 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class L4oTaskRequest {
        /** 任务名称 */
        @JsonProperty("task_name")
        private String taskName;
        /** 身份标签表达式 */
        @JsonProperty("opod_expr")
        private List<String> opodExpr;
        /** 地点标签表达式 */
        @JsonProperty("ocod_expr")
        private List<String> ocodExpr;
        /** 摄像头 ID 列表 */
        @JsonProperty("camera_ids")
        private List<String> cameraIds;
        /** 时间表达式 */
        @JsonProperty("time_expr")
        private Object timeExpr;
    }

    /** L5 任务下发请求 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class L5TaskRequest {
        /** 任务名称 */
        @JsonProperty("task_name")
        private String taskName;
        /** 自然语言任务描述 */
        private String text;
    }

    /** 旧版 API 通用响应格式 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class LagencyResponse {
        /** 返回码，0表示成功 */
        private Integer rtn;
        /** 返回消息 */
        private String message;
    }

    /** 摄像头列表响应 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ListCamerasResponse {
        /** 接收状态。0表示接收正常，非0表示接收异常 */
        private Integer rtn;
        /** 接收状态描述 */
        private String message;
        /** 摄像头列表 */
        private List<CameraOutput> cameras;
        /** 分页信息 */
        private Pagination pagination;
    }

    /** 告警记录查询请求  查询示例: - 查询今天的告警: condition={"timestamp": {"gte": 1704067200, "lte": 1704153599}} - 相似度>=60的告警: condition={"hit_similarity": {"gte": 60}} - 组合条件: condition={"timestamp": {"gte": 1704067200, "lte": 1704153599}, "hit_similarity": {"gte": 60}} */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ListHitRecordsRequest {
        /** 布控任务引用（不传则查询所有任务的告警） */
        @JsonProperty("task_reference")
        private ResourceByURI taskReference;
        /** 需要返回的字段列表。常用字段: id, uri, surveillance_uri, task_name, camera_uri, camera_address, timestamp, face_image_uri, hit_repository_uri, hit_similarity, hit_name, hit_person_id, hit_face_image_uri, annotation, picture_uri */
        private List<String> fields;
        /** 过滤条件。支持格式: 等值匹配如 {"surveillance_id": 123}; 范围查询如 {"timestamp": {"gte": 1704067200, "lte": 1704153599}}; 相似度过滤如 {"hit_similarity": {"gte": 60}}。timestamp 使用 Unix 时间戳（秒） */
        private Object condition;
        /** 排序方式。格式: {"字段名": "asc或desc"}。示例: {"timestamp": "desc"} 表示按时间倒序 */
        private Object order;
        /** 相机标签ID列表，用于权限过滤（按 tag_ids 字段 $in 匹配） */
        @JsonProperty("camera_tag_ids")
        private List<Integer> cameraTagIds;
        /** 页码（从1开始） */
        private Integer page;
        /** 每页数量 */
        private Integer limit;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ListHitRecordsResponse {
        /** 接收状态。0表示接收正常，非0表示接收异常 */
        private Integer rtn;
        /** 接收状态描述 */
        private String message;
        /** 告警记录列表 */
        @JsonProperty("hit_records")
        private List<HitRecordOutput> hitRecords;
        /** 分页信息 */
        private Pagination pagination;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ListRecordsRequest {
        /** 需要返回的字段 */
        private List<String> fields;
        /** 查询条件。支持: 等值匹配 {"name": "张三"}, 范围查询 {"timestamp": {"gte": 1700000000}}, 集合查询 {"gender": {"in": [1, 2]}} */
        private Object condition;
        /** 排序规则，仅支持单字段 */
        private Object order;
        /** 页码（从1开始） */
        private Integer page;
        /** 每页数量 */
        private Integer limit;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ListRecordsResponse {
        /** 接收状态。0表示接收正常，非0表示接收异常 */
        private Integer rtn;
        /** 接收状态描述 */
        private String message;
        /** 记录列表 */
        private List<CaptureFaceRecordOutput> records;
        /** 分页信息 */
        private Pagination pagination;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ListReposResponse {
        /** 接收状态。0表示接收正常，非0表示接收异常 */
        private Integer rtn;
        /** 接收状态描述 */
        private String message;
        /** 库列表 */
        private List<RepositoryOutput> repositories;
        /** 分页信息 */
        private Pagination pagination;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ListTasksResponse {
        /** 接收状态。0表示接收正常，非0表示接收异常 */
        private Integer rtn;
        /** 接收状态描述 */
        private String message;
        /** 布控任务列表 */
        private List<SurveillanceTaskOutput> tasks;
        /** 分页信息 */
        private Pagination pagination;
    }

    /** 地理位置信息 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Location {
        /** 经度 */
        private Double lng;
        /** 纬度 */
        private Double lat;
        /** 地址描述 */
        private String address;
        /** 海拔高度（米） */
        private Double altitude;
    }

    /** 位置类型  - indoor: 室内 - outdoor: 室外 - semi-outdoor: 半室外 */
    public enum LocationType {
        INDOOR("indoor"),
        OUTDOOR("outdoor"),
        SEMI_OUTDOOR("semi_outdoor");

        private final Object value;
        LocationType(Object value) { this.value = value; }
        @JsonValue
        public Object getValue() { return value; }
    }

    /** 登录请求 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class LoginInput {
        /** 用户名 */
        private String username;
        /** 密码 */
        private String password;
    }

    /** 登录响应 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class LoginResponse {
        /** 接收状态。0表示接收正常，非0表示接收异常 */
        private Integer rtn;
        /** 接收状态描述 */
        private String message;
        /** 用户ID */
        @JsonProperty("user_id")
        private Integer userId;
        /** 用户名 */
        private String username;
        /** 认证 Token（也会通过 Set-Cookie 设置） */
        private String token;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MacInfo {
        private String macAddress;
        private String matchStatus;
        private Integer hitCount;
        private Integer maxHitCount;
        private String lastHitTime;
    }

    /** 标签匹配模式 */
    public enum MatchMode {
        ANY("any"),
        ALL("all");

        private final Object value;
        MatchMode(Object value) { this.value = value; }
        @JsonValue
        public Object getValue() { return value; }
    }

    /** 当前用户信息响应 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MeResponse {
        /** 接收状态。0表示接收正常，非0表示接收异常 */
        private Integer rtn;
        /** 接收状态描述 */
        private String message;
        /** 用户ID */
        @JsonProperty("user_id")
        private Integer userId;
        /** 用户名 */
        private String username;
        /** 用户 Token（可用于 API 调用） */
        private String token;
        /** 用户角色URI列表 */
        private List<String> roles;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ModelThreshold {
        @JsonProperty("model_id")
        private String modelId;
        @JsonProperty("threshold_value")
        private Integer thresholdValue;
        @JsonProperty("threshold_type")
        private String thresholdType;
        @JsonProperty("min_value")
        private Integer minValue;
        @JsonProperty("max_value")
        private Integer maxValue;
        private String description;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class NetworkInfo {
        private String broadbandAccount;
        private Integer broadbandCount;
        private String broadbandLink;
        private String mac;
        private Integer macCount;
        private String macLink;
    }

    /** 任务编排请求 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class OrchestrationRequest {
        /** 用户的自然语言任务描述 */
        @JsonProperty("user_input")
        private String userInput;
        /** 会话 ID（可选，用于多轮对话） */
        @JsonProperty("session_id")
        private String sessionId;
        /** 是否流式输出 */
        private Boolean stream;
    }

    /** 排序参数 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class OrderParams {
        /** 排序字段 */
        private String field;
        /** 排序方向 */
        private String direction;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Pagination {
        /** 总记录数 */
        private Integer total;
        /** 当前页码 */
        private Integer page;
        /** 每页数量 */
        private Integer limit;
        /** 总页数 */
        private Integer pages;
    }

    /** 权限对象 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Permission {
        /** 角色ID */
        @JsonProperty("role_id")
        private Integer roleId;
        /** 资源类型 */
        @JsonProperty("resource_type")
        private String resourceType;
        /** 标签ID */
        @JsonProperty("tag_id")
        private Integer tagId;
        /** 操作类型 */
        private ActionEnum action;
    }

    /** 权限列表响应 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PermissionListResponse {
        /** 接收状态。0表示接收正常，非0表示接收异常 */
        private Integer rtn;
        /** 接收状态描述 */
        private String message;
        /** 权限总数 */
        private Integer total;
        /** 权限列表 */
        private List<Permission> permissions;
    }

    /** 2D点坐标 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Point2D {
        private Integer x;
        private Integer y;
    }

    /** 点位类型  - entrance: 出入口 - corridor: 走廊 - parking: 停车场 - perimeter: 周界 - lobby: 大厅 - office: 办公区 */
    public enum PointType {
        ENTRANCE("entrance"),
        CORRIDOR("corridor"),
        PARKING("parking"),
        PERIMETER("perimeter"),
        LOBBY("lobby"),
        OFFICE("office");

        private final Object value;
        PointType(Object value) { this.value = value; }
        @JsonValue
        public Object getValue() { return value; }
    }

    /** 处置类型 */
    public enum ProcessType {
        _0(0),
        _1(1),
        _2(2);

        private final Object value;
        ProcessType(Object value) { this.value = value; }
        @JsonValue
        public Object getValue() { return value; }
    }

    /** 查询权限请求 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class QueryPermissionBody {
        /** 角色引用 */
        @JsonProperty("role_reference")
        private ResourceByURI roleReference;
        /** 标签引用 */
        @JsonProperty("tag_reference")
        private ResourceByURI tagReference;
        /** 操作类型 */
        private ActionEnum action;
    }

    /** 查询接口通用响应 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class QueryResponse {
        /** 返回码，0表示成功 */
        private Integer rtn;
        /** 返回消息 */
        private String message;
        /** 结果总数 */
        private Integer total;
        /** 结果列表 */
        private List<Object> results;
    }

    /** 实时追踪请求 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RealtimeTrackingRequest {
        /** 人员姓名 */
        private String name;
        /** 档案 ID */
        @JsonProperty("dossier_id")
        private String dossierId;
    }

    /** 矩形框 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Rect2D {
        private Integer x;
        private Integer y;
        private Integer width;
        private Integer height;
    }

    /** 刷新 Token 响应 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RefreshTokenResponse {
        /** 接收状态。0表示接收正常，非0表示接收异常 */
        private Integer rtn;
        /** 接收状态描述 */
        private String message;
        /** 新的 Token */
        private String token;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Relation {
        private String id;
        private String uri;
        private String relation;
        private String name;
        private String avatar;
        private List<String> tags;
    }

    /** 关系人档案信息（简化版） */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RelationInfo {
        /** 姓名 */
        private String name;
        /** 标签列表 */
        private List<String> tags;
    }

    /** 社会关系信息  表示目标人员与关系人之间的静态社会关系 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RelationItem {
        /** 关系人档案 ID */
        @JsonProperty("relation_id")
        private String relationId;
        /** 关系类型（如：家人、同乡、亲属、同事、朋友） */
        @JsonProperty("relation_type")
        private String relationType;
        /** 关系强度（0.0-1.0，基于关系类型权重） */
        @JsonProperty("relation_strength")
        private Double relationStrength;
        /** 关系人档案信息 */
        @JsonProperty("relation_info")
        private RelationInfo relationInfo;
    }

    /** 关系分析响应数据  包含目标人员的社会关系网络，按关系强度降序排列 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RelationshipAnalysisDataInput {
        /** 关系总数 */
        private Integer total;
        /** 目标人员档案 ID */
        @JsonProperty("target_dossier_id")
        private String targetDossierId;
        /** 应用的关系类型过滤条件 */
        @JsonProperty("relation_types_filter")
        private List<String> relationTypesFilter;
        /** 关系列表，按关系强度降序 */
        private List<RelationItem> results;
    }

    /** 关系分析响应数据  包含目标人员的社会关系网络，按关系强度降序排列 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RelationshipAnalysisDataOutput {
        /** 关系总数 */
        private Integer total;
        /** 目标人员档案 ID */
        @JsonProperty("target_dossier_id")
        private String targetDossierId;
        /** 应用的关系类型过滤条件 */
        @JsonProperty("relation_types_filter")
        private List<String> relationTypesFilter;
        /** 关系列表，按关系强度降序 */
        private List<RelationItem> results;
    }

    /** 关系分析请求  功能：查询档案库中目标人员的静态社会关系（亲属、同乡等）  字段说明： - target_dossier_uri: 目标人员档案 URI（转换后为 target_dossier_id） - relation_types: 关系类型过滤（可选） */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RelationshipAnalysisRequest {
        /** 目标人员档案 URI */
        @JsonProperty("target_dossier_uri")
        private String targetDossierUri;
        /** 关系类型过滤（可选），如 ['家人', '同乡', '亲属'] */
        @JsonProperty("relation_types")
        private List<String> relationTypes;
    }

    /** 关系分析响应  data 字段为社会关系网络 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RelationshipAnalysisResponse {
        /** 接收状态。0表示接收正常，非0表示接收异常 */
        private Integer rtn;
        /** 接收状态描述 */
        private String message;
        /** 请求追踪 ID */
        @JsonProperty("request_id")
        private String requestId;
        /** 执行耗时（毫秒） */
        @JsonProperty("execution_time_ms")
        private Double executionTimeMs;
        /** 关系分析数据 */
        private RelationshipAnalysisDataOutput data;
    }

    /** VF Master 上的远程任务 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RemoteTask {
        @JsonProperty("atomic_event_id")
        private String atomicEventId;
        private String state;
        @JsonProperty("worker_id")
        private String workerId;
        @JsonProperty("internal_status")
        private String internalStatus;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RepositoryInput {
        private ResourceReferenceFull reference;
        /** 资源全局唯一标识符（type:id@cluster_id） */
        private String uri;
        @JsonProperty("created_at")
        private String createdAt;
        @JsonProperty("updated_at")
        private String updatedAt;
        /** 资源类型标识（如：camera、region、repository 等） */
        private String type;
        /** 库名称 */
        private String name;
        /** 备注 */
        private String comment;
        /** 库类型 */
        @JsonProperty("repo_type")
        private RepositoryType repoType;
        /** 数据类型 */
        @JsonProperty("data_type")
        private DataType dataType;
        /** 库内记录总数 */
        @JsonProperty("record_count")
        private Integer recordCount;
        /** 保密等级 */
        @JsonProperty("security_level")
        private SecurityLevel securityLevel;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RepositoryOutput {
        /** 资源全局唯一标识符（type:id@cluster_id） */
        private String uri;
        @JsonProperty("created_at")
        private String createdAt;
        @JsonProperty("updated_at")
        private String updatedAt;
        /** 资源类型标识（如：camera、region、repository 等） */
        private String type;
        /** 库名称 */
        private String name;
        /** 备注 */
        private String comment;
        /** 库类型 */
        @JsonProperty("repo_type")
        private RepositoryType repoType;
        /** 数据类型 */
        @JsonProperty("data_type")
        private DataType dataType;
        /** 库内记录总数 */
        @JsonProperty("record_count")
        private Integer recordCount;
        /** 保密等级 */
        @JsonProperty("security_level")
        private SecurityLevel securityLevel;
    }

    /** 创建库的输入模型，所有必填字段 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RepositoryInput2 {
        /** 库名称 */
        private String name;
        /** 备注 */
        private String comment;
        @JsonProperty("repo_type")
        private RepositoryType repoType;
        @JsonProperty("data_type")
        private DataType dataType;
        @JsonProperty("security_level")
        private SecurityLevel securityLevel;
    }

    /** 库的存储类型 */
    public enum RepositoryType {
        STATIC("static"),
        DYNAMIC("dynamic");

        private final Object value;
        RepositoryType(Object value) { this.value = value; }
        @JsonValue
        public Object getValue() { return value; }
    }

    /** 更新库的输入模型，所有字段可选（用于 PATCH 部分更新） */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RepositoryUpdate {
        private String name;
        private Object comment;
        @JsonProperty("repo_type")
        private RepositoryType repoType;
        @JsonProperty("data_type")
        private DataType dataType;
        @JsonProperty("security_level")
        private SecurityLevel securityLevel;
    }

    /** 分辨率规格  - 720P: 高清(1280*720) - 1080P: 全高清(1920*1080) - 540*960: 竖屏高清 - 1440*2560: 2K分辨率 - 2160*3840: 4K分辨率 */
    public enum Resolution {
        _720P("720P"),
        _1080P("1080P"),
        _540_960("540*960"),
        _1440_2560("1440*2560"),
        _2160_3840("2160*3840");

        private final Object value;
        Resolution(Object value) { this.value = value; }
        @JsonValue
        public Object getValue() { return value; }
    }

    /** 资源引用结构，用于表示对其他资源的引用  总是包含 uri、id、cluster_id、type 全部字段 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ResourceReferenceFull {
        /**  资源的全局唯一标识符，格式为 `type:id@cluster_id`  **格式说明**： - type: 资源类型标识（小写字母开头，可包含小写字母、数字、点、下划线、连字符） - id: 资源在集群内的ID，支持整数或字符串（字母、数字、点、下划线、连字符、波浪号、井号） - @: 固定分隔符 - cluster_id: 资源所属的集群标识（字母、数字、点、下划线、连字符、波浪号）  **示例**： - camera:1001@cluster_1 (整数型ID摄像头资源) - camera:9328475629384756@cluster-a (Snowflake ID摄像头资源) - repository:repo_001@hz-core (字符串型ID人像库资源) - record.face:313@cluster_1 (人脸记录资源) - user:u_001@cn-prod (用户资源)  **约束规则**： - type 必须以小写字母开头，支持层级结构（如 record.face） - id 支持整数或字符串，字符串型 1-128 个字符 - cluster_id 必须是有效的集群标识符  **使用场景**： - 跨集群资源引用 - 全局资源定位 - 资源所有权明确标识 */
        private String uri;
        /**  资源在集群内的唯一标识符（局部ID） 支持整数型（如数据库自增ID）或字符串型（如 Snowflake ID、UUID 等） - 整数型: 0 到 2^64-1，兼容 protobuf uint64 类型 - 字符串型: 1-128个字符，支持字母、数字、点、下划线、连字符、波浪号 */
        private Integer id;
        /** 集群的唯一标识符 */
        @JsonProperty("cluster_id")
        private String clusterId;
        /** 资源类型标识（如：camera、region、repository 等） */
        private String type;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ResourceReferenceResponse {
        /** 接收状态。0表示接收正常，非0表示接收异常 */
        private Integer rtn;
        /** 接收状态描述 */
        private String message;
        private ResourceReferenceFull reference;
    }

    /** 检索参数对象（通用） */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RetrievalParams {
        /** 检索图片（base64编码）- 若未提供特征，尝试从图片提取。依赖后端特征提取服务。 */
        @JsonProperty("image_content_base64")
        private String imageContentBase64;
        /** 检索特征（Base64编码）- 优先使用。若提供，将忽略图片提取。 */
        @JsonProperty("feature_base64")
        private String featureBase64;
        /** 多算法特征映射（高级用法），key为算法标识，value为特征Base64。若提供，优先使用。 */
        @JsonProperty("rec_feature_base64")
        private Object recFeatureBase64;
        /** 人脸框位置（仅人脸检索时使用） */
        @JsonProperty("face_rect")
        private ModelsCaptureRecordFaceRect faceRect;
        /** 相似度阈值（范围：0-100） */
        private Double threshold;
        /** 返回最多结果数 */
        private Integer topk;
    }

    /** 检索响应 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RetrievalResponse {
        /** 接收状态。0表示接收正常，非0表示接收异常 */
        private Integer rtn;
        /** 接收状态描述 */
        private String message;
        /** 检索查询ID（用于缓存复用） */
        @JsonProperty("retrieval_query_id")
        private Integer retrievalQueryId;
        /** 检索结果总数 */
        private Integer total;
        /** 检索结果列表 */
        private List<RetrievalResultItemOutput> results;
        /** 各阶段耗时统计(毫秒) */
        private Object profiling;
    }

    /** 单条检索结果 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RetrievalResultItemInput {
        /** 记录对象（人脸或人体记录） */
        private CaptureFaceRecordInput record;
        /** 相似度分数（范围：0-100） */
        private Double similarity;
    }

    /** 单条检索结果 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RetrievalResultItemOutput {
        /** 记录对象（人脸或人体记录） */
        private CaptureFaceRecordOutput record;
        /** 相似度分数（范围：0-100） */
        private Double similarity;
    }

    /** 同行反查响应数据  包含已识别的同行人和反查到的疑似嫌疑人列表 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReverseCompanionDataInput {
        /** 符合条件的嫌疑人总数 */
        private Integer total;
        /** 已识别的同行人（查询起点） */
        @JsonProperty("identified_companion")
        private IdentifiedCompanion identifiedCompanion;
        /** 疑似嫌疑人列表，按伴随次数降序 */
        private List<SuspectItem> results;
    }

    /** 同行反查响应数据  包含已识别的同行人和反查到的疑似嫌疑人列表 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReverseCompanionDataOutput {
        /** 符合条件的嫌疑人总数 */
        private Integer total;
        /** 已识别的同行人（查询起点） */
        @JsonProperty("identified_companion")
        private IdentifiedCompanion identifiedCompanion;
        /** 疑似嫌疑人列表，按伴随次数降序 */
        private List<SuspectItem> results;
    }

    /** 同行反查请求  功能：通过清晰同行人反向定位模糊嫌疑人  业务场景： 已知一个清晰图片的同行人（person_uri），反向查找与该人同行的其他人员， 用于确定模糊嫌疑人的身份信息。  字段说明： - person_uri: 已知同行人员档案 URI（转换后为 person_id） - time_start/time_end: 时间范围 - camera_list: 地点过滤（可选） - time_window_seconds: 时间窗口 - min_co_appearances: 最小共现次数（过滤阈值） */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReverseCompanionRequest {
        /** 已知同行人员档案 URI（用于反查） */
        @JsonProperty("person_uri")
        private String personUri;
        /** 开始时间（Unix 秒） */
        @JsonProperty("time_start")
        private Integer timeStart;
        /** 结束时间（Unix 秒） */
        @JsonProperty("time_end")
        private Integer timeEnd;
        /** 地点 URI 列表（可选） */
        @JsonProperty("camera_list")
        private List<String> cameraList;
        /** 时间窗口（±秒），默认 300 */
        @JsonProperty("time_window_seconds")
        private Integer timeWindowSeconds;
        /** 最小共现次数（过滤阈值），默认 2 */
        @JsonProperty("min_co_appearances")
        private Integer minCoAppearances;
    }

    /** 同行反查响应  data 字段包含已识别同行人和疑似嫌疑人列表 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReverseCompanionResponse {
        /** 接收状态。0表示接收正常，非0表示接收异常 */
        private Integer rtn;
        /** 接收状态描述 */
        private String message;
        /** 请求追踪 ID */
        @JsonProperty("request_id")
        private String requestId;
        /** 执行耗时（毫秒） */
        @JsonProperty("execution_time_ms")
        private Double executionTimeMs;
        /** 同行反查数据 */
        private ReverseCompanionDataOutput data;
    }

    /** 角色对象  角色设计： - id: 自增整数，唯一标识（配合 cluster_id） - role_name: 角色名称（不能重复，在同一 cluster_id 下） */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RoleInput {
        /** 角色名称（可包含中文，用于显示） */
        @JsonProperty("role_name")
        private String roleName;
        /** 角色描述 */
        private String description;
        private ResourceReferenceFull reference;
        /** 资源全局唯一标识符（type:id@cluster_id） */
        private String uri;
        @JsonProperty("created_at")
        private String createdAt;
        @JsonProperty("updated_at")
        private String updatedAt;
    }

    /** 角色对象  角色设计： - id: 自增整数，唯一标识（配合 cluster_id） - role_name: 角色名称（不能重复，在同一 cluster_id 下） */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RoleOutput {
        /** 角色名称（可包含中文，用于显示） */
        @JsonProperty("role_name")
        private String roleName;
        /** 角色描述 */
        private String description;
        /** 资源全局唯一标识符（type:id@cluster_id） */
        private String uri;
        @JsonProperty("created_at")
        private String createdAt;
        @JsonProperty("updated_at")
        private String updatedAt;
    }

    /** 角色列表响应 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RoleListResponse {
        /** 接收状态。0表示接收正常，非0表示接收异常 */
        private Integer rtn;
        /** 接收状态描述 */
        private String message;
        /** 角色列表 */
        private List<RoleOutput> roles;
        /** 分页信息 */
        private Pagination pagination;
    }

    /** 样本列表响应 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SampleListResponse {
        /** 接收状态。0表示接收正常，非0表示接收异常 */
        private Integer rtn;
        /** 接收状态描述 */
        private String message;
        /** 样本数据 */
        private Object data;
    }

    /** 样本推荐类型 */
    public enum SampleType {
        POSITIVE("positive"),
        NEGATIVE("negative"),
        FUZZY("fuzzy");

        private final Object value;
        SampleType(Object value) { this.value = value; }
        @JsonValue
        public Object getValue() { return value; }
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SearchReposRequest {
        /** 过滤条件 */
        private Object filters;
        /** 页码（从1开始） */
        private Integer page;
        /** 每页数量 */
        private Integer limit;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SearchReposResponse {
        /** 接收状态。0表示接收正常，非0表示接收异常 */
        private Integer rtn;
        /** 接收状态描述 */
        private String message;
        /** 库列表 */
        private List<RepositoryOutput> repositories;
        /** 分页信息 */
        private Pagination pagination;
    }

    /** 保密等级 */
    public enum SecurityLevel {
        A("A"),
        B("B"),
        C("C");

        private final Object value;
        SecurityLevel(Object value) { this.value = value; }
        @JsonValue
        public Object getValue() { return value; }
    }

    /** L5 语义检索请求 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SemanticRetrievalRequest {
        /** 检索文本 */
        private String text;
        /** 时间表达式 */
        @JsonProperty("time_expr")
        private String timeExpr;
        /** 地点标签表达式 */
        @JsonProperty("ocod_expr")
        private String ocodExpr;
        /** 页码 */
        private Integer page;
        /** 每页数量 */
        private Integer limit;
    }

    /** 语义检索响应 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SemanticRetrievalResponse {
        /** 接收状态。0表示接收正常，非0表示接收异常 */
        private Integer rtn;
        /** 接收状态描述 */
        private String message;
        /** 操作类型 */
        private String action;
        /** 总数 */
        private Integer total;
        /** 检索结果 */
        private List<Object> result;
    }

    /** 单个权限响应 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SinglePermissionResponse {
        /** 接收状态。0表示接收正常，非0表示接收异常 */
        private Integer rtn;
        /** 接收状态描述 */
        private String message;
        private Permission permission;
    }

    /** 单个角色响应 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SingleRoleResponse {
        /** 接收状态。0表示接收正常，非0表示接收异常 */
        private Integer rtn;
        /** 接收状态描述 */
        private String message;
        private RoleOutput role;
    }

    /** 单个标签响应 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SingleTagResponse {
        /** 接收状态。0表示接收正常，非0表示接收异常 */
        private Integer rtn;
        /** 接收状态描述 */
        private String message;
        private TagOutput tag;
    }

    /** 单个用户响应 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SingleUserResponse {
        /** 接收状态。0表示接收正常，非0表示接收异常 */
        private Integer rtn;
        /** 接收状态描述 */
        private String message;
        private UserOutput user;
    }

    /** 时空检索条件（用于L2动态库检索）  用于查询过人记录/轨迹数据。所有字段可选，不指定则检索全部数据。  **时间格式**：使用北京时间，格式为 ISO 8601（如 2026-01-27T09:00:00）  **示例**： - 查询今天上午9点到10点：{"time_start": "2026-01-27T09:00:00", "time_end": "2026-01-27T10:00:00"} - 查询指定摄像头：{"camera_uris": ["camera:2@bodhi-229-dev"]} - 组合查询：{"time_start": "2026-01-27T09:00:00", "time_end": "2026-01-27T10:00:00", "camera_uris": ["camera:2@bodhi-229-dev"]} */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SpatialTemporalCondition {
        /** 开始时间（北京时间，ISO 8601格式如 2026-01-27T09:00:00） */
        @JsonProperty("time_start")
        private String timeStart;
        /** 结束时间（北京时间，ISO 8601格式如 2026-01-27T10:00:00） */
        @JsonProperty("time_end")
        private String timeEnd;
        /** 摄像头URI列表（格式：camera:{id}@{cluster_id}，最多100个） */
        @JsonProperty("camera_uris")
        private List<String> cameraUris;
        /** 摄像头标签ID列表，按标签筛选摄像头 */
        @JsonProperty("camera_tag_ids")
        private List<Integer> cameraTagIds;
    }

    /** 时空碰撞响应数据  包含在指定时空区域都出现过的人员列表，按碰撞得分降序排列 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SpatiotemporalCollisionDataInput {
        /** 碰撞人员总数 */
        private Integer total;
        /** 查询区域总数 */
        @JsonProperty("zones_count")
        private Integer zonesCount;
        /** 最小匹配要求 */
        @JsonProperty("min_match_count")
        private Integer minMatchCount;
        /** 碰撞结果列表，按得分降序 */
        private List<CollisionItem> results;
    }

    /** 时空碰撞响应数据  包含在指定时空区域都出现过的人员列表，按碰撞得分降序排列 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SpatiotemporalCollisionDataOutput {
        /** 碰撞人员总数 */
        private Integer total;
        /** 查询区域总数 */
        @JsonProperty("zones_count")
        private Integer zonesCount;
        /** 最小匹配要求 */
        @JsonProperty("min_match_count")
        private Integer minMatchCount;
        /** 碰撞结果列表，按得分降序 */
        private List<CollisionItem> results;
    }

    /** 时空碰撞请求  功能：查找在多个离散时空区域都出现过的人员（用于串并案分析）  字段说明： - zones: 时空区域列表（1-10 个） - min_match_count: 最小匹配区域数（可选，默认 = zones.length 全匹配） */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SpatiotemporalCollisionRequest {
        /** 时空区域列表（1-10 个） */
        private List<TacticalZone> zones;
        /** 最小匹配区域数（默认 = zones 数量，即全匹配） */
        @JsonProperty("min_match_count")
        private Integer minMatchCount;
    }

    /** 时空碰撞响应  data 字段为碰撞人员列表，用于串并案分析 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SpatiotemporalCollisionResponse {
        /** 接收状态。0表示接收正常，非0表示接收异常 */
        private Integer rtn;
        /** 接收状态描述 */
        private String message;
        /** 请求追踪 ID */
        @JsonProperty("request_id")
        private String requestId;
        /** 执行耗时（毫秒） */
        @JsonProperty("execution_time_ms")
        private Double executionTimeMs;
        /** 时空碰撞数据 */
        private SpatiotemporalCollisionDataOutput data;
    }

    /** L1静态库检索请求参数 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class StaticRetrievalRequest {
        /** 静态库URI列表（当前仅支持单个） */
        @JsonProperty("repository_uris")
        private List<String> repositoryUris;
        /** 检索查询ID（用于获取缓存结果） */
        @JsonProperty("retrieval_query_id")
        private Integer retrievalQueryId;
        /** 检索参数对象（特征检索时必填，纯结构化检索时可省略） */
        private RetrievalParams retrieval;
        /** 结构化过滤条件 */
        private FaceRecordCondition condition;
        /** 排序参数 */
        private OrderParams order;
        /** 返回字段列表（必填） */
        private List<String> fields;
        /** 分页起始位置 */
        private Integer start;
        /** 分页大小 */
        private Integer limit;
        /** 检索附加元信息 */
        @JsonProperty("query_meta")
        private Object queryMeta;
        /** 是否记录检索日志 */
        @JsonProperty("enable_log_query_result")
        private Boolean enableLogQueryResult;
    }

    /** 子任务状态 */
    public enum SubTaskStatus {
        READY("READY"),
        NOT_READY("NOT_READY"),
        INNER_ALGO("INNER_ALGO"),
        TRAINING("TRAINING"),
        TRAINED("TRAINED"),
        TRAIN_FAILED("TRAIN_FAILED"),
        UN_TRAIN("UN_TRAIN");

        private final Object value;
        SubTaskStatus(Object value) { this.value = value; }
        @JsonValue
        public Object getValue() { return value; }
    }

    /** 布控模式 */
    public enum SurveillanceMode {
        STANDARD("standard"),
        L4O("L4o"),
        L5("L5");

        private final Object value;
        SurveillanceMode(Object value) { this.value = value; }
        @JsonValue
        public Object getValue() { return value; }
    }

    /** 布控范围配置  规则： - tags 和 camera_uris 至少提供一个 - 两者同时存在时，取并集 - tags: 关联所有 tags 字段与指定标签ID有交集的相机 - camera_uris: 直接指定具体相机 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SurveillanceScope {
        /** 标签ID列表，关联所有 tags 字段与此列表有交集的相机 */
        private List<Integer> tags;
        /** 摄像头URI列表，直接指定具体相机 */
        @JsonProperty("camera_uris")
        private List<String> cameraUris;
    }

    /** 布控任务完整模型 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SurveillanceTaskInput {
        private ResourceReferenceFull reference;
        /** 资源全局唯一标识符（type:id@cluster_id） */
        private String uri;
        @JsonProperty("created_at")
        private String createdAt;
        @JsonProperty("updated_at")
        private String updatedAt;
        /** 资源类型标识（如：camera、region、repository 等） */
        private String type;
        /** 任务名称 */
        private String name;
        /** 是否启用任务 */
        private Boolean enabled;
        /** 扩展元信息 */
        private Object meta;
        /** 任务状态 */
        @JsonProperty("task_status")
        private TaskStatus taskStatus;
        /** 布控范围 */
        @JsonProperty("surveillance_scope")
        private SurveillanceScope surveillanceScope;
        @JsonProperty("surveillance_mode")
        private SurveillanceMode surveillanceMode;
        /** 静态库URI列表 */
        @JsonProperty("repository_uris")
        private List<String> repositoryUris;
        /** 目标记录的标签ID列表 */
        @JsonProperty("target_record_tag_ids")
        private List<Integer> targetRecordTagIds;
        /** 目标记录标签匹配模式 */
        @JsonProperty("target_record_tag_match_mode")
        private MatchMode targetRecordTagMatchMode;
        /** 相似度阈值（范围：0-100） */
        private Double threshold;
        @JsonProperty("database_type")
        private DatabaseType databaseType;
        @JsonProperty("process_type")
        private ProcessType processType;
        @JsonProperty("surveillance_type")
        private SurveillanceType surveillanceType;
        /** 临时布控开始时间 */
        @JsonProperty("start_timestamp")
        private Integer startTimestamp;
        /** 临时布控结束时间 */
        @JsonProperty("end_timestamp")
        private Integer endTimestamp;
        /** 告警记录总数（只读） */
        @JsonProperty("hit_count")
        private Integer hitCount;
        /** L4o 布控规则配置 */
        @JsonProperty("l4o_rules")
        private Object l4oRules;
        /** L5 语义布控的语义查询表达式 */
        @JsonProperty("semantic_query")
        private String semanticQuery;
    }

    /** 布控任务完整模型 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SurveillanceTaskOutput {
        /** 资源全局唯一标识符（type:id@cluster_id） */
        private String uri;
        @JsonProperty("created_at")
        private String createdAt;
        @JsonProperty("updated_at")
        private String updatedAt;
        /** 资源类型标识（如：camera、region、repository 等） */
        private String type;
        /** 任务名称 */
        private String name;
        /** 是否启用任务 */
        private Boolean enabled;
        /** 扩展元信息 */
        private Object meta;
        /** 任务状态 */
        @JsonProperty("task_status")
        private TaskStatus taskStatus;
        /** 布控范围 */
        @JsonProperty("surveillance_scope")
        private SurveillanceScope surveillanceScope;
        @JsonProperty("surveillance_mode")
        private SurveillanceMode surveillanceMode;
        /** 静态库URI列表 */
        @JsonProperty("repository_uris")
        private List<String> repositoryUris;
        /** 目标记录的标签ID列表 */
        @JsonProperty("target_record_tag_ids")
        private List<Integer> targetRecordTagIds;
        /** 目标记录标签匹配模式 */
        @JsonProperty("target_record_tag_match_mode")
        private MatchMode targetRecordTagMatchMode;
        /** 相似度阈值（范围：0-100） */
        private Double threshold;
        @JsonProperty("database_type")
        private DatabaseType databaseType;
        @JsonProperty("process_type")
        private ProcessType processType;
        @JsonProperty("surveillance_type")
        private SurveillanceType surveillanceType;
        /** 临时布控开始时间 */
        @JsonProperty("start_timestamp")
        private Integer startTimestamp;
        /** 临时布控结束时间 */
        @JsonProperty("end_timestamp")
        private Integer endTimestamp;
        /** 告警记录总数（只读） */
        @JsonProperty("hit_count")
        private Integer hitCount;
        /** L4o 布控规则配置 */
        @JsonProperty("l4o_rules")
        private Object l4oRules;
        /** L5 语义布控的语义查询表达式 */
        @JsonProperty("semantic_query")
        private String semanticQuery;
    }

    /** 创建/更新布控任务的输入模型 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SurveillanceTaskInput2 {
        /** 布控任务名称 */
        private String name;
        /** 是否启用布控 */
        private Boolean enabled;
        /** 扩展元信息 */
        private Object meta;
        /** 布控范围 */
        @JsonProperty("surveillance_scope")
        private SurveillanceScope surveillanceScope;
        @JsonProperty("surveillance_mode")
        private SurveillanceMode surveillanceMode;
        /** 静态库URI列表（database_type为0时必填） */
        @JsonProperty("repository_uris")
        private List<String> repositoryUris;
        /** 目标记录的标签ID列表（当提供 repository_uris 时，对这些库内记录按标签取交集筛选） */
        @JsonProperty("target_record_tag_ids")
        private List<Integer> targetRecordTagIds;
        /** 目标记录标签匹配模式（any：包含任一标签；all：必须同时包含所有标签） */
        @JsonProperty("target_record_tag_match_mode")
        private MatchMode targetRecordTagMatchMode;
        /** 相似度阈值（范围：0-100） */
        private Double threshold;
        @JsonProperty("database_type")
        private DatabaseType databaseType;
        @JsonProperty("process_type")
        private ProcessType processType;
        @JsonProperty("surveillance_type")
        private SurveillanceType surveillanceType;
        /** 临时布控开始时间（Unix时间戳） */
        @JsonProperty("start_timestamp")
        private Integer startTimestamp;
        /** 临时布控结束时间（Unix时间戳） */
        @JsonProperty("end_timestamp")
        private Integer endTimestamp;
        /** L4o 布控规则配置（surveillance_mode=L4o 时可提供） */
        @JsonProperty("l4o_rules")
        private Object l4oRules;
        /** L5 语义布控的语义查询表达式（surveillance_mode=L5 时可提供） */
        @JsonProperty("semantic_query")
        private String semanticQuery;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SurveillanceTaskUpdate {
        /** 布控任务名称 */
        private String name;
        /** 是否启用布控 */
        private Boolean enabled;
        /** 扩展元信息 */
        private Object meta;
        /** 布控范围 */
        @JsonProperty("surveillance_scope")
        private SurveillanceScope surveillanceScope;
        /** 布控模式 */
        @JsonProperty("surveillance_mode")
        private SurveillanceMode surveillanceMode;
        /** 静态库URI列表 */
        @JsonProperty("repository_uris")
        private List<String> repositoryUris;
        /** 目标记录的标签ID列表 */
        @JsonProperty("target_record_tag_ids")
        private List<Integer> targetRecordTagIds;
        /** 目标记录标签匹配模式 */
        @JsonProperty("target_record_tag_match_mode")
        private MatchMode targetRecordTagMatchMode;
        /** 相似度阈值（范围：0-100） */
        private Double threshold;
        /** 数据库类型 */
        @JsonProperty("database_type")
        private DatabaseType databaseType;
        /** 处置类型 */
        @JsonProperty("process_type")
        private ProcessType processType;
        /** 布控类型 */
        @JsonProperty("surveillance_type")
        private SurveillanceType surveillanceType;
        /** 临时布控开始时间（Unix时间戳） */
        @JsonProperty("start_timestamp")
        private Integer startTimestamp;
        /** 临时布控结束时间（Unix时间戳） */
        @JsonProperty("end_timestamp")
        private Integer endTimestamp;
        /** L4o 布控规则配置 */
        @JsonProperty("l4o_rules")
        private Object l4oRules;
        /** L5 语义布控的语义查询表达式 */
        @JsonProperty("semantic_query")
        private String semanticQuery;
    }

    /** 布控类型 */
    public enum SurveillanceType {
        _0(0),
        _1(1);

        private final Object value;
        SurveillanceType(Object value) { this.value = value; }
        @JsonValue
        public Object getValue() { return value; }
    }

    /** 疑似嫌疑人信息  同行反查结果中，与已知同行人有伴随关系的疑似目标人员 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SuspectItem {
        /** 疑似嫌疑人档案 ID */
        @JsonProperty("suspect_dossier_id")
        private String suspectDossierId;
        /** 伴随次数 */
        @JsonProperty("co_appearance_count")
        private Integer coAppearanceCount;
        /** 共现记录列表 */
        @JsonProperty("co_appearances")
        private List<List<Object>> coAppearances;
        /** 嫌疑人档案信息 */
        @JsonProperty("suspect_info")
        private DossierInfo suspectInfo;
    }

    /** 从 VF Master 同步输入 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SyncFromVfMasterInput {
        @JsonProperty("create_missing")
        private Boolean createMissing;
        @JsonProperty("update_status")
        private Boolean updateStatus;
    }

    /** 从 VF Master 同步响应 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SyncFromVfMasterResponse {
        /** 接收状态。0表示接收正常，非0表示接收异常 */
        private Integer rtn;
        /** 接收状态描述 */
        private String message;
        private Integer discovered;
        private Integer created;
        private Integer updated;
        @JsonProperty("already_exists")
        private Integer alreadyExists;
        @JsonProperty("created_task_ids")
        private List<String> createdTaskIds;
    }

    /** 时空区域定义（用于时空碰撞分析）  每个区域包含地点列表和时间范围，用于指定一个时空窗口 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TacticalZone {
        /** 地点 URI 列表 */
        @JsonProperty("camera_list")
        private List<String> cameraList;
        /** 开始时间（Unix 秒） */
        @JsonProperty("time_start")
        private Integer timeStart;
        /** 结束时间（Unix 秒） */
        @JsonProperty("time_end")
        private Integer timeEnd;
        /** 区域名称（可选） */
        @JsonProperty("zone_name")
        private String zoneName;
    }

    /** 标签对象  标签设计： - id: 自增整数，唯一标识 - tag_path: 由 id 组成的 ltree 路径（如 1.2.3），用于数据库检索，由数据库触发器自动生成，禁止手动修改 - tag_name: 标签名称（可包含中文），用于显示 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TagInput {
        /** 资源类型 */
        @JsonProperty("resource_type")
        private String resourceType;
        /** 父标签ID（None表示根节点） */
        @JsonProperty("parent_id")
        private Integer parentId;
        /** 标签显示名称 */
        @JsonProperty("tag_name")
        private String tagName;
        /** 标签描述 */
        private String description;
        /** 同级排序权重（数值越大越靠前） */
        @JsonProperty("sort_order")
        private Integer sortOrder;
        /** 扩展元数据（可选，用于存储额外信息） */
        private Object metadata;
        private ResourceReferenceFull reference;
        /** 资源全局唯一标识符（type:id@cluster_id） */
        private String uri;
        @JsonProperty("created_at")
        private String createdAt;
        @JsonProperty("updated_at")
        private String updatedAt;
        /** 标签路径（ltree格式，由id组成，如 1.2.3） */
        @JsonProperty("tag_path")
        private String tagPath;
    }

    /** 标签对象  标签设计： - id: 自增整数，唯一标识 - tag_path: 由 id 组成的 ltree 路径（如 1.2.3），用于数据库检索，由数据库触发器自动生成，禁止手动修改 - tag_name: 标签名称（可包含中文），用于显示 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TagOutput {
        /** 资源类型 */
        @JsonProperty("resource_type")
        private String resourceType;
        /** 父标签ID（None表示根节点） */
        @JsonProperty("parent_id")
        private Integer parentId;
        /** 标签显示名称 */
        @JsonProperty("tag_name")
        private String tagName;
        /** 标签描述 */
        private String description;
        /** 同级排序权重（数值越大越靠前） */
        @JsonProperty("sort_order")
        private Integer sortOrder;
        /** 扩展元数据（可选，用于存储额外信息） */
        private Object metadata;
        /** 资源全局唯一标识符（type:id@cluster_id） */
        private String uri;
        @JsonProperty("created_at")
        private String createdAt;
        @JsonProperty("updated_at")
        private String updatedAt;
        /** 标签路径（ltree格式，由id组成，如 1.2.3） */
        @JsonProperty("tag_path")
        private String tagPath;
    }

    public enum TagAction {
        SET("set"),
        ADD("add"),
        REMOVE("remove");

        private final Object value;
        TagAction(Object value) { this.value = value; }
        @JsonValue
        public Object getValue() { return value; }
    }

    /** 标签列表响应 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TagListResponse {
        /** 接收状态。0表示接收正常，非0表示接收异常 */
        private Integer rtn;
        /** 接收状态描述 */
        private String message;
        /** 标签列表 */
        private List<TagOutput> tags;
        /** 分页信息 */
        private Pagination pagination;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TagObject {
        private String name;
        private String value;
    }

    /** 任务响应 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TaskResponse {
        /** 是否成功 */
        private Boolean success;
        /** 响应消息 */
        private String message;
        /** 响应数据 */
        private Object data;
    }

    /** 任务状态 */
    public enum TaskStatus {
        _0(0),
        _1(1),
        _2(2),
        _3(3),
        _4(4);

        private final Object value;
        TaskStatus(Object value) { this.value = value; }
        @JsonValue
        public Object getValue() { return value; }
    }

    /** 训练数据集引用 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TrainDatasetRef {
        /** 数据集ID */
        private String id;
        /** 数据集 URI */
        private String uri;
        /** 数据集名称 */
        private String name;
        /** 使用的数据集版本 */
        private Integer version;
        /** 训练标签 */
        private List<String> tags;
    }

    /** 训练任务资源  一个训练任务可以包含多个子任务，每个子任务训练一个算法。 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TrainingJobInput {
        private ResourceReferenceFull reference;
        /** 资源全局唯一标识符（type:id@cluster_id） */
        private String uri;
        /** 创建时间 */
        private Integer createdTime;
        @JsonProperty("updated_at")
        private String updatedAt;
        /** 资源类型标识（如：camera、region、repository 等） */
        private String type;
        /** 任务名称 */
        private String taskName;
        /** 任务状态 */
        private TrainingJobStatus status;
        /** 子任务列表 */
        private List<TrainingSubTask> subTasks;
        /** 开始时间 */
        private Integer startTrainTime;
        /** 结束时间 */
        private Integer endTrainTime;
        /** 总耗时（毫秒） */
        private Integer trainCostTime;
    }

    /** 训练任务资源  一个训练任务可以包含多个子任务，每个子任务训练一个算法。 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TrainingJobOutput {
        /** 资源全局唯一标识符（type:id@cluster_id） */
        private String uri;
        /** 创建时间 */
        private Integer createdTime;
        @JsonProperty("updated_at")
        private String updatedAt;
        /** 资源类型标识（如：camera、region、repository 等） */
        private String type;
        /** 任务名称 */
        private String taskName;
        /** 任务状态 */
        private TrainingJobStatus status;
        /** 子任务列表 */
        private List<TrainingSubTask> subTasks;
        /** 开始时间 */
        private Integer startTrainTime;
        /** 结束时间 */
        private Integer endTrainTime;
        /** 总耗时（毫秒） */
        private Integer trainCostTime;
    }

    /** 创建训练任务请求 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TrainingJobCreateRequest {
        /** 任务名称 */
        private String taskName;
        /** 子任务配置列表 */
        private List<TrainingSubTask> subTasks;
    }

    /** 从算法构建训练任务请求 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TrainingJobFromAlgorithmRequest {
        /** 来源类型 */
        private TrainingJobFromAlgorithmType type;
        /** 算法 URI */
        private String algorithmUri;
        /** 算法 ID（兼容） */
        private String id;
    }

    /** 从算法构建任务的类型 */
    public enum TrainingJobFromAlgorithmType {
        MODEL_ID("model_id"),
        BIZ_ALGO_ID("biz_algo_id"),
        USER_INPUT("user_input");

        private final Object value;
        TrainingJobFromAlgorithmType(Object value) { this.value = value; }
        @JsonValue
        public Object getValue() { return value; }
    }

    /** 训练任务列表数据 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TrainingJobListDataInput {
        /** 任务列表 */
        private List<TrainingJobInput> trainTaskList;
        /** 统计信息 */
        private TrainingJobStats trainTaskMeta;
    }

    /** 训练任务列表数据 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TrainingJobListDataOutput {
        /** 任务列表 */
        private List<TrainingJobOutput> trainTaskList;
        /** 统计信息 */
        private TrainingJobStats trainTaskMeta;
    }

    /** 训练任务列表响应 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TrainingJobListResponse {
        /** 接收状态。0表示接收正常，非0表示接收异常 */
        private Integer rtn;
        /** 接收状态描述 */
        private String message;
        /** 任务列表数据 */
        private TrainingJobListDataOutput data;
    }

    /** 训练任务响应 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TrainingJobResponse {
        /** 接收状态。0表示接收正常，非0表示接收异常 */
        private Integer rtn;
        /** 接收状态描述 */
        private String message;
        /** 训练任务详情 */
        private TrainingJobOutput data;
    }

    /** 搜索训练任务请求 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TrainingJobSearchRequest {
        /** 起始位置 */
        private Integer start;
        /** 每页数量 */
        private Integer limit;
        /** 排序字段 */
        @JsonProperty("sort_key")
        private String sortKey;
        /** 排序方向 */
        private ModelsMossTrainSortOrder order;
    }

    /** 训练任务统计 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TrainingJobStats {
        /** 总数 */
        private Integer total;
        /** 训练中 */
        private Integer training;
        /** 已完成 */
        private Integer trained;
        /** 失败 */
        private Integer failed;
    }

    /** 训练任务统计响应 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TrainingJobStatsResponse {
        /** 接收状态。0表示接收正常，非0表示接收异常 */
        private Integer rtn;
        /** 接收状态描述 */
        private String message;
        /** 统计信息 */
        private TrainingJobStats data;
    }

    /** 训练任务状态 */
    public enum TrainingJobStatus {
        READY("READY"),
        NOT_READY("NOT_READY"),
        TRAINING("TRAINING"),
        TRAINED("TRAINED"),
        FAILED("FAILED");

        private final Object value;
        TrainingJobStatus(Object value) { this.value = value; }
        @JsonValue
        public Object getValue() { return value; }
    }

    /** 训练子任务 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TrainingSubTask {
        /** 训练目标配置 */
        private TrainingTarget target;
        /** 子任务状态 */
        private SubTaskStatus status;
        /** 错误码 */
        private Integer code;
        /** 错误信息 */
        private String msg;
        /** 开始时间 */
        private Integer startTrainTime;
        /** 结束时间 */
        private Integer endTrainTime;
        /** 耗时（毫秒） */
        private Integer trainCostTime;
    }

    /** 训练目标配置  定义一个模型的训练目标，包括算法、数据集等。 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TrainingTarget {
        /** 目标算法 URI */
        private String algorithmUri;
        /** 算法 ID（兼容） */
        private String algorithmId;
        /** 算法名称 */
        private String algorithmName;
        /** 训练表达式 */
        private String expr;
        /** 数据集 URI */
        private String datasetUri;
        /** 数据集 ID（兼容） */
        private String datasetId;
        /** 检测对象 */
        private String detObj;
        /** 正例标签名 */
        private String positiveTagName;
        /** 是否反转 */
        private Boolean reverse;
        /** 模型 ID 列表 */
        private List<String> modelIdList;
        /** 是否文本模型 */
        private Boolean isTextModel;
        /** 正例数量 */
        private Integer positiveCount;
        /** 负例数量 */
        private Integer negativeCount;
    }

    /** 传输协议类型  TCP: TCP协议 UDP: UDP协议 HTTP: HTTP协议 HTTPS: HTTPS协议 RTSP: RTSP协议 RTMP: RTMP协议 */
    public enum TransportProtocol {
        TCP("TCP"),
        UDP("UDP"),
        HTTP("HTTP"),
        HTTPS("HTTPS"),
        RTSP("RTSP"),
        RTMP("RTMP");

        private final Object value;
        TransportProtocol(Object value) { this.value = value; }
        @JsonValue
        public Object getValue() { return value; }
    }

    /** 更新事件状态响应 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UpdateEventStatusResponse {
        /** 接收状态。0表示接收正常，非0表示接收异常 */
        private Integer rtn;
        /** 接收状态描述 */
        private String message;
        /** 成功更新的数量 */
        @JsonProperty("updated_count")
        private Integer updatedCount;
    }

    /** 修改记录请求 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UpdateRecordRequest {
        /** 姓名 */
        private String name;
        /** 证件号 */
        @JsonProperty("person_id")
        private String personId;
        /** 出生日期，格式：YYYY-mm-dd */
        private String birthday;
        /** 性别：0=未知，1=男，2=女 */
        private Integer gender;
        /** 民族编码，0表示未知 */
        private Integer nation;
        /** 区域编码 */
        private Integer region;
        /** 外部数据源ID */
        @JsonProperty("external_id")
        private String externalId;
    }

    /** 更新角色请求 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UpdateRolePayload {
        /** 角色名称（可包含中文，用于显示） */
        @JsonProperty("role_name")
        private String roleName;
        /** 角色描述 */
        private String description;
    }

    /** 更新标签请求 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UpdateTagPayload {
        /** 标签显示名称 */
        @JsonProperty("tag_name")
        private String tagName;
        /** 标签描述 */
        private String description;
        /** 同级排序权重（数值越大越靠前） */
        @JsonProperty("sort_order")
        private Integer sortOrder;
        /** 扩展元数据（可选，用于存储额外信息） */
        private Object metadata;
    }

    /** 更新用户请求 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UpdateUserPayload {
        /** 邮箱（可选，可清空） */
        private String email;
        /** 全名 */
        @JsonProperty("full_name")
        private String fullName;
        /** 电话号码 */
        private String phone;
        /** 头像URL */
        @JsonProperty("avatar_url")
        private String avatarUrl;
        /** 用户状态 */
        private String status;
        /** 角色ID列表 */
        private List<Integer> roles;
        /** 标签ID列表 */
        private List<Integer> tags;
        /** 扩展元数据 */
        private Object metadata;
        /** 新密码（可选，提供则更新密码） */
        private String password;
    }

    /** 文件上传状态 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UploadStatus {
        /** 是否需要上传 */
        private Boolean shouldUpload;
        /** 已上传分片列表 */
        private List<Integer> uploadedChunks;
    }

    /** 上传状态响应 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UploadStatusResponse {
        /** 接收状态。0表示接收正常，非0表示接收异常 */
        private Integer rtn;
        /** 接收状态描述 */
        private String message;
        /** 上传状态 */
        private UploadStatus data;
    }

    /** 用户对象  用户设计： - id: 自增整数，唯一标识（配合 cluster_id） - username: 用户名（必需，唯一，在同一 cluster_id 下） - email: 邮箱（可选，提供时唯一，在同一 cluster_id 下） - Keycloak 只保存 username 和 password - Controller 保存其他所有信息 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserInput {
        /** 用户名 */
        private String username;
        /** 邮箱（可选，提供时需唯一） */
        private String email;
        /** 全名 */
        @JsonProperty("full_name")
        private String fullName;
        /** 电话号码 */
        private String phone;
        /** 头像URL */
        @JsonProperty("avatar_url")
        private String avatarUrl;
        /** 用户状态（active/inactive/suspended） */
        private String status;
        /** 角色ID列表 */
        private List<Integer> roles;
        /** 标签ID列表 */
        private List<Integer> tags;
        /** 扩展元数据（可选，用于存储额外信息） */
        private Object metadata;
        private ResourceReferenceFull reference;
        /** 资源全局唯一标识符（type:id@cluster_id） */
        private String uri;
        @JsonProperty("created_at")
        private String createdAt;
        @JsonProperty("updated_at")
        private String updatedAt;
    }

    /** 用户对象  用户设计： - id: 自增整数，唯一标识（配合 cluster_id） - username: 用户名（必需，唯一，在同一 cluster_id 下） - email: 邮箱（可选，提供时唯一，在同一 cluster_id 下） - Keycloak 只保存 username 和 password - Controller 保存其他所有信息 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserOutput {
        /** 用户名 */
        private String username;
        /** 邮箱（可选，提供时需唯一） */
        private String email;
        /** 全名 */
        @JsonProperty("full_name")
        private String fullName;
        /** 电话号码 */
        private String phone;
        /** 头像URL */
        @JsonProperty("avatar_url")
        private String avatarUrl;
        /** 用户状态（active/inactive/suspended） */
        private String status;
        /** 角色ID列表 */
        private List<Integer> roles;
        /** 标签ID列表 */
        private List<Integer> tags;
        /** 扩展元数据（可选，用于存储额外信息） */
        private Object metadata;
        /** 资源全局唯一标识符（type:id@cluster_id） */
        private String uri;
        @JsonProperty("created_at")
        private String createdAt;
        @JsonProperty("updated_at")
        private String updatedAt;
    }

    /** 用户列表响应 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserListResponse {
        /** 接收状态。0表示接收正常，非0表示接收异常 */
        private Integer rtn;
        /** 接收状态描述 */
        private String message;
        /** 用户列表 */
        private List<UserOutput> users;
        /** 分页信息 */
        private Pagination pagination;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ValidationError {
        private List<String> loc;
        private String msg;
        private String type;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class VehicleInfo {
        private String vehicleType;
        private String brand;
        private String model;
        private String plateType;
        private String plateNumber;
        private String color;
        private Integer totalVehicles;
    }

    /** 视觉解析任务 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class VisionTask {
        private Integer id;
        @JsonProperty("task_id")
        private String taskId;
        private String name;
        @JsonProperty("composite_event_expression")
        private String compositeEventExpression;
        @JsonProperty("composite_events")
        private String compositeEvents;
        @JsonProperty("business_algorithm_id")
        private String businessAlgorithmId;
        @JsonProperty("task_meta")
        private String taskMeta;
        @JsonProperty("surveillance_type")
        private String surveillanceType;
        @JsonProperty("traffic_config")
        private String trafficConfig;
        private Integer status;
        @JsonProperty("is_deleted")
        private Boolean isDeleted;
        @JsonProperty("created_at")
        private Integer createdAt;
        @JsonProperty("updated_at")
        private Integer updatedAt;
        @JsonProperty("cluster_id")
        private String clusterId;
        private String description;
        @JsonProperty("source_uri")
        private String sourceUri;
        @JsonProperty("algorithm_config")
        private String algorithmConfig;
        @JsonProperty("created_by")
        private String createdBy;
        @JsonProperty("started_at")
        private Integer startedAt;
        @JsonProperty("completed_at")
        private Integer completedAt;
        private String statistics;
        @JsonProperty("runtime_status")
        private String runtimeStatus;
    }

    /** 创建视觉解析任务输入 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class VisionTaskInput {
        private String name;
        @JsonProperty("composite_event_expression")
        private String compositeEventExpression;
        @JsonProperty("composite_events")
        private String compositeEvents;
        @JsonProperty("business_algorithm_id")
        private String businessAlgorithmId;
        @JsonProperty("task_meta")
        private String taskMeta;
        @JsonProperty("surveillance_type")
        private String surveillanceType;
        @JsonProperty("traffic_config")
        private String trafficConfig;
        private Integer status;
        @JsonProperty("cluster_id")
        private String clusterId;
        private String description;
        @JsonProperty("source_uri")
        private String sourceUri;
        @JsonProperty("algorithm_config")
        private String algorithmConfig;
        @JsonProperty("created_by")
        private String createdBy;
    }

    /** 任务列表响应 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class VisionTaskListResponse {
        /** 接收状态。0表示接收正常，非0表示接收异常 */
        private Integer rtn;
        /** 接收状态描述 */
        private String message;
        private List<VisionTask> tasks;
        private Pagination pagination;
    }

    /** 单个任务响应 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class VisionTaskResponse {
        /** 接收状态。0表示接收正常，非0表示接收异常 */
        private Integer rtn;
        /** 接收状态描述 */
        private String message;
        private VisionTask task;
    }

    /** 更新视觉解析任务输入 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class VisionTaskUpdateInput {
        private String name;
        @JsonProperty("composite_event_expression")
        private String compositeEventExpression;
        @JsonProperty("composite_events")
        private String compositeEvents;
        @JsonProperty("business_algorithm_id")
        private String businessAlgorithmId;
        @JsonProperty("task_meta")
        private String taskMeta;
        @JsonProperty("surveillance_type")
        private String surveillanceType;
        @JsonProperty("traffic_config")
        private String trafficConfig;
        private Integer status;
        @JsonProperty("cluster_id")
        private String clusterId;
        private String description;
        @JsonProperty("source_uri")
        private String sourceUri;
        @JsonProperty("algorithm_config")
        private String algorithmConfig;
    }

    /** 兼容格式：提供 type、id、cluster_id。 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ResourceByParts {
        /** 资源类型标识（如：camera、region、repository 等） */
        private String type;
        /**  资源在集群内的唯一标识符（局部ID） 支持整数型（如数据库自增ID）或字符串型（如 Snowflake ID、UUID 等） - 整数型: 0 到 2^64-1，兼容 protobuf uint64 类型 - 字符串型: 1-128个字符，支持字母、数字、点、下划线、连字符、波浪号 */
        private Integer id;
        /** 集群的唯一标识符 */
        @JsonProperty("cluster_id")
        private String clusterId;
    }

    /** 推荐格式：仅提供 uri。 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ResourceByURI {
        /**  资源的全局唯一标识符，格式为 `type:id@cluster_id`  **格式说明**： - type: 资源类型标识（小写字母开头，可包含小写字母、数字、点、下划线、连字符） - id: 资源在集群内的ID，支持整数或字符串（字母、数字、点、下划线、连字符、波浪号、井号） - @: 固定分隔符 - cluster_id: 资源所属的集群标识（字母、数字、点、下划线、连字符、波浪号）  **示例**： - camera:1001@cluster_1 (整数型ID摄像头资源) - camera:9328475629384756@cluster-a (Snowflake ID摄像头资源) - repository:repo_001@hz-core (字符串型ID人像库资源) - record.face:313@cluster_1 (人脸记录资源) - user:u_001@cn-prod (用户资源)  **约束规则**： - type 必须以小写字母开头，支持层级结构（如 record.face） - id 支持整数或字符串，字符串型 1-128 个字符 - cluster_id 必须是有效的集群标识符  **使用场景**： - 跨集群资源引用 - 全局资源定位 - 资源所有权明确标识 */
        private String uri;
    }

    /** 排序方向  - asc: 升序 - desc: 降序 */
    public enum ModelsCameraSortOrder {
        ASC("asc"),
        DESC("desc");

        private final Object value;
        ModelsCameraSortOrder(Object value) { this.value = value; }
        @JsonValue
        public Object getValue() { return value; }
    }

    /** 人脸框位置信息 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ModelsCaptureRecordFaceRect {
        /** 左上角X坐标 */
        private Integer x;
        /** 左上角Y坐标 */
        private Integer y;
        /** 宽度 */
        private Integer w;
        /** 高度 */
        private Integer h;
    }

    /** 排序方向 */
    public enum ModelsMossTrainSortOrder {
        ASC("asc"),
        DESC("desc");

        private final Object value;
        ModelsMossTrainSortOrder(Object value) { this.value = value; }
        @JsonValue
        public Object getValue() { return value; }
    }

    /** 人脸框位置 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ModelsSurveillanceTaskFaceRect {
        /** x坐标 */
        private Integer x;
        /** y坐标 */
        private Integer y;
        /** 宽度 */
        private Integer w;
        /** 高度 */
        private Integer h;
    }

}
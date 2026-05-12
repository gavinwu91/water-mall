package com.yitu.vms.client;

import com.yitu.vms.model.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

/**
 * 依图 VMS Java 客户端 (100% 强类型)
 */
@FeignClient(name = "yitu-vms-client", url = "${yitu.vms.base-url:http://192.168.106.23:30081}")
public interface YituVmsClient {
    /**
     * Health Check
     */
    @GetMapping("/health")
    BaseResponse<GeneratedModels.HealthResponse> healthCheckHealthGet();

    /**
     * 创建库
     */
    @PostMapping("/api/v1/repositories")
    BaseResponse<GeneratedModels.ResourceReferenceResponse> createRepoApiV1RepositoriesPost(@RequestBody GeneratedModels.RepositoryInput2 body);

    /**
     * 列出所有库
     */
    @GetMapping("/api/v1/repositories")
    BaseResponse<GeneratedModels.ListReposResponse> listReposApiV1RepositoriesGet(@RequestParam(value = "repo_type", required = false) GeneratedModels.RepositoryType repoType, @RequestParam(value = "data_type", required = false) GeneratedModels.DataType dataType, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "limit", required = false) Integer limit);

    /**
     * 搜索库
     */
    @PostMapping("/api/v1/repositories/search")
    BaseResponse<GeneratedModels.SearchReposResponse> searchReposApiV1RepositoriesSearchPost(@RequestBody GeneratedModels.SearchReposRequest body);

    /**
     * 修改单条记录
     */
    @PatchMapping("/api/v1/repositories/{uri}/records/{record_id}")
    BaseResponse<GeneratedModels.BasicResponse> updateRecordApiV1RepositoriesUriRecordsRecordIdPatch(@PathVariable("uri") String uri, @PathVariable("record_id") String recordId, @RequestBody GeneratedModels.UpdateRecordRequest body);

    /**
     * 获取库详情
     */
    @GetMapping("/api/v1/repositories/{uri}")
    BaseResponse<GeneratedModels.GetRepoResponse> getRepoByUriApiV1RepositoriesUriGet(@PathVariable("uri") String uri);

    /**
     * 更新库
     */
    @PatchMapping("/api/v1/repositories/{uri}")
    BaseResponse<GeneratedModels.BasicResponse> updateRepoByUriApiV1RepositoriesUriPatch(@PathVariable("uri") String uri, @RequestBody GeneratedModels.RepositoryUpdate body);

    /**
     * 删除库
     */
    @DeleteMapping("/api/v1/repositories/{uri}")
    BaseResponse<GeneratedModels.BasicResponse> deleteRepoByUriApiV1RepositoriesUriDelete(@PathVariable("uri") String uri, @RequestParam(value = "delete_all_records", required = false) Boolean deleteAllRecords);

    /**
     * 批量导入记录
     */
    @PostMapping("/api/v1/repositories/{uri}/records")
    BaseResponse<GeneratedModels.BatchAddRecordsResponse> addRecordsApiV1RepositoriesUriRecordsPost(@PathVariable("uri") String uri, @RequestBody GeneratedModels.BatchAddRecordsRequest body);

    /**
     * 批量删除记录
     */
    @PostMapping("/api/v1/repositories/{uri}/records/delete")
    BaseResponse<GeneratedModels.BasicResponse> deleteRecordsApiV1RepositoriesUriRecordsDeletePost(@PathVariable("uri") String uri, @RequestBody GeneratedModels.BatchDeleteRecordsRequest body);

    /**
     * [NOT IMPLEMENTED] 批量更新记录标签
     */
    @PostMapping("/api/v1/repositories/{uri}/records/tags")
    BaseResponse<GeneratedModels.BasicResponse> updateRecordTagsApiV1RepositoriesUriRecordsTagsPost(@PathVariable("uri") String uri, @RequestBody GeneratedModels.BatchUpdateRecordTagsRequest body);

    /**
     * 搜索库记录
     */
    @PostMapping("/api/v1/repositories/{uri}/records/search")
    BaseResponse<GeneratedModels.ListRecordsResponse> searchRecordsApiV1RepositoriesUriRecordsSearchPost(@PathVariable("uri") String uri, @RequestBody GeneratedModels.ListRecordsRequest body);

    /**
     * 用户登录
     */
    @PostMapping("/api/v1/auth/login")
    BaseResponse<GeneratedModels.LoginResponse> loginApiV1AuthLoginPost(@RequestBody GeneratedModels.LoginInput body);

    /**
     * 用户登出
     */
    @PostMapping("/api/v1/auth/logout")
    BaseResponse<GeneratedModels.BasicResponse> logoutApiV1AuthLogoutPost();

    /**
     * 获取当前用户信息
     */
    @GetMapping("/api/v1/auth/me")
    BaseResponse<GeneratedModels.MeResponse> meApiV1AuthMeGet();

    /**
     * 刷新 Token
     */
    @PostMapping("/api/v1/auth/refresh-token")
    BaseResponse<GeneratedModels.RefreshTokenResponse> refreshTokenApiV1AuthRefreshTokenPost();

    /**
     * 获取当前用户的权限标签
     */
    @GetMapping("/api/v1/auth/tags")
    BaseResponse<Object> tagsApiV1AuthTagsGet(@RequestParam(value = "action", required = false) GeneratedModels.ActionEnum action, @RequestParam(value = "resource_type", required = false) String resourceType, @RequestParam(value = "expand", required = false) Boolean expand);

    /**
     * 创建摄像头
     */
    @PostMapping("/api/v1/cameras")
    BaseResponse<GeneratedModels.ResourceReferenceResponse> createCameraApiV1CamerasPost(@RequestBody GeneratedModels.CameraCreate body);

    /**
     * 搜索摄像头
     */
    @GetMapping("/api/v1/cameras")
    BaseResponse<GeneratedModels.ListCamerasResponse> listCamerasApiV1CamerasGet(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "limit", required = false) Integer limit, @RequestParam(value = "tags", required = false) List<Integer> tags, @RequestParam(value = "status", required = false) List<String> status, @RequestParam(value = "name", required = false) String name, @RequestParam(value = "code", required = false) String code, @RequestParam(value = "sort_by", required = false) GeneratedModels.CameraSortField sortBy, @RequestParam(value = "order", required = false) GeneratedModels.ModelsCameraSortOrder order);

    /**
     * 获取摄像头详情
     */
    @GetMapping("/api/v1/cameras/{uri}")
    BaseResponse<GeneratedModels.CameraResponse> getCameraByUriApiV1CamerasUriGet(@PathVariable("uri") String uri);

    /**
     * 更新摄像头
     */
    @PatchMapping("/api/v1/cameras/{uri}")
    BaseResponse<GeneratedModels.BasicResponse> updateCameraByUriApiV1CamerasUriPatch(@PathVariable("uri") String uri, @RequestBody GeneratedModels.CameraUpdate body);

    /**
     * 删除摄像头
     */
    @DeleteMapping("/api/v1/cameras/{uri}")
    BaseResponse<GeneratedModels.BasicResponse> deleteCameraByUriApiV1CamerasUriDelete(@PathVariable("uri") String uri);

    /**
     * 创建标签
     */
    @PostMapping("/api/v1/tags")
    BaseResponse<GeneratedModels.SingleTagResponse> createTagApiV1TagsPost(@RequestBody GeneratedModels.CreateTagBody body);

    /**
     * 列出标签
     */
    @GetMapping("/api/v1/tags")
    BaseResponse<GeneratedModels.TagListResponse> listTagsApiV1TagsGet(@RequestParam(value = "resource_type", required = false) String resourceType, @RequestParam(value = "parent_id", required = false) Integer parentId, @RequestParam(value = "depth", required = false) Integer depth, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "limit", required = false) Integer limit);

    /**
     * 更新标签
     */
    @PatchMapping("/api/v1/tags/{uri}")
    BaseResponse<GeneratedModels.SingleTagResponse> updateTagApiV1TagsUriPatch(@PathVariable("uri") String uri, @RequestBody GeneratedModels.UpdateTagPayload body);

    /**
     * 删除标签
     */
    @DeleteMapping("/api/v1/tags/{uri}")
    BaseResponse<GeneratedModels.BasicResponse> deleteTagApiV1TagsUriDelete(@PathVariable("uri") String uri, @RequestParam(value = "cascade", required = false) Boolean cascade);

    /**
     * 获取标签详情
     */
    @GetMapping("/api/v1/tags/{uri}")
    BaseResponse<GeneratedModels.SingleTagResponse> getTagApiV1TagsUriGet(@PathVariable("uri") String uri);

    /**
     * 创建角色
     */
    @PostMapping("/api/v1/roles")
    BaseResponse<GeneratedModels.SingleRoleResponse> createRoleApiV1RolesPost(@RequestBody GeneratedModels.CreateRoleBody body);

    /**
     * 列出角色
     */
    @GetMapping("/api/v1/roles")
    BaseResponse<GeneratedModels.RoleListResponse> listRolesApiV1RolesGet(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "limit", required = false) Integer limit);

    /**
     * 获取角色详情
     */
    @GetMapping("/api/v1/roles/{uri}")
    BaseResponse<GeneratedModels.SingleRoleResponse> getRoleApiV1RolesUriGet(@PathVariable("uri") String uri);

    /**
     * 更新角色
     */
    @PatchMapping("/api/v1/roles/{uri}")
    BaseResponse<GeneratedModels.SingleRoleResponse> updateRoleApiV1RolesUriPatch(@PathVariable("uri") String uri, @RequestBody GeneratedModels.UpdateRolePayload body);

    /**
     * 删除角色
     */
    @DeleteMapping("/api/v1/roles/{uri}")
    BaseResponse<GeneratedModels.BasicResponse> deleteRoleApiV1RolesUriDelete(@PathVariable("uri") String uri);

    /**
     * 创建用户
     */
    @PostMapping("/api/v1/users")
    BaseResponse<GeneratedModels.CreateUserResponse> createUserApiV1UsersPost(@RequestBody GeneratedModels.CreateUserBody body);

    /**
     * 列出用户
     */
    @GetMapping("/api/v1/users")
    BaseResponse<GeneratedModels.UserListResponse> listUsersApiV1UsersGet(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "limit", required = false) Integer limit, @RequestParam(value = "role_ids", required = false) List<Integer> roleIds, @RequestParam(value = "tags", required = false) List<Integer> tags, @RequestParam(value = "username", required = false) String username, @RequestParam(value = "full_name", required = false) String fullName);

    /**
     * 获取用户详情
     */
    @GetMapping("/api/v1/users/{uri}")
    BaseResponse<GeneratedModels.SingleUserResponse> getUserApiV1UsersUriGet(@PathVariable("uri") String uri);

    /**
     * 更新用户
     */
    @PatchMapping("/api/v1/users/{uri}")
    BaseResponse<GeneratedModels.BasicResponse> updateUserApiV1UsersUriPatch(@PathVariable("uri") String uri, @RequestBody GeneratedModels.UpdateUserPayload body);

    /**
     * 删除用户
     */
    @DeleteMapping("/api/v1/users/{uri}")
    BaseResponse<GeneratedModels.BasicResponse> deleteUserApiV1UsersUriDelete(@PathVariable("uri") String uri);

    /**
     * 创建权限
     */
    @PostMapping("/api/v1/permissions")
    BaseResponse<GeneratedModels.SinglePermissionResponse> createPermissionApiV1PermissionsPost(@RequestBody GeneratedModels.CreatePermissionBody body);

    /**
     * 列出权限
     */
    @GetMapping("/api/v1/permissions")
    BaseResponse<GeneratedModels.PermissionListResponse> listPermissionsApiV1PermissionsGet(@RequestParam(value = "role_id", required = false) Integer roleId, @RequestParam(value = "tag_id", required = false) Integer tagId, @RequestParam(value = "resource_type", required = false) String resourceType, @RequestParam(value = "action", required = false) GeneratedModels.ActionEnum action, @RequestParam(value = "start", required = false) Integer start, @RequestParam(value = "limit", required = false) Integer limit);

    /**
     * 删除权限
     */
    @DeleteMapping("/api/v1/permissions")
    BaseResponse<GeneratedModels.BasicResponse> deletePermissionApiV1PermissionsDelete(@RequestBody GeneratedModels.DeletePermissionBody body);

    /**
     * 查询单个权限
     */
    @PostMapping("/api/v1/permissions/query")
    BaseResponse<GeneratedModels.SinglePermissionResponse> queryPermissionApiV1PermissionsQueryPost(@RequestBody GeneratedModels.QueryPermissionBody body);

    /**
     * 获取当前集群ID
     */
    @GetMapping("/api/v1/cluster/current")
    BaseResponse<GeneratedModels.ClusterInfoResponse> getCurrentClusterApiV1ClusterCurrentGet();

    /**
     * 获取图片（GET）
     */
    @GetMapping("/api/v1/storage/image")
    BaseResponse<Object> getStorageImageApiV1StorageImageGet(@RequestParam(value = "uri", required = false) String uri, @RequestParam(value = "uri_base64", required = false) String uriBase64);

    /**
     * 图片特征抽取
     */
    @PostMapping("/api/v1/feature-extraction")
    BaseResponse<GeneratedModels.FeatureExtractionResponse> featureExtractionApiV1FeatureExtractionPost(@RequestBody GeneratedModels.FeatureExtractionRequest body);

    /**
     * Batch Feature Extraction
     */
    @PostMapping("/api/v1/feature-extraction/batch")
    BaseResponse<GeneratedModels.BatchFeatureExtractionResponse> batchFeatureExtractionApiV1FeatureExtractionBatchPost(@RequestBody GeneratedModels.BatchFeatureExtractionRequest body);

    /**
     * Health Check
     */
    @GetMapping("/api/v1/feature-extraction/health")
    BaseResponse<Object> healthCheckApiV1FeatureExtractionHealthGet();

    /**
     * 创建布控任务
     */
    @PostMapping("/api/v1/surveillance-tasks")
    BaseResponse<GeneratedModels.ResourceReferenceResponse> createTaskApiV1SurveillanceTasksPost(@RequestBody GeneratedModels.SurveillanceTaskInput2 body);

    /**
     * 列出布控任务
     */
    @GetMapping("/api/v1/surveillance-tasks")
    BaseResponse<GeneratedModels.ListTasksResponse> listTasksApiV1SurveillanceTasksGet(@RequestParam(value = "tag_path", required = false) String tagPath, @RequestParam(value = "cluster_id", required = false) String clusterId, @RequestParam(value = "enabled", required = false) Boolean enabled, @RequestParam(value = "surveillance_mode", required = false) GeneratedModels.SurveillanceMode surveillanceMode, @RequestParam(value = "surveillance_type", required = false) Integer surveillanceType, @RequestParam(value = "process_type", required = false) Integer processType, @RequestParam(value = "keyword", required = false) String keyword, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "limit", required = false) Integer limit);

    /**
     * 获取布控任务详情
     */
    @GetMapping("/api/v1/surveillance-tasks/{uri}")
    BaseResponse<GeneratedModels.GetTaskResponse> getTaskByUriApiV1SurveillanceTasksUriGet(@PathVariable("uri") String uri);

    /**
     * 基于 URI 更新布控任务
     */
    @PatchMapping("/api/v1/surveillance-tasks/{uri}")
    BaseResponse<GeneratedModels.BasicResponse> patchTaskApiV1SurveillanceTasksUriPatch(@PathVariable("uri") String uri, @RequestBody GeneratedModels.SurveillanceTaskUpdate body);

    /**
     * 基于 URI 删除布控任务
     */
    @DeleteMapping("/api/v1/surveillance-tasks/{uri}")
    BaseResponse<GeneratedModels.BasicResponse> deleteTaskByUriApiV1SurveillanceTasksUriDelete(@PathVariable("uri") String uri, @RequestParam(value = "delete_hit_records", required = false) Boolean deleteHitRecords);

    /**
     * 查询告警记录列表
     */
    @PostMapping("/api/v1/surveillance-tasks/hit-records/search")
    BaseResponse<GeneratedModels.ListHitRecordsResponse> listHitRecordsApiV1SurveillanceTasksHitRecordsSearchPost(@RequestBody GeneratedModels.ListHitRecordsRequest body);

    /**
     * [NOT IMPLEMENTED] 标注告警记录
     */
    @PutMapping("/api/v1/surveillance-tasks/hit-records/annotation")
    BaseResponse<GeneratedModels.AnnotateHitRecordsResponse> annotateHitRecordsApiV1SurveillanceTasksHitRecordsAnnotationPut(@RequestBody GeneratedModels.AnnotateHitRecordsRequest body);

    /**
     * L1 静态库检索
     */
    @PostMapping("/api/v1/retrieval/static")
    BaseResponse<GeneratedModels.RetrievalResponse> retrievalStaticApiV1RetrievalStaticPost(@RequestBody GeneratedModels.StaticRetrievalRequest body);

    /**
     * 查询过人记录
     */
    @PostMapping("/api/v1/retrieval/dynamic")
    BaseResponse<GeneratedModels.RetrievalResponse> retrievalDynamicApiV1RetrievalDynamicPost(@RequestBody GeneratedModels.DynamicRetrievalRequest body);

    /**
     * L5 档案检索
     */
    @PostMapping("/api/v1/retrieval/dossier")
    BaseResponse<GeneratedModels.DossierRetrievalResponse> retrievalDossierApiV1RetrievalDossierPost(@RequestBody GeneratedModels.DossierRetrievalRequest body);

    /**
     * [NOT IMPLEMENTED] L5 语义检索（文本+时空过滤）
     */
    @PostMapping("/api/v1/retrieval/semantic")
    BaseResponse<GeneratedModels.SemanticRetrievalResponse> retrievalSemanticApiV1RetrievalSemanticPost(@RequestBody GeneratedModels.SemanticRetrievalRequest body);

    /**
     * [NOT IMPLEMENTED] L4 档案结构化检索
     */
    @PostMapping("/api/v1/retrieval/dossier/l4")
    BaseResponse<GeneratedModels.L4DossierRetrievalResponse> retrievalDossierL4ApiV1RetrievalDossierL4Post(@RequestBody GeneratedModels.L4DossierRetrievalRequest body);

    /**
     * 列出所有档案
     */
    @GetMapping("/api/v1/dossiers")
    BaseResponse<GeneratedModels.DossierListResponse> listDossiersApiV1DossiersGet(@RequestParam(value = "dossier_type", required = false) String dossierType, @RequestParam(value = "status", required = false) String status, @RequestParam(value = "priority", required = false) String priority, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "limit", required = false) Integer limit);

    /**
     * 查询单个档案详情
     */
    @GetMapping("/api/v1/dossiers/{uri}")
    BaseResponse<GeneratedModels.DossierResponse> getDossierApiV1DossiersUriGet(@PathVariable("uri") String uri);

    /**
     * 搜索档案列表
     */
    @PostMapping("/api/v1/dossiers/search")
    BaseResponse<GeneratedModels.DossierListResponse> searchDossiersApiV1DossiersSearchPost(@RequestBody GeneratedModels.DossierQueryRequest body);

    /**
     * [NOT IMPLEMENTED] 更新档案标签
     */
    @PostMapping("/api/v1/dossiers/{uri}/tags")
    BaseResponse<Object> updateDossierTagsApiV1DossiersUriTagsPost(@PathVariable("uri") String uri, @RequestBody GeneratedModels.DossierTagUpdateBody body);

    /**
     * 获取所有静态人像库（旧版兼容）
     */
    @GetMapping("/lagency/face/v1/framework/face_image/repository")
    BaseResponse<GeneratedModels.ResponseGetRepositoriesLagencyFaceV1FrameworkFaceImageRepositoryGet> getRepositoriesLagencyFaceV1FrameworkFaceImageRepositoryGet(@RequestParam(value = "cluster_id", required = false) String clusterId);

    /**
     * 添加人像库（旧版兼容）
     */
    @PostMapping("/lagency/face/v1/framework/face_image/repository")
    BaseResponse<GeneratedModels.ResponseCreateRepositoryLagencyFaceV1FrameworkFaceImageRepositoryPost> createRepositoryLagencyFaceV1FrameworkFaceImageRepositoryPost(@RequestBody Map<String, Object> body);

    /**
     * 修改人像库（旧版兼容）
     */
    @PutMapping("/lagency/face/v1/framework/face_image/repository")
    BaseResponse<GeneratedModels.ResponseUpdateRepositoryLagencyFaceV1FrameworkFaceImageRepositoryPut> updateRepositoryLagencyFaceV1FrameworkFaceImageRepositoryPut(@RequestBody Map<String, Object> body);

    /**
     * 删除人像库（旧版兼容）
     */
    @DeleteMapping("/lagency/face/v1/framework/face_image/repository")
    BaseResponse<GeneratedModels.ResponseDeleteRepositoryLagencyFaceV1FrameworkFaceImageRepositoryDelete> deleteRepositoryLagencyFaceV1FrameworkFaceImageRepositoryDelete(@RequestParam(value = "cluster_id", required = false) String clusterId, @RequestParam(value = "id", required = false) Integer id, @RequestParam(value = "is_delete_all", required = false) Boolean isDeleteAll);

    /**
     * [NOT IMPLEMENTED] 添加人像（异步）
     */
    @PostMapping("/lagency/face/v1/framework/face_image/repository/picture")
    BaseResponse<GeneratedModels.LagencyResponse> addFaceImageLagencyFaceV1FrameworkFaceImageRepositoryPicturePost(@RequestBody Map<String, Object> body);

    /**
     * 添加人像（带特征）（旧版兼容）
     */
    @PostMapping("/lagency/face/v1/framework/face_image/repository/picture/feature")
    BaseResponse<GeneratedModels.ResponseAddFaceWithFeatureLagencyFaceV1FrameworkFaceImageRepositoryPictureFeaturePost> addFaceWithFeatureLagencyFaceV1FrameworkFaceImageRepositoryPictureFeaturePost(@RequestBody Map<String, Object> body);

    /**
     * 删除人像（旧版兼容）
     */
    @PostMapping("/lagency/face/v1/framework/face/delete")
    BaseResponse<GeneratedModels.ResponseDeleteFaceLagencyFaceV1FrameworkFaceDeletePost> deleteFaceLagencyFaceV1FrameworkFaceDeletePost(@RequestBody Map<String, Object> body);

    /**
     * 更新人像信息（旧版兼容）
     */
    @PostMapping("/lagency/face/v1/framework/face/update")
    BaseResponse<GeneratedModels.ResponseUpdateFaceLagencyFaceV1FrameworkFaceUpdatePost> updateFaceLagencyFaceV1FrameworkFaceUpdatePost(@RequestBody Map<String, Object> body);

    /**
     * 人脸查询接口（旧版兼容）
     */
    @PostMapping("/lagency/face/v1/framework/face/query")
    BaseResponse<GeneratedModels.ResponseQueryFaceLagencyFaceV1FrameworkFaceQueryPost> queryFaceLagencyFaceV1FrameworkFaceQueryPost(@RequestBody Map<String, Object> body);

    /**
     * 人脸检索接口（旧版兼容）
     */
    @PostMapping("/lagency/face/v1/framework/face/retrieval")
    BaseResponse<GeneratedModels.ResponseRetrieveFaceLagencyFaceV1FrameworkFaceRetrievalPost> retrieveFaceLagencyFaceV1FrameworkFaceRetrievalPost(@RequestBody Map<String, Object> body);

    /**
     * 查看摄像头（旧版兼容）
     */
    @GetMapping("/lagency/face/v1/framework/face_video/camera")
    BaseResponse<GeneratedModels.ResponseGetCamerasLagencyFaceV1FrameworkFaceVideoCameraGet> getCamerasLagencyFaceV1FrameworkFaceVideoCameraGet(@RequestParam(value = "cluster_id", required = false) String clusterId);

    /**
     * 添加摄像头（旧版兼容）
     */
    @PostMapping("/lagency/face/v1/framework/face_video/camera")
    BaseResponse<GeneratedModels.ResponseCreateCameraLagencyFaceV1FrameworkFaceVideoCameraPost> createCameraLagencyFaceV1FrameworkFaceVideoCameraPost(@RequestBody Map<String, Object> body);

    /**
     * 删除摄像头（旧版兼容）
     */
    @DeleteMapping("/lagency/face/v1/framework/face_video/camera")
    BaseResponse<GeneratedModels.ResponseDeleteCameraLagencyFaceV1FrameworkFaceVideoCameraDelete> deleteCameraLagencyFaceV1FrameworkFaceVideoCameraDelete(@RequestParam(value = "cluster_id", required = false) String clusterId, @RequestParam(value = "id", required = false) Integer id);

    /**
     * 修改摄像头信息（旧版兼容）
     */
    @PutMapping("/lagency/face/v1/framework/face_video/camera")
    BaseResponse<GeneratedModels.ResponseUpdateCameraLagencyFaceV1FrameworkFaceVideoCameraPut> updateCameraLagencyFaceV1FrameworkFaceVideoCameraPut(@RequestBody Map<String, Object> body);

    /**
     * 摄像头名字重复检查（旧版兼容）
     */
    @PostMapping("/lagency/face/v1/framework/face_video/camera/check_repeat")
    BaseResponse<GeneratedModels.ResponseCheckCameraRepeatLagencyFaceV1FrameworkFaceVideoCameraCheckRepeatPost> checkCameraRepeatLagencyFaceV1FrameworkFaceVideoCameraCheckRepeatPost(@RequestBody Map<String, Object> body);

    /**
     * 获取区域
     */
    @GetMapping("/lagency/face/v1/framework/resource_set/camera")
    BaseResponse<GeneratedModels.QueryResponse> getResourceSetsLagencyFaceV1FrameworkResourceSetCameraGet(@RequestParam(value = "cluster_id", required = false) String clusterId);

    /**
     * 添加区域
     */
    @PostMapping("/lagency/face/v1/framework/resource_set/camera")
    BaseResponse<GeneratedModels.LagencyResponse> createResourceSetLagencyFaceV1FrameworkResourceSetCameraPost(@RequestBody GeneratedModels.CreateResourceSetRequest body);

    /**
     * [NOT IMPLEMENTED] 异步图片流批量导入
     */
    @PostMapping("/lagency/face/v1/image_flow/batch")
    BaseResponse<GeneratedModels.LagencyResponse> imageFlowBatchLagencyFaceV1ImageFlowBatchPost(@RequestBody GeneratedModels.ImageFlowBatchRequest body);

    /**
     * 过人查询接口（旧版兼容）
     */
    @PostMapping("/lagency/face/v1/framework/track/query")
    BaseResponse<GeneratedModels.ResponseQueryTrackLagencyFaceV1FrameworkTrackQueryPost> queryTrackLagencyFaceV1FrameworkTrackQueryPost(@RequestBody Map<String, Object> body);

    /**
     * 过人检索接口（旧版兼容）
     */
    @PostMapping("/lagency/face/v1/framework/track/retrieval")
    BaseResponse<GeneratedModels.ResponseRetrieveTrackLagencyFaceV1FrameworkTrackRetrievalPost> retrieveTrackLagencyFaceV1FrameworkTrackRetrievalPost(@RequestBody Map<String, Object> body);

    /**
     * 添加布控任务（旧版兼容）
     */
    @PostMapping("/lagency/face/v1/framework/face_video/surveillance")
    BaseResponse<GeneratedModels.ResponseCreateSurveillanceLagencyFaceV1FrameworkFaceVideoSurveillancePost> createSurveillanceLagencyFaceV1FrameworkFaceVideoSurveillancePost(@RequestBody Map<String, Object> body);

    /**
     * 修改布控任务（旧版兼容）
     */
    @PutMapping("/lagency/face/v1/framework/face_video/surveillance")
    BaseResponse<GeneratedModels.ResponseUpdateSurveillanceLagencyFaceV1FrameworkFaceVideoSurveillancePut> updateSurveillanceLagencyFaceV1FrameworkFaceVideoSurveillancePut(@RequestBody Map<String, Object> body);

    /**
     * 获取布控任务列表（旧版兼容）
     */
    @GetMapping("/lagency/face/v1/framework/face_video/surveillance")
    BaseResponse<GeneratedModels.ResponseGetSurveillanceListLagencyFaceV1FrameworkFaceVideoSurveillanceGet> getSurveillanceListLagencyFaceV1FrameworkFaceVideoSurveillanceGet(@RequestParam(value = "cluster_id", required = false) String clusterId, @RequestParam(value = "surveillance_id", required = false) String surveillanceId);

    /**
     * 删除布控任务（旧版兼容）
     */
    @DeleteMapping("/lagency/face/v1/framework/face_video/surveillance")
    BaseResponse<GeneratedModels.ResponseDeleteSurveillanceLagencyFaceV1FrameworkFaceVideoSurveillanceDelete> deleteSurveillanceLagencyFaceV1FrameworkFaceVideoSurveillanceDelete(@RequestParam(value = "surveillance_id", required = false) String surveillanceId);

    /**
     * 布控报警查询（旧版兼容）
     */
    @PostMapping("/lagency/face/v1/framework/surveillance/query")
    BaseResponse<GeneratedModels.ResponseQuerySurveillanceAlertLagencyFaceV1FrameworkSurveillanceQueryPost> querySurveillanceAlertLagencyFaceV1FrameworkSurveillanceQueryPost(@RequestBody Map<String, Object> body);

    /**
     * [NOT IMPLEMENTED] 获取动态库当前 Offset
     */
    @GetMapping("/lagency/track_result/current_offset")
    BaseResponse<GeneratedModels.LagencyResponse> getTrackCurrentOffsetLagencyTrackResultCurrentOffsetGet(@RequestParam(value = "cluster_id", required = false) String clusterId);

    /**
     * [NOT IMPLEMENTED] 动态库数据拉取
     */
    @PostMapping("/lagency/track_result/fetch_total")
    BaseResponse<GeneratedModels.QueryResponse> fetchTrackTotalLagencyTrackResultFetchTotalPost(@RequestBody GeneratedModels.FetchTrackRequest body);

    /**
     * [NOT IMPLEMENTED] 告警数据拉取
     */
    @PostMapping("/lagency/hit_result/fetch")
    BaseResponse<GeneratedModels.QueryResponse> fetchHitResultLagencyHitResultFetchPost(@RequestBody GeneratedModels.FetchHitRequest body);

    /**
     * [NOT IMPLEMENTED] 获取静态库最早 Offset
     */
    @GetMapping("/lagency/face/v1/framework/log/earliest_offset")
    BaseResponse<GeneratedModels.LagencyResponse> getLogEarliestOffsetLagencyFaceV1FrameworkLogEarliestOffsetGet(@RequestParam(value = "cluster_id", required = false) String clusterId, @RequestParam(value = "repository", required = false) Integer repository);

    /**
     * [NOT IMPLEMENTED] 获取静态库当前 Offset
     */
    @GetMapping("/lagency/face/v1/framework/log/current_offset")
    BaseResponse<GeneratedModels.LagencyResponse> getLogCurrentOffsetLagencyFaceV1FrameworkLogCurrentOffsetGet(@RequestParam(value = "cluster_id", required = false) String clusterId, @RequestParam(value = "repository", required = false) Integer repository);

    /**
     * [NOT IMPLEMENTED] 静态库数据拉取
     */
    @PostMapping("/lagency/face/v1/framework/log/fetch")
    BaseResponse<GeneratedModels.QueryResponse> fetchLogLagencyFaceV1FrameworkLogFetchPost(@RequestBody GeneratedModels.FetchLogRequest body);

    /**
     * 创建视觉解析任务
     */
    @PostMapping("/api/v1/vision-tasks")
    BaseResponse<GeneratedModels.CreateTaskResponse> createTaskApiV1VisionTasksPost(@RequestBody GeneratedModels.VisionTaskInput body);

    /**
     * 列出视觉解析任务
     */
    @GetMapping("/api/v1/vision-tasks")
    BaseResponse<GeneratedModels.VisionTaskListResponse> listTasksApiV1VisionTasksGet(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "limit", required = false) Integer limit, @RequestParam(value = "status", required = false) Integer status, @RequestParam(value = "filter", required = false) String filter);

    /**
     * 获取视觉解析任务详情
     */
    @GetMapping("/api/v1/vision-tasks/{task_id}")
    BaseResponse<GeneratedModels.VisionTaskResponse> getTaskApiV1VisionTasksTaskIdGet(@PathVariable("task_id") String taskId);

    /**
     * 更新视觉解析任务
     */
    @PatchMapping("/api/v1/vision-tasks/{task_id}")
    BaseResponse<GeneratedModels.BasicResponse> updateTaskApiV1VisionTasksTaskIdPatch(@PathVariable("task_id") String taskId, @RequestBody GeneratedModels.VisionTaskUpdateInput body);

    /**
     * 删除视觉解析任务
     */
    @DeleteMapping("/api/v1/vision-tasks/{task_id}")
    BaseResponse<GeneratedModels.BasicResponse> deleteTaskApiV1VisionTasksTaskIdDelete(@PathVariable("task_id") String taskId, @RequestParam(value = "hard_delete", required = false) Boolean hardDelete);

    /**
     * 控制视觉解析任务
     */
    @PostMapping("/api/v1/vision-tasks/{task_id}/control")
    BaseResponse<GeneratedModels.ControlTaskResponse> controlTaskApiV1VisionTasksTaskIdControlPost(@PathVariable("task_id") String taskId, @RequestBody GeneratedModels.ControlTaskInput body);

    /**
     * 同步任务状态
     */
    @PostMapping("/api/v1/vision-tasks/sync-status")
    BaseResponse<GeneratedModels.BasicResponse> syncTaskStatusApiV1VisionTasksSyncStatusPost(@RequestParam(value = "task_id", required = false) String taskId);

    /**
     * 发现 VF Master 上的任务
     */
    @GetMapping("/api/v1/vision-tasks/vf-master/discover")
    BaseResponse<GeneratedModels.DiscoverRemoteTasksResponse> discoverRemoteTasksApiV1VisionTasksVfMasterDiscoverGet();

    /**
     * 从 VF Master 同步任务
     */
    @PostMapping("/api/v1/vision-tasks/vf-master/sync")
    BaseResponse<GeneratedModels.SyncFromVfMasterResponse> syncFromVfMasterApiV1VisionTasksVfMasterSyncPost(@RequestBody GeneratedModels.SyncFromVfMasterInput body);

    /**
     * 获取算法详情
     */
    @GetMapping("/api/v1/algorithms/{algorithm_uri}")
    BaseResponse<GeneratedModels.AlgorithmResponse> getAlgorithmApiV1AlgorithmsAlgorithmUriGet(@PathVariable("algorithm_uri") String algorithmUri);

    /**
     * 删除算法
     */
    @DeleteMapping("/api/v1/algorithms/{algorithm_uri}")
    BaseResponse<GeneratedModels.BasicResponse> deleteAlgorithmApiV1AlgorithmsAlgorithmUriDelete(@PathVariable("algorithm_uri") String algorithmUri);

    /**
     * 获取算法使用的数据集
     */
    @GetMapping("/api/v1/algorithms/{algorithm_uri}/datasets")
    BaseResponse<GeneratedModels.AlgorithmDatasetListResponse> listAlgorithmDatasetsApiV1AlgorithmsAlgorithmUriDatasetsGet(@PathVariable("algorithm_uri") String algorithmUri);

    /**
     * 删除算法版本
     */
    @DeleteMapping("/api/v1/algorithms/{algorithm_uri}/versions/{version}")
    BaseResponse<GeneratedModels.BasicResponse> deleteAlgorithmVersionApiV1AlgorithmsAlgorithmUriVersionsVersionDelete(@PathVariable("algorithm_uri") String algorithmUri, @PathVariable("version") String version);

    /**
     * 创建模型导出任务
     */
    @PostMapping("/api/v1/algorithms/{algorithm_uri}/versions/{version}/exports")
    BaseResponse<GeneratedModels.ExportTaskResponse> createExportTaskApiV1AlgorithmsAlgorithmUriVersionsVersionExportsPost(@PathVariable("algorithm_uri") String algorithmUri, @PathVariable("version") String version);

    /**
     * 列出导出任务
     */
    @GetMapping("/api/v1/algorithms/{algorithm_uri}/exports")
    BaseResponse<GeneratedModels.ExportTaskListResponse> listExportTasksApiV1AlgorithmsAlgorithmUriExportsGet(@PathVariable("algorithm_uri") String algorithmUri, @RequestParam(value = "start", required = false) Integer start, @RequestParam(value = "limit", required = false) Integer limit);

    /**
     * 获取导出任务详情
     */
    @GetMapping("/api/v1/algorithms/{algorithm_uri}/exports/{export_task_uri}")
    BaseResponse<GeneratedModels.ExportTaskResponse> getExportTaskApiV1AlgorithmsAlgorithmUriExportsExportTaskUriGet(@PathVariable("algorithm_uri") String algorithmUri, @PathVariable("export_task_uri") String exportTaskUri);

    /**
     * 删除导出任务
     */
    @DeleteMapping("/api/v1/algorithms/{algorithm_uri}/exports/{export_task_uri}")
    BaseResponse<GeneratedModels.BasicResponse> deleteExportTaskApiV1AlgorithmsAlgorithmUriExportsExportTaskUriDelete(@PathVariable("algorithm_uri") String algorithmUri, @PathVariable("export_task_uri") String exportTaskUri);

    /**
     * 下载导出文件
     */
    @GetMapping("/api/v1/algorithms/{algorithm_uri}/exports/{export_task_uri}/download")
    BaseResponse<Object> downloadExportFileApiV1AlgorithmsAlgorithmUriExportsExportTaskUriDownloadGet(@PathVariable("algorithm_uri") String algorithmUri, @PathVariable("export_task_uri") String exportTaskUri);

    /**
     * 检查模型包
     */
    @PostMapping("/api/v1/algorithms/imports/check")
    BaseResponse<GeneratedModels.ImportCheckResponse> checkImportApiV1AlgorithmsImportsCheckPost(@RequestBody GeneratedModels.AlgorithmImportCheckRequest body);

    /**
     * 导入模型包
     */
    @PostMapping("/api/v1/algorithms/imports")
    BaseResponse<GeneratedModels.BasicResponse> importAlgorithmApiV1AlgorithmsImportsPost(@RequestBody GeneratedModels.AlgorithmImportRequest body);

    /**
     * 删除待导入包
     */
    @DeleteMapping("/api/v1/algorithms/imports")
    BaseResponse<GeneratedModels.BasicResponse> deleteImportApiV1AlgorithmsImportsDelete(@RequestBody GeneratedModels.AlgorithmImportCheckRequest body);

    /**
     * 获取数据集列表
     */
    @GetMapping("/api/v1/datasets")
    BaseResponse<GeneratedModels.DatasetListResponse> listDatasetsApiV1DatasetsGet(@RequestParam(value = "node_id", required = false) String nodeId, @RequestParam(value = "name", required = false) String name, @RequestParam(value = "cursor", required = false) Integer cursor, @RequestParam(value = "limit", required = false) Integer limit);

    /**
     * 创建数据集
     */
    @PostMapping("/api/v1/datasets")
    BaseResponse<GeneratedModels.DatasetResponse> createDatasetApiV1DatasetsPost(@RequestBody GeneratedModels.DatasetCreateRequest body);

    /**
     * 获取数据集详情
     */
    @GetMapping("/api/v1/datasets/{dataset_uri}")
    BaseResponse<GeneratedModels.DatasetResponse> getDatasetApiV1DatasetsDatasetUriGet(@PathVariable("dataset_uri") String datasetUri);

    /**
     * 删除数据集
     */
    @DeleteMapping("/api/v1/datasets/{dataset_uri}")
    BaseResponse<GeneratedModels.BasicResponse> deleteDatasetApiV1DatasetsDatasetUriDelete(@PathVariable("dataset_uri") String datasetUri);

    /**
     * 获取资源详情
     */
    @GetMapping("/api/v1/datasets/{dataset_uri}/versions/{version}/resources/{resource_id}")
    BaseResponse<GeneratedModels.DatasetResource> getDatasetResourceApiV1DatasetsDatasetUriVersionsVersionResourcesResourceIdGet(@PathVariable("dataset_uri") String datasetUri, @PathVariable("version") String version, @PathVariable("resource_id") String resourceId, @RequestParam(value = "type", required = false) String type);

    /**
     * 获取数据集版本资源
     */
    @PostMapping("/api/v1/datasets/{dataset_uri}/versions/{version}/resources")
    BaseResponse<GeneratedModels.DatasetResourceListResponse> listDatasetResourcesApiV1DatasetsDatasetUriVersionsVersionResourcesPost(@PathVariable("dataset_uri") String datasetUri, @PathVariable("version") String version, @RequestParam(value = "cursor", required = false) Integer cursor, @RequestParam(value = "limit", required = false) Integer limit, @RequestBody GeneratedModels.DatasetResourceSearchRequest body);

    /**
     * 获取数据集版本列表
     */
    @GetMapping("/api/v1/datasets/{dataset_uri}/versions")
    BaseResponse<GeneratedModels.DatasetVersionsResponse> listDatasetVersionsApiV1DatasetsDatasetUriVersionsGet(@PathVariable("dataset_uri") String datasetUri);

    /**
     * 获取使用此数据集的算法
     */
    @GetMapping("/api/v1/datasets/{dataset_uri}/algorithms")
    BaseResponse<GeneratedModels.DatasetAlgorithmListResponse> listDatasetAlgorithmsApiV1DatasetsDatasetUriAlgorithmsGet(@PathVariable("dataset_uri") String datasetUri, @RequestParam(value = "cursor", required = false) Integer cursor, @RequestParam(value = "limit", required = false) Integer limit);

    /**
     * 推荐样本
     */
    @PostMapping("/api/v1/datasets/{dataset_uri}/samples/recommend")
    BaseResponse<GeneratedModels.SampleListResponse> recommendSamplesApiV1DatasetsDatasetUriSamplesRecommendPost(@PathVariable("dataset_uri") String datasetUri, @RequestBody GeneratedModels.DatasetSampleRecommendRequest body);

    /**
     * 批量标注
     */
    @PostMapping("/api/v1/datasets/{dataset_uri}/annotations")
    BaseResponse<GeneratedModels.BasicResponse> annotateSamplesApiV1DatasetsDatasetUriAnnotationsPost(@PathVariable("dataset_uri") String datasetUri, @RequestBody GeneratedModels.DatasetAnnotateRequest body);

    /**
     * 提交数据集
     */
    @PutMapping("/api/v1/datasets/{dataset_uri}/commit")
    BaseResponse<GeneratedModels.BasicResponse> commitDatasetApiV1DatasetsDatasetUriCommitPut(@PathVariable("dataset_uri") String datasetUri);

    /**
     * 检查文件上传状态
     */
    @PostMapping("/api/v1/datasets/{dataset_uri}/files/check")
    BaseResponse<GeneratedModels.UploadStatusResponse> checkFileUploadApiV1DatasetsDatasetUriFilesCheckPost(@PathVariable("dataset_uri") String datasetUri, @RequestBody GeneratedModels.FileUploadCheckRequest body);

    /**
     * 上传文件分片
     */
    @PostMapping("/api/v1/datasets/{dataset_uri}/files/chunks")
    BaseResponse<GeneratedModels.BasicResponse> uploadFileChunkApiV1DatasetsDatasetUriFilesChunksPost(@PathVariable("dataset_uri") String datasetUri, @RequestBody Object body);

    /**
     * 合并文件分片
     */
    @PostMapping("/api/v1/datasets/{dataset_uri}/files/merge")
    BaseResponse<GeneratedModels.BasicResponse> mergeFileChunksApiV1DatasetsDatasetUriFilesMergePost(@PathVariable("dataset_uri") String datasetUri, @RequestBody GeneratedModels.FileUploadMergeRequest body);

    /**
     * 上传单个图片到数据集（一步）
     */
    @PostMapping("/api/v1/datasets/{dataset_uri}/samples/upload-image")
    BaseResponse<GeneratedModels.ImageUploadResponse> uploadImageToDatasetApiV1DatasetsDatasetUriSamplesUploadImagePost(@PathVariable("dataset_uri") String datasetUri, @RequestBody Object body);

    /**
     * 批量上传图片到数据集
     */
    @PostMapping("/api/v1/datasets/{dataset_uri}/samples/upload-images")
    BaseResponse<GeneratedModels.BatchUploadResponse> uploadImagesToDatasetApiV1DatasetsDatasetUriSamplesUploadImagesPost(@PathVariable("dataset_uri") String datasetUri, @RequestBody Object body);

    /**
     * 从算法构建训练任务
     */
    @PostMapping("/api/v1/training-jobs/from-algorithm")
    BaseResponse<GeneratedModels.TrainingJobResponse> buildFromAlgorithmApiV1TrainingJobsFromAlgorithmPost(@RequestBody GeneratedModels.TrainingJobFromAlgorithmRequest body);

    /**
     * 创建训练任务
     */
    @PostMapping("/api/v1/training-jobs")
    BaseResponse<GeneratedModels.TrainingJobResponse> createTrainingJobApiV1TrainingJobsPost(@RequestBody GeneratedModels.TrainingJobCreateRequest body);

    /**
     * 搜索训练任务
     */
    @PostMapping("/api/v1/training-jobs/search")
    BaseResponse<GeneratedModels.TrainingJobListResponse> searchTrainingJobsApiV1TrainingJobsSearchPost(@RequestBody GeneratedModels.TrainingJobSearchRequest body);

    /**
     * 清理已完成任务
     */
    @DeleteMapping("/api/v1/training-jobs/completed")
    BaseResponse<GeneratedModels.TrainingJobStatsResponse> clearCompletedJobsApiV1TrainingJobsCompletedDelete();

    /**
     * 搜索事件列表
     */
    @PostMapping("/api/v1/events/search")
    BaseResponse<GeneratedModels.EventSearchResponse> searchEventsApiV1EventsSearchPost(@RequestBody GeneratedModels.EventSearchRequest body);

    /**
     * 获取事件详情
     */
    @GetMapping("/api/v1/events/{uri}")
    BaseResponse<GeneratedModels.EventDetailResponse> getEventApiV1EventsUriGet(@PathVariable("uri") String uri);

    /**
     * 更新事件状态
     */
    @PatchMapping("/api/v1/events/{uri}/status")
    BaseResponse<GeneratedModels.UpdateEventStatusResponse> updateEventStatusApiV1EventsUriStatusPatch(@PathVariable("uri") String uri, @RequestBody GeneratedModels.EventStatusUpdateRequest body);

    /**
     * 批量更新事件状态
     */
    @PatchMapping("/api/v1/events/batch-status")
    BaseResponse<GeneratedModels.UpdateEventStatusResponse> batchUpdateEventStatusApiV1EventsBatchStatusPatch(@RequestBody GeneratedModels.BatchEventStatusUpdateRequest body);

    /**
     * 事件实时推送（SSE）
     */
    @GetMapping("/api/v1/events/stream")
    BaseResponse<Object> streamEventsApiV1EventsStreamGet(@RequestParam(value = "event_class", required = false) String eventClass, @RequestParam(value = "level", required = false) String level);

    /**
     * 搜索算法模型列表
     */
    @PostMapping("/api/v1/algorithm-management/models/search")
    BaseResponse<GeneratedModels.AlgorithmModelListResponse> searchModelsApiV1AlgorithmManagementModelsSearchPost(@RequestBody GeneratedModels.AlgorithmModelQueryRequest body);

    /**
     * 搜索原子任务列表
     */
    @PostMapping("/api/v1/algorithm-management/atomic-tasks/search")
    BaseResponse<GeneratedModels.AtomicTaskListResponse> searchAtomicTasksApiV1AlgorithmManagementAtomicTasksSearchPost(@RequestBody GeneratedModels.AtomicTaskQueryRequest body);

    /**
     * 区域摸排
     */
    @PostMapping("/api/v1/tactical-methods/area-screening")
    BaseResponse<GeneratedModels.AreaScreeningResponse> areaScreeningApiV1TacticalMethodsAreaScreeningPost(@RequestBody GeneratedModels.AreaScreeningRequest body);

    /**
     * 同行分析
     */
    @PostMapping("/api/v1/tactical-methods/companion-analysis")
    BaseResponse<GeneratedModels.CompanionAnalysisResponse> companionAnalysisApiV1TacticalMethodsCompanionAnalysisPost(@RequestBody GeneratedModels.CompanionAnalysisRequest body);

    /**
     * 同行反查
     */
    @PostMapping("/api/v1/tactical-methods/reverse-companion")
    BaseResponse<GeneratedModels.ReverseCompanionResponse> reverseCompanionApiV1TacticalMethodsReverseCompanionPost(@RequestBody GeneratedModels.ReverseCompanionRequest body);

    /**
     * 落脚点分析
     */
    @PostMapping("/api/v1/tactical-methods/foothold-analysis")
    BaseResponse<GeneratedModels.FootholdAnalysisResponse> footholdAnalysisApiV1TacticalMethodsFootholdAnalysisPost(@RequestBody GeneratedModels.FootholdAnalysisRequest body);

    /**
     * 初次入圈
     */
    @PostMapping("/api/v1/tactical-methods/first-entry")
    BaseResponse<GeneratedModels.FirstEntryResponse> firstEntryApiV1TacticalMethodsFirstEntryPost(@RequestBody GeneratedModels.FirstEntryRequest body);

    /**
     * 关系分析
     */
    @PostMapping("/api/v1/tactical-methods/relationship-analysis")
    BaseResponse<GeneratedModels.RelationshipAnalysisResponse> relationshipAnalysisApiV1TacticalMethodsRelationshipAnalysisPost(@RequestBody GeneratedModels.RelationshipAnalysisRequest body);

    /**
     * 时空碰撞
     */
    @PostMapping("/api/v1/tactical-methods/spatiotemporal-collision")
    BaseResponse<GeneratedModels.SpatiotemporalCollisionResponse> spatiotemporalCollisionApiV1TacticalMethodsSpatiotemporalCollisionPost(@RequestBody GeneratedModels.SpatiotemporalCollisionRequest body);

    /**
     * Chat Stream
     */
    @PostMapping("/aip/v1/chat/stream")
    BaseResponse<Object> chatStreamAipV1ChatStreamPost(@RequestBody GeneratedModels.ChatRequest body);

    /**
     * Chat
     */
    @PostMapping("/aip/v1/chat")
    BaseResponse<GeneratedModels.ChatResponse> chatAipV1ChatPost(@RequestBody GeneratedModels.ChatRequest body);

    /**
     * Omni Agent Chat
     */
    @PostMapping("/aip/v1/agents/omni/chat")
    BaseResponse<Object> omniAgentChatAipV1AgentsOmniChatPost(@RequestBody GeneratedModels.ChatRequest body);

    /**
     * Omni Agent Chat Stream
     */
    @PostMapping("/aip/v1/agents/omni/chat/stream")
    BaseResponse<Object> omniAgentChatStreamAipV1AgentsOmniChatStreamPost(@RequestBody GeneratedModels.ChatRequest body);

    /**
     * Copilot Chat Stream
     */
    @PostMapping("/aip/v1/copilot/chat/stream")
    BaseResponse<Object> copilotChatStreamAipV1CopilotChatStreamPost(@RequestBody GeneratedModels.CopilotChatRequest body);

    /**
     * Copilot Chat
     */
    @PostMapping("/aip/v1/copilot/chat")
    BaseResponse<Object> copilotChatAipV1CopilotChatPost(@RequestBody GeneratedModels.CopilotChatRequest body);

    /**
     * Dispatch L4O Task
     */
    @PostMapping("/aip/v1/tasks/l4o/dispatch")
    BaseResponse<GeneratedModels.TaskResponse> dispatchL4oTaskAipV1TasksL4oDispatchPost(@RequestBody GeneratedModels.L4oTaskRequest body);

    /**
     * Dispatch L5 Task
     */
    @PostMapping("/aip/v1/tasks/l5/dispatch")
    BaseResponse<GeneratedModels.TaskResponse> dispatchL5TaskAipV1TasksL5DispatchPost(@RequestBody GeneratedModels.L5TaskRequest body);

    /**
     * Start Realtime Tracking
     */
    @PostMapping("/aip/v1/tasks/realtime-tracking")
    BaseResponse<GeneratedModels.TaskResponse> startRealtimeTrackingAipV1TasksRealtimeTrackingPost(@RequestBody GeneratedModels.RealtimeTrackingRequest body);

    /**
     * List Tasks
     */
    @GetMapping("/aip/v1/tasks")
    BaseResponse<Object> listTasksAipV1TasksGet(@RequestParam(value = "limit", required = false) Integer limit, @RequestParam(value = "offset", required = false) Integer offset);

    /**
     * Get Task
     */
    @GetMapping("/aip/v1/tasks/{task_id}")
    BaseResponse<Object> getTaskAipV1TasksTaskIdGet(@PathVariable("task_id") String taskId);

    /**
     * Delete Task
     */
    @DeleteMapping("/aip/v1/tasks/{task_id}")
    BaseResponse<Object> deleteTaskAipV1TasksTaskIdDelete(@PathVariable("task_id") String taskId);

    /**
     * Orchestrate Task
     */
    @PostMapping("/aip/v1/orchestrate")
    BaseResponse<Object> orchestrateTaskAipV1OrchestratePost(@RequestBody GeneratedModels.OrchestrationRequest body);

    /**
     * Batch Orchestrate Tasks
     */
    @PostMapping("/aip/v1/orchestrate/batch")
    BaseResponse<Object> batchOrchestrateTasksAipV1OrchestrateBatchPost(@RequestBody List<GeneratedModels.OrchestrationRequest> body);
}
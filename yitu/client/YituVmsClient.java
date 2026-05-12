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
    BaseResponse<GeneratedModels.ListReposResponse> listReposApiV1RepositoriesGet(@RequestParam(value = "repo_type", required = false) GeneratedModels.RepositoryType repoType, @RequestParam(value = "data_type", required = false) GeneratedModels.DataType dataType, @RequestParam(value = "name", required = false) String name, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "limit", required = false) Integer limit);

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
     * 批量同步上传记录
     */
    @PostMapping("/api/v1/repositories/{uri}/records/synchronized/batch")
    BaseResponse<GeneratedModels.BatchSyncUploadResponse> batchSyncUploadRecordsApiV1RepositoriesUriRecordsSynchronizedBatchPost(@PathVariable("uri") String uri, @RequestBody GeneratedModels.BatchSyncUploadRequest body);

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
    BaseResponse<GeneratedModels.ListCamerasResponse> listCamerasApiV1CamerasGet(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "limit", required = false) Integer limit, @RequestParam(value = "tags", required = false) List<Integer> tags, @RequestParam(value = "tag_name", required = false) String tagName, @RequestParam(value = "status", required = false) List<String> status, @RequestParam(value = "name", required = false) String name, @RequestParam(value = "code", required = false) String code, @RequestParam(value = "device_type", required = false) Integer deviceType, @RequestParam(value = "after_id", required = false) Integer afterId, @RequestParam(value = "sort_by", required = false) GeneratedModels.CameraSortField sortBy, @RequestParam(value = "order", required = false) GeneratedModels.ModelsCameraSortOrder order);

    /**
     * 批量创建摄像头
     */
    @PostMapping("/api/v1/cameras/bulk")
    BaseResponse<GeneratedModels.BulkCreateCamerasResponse> bulkCreateCamerasApiV1CamerasBulkPost(@RequestBody GeneratedModels.BulkCreateCamerasBody body);

    /**
     * 按国标编码批量 upsert 摄像头
     */
    @PostMapping("/api/v1/cameras/bulk-upsert")
    BaseResponse<GeneratedModels.BulkUpsertCamerasResponse> bulkUpsertCamerasApiV1CamerasBulkUpsertPost(@RequestBody GeneratedModels.BulkCreateCamerasBody body);

    /**
     * GIS 视口查询摄像头
     */
    @PostMapping("/api/v1/cameras/gis/viewport-query")
    BaseResponse<GeneratedModels.CameraViewportQueryResponse> queryCamerasByViewportApiV1CamerasGisViewportQueryPost(@RequestBody GeneratedModels.CameraViewportQueryRequest body);

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
    BaseResponse<GeneratedModels.TagListResponse> listTagsApiV1TagsGet(@RequestParam(value = "resource_type", required = false) String resourceType, @RequestParam(value = "parent_id", required = false) Integer parentId, @RequestParam(value = "name", required = false) String name, @RequestParam(value = "depth", required = false) Integer depth, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "limit", required = false) Integer limit);

    /**
     * 批量补建标签路径（idempotent）
     */
    @PostMapping("/api/v1/tags/ensure-paths")
    BaseResponse<GeneratedModels.EnsureTagPathsResponse> ensureTagPathsApiV1TagsEnsurePathsPost(@RequestBody GeneratedModels.EnsureTagPathsBody body);

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
    BaseResponse<Object> getStorageImageApiV1StorageImageGet(@RequestParam(value = "uri", required = false) String uri, @RequestParam(value = "uri_base64", required = false) String uriBase64, @RequestParam(value = "cluster_id", required = false) String clusterId);

    /**
     * 图片特征抽取
     */
    @PostMapping("/api/v1/feature-extraction")
    BaseResponse<GeneratedModels.FeatureExtractionResponse> featureExtractionApiV1FeatureExtractionPost(@RequestBody GeneratedModels.FeatureExtractionRequest body);

    /**
     * 批量图片特征抽取
     */
    @PostMapping("/api/v1/feature-extraction/batch")
    BaseResponse<GeneratedModels.BatchFeatureExtractionResponse> batchFeatureExtractionApiV1FeatureExtractionBatchPost(@RequestBody GeneratedModels.BatchFeatureExtractionRequest body);

    /**
     * Health Check
     */
    @GetMapping("/api/v1/feature-extraction/health")
    BaseResponse<Object> healthCheckApiV1FeatureExtractionHealthGet();

    /**
     * 1:1 图片比对 (1v1)
     */
    @PostMapping("/api/v1/feature-extraction/compare")
    BaseResponse<GeneratedModels.Compare1v1Response> compare1v1ApiV1FeatureExtractionComparePost(@RequestBody GeneratedModels.Compare1v1Request body);

    /**
     * 创建布控任务
     */
    @PostMapping("/api/v1/surveillance-tasks")
    BaseResponse<GeneratedModels.ResourceReferenceResponse> createTaskApiV1SurveillanceTasksPost(@RequestBody GeneratedModels.SurveillanceTaskInput2 body);

    /**
     * 列出布控任务
     */
    @GetMapping("/api/v1/surveillance-tasks")
    BaseResponse<GeneratedModels.RoutersSurveillanceTaskListTasksResponse> listTasksApiV1SurveillanceTasksGet(@RequestParam(value = "tag_path", required = false) String tagPath, @RequestParam(value = "cluster_id", required = false) String clusterId, @RequestParam(value = "enabled", required = false) Boolean enabled, @RequestParam(value = "surveillance_mode", required = false) GeneratedModels.SurveillanceMode surveillanceMode, @RequestParam(value = "surveillance_type", required = false) Integer surveillanceType, @RequestParam(value = "process_type", required = false) Integer processType, @RequestParam(value = "keyword", required = false) String keyword, @RequestParam(value = "sort_by", required = false) String sortBy, @RequestParam(value = "sort_order", required = false) String sortOrder, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "limit", required = false) Integer limit);

    /**
     * 获取布控任务详情
     */
    @GetMapping("/api/v1/surveillance-tasks/{uri}")
    BaseResponse<GeneratedModels.RoutersSurveillanceTaskGetTaskResponse> getTaskByUriApiV1SurveillanceTasksUriGet(@PathVariable("uri") String uri);

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
     * L4 档案检索
     */
    @PostMapping("/api/v1/retrieval/dossier")
    BaseResponse<GeneratedModels.DossierRetrievalResponse> retrievalDossierApiV1RetrievalDossierPost(@RequestBody GeneratedModels.DossierRetrievalRequest body);

    /**
     * L5 语义检索（文搜图/图搜图/特征搜图）
     */
    @PostMapping("/api/v1/retrieval/semantic")
    BaseResponse<GeneratedModels.SemanticSearchResponse> retrievalSemanticApiV1RetrievalSemanticPost(@RequestBody GeneratedModels.SemanticSearchParams body);

    /**
     * [NOT IMPLEMENTED] L4 档案结构化检索
     */
    @PostMapping("/api/v1/retrieval/dossier/l4")
    BaseResponse<GeneratedModels.L4DossierRetrievalResponse> retrievalDossierL4ApiV1RetrievalDossierL4Post(@RequestBody GeneratedModels.L4DossierRetrievalRequest body);

    /**
     * 列出所有档案标签定义
     */
    @GetMapping("/api/v1/dossiers/tags")
    BaseResponse<GeneratedModels.DossierTagDefListResponse> listDossierTagDefsApiV1DossiersTagsGet();

    /**
     * 创建档案标签定义
     */
    @PostMapping("/api/v1/dossiers/tags")
    BaseResponse<GeneratedModels.DossierTagDefResponse> createDossierTagDefApiV1DossiersTagsPost(@RequestBody GeneratedModels.CreateDossierTagBody body);

    /**
     * 删除档案标签定义
     */
    @DeleteMapping("/api/v1/dossiers/tags/{tag_id}")
    BaseResponse<GeneratedModels.BasicResponse> deleteDossierTagDefApiV1DossiersTagsTagIdDelete(@PathVariable("tag_id") String tagId);

    /**
     * 批量关联档案到标签
     */
    @PostMapping("/api/v1/dossiers/tags/{tag_id}/dossiers")
    BaseResponse<GeneratedModels.BasicResponse> batchAddDossiersToTagApiV1DossiersTagsTagIdDossiersPost(@PathVariable("tag_id") String tagId, @RequestBody GeneratedModels.BatchAddDossiersByTagBody body);

    /**
     * 按标签ID查询全量档案ID
     */
    @GetMapping("/api/v1/dossiers/tags/{tag_id}/dossier-ids")
    BaseResponse<GeneratedModels.DossierIdsByTagResponse> getDossierIdsByTagApiV1DossiersTagsTagIdDossierIdsGet(@PathVariable("tag_id") String tagId);

    /**
     * 列出所有档案
     */
    @GetMapping("/api/v1/dossiers")
    BaseResponse<GeneratedModels.DossierListResponse> listDossiersApiV1DossiersGet(@RequestParam(value = "dossier_type", required = false) String dossierType, @RequestParam(value = "status", required = false) String status, @RequestParam(value = "priority", required = false) String priority, @RequestParam(value = "tag_ids", required = false) String tagIds, @RequestParam(value = "tag_match_mode", required = false) String tagMatchMode, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "limit", required = false) Integer limit);

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
     * 更新档案标签
     */
    @PostMapping("/api/v1/dossiers/{uri}/tags")
    BaseResponse<GeneratedModels.BasicResponse> updateDossierTagsApiV1DossiersUriTagsPost(@PathVariable("uri") String uri, @RequestBody GeneratedModels.DossierTagUpdateBody body);

    /**
     * 删除档案标签关联
     */
    @DeleteMapping("/api/v1/dossiers/{uri}/tags")
    BaseResponse<GeneratedModels.BasicResponse> deleteDossierTagsApiV1DossiersUriTagsDelete(@PathVariable("uri") String uri, @RequestBody GeneratedModels.DossierTagDeleteBody body);

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
     * 创建事件
     */
    @PostMapping("/api/v1/events")
    BaseResponse<GeneratedModels.CreateEventResponse> createEventApiV1EventsPost(@RequestBody GeneratedModels.CreateEventRequest body);

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
     * 时间线事件聚合查询
     */
    @PostMapping("/api/v1/timeline/events/query")
    BaseResponse<GeneratedModels.TimelineEventsResponse> queryTimelineEventsApiV1TimelineEventsQueryPost(@RequestBody GeneratedModels.TimelineEventsQueryRequest body);

    /**
     * 时间轴场景查询
     */
    @PostMapping("/api/v1/timeline/scenarios/query")
    BaseResponse<GeneratedModels.TimelineScenariosResponse> queryTimelineScenariosApiV1TimelineScenariosQueryPost(@RequestBody GeneratedModels.TimelineScenariosQueryRequest body);

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
     * 创建任务
     */
    @PostMapping("/api/v1/vatask/tasks")
    BaseResponse<GeneratedModels.CreateTaskResponse> createTaskApiV1VataskTasksPost(@RequestBody GeneratedModels.CreateTaskInput body);

    /**
     * 列出任务
     */
    @GetMapping("/api/v1/vatask/tasks")
    BaseResponse<GeneratedModels.RoutersVataskV2ListTasksResponse> listTasksApiV1VataskTasksGet(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "limit", required = false) Integer limit, @RequestParam(value = "status", required = false) Integer status, @RequestParam(value = "display_status", required = false) String displayStatus, @RequestParam(value = "name_filter", required = false) String nameFilter);

    /**
     * 获取任务
     */
    @GetMapping("/api/v1/vatask/tasks/{task_id}")
    BaseResponse<GeneratedModels.RoutersVataskV2GetTaskResponse> getTaskApiV1VataskTasksTaskIdGet(@PathVariable("task_id") String taskId);

    /**
     * 删除任务
     */
    @DeleteMapping("/api/v1/vatask/tasks/{task_id}")
    BaseResponse<GeneratedModels.BasicResponse> deleteTaskApiV1VataskTasksTaskIdDelete(@PathVariable("task_id") String taskId, @RequestParam(value = "hard_delete", required = false) Boolean hardDelete);

    /**
     * 更新任务
     */
    @PutMapping("/api/v1/vatask/tasks/{task_id}")
    BaseResponse<GeneratedModels.UpdateTaskResponse> updateTaskApiV1VataskTasksTaskIdPut(@PathVariable("task_id") String taskId, @RequestBody GeneratedModels.UpdateTaskInput body);

    /**
     * 查询离线解析进度
     */
    @GetMapping("/api/v1/vatask/tasks/{task_id}/progress")
    BaseResponse<GeneratedModels.ProgressResponse> getTaskProgressApiV1VataskTasksTaskIdProgressGet(@PathVariable("task_id") String taskId);

    /**
     * 获取任务详情
     */
    @GetMapping("/api/v1/vatask/tasks/{task_id}/detail")
    BaseResponse<GeneratedModels.GetTaskDetailResponse> getTaskDetailApiV1VataskTasksTaskIdDetailGet(@PathVariable("task_id") String taskId);

    /**
     * 控制任务
     */
    @PostMapping("/api/v1/vatask/tasks/{task_id}/control")
    BaseResponse<GeneratedModels.ControlTaskResponse> controlTaskApiV1VataskTasksTaskIdControlPost(@PathVariable("task_id") String taskId, @RequestBody GeneratedModels.ControlTaskInput body);

    /**
     * 批量添加设备
     */
    @PostMapping("/api/v1/vatask/tasks/{task_id}/devices")
    BaseResponse<GeneratedModels.BatchAddDevicesResponse> batchAddDevicesApiV1VataskTasksTaskIdDevicesPost(@PathVariable("task_id") String taskId, @RequestBody GeneratedModels.BatchAddDevicesInput body);

    /**
     * 批量删除设备
     */
    @DeleteMapping("/api/v1/vatask/tasks/{task_id}/devices")
    BaseResponse<GeneratedModels.BatchRemoveDevicesResponse> batchRemoveDevicesApiV1VataskTasksTaskIdDevicesDelete(@PathVariable("task_id") String taskId, @RequestBody GeneratedModels.BatchRemoveDevicesInput body);

    /**
     * 列出设备
     */
    @GetMapping("/api/v1/vatask/tasks/{task_id}/devices")
    BaseResponse<GeneratedModels.ListDevicesResponse> listDevicesApiV1VataskTasksTaskIdDevicesGet(@PathVariable("task_id") String taskId, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "limit", required = false) Integer limit, @RequestParam(value = "status", required = false) Integer status, @RequestParam(value = "shard", required = false) Integer shard);

    /**
     * 获取设备
     */
    @GetMapping("/api/v1/vatask/tasks/{task_id}/devices/{device_id}")
    BaseResponse<GeneratedModels.GetDeviceResponse> getDeviceApiV1VataskTasksTaskIdDevicesDeviceIdGet(@PathVariable("task_id") String taskId, @PathVariable("device_id") String deviceId);

    /**
     * 列出模板
     */
    @GetMapping("/api/v1/vatask/templates")
    BaseResponse<GeneratedModels.RoutersVataskV2ListTemplatesResponse> listTemplatesApiV1VataskTemplatesGet(@RequestParam(value = "category", required = false) String category);

    /**
     * 获取模板
     */
    @GetMapping("/api/v1/vatask/templates/{template_id}")
    BaseResponse<GeneratedModels.GetTemplateResponse> getTemplateApiV1VataskTemplatesTemplateIdGet(@PathVariable("template_id") String templateId);

    /**
     * 解析模板或表达式
     */
    @PostMapping("/api/v2/algomgr/resolve")
    BaseResponse<GeneratedModels.ResolveResponse> resolveApiV2AlgomgrResolvePost(@RequestBody GeneratedModels.ResolveInput body);

    /**
     * 列出模板
     */
    @GetMapping("/api/v2/algomgr/templates")
    BaseResponse<GeneratedModels.RoutersAlgomgrV2ListTemplatesResponse> listTemplatesApiV2AlgomgrTemplatesGet(@RequestParam(value = "category", required = false) String category, @RequestParam(value = "name_filter", required = false) String nameFilter, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "limit", required = false) Integer limit);

    /**
     * 列出算法
     */
    @GetMapping("/api/v2/algomgr/algorithms")
    BaseResponse<GeneratedModels.ListAlgorithmsResponse> listAlgorithmsApiV2AlgomgrAlgorithmsGet(@RequestParam(value = "type", required = false) String type, @RequestParam(value = "name_filter", required = false) String nameFilter, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "limit", required = false) Integer limit);

    /**
     * 刷新缓存
     */
    @PostMapping("/api/v2/algomgr/cache/refresh")
    BaseResponse<GeneratedModels.RefreshCacheResponse> refreshCacheApiV2AlgomgrCacheRefreshPost(@RequestParam(value = "full_refresh", required = false) Boolean fullRefresh, @RequestParam(value = "template_id", required = false) String templateId);

    /**
     * 健康检查
     */
    @GetMapping("/api/v2/algomgr/health")
    BaseResponse<GeneratedModels.HealthCheckResponse> healthCheckApiV2AlgomgrHealthGet();

    /**
     * 列出原子任务
     */
    @GetMapping("/api/v2/algomgr/atomic_tasks")
    BaseResponse<GeneratedModels.ListAtomicTasksResponse> listAtomicTasksApiV2AlgomgrAtomicTasksGet(@RequestParam(value = "limit", required = false) Integer limit, @RequestParam(value = "offset", required = false) Integer offset, @RequestParam(value = "is_builtin", required = false) Integer isBuiltin);

    /**
     * 创建原子任务
     */
    @PostMapping("/api/v2/algomgr/atomic_tasks")
    BaseResponse<GeneratedModels.CreateAtomicTaskResponse> createAtomicTaskApiV2AlgomgrAtomicTasksPost(@RequestBody GeneratedModels.CreateAtomicTaskInput body);

    /**
     * 获取原子任务
     */
    @GetMapping("/api/v2/algomgr/atomic_tasks/{atomic_task_id}")
    BaseResponse<GeneratedModels.GetAtomicTaskResponse> getAtomicTaskApiV2AlgomgrAtomicTasksAtomicTaskIdGet(@PathVariable("atomic_task_id") String atomicTaskId);

    /**
     * 删除原子任务
     */
    @DeleteMapping("/api/v2/algomgr/atomic_tasks/{atomic_task_id}")
    BaseResponse<GeneratedModels.DeleteAtomicTaskResponse> deleteAtomicTaskApiV2AlgomgrAtomicTasksAtomicTaskIdDelete(@PathVariable("atomic_task_id") String atomicTaskId);

    /**
     * 搜索原子任务列表（含训练数据）
     */
    @PostMapping("/api/v2/algomgr/atomic-tasks/search")
    BaseResponse<GeneratedModels.AtomicTaskListResponse> searchAtomicTasksV2ApiV2AlgomgrAtomicTasksSearchPost(@RequestBody GeneratedModels.AtomicTaskQueryRequest body);

    /**
     * 搜索算法模型列表
     */
    @PostMapping("/api/v2/algomgr/models/search")
    BaseResponse<GeneratedModels.AlgorithmModelListResponse> searchModelsV2ApiV2AlgomgrModelsSearchPost(@RequestBody GeneratedModels.AlgorithmModelQueryRequest body);

    /**
     * Proxy Ontology
     */
    @PostMapping("/api/v1/ontology/{path}")
    BaseResponse<Object> proxyOntologyApiV1OntologyPathPost(@PathVariable("path") String path);

    /**
     * Proxy Ontology
     */
    @PutMapping("/api/v1/ontology/{path}")
    BaseResponse<Object> proxyOntologyApiV1OntologyPathPost(@PathVariable("path") String path);

    /**
     * Proxy Ontology
     */
    @GetMapping("/api/v1/ontology/{path}")
    BaseResponse<Object> proxyOntologyApiV1OntologyPathPost(@PathVariable("path") String path);

    /**
     * Proxy Ontology
     */
    @PatchMapping("/api/v1/ontology/{path}")
    BaseResponse<Object> proxyOntologyApiV1OntologyPathPost(@PathVariable("path") String path);

    /**
     * Proxy Ontology
     */
    @DeleteMapping("/api/v1/ontology/{path}")
    BaseResponse<Object> proxyOntologyApiV1OntologyPathPost(@PathVariable("path") String path);

    /**
     * 计算任务服务健康检查
     */
    @GetMapping("/api/v1/compute-tasks/health")
    BaseResponse<Object> healthCheckApiV1ComputeTasksHealthGet();

    /**
     * 获取可选 Topic 列表
     */
    @GetMapping("/api/v1/compute-tasks/topic-options")
    BaseResponse<Object> getTopicOptionsApiV1ComputeTasksTopicOptionsGet();

    /**
     * 列出计算任务
     */
    @GetMapping("/api/v1/compute-tasks")
    BaseResponse<Object> listTasksApiV1ComputeTasksGet();

    /**
     * 创建计算任务
     */
    @PostMapping("/api/v1/compute-tasks")
    BaseResponse<Object> createTaskApiV1ComputeTasksPost();

    /**
     * 获取计算任务详情
     */
    @GetMapping("/api/v1/compute-tasks/{task_id}")
    BaseResponse<Object> getTaskApiV1ComputeTasksTaskIdGet(@PathVariable("task_id") String taskId);

    /**
     * 更新计算任务
     */
    @PutMapping("/api/v1/compute-tasks/{task_id}")
    BaseResponse<Object> updateTaskApiV1ComputeTasksTaskIdPut(@PathVariable("task_id") String taskId);

    /**
     * 删除计算任务
     */
    @DeleteMapping("/api/v1/compute-tasks/{task_id}")
    BaseResponse<Object> deleteTaskApiV1ComputeTasksTaskIdDelete(@PathVariable("task_id") String taskId);

    /**
     * 启动计算任务
     */
    @PostMapping("/api/v1/compute-tasks/{task_id}/start")
    BaseResponse<Object> startTaskApiV1ComputeTasksTaskIdStartPost(@PathVariable("task_id") String taskId);

    /**
     * 停止计算任务
     */
    @PostMapping("/api/v1/compute-tasks/{task_id}/stop")
    BaseResponse<Object> stopTaskApiV1ComputeTasksTaskIdStopPost(@PathVariable("task_id") String taskId);

    /**
     * 写入审计日志
     */
    @PostMapping("/api/v1/admin/audit/logs")
    BaseResponse<GeneratedModels.AuditLogCreateResponse> createAuditLogApiV1AdminAuditLogsPost(@RequestBody GeneratedModels.CreateAuditLogRequest body);

    /**
     * 查询审计日志
     */
    @GetMapping("/api/v1/admin/audit/logs")
    BaseResponse<GeneratedModels.AuditLogListResponse> listAuditLogsApiV1AdminAuditLogsGet(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "page_size", required = false) Integer pageSize, @RequestParam(value = "start_time", required = false) String startTime, @RequestParam(value = "end_time", required = false) String endTime, @RequestParam(value = "user_name", required = false) String userName, @RequestParam(value = "source_module", required = false) String sourceModule, @RequestParam(value = "action_category", required = false) String actionCategory, @RequestParam(value = "action_name", required = false) String actionName, @RequestParam(value = "target_type", required = false) String targetType, @RequestParam(value = "target_id", required = false) String targetId, @RequestParam(value = "result_status", required = false) String resultStatus, @RequestParam(value = "keyword", required = false) String keyword);

    /**
     * 导出审计日志
     */
    @GetMapping("/api/v1/admin/audit/logs/export")
    BaseResponse<Object> exportAuditLogsApiV1AdminAuditLogsExportGet(@RequestParam(value = "start_time", required = false) String startTime, @RequestParam(value = "end_time", required = false) String endTime, @RequestParam(value = "user_name", required = false) String userName, @RequestParam(value = "source_module", required = false) String sourceModule, @RequestParam(value = "action_category", required = false) String actionCategory, @RequestParam(value = "action_name", required = false) String actionName, @RequestParam(value = "target_type", required = false) String targetType, @RequestParam(value = "target_id", required = false) String targetId, @RequestParam(value = "result_status", required = false) String resultStatus, @RequestParam(value = "keyword", required = false) String keyword);

    /**
     * 获取审计日志详情
     */
    @GetMapping("/api/v1/admin/audit/logs/{log_id}")
    BaseResponse<GeneratedModels.AuditLogDetailResponse> getAuditLogApiV1AdminAuditLogsLogIdGet(@PathVariable("log_id") String logId);

    /**
     * 获取上传 URL
     */
    @PostMapping("/api/v2/offline-files/upload-url")
    BaseResponse<GeneratedModels.UploadUrlResponse> getUploadUrlApiV2OfflineFilesUploadUrlPost(@RequestBody GeneratedModels.UploadUrlRequest body);

    /**
     * 初始化分片上传
     */
    @PostMapping("/api/v2/offline-files/multipart/init")
    BaseResponse<GeneratedModels.InitMultipartResponse> initMultipartUploadApiV2OfflineFilesMultipartInitPost(@RequestBody GeneratedModels.InitMultipartRequest body);

    /**
     * 获取分片上传 URL
     */
    @PostMapping("/api/v2/offline-files/multipart/presign-part")
    BaseResponse<GeneratedModels.PresignPartResponse> presignPartApiV2OfflineFilesMultipartPresignPartPost(@RequestBody GeneratedModels.PresignPartRequest body);

    /**
     * 完成分片上传
     */
    @PostMapping("/api/v2/offline-files/multipart/complete")
    BaseResponse<GeneratedModels.OfflineFileResponse> completeMultipartApiV2OfflineFilesMultipartCompletePost(@RequestBody GeneratedModels.CompleteMultipartRequest body);

    /**
     * 查询已上传分片
     */
    @GetMapping("/api/v2/offline-files/multipart/parts/{upload_id}")
    BaseResponse<GeneratedModels.ListPartsResponse> listUploadedPartsApiV2OfflineFilesMultipartPartsUploadIdGet(@PathVariable("upload_id") String uploadId, @RequestParam(value = "bucket", required = false) String bucket, @RequestParam(value = "key", required = false) String key);

    /**
     * 取消分片上传
     */
    @DeleteMapping("/api/v2/offline-files/multipart/abort/{upload_id}")
    BaseResponse<GeneratedModels.BasicResponse> abortMultipartApiV2OfflineFilesMultipartAbortUploadIdDelete(@PathVariable("upload_id") String uploadId, @RequestParam(value = "bucket", required = false) String bucket, @RequestParam(value = "key", required = false) String key);

    /**
     * 确认上传
     */
    @PostMapping("/api/v2/offline-files/confirm")
    BaseResponse<GeneratedModels.OfflineFileResponse> confirmUploadApiV2OfflineFilesConfirmPost(@RequestBody GeneratedModels.ConfirmUploadRequest body);

    /**
     * 列出离线文件
     */
    @GetMapping("/api/v2/offline-files/")
    BaseResponse<GeneratedModels.ListOfflineFilesResponse> listFilesApiV2OfflineFilesGet(@RequestParam(value = "prefix", required = false) String prefix, @RequestParam(value = "offset", required = false) Integer offset, @RequestParam(value = "limit", required = false) Integer limit);

    /**
     * 获取文件详情
     */
    @GetMapping("/api/v2/offline-files/{file_id}")
    BaseResponse<GeneratedModels.OfflineFileResponse> getFileApiV2OfflineFilesFileIdGet(@PathVariable("file_id") String fileId);

    /**
     * 删除文件
     */
    @DeleteMapping("/api/v2/offline-files/{file_id}")
    BaseResponse<GeneratedModels.BasicResponse> deleteFileApiV2OfflineFilesFileIdDelete(@PathVariable("file_id") String fileId);

    /**
     * 更新文件元信息
     */
    @PatchMapping("/api/v2/offline-files/{file_id}")
    BaseResponse<GeneratedModels.OfflineFileResponse> updateFileApiV2OfflineFilesFileIdPatch(@PathVariable("file_id") String fileId, @RequestBody GeneratedModels.UpdateFileRequest body);

    /**
     * 查询存储用量
     */
    @GetMapping("/api/v2/offline-files/storage/usage")
    BaseResponse<GeneratedModels.StorageUsageResponse> getStorageUsageApiV2OfflineFilesStorageUsageGet();

    /**
     * 触发存储清理
     */
    @PostMapping("/api/v2/offline-files/storage/cleanup")
    BaseResponse<GeneratedModels.BasicResponse> triggerCleanupApiV2OfflineFilesStorageCleanupPost(@RequestParam(value = "retention_days", required = false) Integer retentionDays);

    /**
     * List Components
     */
    @GetMapping("/api/v1/ops/components")
    BaseResponse<GeneratedModels.ComponentListResponse> listComponentsApiV1OpsComponentsGet(@RequestParam(value = "component_type", required = false) String componentType, @RequestParam(value = "status", required = false) String status);

    /**
     * Get Component
     */
    @GetMapping("/api/v1/ops/components/{component_id}")
    BaseResponse<GeneratedModels.ComponentResponse> getComponentApiV1OpsComponentsComponentIdGet(@PathVariable("component_id") String componentId);

    /**
     * Get Component Metrics
     */
    @GetMapping("/api/v1/ops/components/{component_id}/metrics")
    BaseResponse<GeneratedModels.ComponentMetricsResponse> getComponentMetricsApiV1OpsComponentsComponentIdMetricsGet(@PathVariable("component_id") String componentId, @RequestParam(value = "start_time", required = false) Integer startTime, @RequestParam(value = "end_time", required = false) Integer endTime);

    /**
     * List Alerts
     */
    @GetMapping("/api/v1/ops/alerts")
    BaseResponse<GeneratedModels.AlertListResponse> listAlertsApiV1OpsAlertsGet(@RequestParam(value = "level", required = false) String level, @RequestParam(value = "status", required = false) String status, @RequestParam(value = "component_id", required = false) String componentId, @RequestParam(value = "start_time", required = false) Integer startTime, @RequestParam(value = "end_time", required = false) Integer endTime);

    /**
     * Get Alert
     */
    @GetMapping("/api/v1/ops/alerts/{alert_id}")
    BaseResponse<GeneratedModels.AlertResponse> getAlertApiV1OpsAlertsAlertIdGet(@PathVariable("alert_id") String alertId);

    /**
     * Update Alert
     */
    @PatchMapping("/api/v1/ops/alerts/{alert_id}")
    BaseResponse<GeneratedModels.AlertResponse> updateAlertApiV1OpsAlertsAlertIdPatch(@PathVariable("alert_id") String alertId, @RequestBody GeneratedModels.AlertUpdateRequest body);

    /**
     * Get System Overview
     */
    @GetMapping("/api/v1/ops/overview")
    BaseResponse<GeneratedModels.SystemOverviewResponse> getSystemOverviewApiV1OpsOverviewGet();

    /**
     * Start Retrieval Upgrade
     */
    @PostMapping("/api/v1/ops/retrieval-upgrade/start")
    BaseResponse<GeneratedModels.UpgradeStartResponse> startRetrievalUpgradeApiV1OpsRetrievalUpgradeStartPost(@RequestBody GeneratedModels.UpgradeStartRequest body);

    /**
     * Get Retrieval Upgrade Status
     */
    @GetMapping("/api/v1/ops/retrieval-upgrade/status")
    BaseResponse<GeneratedModels.UpgradeStatusResponse> getRetrievalUpgradeStatusApiV1OpsRetrievalUpgradeStatusGet();

    /**
     * Validate Retrieval Upgrade
     */
    @PostMapping("/api/v1/ops/retrieval-upgrade/validate")
    BaseResponse<GeneratedModels.UpgradeValidateResponse> validateRetrievalUpgradeApiV1OpsRetrievalUpgradeValidatePost(@RequestBody GeneratedModels.UpgradeValidateRequest body);

    /**
     * Stop Retrieval Upgrade
     */
    @PostMapping("/api/v1/ops/retrieval-upgrade/stop")
    BaseResponse<GeneratedModels.UpgradeStopResponse> stopRetrievalUpgradeApiV1OpsRetrievalUpgradeStopPost();

    /**
     * 获取 License 状态
     */
    @GetMapping("/api/v1/license/status")
    BaseResponse<GeneratedModels.LicenseStatusResponse> getLicenseStatusApiV1LicenseStatusGet();

    /**
     * 获取集群所有 Pod 的健康状态
     */
    @GetMapping("/api/v1/diagnostics/pods")
    BaseResponse<GeneratedModels.PodsHealthResponse> listPodHealthApiV1DiagnosticsPodsGet(@RequestParam(value = "namespace", required = false) String namespace, @RequestParam(value = "only_unhealthy", required = false) Boolean onlyUnhealthy);

    /**
     * 下载系统诊断包
     */
    @GetMapping("/api/v1/diagnostics/bundle")
    BaseResponse<Object> downloadBundleApiV1DiagnosticsBundleGet(@RequestParam(value = "log_tail_lines", required = false) Integer logTailLines, @RequestParam(value = "namespaces", required = false) String namespaces, @RequestParam(value = "include_previous", required = false) Boolean includePrevious);

    /**
     * [旧3.x兼容] 第三方系统登录
     */
    @PostMapping("/business/api/login")
    BaseResponse<Object> businessLoginBusinessApiLoginPost(@RequestBody GeneratedModels.BusinessLoginInput body);

    /**
     * [旧3.x兼容] 第三方系统登出
     */
    @PostMapping("/business/api/logout")
    BaseResponse<Object> businessLogoutBusinessApiLogoutPost();
}
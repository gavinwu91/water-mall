package com.yitu.vms.service;

import com.yitu.vms.client.YituVmsClient;
import com.yitu.vms.model.BaseResponse;
import com.yitu.vms.model.GeneratedModels.DataType;
import com.yitu.vms.model.GeneratedModels.RepositoryInput2;
import com.yitu.vms.model.GeneratedModels.RepositoryType;
import com.yitu.vms.model.GeneratedModels.ResourceReferenceResponse;
import com.yitu.vms.model.GeneratedModels.SecurityLevel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 依图 VMS 底库业务服务示例
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class YituRepositoryService {

    // 1. 直接注入我们生成的强类型 Feign 客户端
    private final YituVmsClient yituVmsClient;

    /**
     * 示例：创建一个全新的静态人像库
     * 
     * @param repoName 库名称
     * @param comment  备注说明
     * @return 依图系统返回的该库的全局唯一 URI
     */
    public String createStaticFaceRepository(String repoName, String comment) {
        
        // 2. 组装请求体 (告别 Map 和硬编码字符串，全面拥抱面向对象！)
        RepositoryInput2 input = new RepositoryInput2();
        
        // 使用标准的 Java 小驼峰 Setter
        input.setName(repoName);
        input.setComment(comment);
        
        // 3. 核心亮点：使用强类型枚举！再也不用担心拼写错误传错参数了
        input.setRepoType(RepositoryType.STATIC);      // 只能选 STATIC 或 DYNAMIC
        input.setDataType(DataType.FACE);              // 只能选 FACE, BODY, VEHICLE
        input.setSecurityLevel(SecurityLevel.A);       // 只能选 A, B, C 等级

        log.info("准备发起请求创建底库, 参数对象: {}", input);

        // 4. 发起 HTTP 远程调用，IDE 能够完美推断出返回值类型是 BaseResponse<ResourceReferenceResponse>
        BaseResponse<ResourceReferenceResponse> response = yituVmsClient.createRepoApiV1RepositoriesPost(input);

        // 5. 解析并处理依图后端的返回结果
        if (response.getCode() != null && response.getCode() == 0 && response.getData() != null) {
            
            // 直接通过 getUri() 获取，不再需要把 Object 强转成 Map 然后再 get("uri") 了！
            String newRepoUri = response.getData().getUri();
            
            log.info("底库创建成功！依图返回的全局唯一 URI 为: {}", newRepoUri);
            return newRepoUri;
            
        } else {
            log.error("创建底库失败！错误码: {}, 错误信息: {}", response.getCode(), response.getMessage());
            throw new RuntimeException("调用依图 VMS 创建底库失败: " + response.getMessage());
        }
    }
}

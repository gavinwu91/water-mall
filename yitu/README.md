# 依图 VMS API 客户端 (Java/Feign)

本项目代码基于依图 Gateway-Python OpenAPI (Swagger) 接口文档生成。

## 目录结构
- `client/`: 声明式 API 客户端 (Feign Client)
- `model/`: 实体类、DTO 和 枚举定义

## 核心配置
- **Base URL**: `http://192.168.106.23:30081`
- **Feign 配置**: 
  在 `application.yml` 中配置：
  ```yaml
  yitu:
    vms:
      base-url: http://192.168.106.23:30081
  ```

## 依赖要求
- Spring Cloud OpenFeign
- Lombok
- Jackson (JSON 处理)

## 说明
目前已生成核心模块：
1. **系统健康检查**
2. **库管理** (创建、查询、详情、更新、删除、搜索)
3. **记录管理** (批量导入、修改)

如需其他模块（如：算法特征提取、布控管理等），可继续基于 `vms.json` 扩展。

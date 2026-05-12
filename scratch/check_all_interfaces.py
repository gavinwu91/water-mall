import json
import re

# 1. 加载 Swagger JSON
with open('file/vms.json', 'r', encoding='utf-8') as f:
    swagger = json.load(f)

all_paths = swagger.get('paths', {})
swagger_endpoints = []

for path, methods in all_paths.items():
    for method in methods.keys():
        if method.lower() in ['get', 'post', 'put', 'patch', 'delete']:
            swagger_endpoints.append(f"{method.upper()} {path}")

# 2. 读取生成的 Java 客户端
java_file = 'yitu/client/YituVmsClient.java'
with open(java_file, 'r', encoding='utf-8') as f:
    java_content = f.read()

# 提取 Java 中的 Mapping 路径 (增加 PutMapping 支持)
java_mappings = re.findall(r'@(Get|Post|Patch|Delete|Put)Mapping\("(.*?)"\)', java_content)
implemented_endpoints = [f"{m[0].upper()} {m[1]}" for m in java_mappings]

# 3. 交叉对比 (增强占位符忽略)
missing = []
for se in swagger_endpoints:
    # 忽略路径中的所有占位符进行匹配
    standardized_se = re.sub(r'\{.*?\}', '{P}', se)
    found = False
    for ie in implemented_endpoints:
        standardized_ie = re.sub(r'\{.*?\}', '{P}', ie)
        if standardized_se == standardized_ie:
            found = True
            break
    if not found:
        missing.append(se)

# 4. 输出结果
print(f"Total Swagger Endpoints: {len(swagger_endpoints)}")
print(f"Implemented Endpoints: {len(implemented_endpoints)}")
if missing:
    print("\n[CRITICAL] Still Missing Endpoints:")
    for m in missing:
        print(f" - {m}")
else:
    print("\n[SUCCESS] 100% Path Coverage Verified by Script!")

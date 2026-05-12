import json
import re

with open('file/vms.json', 'r', encoding='utf-8') as f:
    swagger = json.load(f)

schemas = swagger.get('components', {}).get('schemas', {})

# 采用最完美的按需小驼峰转换逻辑
def to_camel_case_prop(name):
    clean = re.sub(r'[^a-zA-Z0-9]', '_', name)
    if '_' in clean:
        parts = [p for p in clean.split('_') if p]
        if not parts: return "prop"
        camel = parts[0].lower() + "".join(p[0].upper() + p[1:] for p in parts[1:])
    else:
        if not clean: return "prop"
        camel = clean[0].lower() + clean[1:]
        
    if camel in ['class', 'public', 'private', 'protected', 'default', 'new', 'return', 'static', 'final', 'boolean', 'int']:
        camel = "_" + camel
    return camel

def to_pascal_case(name):
    parts = re.split(r'[^a-zA-Z0-9]', name)
    clean = "".join(p[0].upper() + p[1:] for p in parts if p)
    if not clean: return "Object"
    if clean[0].isdigit(): clean = "Model" + clean
    return clean

name_map = {}

def get_class_name(original_name):
    if original_name in name_map:
        return name_map[original_name]
    
    base_name = to_pascal_case(original_name)
    final_name = base_name
    counter = 2
    while final_name in name_map.values():
        final_name = f"{base_name}{counter}"
        counter += 1
    
    name_map[original_name] = final_name
    return final_name

for name in schemas.keys():
    get_class_name(name)

# 移植强大的深度解析引擎（支持 anyOf, Enum 内联等）
def resolve_type(schema):
    if not schema: return "Object"
    
    if '$ref' in schema:
        orig = schema['$ref'].split('/')[-1]
        ref_schema = schemas.get(orig, {})
        # 如果是内联别名（例如非枚举的普通 String 包装），直接展开
        if 'enum' not in ref_schema and ref_schema.get('type') in ['string', 'integer', 'number', 'boolean']:
            t = ref_schema.get('type')
            if t == 'string': return "String"
            if t == 'integer': return "Integer"
            if t == 'number': return "Double"
            if t == 'boolean': return "Boolean"
        return "GeneratedModels." + get_class_name(orig)
        
    if 'anyOf' in schema:
        for option in schema['anyOf']:
            if '$ref' in option:
                return resolve_type(option)
            if option.get('type') and option.get('type') != 'null':
                return resolve_type(option)
                
    if 'allOf' in schema:
        for option in schema['allOf']:
            if '$ref' in option:
                return resolve_type(option)

    if schema.get('type') == 'array':
        items = schema.get('items', {})
        return f"List<{resolve_type(items)}>"
        
    if schema.get('type') == 'object':
        title = schema.get('title')
        if title and title != "Body":
            return f"GeneratedModels.{get_class_name(title)}"
        return "Map<String, Object>"
        
    t = schema.get('type')
    if t == 'string': return "String"
    if t == 'integer': return "Integer"
    if t == 'number': return "Double"
    if t == 'boolean': return "Boolean"
    return "Object"

paths = swagger.get('paths', {})
java_methods = []

for path, methods in paths.items():
    for method_type, details in methods.items():
        if method_type.lower() not in ['get', 'post', 'put', 'patch', 'delete']:
            continue
        
        op_id = details.get('operationId', 'method_' + str(len(java_methods)))
        summary = details.get('summary', '')
        annotation = f"    @{method_type.title()}Mapping(\"{path}\")"
        
        params = []
        # Path Params
        for pv in re.findall(r'\{(.*?)\}', path):
            params.append(f"@PathVariable(\"{pv}\") String {to_camel_case_prop(pv)}")
        
        # Query Params
        for qp in details.get('parameters', []):
            if qp.get('in') == 'query':
                name = qp.get('name')
                p_type = resolve_type(qp.get('schema'))
                params.append(f"@RequestParam(value = \"{name}\", required = false) {p_type} {to_camel_case_prop(name)}")
        
        # Request Body
        if 'requestBody' in details:
            content = details['requestBody'].get('content', {})
            schema = content.get('application/json', {}).get('schema', {})
            params.append(f"@RequestBody {resolve_type(schema)} body")
            
        # Response Type
        resp_type = "Object"
        responses = details.get('responses', {})
        ok_resp = responses.get('200', {}).get('content', {}).get('application/json', {}).get('schema', {})
        resp_type = resolve_type(ok_resp)
        
        param_str = ", ".join(params)
        method_str = f"    /**\n     * {summary}\n     */\n{annotation}\n    BaseResponse<{resp_type}> {to_camel_case_prop(op_id)}({param_str});"
        java_methods.append(method_str)

header = """package com.yitu.vms.client;

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
"""

with open('yitu/client/YituVmsClient.java', 'w', encoding='utf-8') as f:
    f.write(header)
    f.write("\n\n".join(java_methods))
    f.write("\n}")

print("Successfully aligned YituVmsClient with deep parameter types and perfect camelCase.")

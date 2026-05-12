import json
import re

with open('file/vms.json', 'r', encoding='utf-8') as f:
    swagger = json.load(f)

schemas = swagger.get('components', {}).get('schemas', {})

def to_pascal_case(name):
    parts = re.split(r'[^a-zA-Z0-9]', name)
    clean = "".join(p[0].upper() + p[1:] for p in parts if p)
    if not clean: return "Object"
    if clean[0].isdigit(): clean = "Model" + clean
    return clean

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

def resolve_property_type(p_data):
    if not p_data: return "Object"
    
    if '$ref' in p_data:
        orig = p_data['$ref'].split('/')[-1]
        ref_schema = schemas.get(orig, {})
        if 'enum' not in ref_schema and ref_schema.get('type') in ['string', 'integer', 'number', 'boolean']:
            t = ref_schema.get('type')
            if t == 'string': return "String"
            if t == 'integer': return "Integer"
            if t == 'number': return "Double"
            if t == 'boolean': return "Boolean"
        return get_class_name(orig)
        
    if 'anyOf' in p_data:
        for option in p_data['anyOf']:
            if '$ref' in option:
                return resolve_property_type(option)
            if option.get('type') and option.get('type') != 'null':
                return resolve_property_type(option)
                
    if 'allOf' in p_data:
        for option in p_data['allOf']:
            if '$ref' in option:
                return resolve_property_type(option)

    t = p_data.get('type')
    if t == 'string': return "String"
    if t == 'integer': return "Integer"
    if t == 'number': return "Double"
    if t == 'boolean': return "Boolean"
    
    if t == 'array':
        items = p_data.get('items', {})
        inner_type = resolve_property_type(items)
        return f"List<{inner_type}>"
        
    return "Object"

def generate_java_class(name, data):
    class_name = get_class_name(name)
    desc_str = data.get('description', '').replace('\n', ' ')
    lines = []
    if desc_str:
        lines.append(f"    /** {desc_str} */")
        
    if 'enum' in data:
        lines.append(f"    public enum {class_name} {{")
        enum_values = data['enum']
        constants = []
        for val in enum_values:
            if val is None: continue
            enum_name = re.sub(r'[^a-zA-Z0-9_]', '_', str(val)).upper()
            if not enum_name or enum_name[0].isdigit(): enum_name = "_" + enum_name
            
            if isinstance(val, str):
                constants.append(f"        {enum_name}(\"{val}\")")
            else:
                constants.append(f"        {enum_name}({val})")
        lines.append(",\n".join(constants) + ";")
        lines.append("")
        lines.append(f"        private final Object value;")
        lines.append(f"        {class_name}(Object value) {{ this.value = value; }}")
        lines.append(f"        @JsonValue")
        lines.append(f"        public Object getValue() {{ return value; }}")
        lines.append("    }")
        return "\n".join(lines)
        
    if data.get('type') in ['string', 'integer', 'number', 'boolean']:
        return "" 

    lines.extend([
        f"    @Data",
        f"    @NoArgsConstructor",
        f"    @AllArgsConstructor",
        f"    public static class {class_name} {{"
    ])
    props = data.get('properties', {})
    for p_name, p_data in props.items():
        java_p_name = to_camel_case_prop(p_name)
        p_type = resolve_property_type(p_data)
        p_desc = p_data.get('description', '').replace('\n', ' ')
        
        if p_desc: lines.append(f"        /** {p_desc} */")
        
        # 极简模式：只有在原始 JSON 字段名和 Java 驼峰名不一致时，才加注解
        if p_name != java_p_name:
            lines.append(f"        @JsonProperty(\"{p_name}\")")
            
        lines.append(f"        private {p_type} {java_p_name};")
    lines.append("    }")
    return "\n".join(lines)

output = [
    "package com.yitu.vms.model;",
    "",
    "import lombok.Data;",
    "import lombok.NoArgsConstructor;",
    "import lombok.AllArgsConstructor;",
    "import com.fasterxml.jackson.annotation.JsonProperty;",
    "import com.fasterxml.jackson.annotation.JsonValue;",
    "import java.util.List;",
    "import java.util.Map;",
    "",
    "public class GeneratedModels {"
]

for name, data in schemas.items():
    java_code = generate_java_class(name, data)
    if java_code:
        output.append(java_code)

output.append("}")

with open('yitu/model/GeneratedModels.java', 'w', encoding='utf-8') as f:
    f.write("\n\n".join(output))

print("Successfully generated Java models with on-demand @JsonProperty annotations.")

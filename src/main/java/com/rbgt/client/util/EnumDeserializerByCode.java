package com.rbgt.client.util;

/**
 * @project_name: client
 * @package_name: com.rbgt.client.util
 * @name: EnumDeserializerByCode
 * @author: 俞春旺
 * @date: 2020/3/25 21:13
 * @day_name_full: 星期三
 * @remark: 无
 **/
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EnumDeserializerByCode extends JsonDeserializer<Object> {
    private static final Logger log = LoggerFactory.getLogger(EnumDeserializerByCode.class);

    public EnumDeserializerByCode() {
    }

    public Object deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        TreeNode node = parser.readValueAsTree();
        Object object = parser.getCurrentValue();
        String attrName = parser.getCurrentName();
        Object attrValue;
        if (node.isValueNode()) {
            attrValue = node;
        } else {
            if (!node.isObject() || !node.toString().startsWith("{") || !node.toString().endsWith("}")) {
                throw new IllegalArgumentException("deserializer enum error: node value [" + node + "] can't deserializer to " + object.getClass().getName());
            }

            attrValue = node.get("code");
        }

        Class clazz = null;

        try {
            clazz = object.getClass().getDeclaredField(attrName).getType();
        } catch (NoSuchFieldException var9) {
        }

        if (clazz == null) {
            return null;
        } else if (!clazz.isEnum()) {
            throw new IllegalArgumentException("deserializer enum error: " + clazz.getName() + " is not enum");
        } else {
            if (attrValue.toString().contains("\"")) {
                attrValue = attrValue.toString().replace("\"", "");
            }

            return null;
        }
    }
}

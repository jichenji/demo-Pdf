package com.chenji.demo.pdf.api.common.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.slf4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by wangzhigang on 2017/2/16.
 */

public class JsonUtil {

    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(JsonUtil.class);
    public static final ObjectMapper objectMapper;

    static {
        objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        //        objectMapper.setPropertyNamingStrategy(new CapitalizedPropertyNamingStrategy());
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
    }

    public static <T> T convertToObject(String jsonStr, Class<T> valueType) {

        try {
            if (jsonStr == null || jsonStr == "") {
                return null;
            }
            return objectMapper.readValue(jsonStr, valueType);
        } catch (Exception e) {
            logger.error("json convertToObject exception,", e);
            throw new RuntimeException(e);
        }
    }

    public static <T> T convertToObject(String jsonStr, TypeReference<T> valueTypeRef) {
        try {
            if (jsonStr == null || jsonStr == "") {
                return null;
            }
            return objectMapper.readValue(jsonStr, valueTypeRef);
        } catch (Exception e) {
            logger.error("异常", e);
        }

        return null;
    }

    public static <T> T convertToObject(String jsonStr, JavaType javaType) {
        try {
            if (jsonStr == null || jsonStr == "") {
                return null;
            }
            return objectMapper.readValue(jsonStr, javaType);
        } catch (Exception e) {
            logger.error("异常", e);
        }

        return null;
    }

    public static String convertToJson(Object object) {

        try {
            if (object == null) {
                return null;
            }
            return objectMapper.writeValueAsString(object);
        } catch (Exception e) {
            logger.error("JsonUtil异常", e);
        }
        return null;
    }

    public static JsonNode convertToJsonNode(String jsonStr) {
        try {
            JsonNode node = objectMapper.readTree(jsonStr);
            return node;
        } catch (Exception e) {
            logger.error("JsonUtil异常", e);
        }
        return null;
    }

    public static <T> T convertToObejctFromKey(String jsonStr, String key, Class<T> valueType) {
        try {
            JsonNode node = objectMapper.readTree(jsonStr);
            String nodeString = node.get(key).textValue();
            return convertToObject(nodeString, valueType);
        } catch (Exception e) {
            logger.error("JsonUtil异常", e);
        }
        return null;

    }

    public static String getNodeString(String jsonStr, String key) {
        try {
            JsonNode node = objectMapper.readTree(jsonStr);
            return node.get(key).textValue();

        } catch (Exception e) {
            logger.error("JsonUtil异常", e);
        }
        return null;

    }

    public static JsonNode getNode(String jsonStr, String key) {
        try {
            JsonNode node = objectMapper.readTree(jsonStr);
            return node.get(key);
        } catch (Exception e) {
            logger.error("JsonUtil异常", e);
        }
        return null;
    }

    public static JavaType BuildJavaType(Class<?> c1, Class<?> c2) {
        return objectMapper.getTypeFactory().constructParametricType(c1, c2);
    }

    public static <T> T convertToObject(Class<T> valueType, Map<String, Object> params) {
        try {
            if (params == null) {
                return null;
            }
            return objectMapper.readValue(objectMapper.writeValueAsString(params), valueType);
        } catch (Exception e) {
            logger.error("JsonUtil异常", e);
        }
        return null;
    }

    /*
    *
    public static class CapitalizedPropertyNamingStrategy extends PropertyNamingStrategy.PropertyNamingStrategyBase {
        @Override
        public String translate(String propertyName) {
            String name = propertyName.replaceAll("^\\w", propertyName.toUpperCase().substring(0,1));
            return name;
        }
    }*/

    public static <T> List<T> convertObjectList(String jsonStr, Class<T> clazz) throws IOException {

        CollectionType listType = objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, clazz);
        List<T> ObjectList = objectMapper.readValue(jsonStr, listType);
        return ObjectList;
    }
}
package com.chenji.demo.pdf.api.common.utils;

import java.util.Map;

/**
 * Created by zhongkewen on 2016/6/16.
 */
public class MapUtil {

    public static <T> T getValue(Map<String, Object> params, String... keys) {
        if (params == null) {
            return null;
        }
        Object value = null;
        for (int i = 0; i < keys.length - 1; i++) {
            if (params.get(keys[i]) == null) {
                break;
            }
            if (params.get(keys[i]) instanceof Map) {
                params = (Map<String, Object>) params.get(keys[i]);
            } else {
                break;
            }
        }
        if (keys.length > 0) {
            value = params.get(keys[keys.length - 1]);
        }
        return (T) value;
    }
}

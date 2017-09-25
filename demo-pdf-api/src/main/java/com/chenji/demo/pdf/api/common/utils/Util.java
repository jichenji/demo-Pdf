package com.chenji.demo.pdf.api.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by wangzhigang on 2017/4/19.
 */
public class Util {
    public static boolean eof(List list) {
        return list == null || list.size() < 1;
    }

    private static Logger logger = LoggerFactory.getLogger(Util.class);

    public static int parseInt(Object value, int defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        return parseInt(value.toString(), defaultValue);
    }

    public static int parseInt(String value, int defaultValue) {
        if (StringUtil.isEmptyValue(value)) {
            return defaultValue;
        }

        try {
            return Integer.parseInt(value);
        } catch (Exception e) {
            logger.error("Util异常", e);
            return defaultValue;
        }

    }
}

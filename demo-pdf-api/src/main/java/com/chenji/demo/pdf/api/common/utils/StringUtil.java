package com.chenji.demo.pdf.api.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wangzhigang on 2017/2/16.
 */
public class StringUtil {
    private static final Logger logger = LoggerFactory.getLogger(StringUtil.class);
    private static final String PHONE_NUMBER_REGEX = "^1[0-9]{10}$";

    public static boolean isEmpty(String value) {
        return value == null || value.isEmpty();
    }

    public static boolean isEmptyValue(String value) {
        return isEmpty(value) || "null".equals(value);
    }

    private static final String OLD_REASON_ID = "(\"reasonID\":)\\s*\\d+,";

    public static boolean hasEmpty(String... values) {
        for (String item : values) {
            if (isEmpty(item)) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasNull(Object... values) {
        for (Object item : values) {
            if (item == null) {
                return true;
            }
        }
        return false;
    }

    public static boolean allNull(Object... values) {
        for (Object item : values) {
            if (item != null) {
                return false;
            }
        }
        return true;
    }

    public static boolean allEmpty(String... values) {
        for (String item : values) {
            if (!isEmpty(item)) {
                return false;
            }
        }
        return true;
    }

    public static String getString(Object obj) {
        if (obj == null) {
            return "";
        }
        return obj.toString();
    }

    public static String getSexByIdNumber(String idNumber) {
        try {
            if (idNumber.length() == 15) {
                return Integer.parseInt(idNumber.substring(14, 15)) % 2 == 0 ? "女" : "男";
            } else if (idNumber.length() == 18) {
                return Integer.parseInt(idNumber.substring(16, 17)) % 2 == 0 ? "女" : "男";
            } else {
                return "未知";
            }
        } catch (Exception ex) {
            logger.error("异常", ex);
            return "未知";
        }
    }


    public static boolean checkPhoneNo(String phoneNo) {
        Pattern p = Pattern.compile(PHONE_NUMBER_REGEX);
        Matcher matcher = p.matcher(phoneNo);
        return matcher.matches();
    }

    public static String getOldReasonId(String string) {
        Pattern p = Pattern.compile(OLD_REASON_ID);
        Matcher matcher = p.matcher(string);
        if (matcher.find()) {
            return matcher.group(0);
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(StringUtil.getOldReasonId("'reasonID':6625,'fasdfddfadf':wer,'reasonID':6665,"));
    }
}

package com.chenji.demo.pdf.api.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by wangzhigang on 2017/4/13.
 */

public class DateUtil {
    private static final String defaultformat = "yyyy-MM-dd HH:mm:ss.SSS";
    private static final String YYYY_MM_DD = "yyyy-MM-dd";

    private static Logger logger = LoggerFactory.getLogger(DateUtil.class);

    public static String convertDate(Date date) {
        if (date == null) {
            return "";
        }
        DateFormat format = new SimpleDateFormat(defaultformat);
        return format.format(date);
    }

    public static String convertDate(Date date, String formatString) {
        if (date == null) {
            return "";
        }
        DateFormat format = new SimpleDateFormat(formatString);
        return format.format(date);
    }

    public static Date convertToDate(String value) {
        if (StringUtil.isEmpty(value)) {
            return null;
        }

        DateFormat format = null;
        if (value.contains(".")) {
            format = new SimpleDateFormat(defaultformat);
        } else if (value.contains(":")) {
            if (value.length() > 16) {
                format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            } else if (value.length() == 16) {
                format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            }
        } else if (value.contains("-")) {
            format = new SimpleDateFormat("yyyy-MM-dd");
        } else {
            return null;
        }


        try {
            return format == null ? null : format.parse(value);
        } catch (ParseException e) {
            logger.error("convertToDate异常", e);
            return null;
        }
    }

    public static Date now() {
        return new Date();
    }

    /**
     * 增加分钟
     *
     * @param date
     * @param addMins
     */
    public static Date dateAddMins(Date date, int addMins) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, addMins);
        return calendar.getTime();
    }

    /**
     * 添加指定的天数，可为负数
     *
     * @param date
     * @param days
     * @return
     */
    public static Date addDays(Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, days);
        return calendar.getTime();
    }

    /**
     * 添加指定的天数，可为负数
     *
     * @param date
     * @param months
     * @return
     */
    public static Date addMonths(Date date, int months) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, months);
        return calendar.getTime();
    }

}

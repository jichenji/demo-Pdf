package com.chenji.demo.pdf.api.common.utils;

import java.math.BigDecimal;

/**
 * Created by wangzhigang on 2017/2/24.
 */
public class DecimalUtil {
    public static BigDecimal formatToMoney(BigDecimal value){
        return value.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public static boolean equalsMoney(BigDecimal valueSource,BigDecimal valueTarget){
        return  formatToMoney(valueSource).equals(formatToMoney(valueTarget));
    }
}

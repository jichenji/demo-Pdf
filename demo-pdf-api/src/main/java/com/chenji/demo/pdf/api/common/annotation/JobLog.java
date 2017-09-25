package com.chenji.demo.pdf.api.common.annotation;

import java.lang.annotation.*;

/**
 * Created by wangzhigang on 2017/4/21.
 */
@Target(value={ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface  JobLog {
    String value() default "";

    String description() default "";
}

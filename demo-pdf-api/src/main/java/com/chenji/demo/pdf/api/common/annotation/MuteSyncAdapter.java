package com.chenji.demo.pdf.api.common.annotation;

import java.lang.annotation.*;

/**
 * Created by lifengguang on 2017/6/27.
 */
@Target(value={ElementType.METHOD})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface MuteSyncAdapter {

    boolean value() default true;
}

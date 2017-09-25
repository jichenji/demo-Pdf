package com.chenji.demo.pdf.api.common.exception;

import org.springframework.core.NestedRuntimeException;

/**
 * Created by wangzhigang on 2017/4/13.
 */
public class ApiException extends NestedRuntimeException {
    private int exceptionCode;

    public ApiException(int exceptionCode, String msg) {
        super(msg);
        this.exceptionCode = exceptionCode;
    }

    public ApiException(int exceptionCode, String msg, Throwable cause) {
        super(msg, cause);
        this.exceptionCode = exceptionCode;
    }

    public int getExceptionCode() {
        return exceptionCode;
    }

    public void setExceptionCode(int exceptionCode) {
        this.exceptionCode = exceptionCode;
    }

}

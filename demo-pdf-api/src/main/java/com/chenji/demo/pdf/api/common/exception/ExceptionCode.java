package com.chenji.demo.pdf.api.common.exception;

/**
 * Created by wangzhigang on 2017/4/13.
 *  0：成功
 *  -1:意外异常
 *  负数：技术性错误
 *  正数：业务线错误
 */
public class ExceptionCode {
    public static final int SUCCESS = 0;

    public static final int UNKNOW_EXCEPTION=-1;

    public static final int DB_Connect_Error = -100;

    public static final int Parameter_Miss = 100;
    public static final int Parameter_Value_Wrong = 101;

    public static final int Biz_Data_Not_Exisit = 200;


}

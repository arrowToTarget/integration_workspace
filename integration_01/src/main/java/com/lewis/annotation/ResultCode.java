package com.lewis.annotation;


/**
 * Created by zhangminghua on 2016/5/3.
 */
public enum ResultCode {
    RESULT_CODE_SUCCESS(10000,"SUCCESS"),
    RESULT_CODE_FAILED(11111,"FAILED"),
    RESULT_CODE_SYSERROR(11112,"SYSTEM ERROR");
    private int errorCode ;

    private String msg ;

    ResultCode(int errorCode, String msg) {
        this.errorCode = errorCode;
        this.msg = msg;
    }
}

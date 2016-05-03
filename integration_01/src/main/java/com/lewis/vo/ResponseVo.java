package com.lewis.vo;

import com.lewis.annotation.ResultCode;

/**
 * Created by zhangminghua on 2016/5/3.
 */
public class ResponseVo {

    private boolean success = true;

    private ResultCode resultCode = ResultCode.RESULT_CODE_SUCCESS;

    private Object data;


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public ResultCode getResultCode() {
        return resultCode;
    }

    public void setResultCode(ResultCode resultCode) {
        this.resultCode = resultCode;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


    public ResponseVo() {
    }

    public ResponseVo(boolean success, ResultCode resultCode, Object data) {
        this.success = success;
        this.resultCode = resultCode;
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseVo{" +
                "success=" + success +
                ", resultCode=" + resultCode +
                ", data=" + data +
                '}';
    }
}

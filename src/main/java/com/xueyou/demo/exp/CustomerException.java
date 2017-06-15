package com.xueyou.demo.exp;

/**
 * Created by wuxueyou on 2017/6/14.
 */
public class CustomerException extends Exception {
    private String errCode;
    private String errMsg;

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public CustomerException(String errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

}

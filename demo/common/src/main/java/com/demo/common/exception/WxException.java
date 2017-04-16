package com.demo.common.exception;

import com.demo.common.exception.domain.WxRespCode;

public class WxException extends Exception {

    private static final long serialVersionUID = -3784068986504862514L;

    private WxRespCode error;
    private String errorCode;
    private String errorMsg;

    public WxException(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public WxException(String errorMsg) {
        this.errorCode = "-1";
        this.errorMsg = errorMsg;
    }

    public WxException(Throwable cause) {
        super(cause);
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public WxRespCode getError() {
        return error;
    }
}
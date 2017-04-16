package com.demo.common.exception.domain;

/**
 * 微信返回码模型
 *
 * @author kxw
 * @time 16/1/19 12:47
 */
public class WxRespCode {

    private Integer errorCode;
    private String errorMessage;

    public WxRespCode() {
    }

    public WxRespCode(Integer errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
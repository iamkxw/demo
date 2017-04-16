package com.demo.data.domain.related.model;

/**
 * 附加模型类
 * 验证码发送检查结果
 *
 * @Author: kxw
 * @Create: 13:55
 */
public class SMSCodeCheckResult {

    private Boolean canSendSmsCode = false;

    private String errorMsg;

    public Boolean getCanSendSmsCode() {
        return canSendSmsCode;
    }

    public void setCanSendSmsCode(Boolean canSendSmsCode) {
        this.canSendSmsCode = canSendSmsCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}

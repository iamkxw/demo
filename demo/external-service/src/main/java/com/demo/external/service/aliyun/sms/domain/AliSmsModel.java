package com.demo.external.service.aliyun.sms.domain;

/**
 * Created by lixusheng on 10/12/16.
 */
public class AliSmsModel {

    //必须，操作接口名，系统规定参数，取值：SingleSendSms
    private String Action;

    //必须，管理控制台中配置的短信签名（状态必须是验证通过）
    private String SignName;

    //必须，管理控制台中配置的审核通过的短信模板的模板CODE（状态必须是验证通过）
    private String TemplateCode;

    //必须，目标手机号，多个手机号可以逗号分隔
    private String RecNum;

    //必须，短信模板中的变量；数字需要转换为字符串，json文本类型
    private String ParamString;

    public String getAction() {
        return Action;
    }

    public void setAction(String action) {
        Action = action;
    }

    public String getSignName() {
        return SignName;
    }

    public void setSignName(String signName) {
        SignName = signName;
    }

    public String getTemplateCode() {
        return TemplateCode;
    }

    public void setTemplateCode(String templateCode) {
        TemplateCode = templateCode;
    }

    public String getRecNum() {
        return RecNum;
    }

    public void setRecNum(String recNum) {
        RecNum = recNum;
    }

    public String getParamString() {
        return ParamString;
    }

    public void setParamString(String paramString) {
        ParamString = paramString;
    }
}

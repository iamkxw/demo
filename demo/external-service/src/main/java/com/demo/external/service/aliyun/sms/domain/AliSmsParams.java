package com.demo.external.service.aliyun.sms.domain;

/**
 * 阿里大于短信请求模型
 *
 * @Author: kxw
 * @Create: 18:09
 */
public class AliSmsParams {

    //短信模板名
    private String template;
    //短信应用名
    private String name;
    //接收人号码
    private String mobilePhoneNumber;
    //手机验证码
    private String code;
    //订单号
    private String orderId;
    //美容机构
    private String beautyOrgName;
    //美容项目
    private String beautyProjectName;
    //核销验证码
    private String tradeCode;
    //团购项目数量
    private String beautyProjectCnt;

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public void setMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getBeautyOrgName() {
        return beautyOrgName;
    }

    public void setBeautyOrgName(String beautyOrgName) {
        this.beautyOrgName = beautyOrgName;
    }

    public String getBeautyProjectName() {
        return beautyProjectName;
    }

    public void setBeautyProjectName(String beautyProjectName) {
        this.beautyProjectName = beautyProjectName;
    }

    public String getTradeCode() {
        return tradeCode;
    }

    public void setTradeCode(String tradeCode) {
        this.tradeCode = tradeCode;
    }

    public String getBeautyProjectCnt() {
        return beautyProjectCnt;
    }

    public void setBeautyProjectCnt(String beautyProjectCnt) {
        this.beautyProjectCnt = beautyProjectCnt;
    }
}
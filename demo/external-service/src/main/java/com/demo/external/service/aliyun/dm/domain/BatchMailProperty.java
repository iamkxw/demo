package com.demo.external.service.aliyun.dm.domain;

/**
 * Created by lixusheng on 8/24/16.
 */
public class BatchMailProperty {

    //必须
    //管理控制台中配置的发信地址
    private String AccountName;

    //必须
    //取值范围0~1: 0为随机账号(推荐,可以更好的统计退信情况);1为发信地址
    private int AddressType;

    //必须
    //预先创建且通过审核的模板名称
    private String TemplateName;

    //必须
    //预先创建且上传了收件人的收件人列表名称
    private String ReceiversName;

    //可选
    //邮件标签名称
    private String TagName;

    public String getAccountName() {
        return AccountName;
    }

    public void setAccountName(String accountName) {
        AccountName = accountName;
    }

    public int getAddressType() {
        return AddressType;
    }

    public void setAddressType(int addressType) {
        AddressType = addressType;
    }

    public String getTemplateName() {
        return TemplateName;
    }

    public void setTemplateName(String templateName) {
        TemplateName = templateName;
    }

    public String getReceiversName() {
        return ReceiversName;
    }

    public void setReceiversName(String receiversName) {
        ReceiversName = receiversName;
    }

    public String getTagName() {
        return TagName;
    }

    public void setTagName(String tagName) {
        TagName = tagName;
    }
}

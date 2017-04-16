package com.demo.external.service.aliyun.dm.domain;

/**
 * Created by lixusheng on 8/24/16.
 */
public class SingleMailProperty {

    //必须
    //管理控制台中配置的发信地址
    private String AccountName;

    //可选
    //发信人昵称,长度小于15个字符 例如:发信人昵称设置为"小红"，发信地址为"test@example.com"，收信人看到的发信地址为"小红"<test@example.com>
    private String FromAlias;

    //必须
    //取值范围0~1: 0为随机账号(推荐,可以更好的统计退信情况);1为发信地址
    private int AddressType;

    //必须
    private String TagName;

    //必须
    //是否使用管理控制台中配置的回信地址（状态必须是验证通过）
    private Boolean ReplyToAddress;

    //必须
    //目标地址，多个Email地址可以逗号分隔
    private String ToAddress;

    //必须
    //邮件主题,建议填写
    private String Subject;

    //邮件html正文
    private String HtmlBody;

    public String getAccountName() {
        return AccountName;
    }

    public void setAccountName(String accountName) {
        AccountName = accountName;
    }

    public String getFromAlias() {
        return FromAlias;
    }

    public void setFromAlias(String fromAlias) {
        FromAlias = fromAlias;
    }

    public int getAddressType() {
        return AddressType;
    }

    public void setAddressType(int addressType) {
        AddressType = addressType;
    }

    public String getTagName() {
        return TagName;
    }

    public void setTagName(String tagName) {
        TagName = tagName;
    }

    public Boolean getReplyToAddress() {
        return ReplyToAddress;
    }

    public void setReplyToAddress(Boolean replyToAddress) {
        ReplyToAddress = replyToAddress;
    }

    public String getToAddress() {
        return ToAddress;
    }

    public void setToAddress(String toAddress) {
        ToAddress = toAddress;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }

    public String getHtmlBody() {
        return HtmlBody;
    }

    public void setHtmlBody(String htmlBody) {
        HtmlBody = htmlBody;
    }
}

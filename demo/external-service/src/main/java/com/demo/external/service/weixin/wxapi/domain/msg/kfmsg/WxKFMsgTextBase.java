package com.demo.external.service.weixin.wxapi.domain.msg.kfmsg;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 微信客服信息请求模型:
 * 文本消息
 *
 * @Author: kxw
 * @Create: 17:03
 */
public class WxKFMsgTextBase {

    @JSONField(name = "touser")
    @JsonProperty("touser")
    private String touser;

    @JSONField(name = "msgtype")
    @JsonProperty("msgtype")
    private String msgtype = "text";

    @JSONField(name = "text")
    @JsonProperty("text")
    private WxKFMsgText text;

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }

    public WxKFMsgText getText() {
        return text;
    }

    public void setText(WxKFMsgText text) {
        this.text = text;
    }
}

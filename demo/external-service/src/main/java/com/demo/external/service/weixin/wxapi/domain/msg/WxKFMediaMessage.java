package com.demo.external.service.weixin.wxapi.domain.msg;

/**
 * 微信客服信息请求模型:
 * 图文信息
 *
 * @Author: kxw
 * @Create: 17:03
 */
public class WxKFMediaMessage {

    private String touser;

    private String msgtype = "mpnews";

    private WxKFMpnews mpnews;

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

    public WxKFMpnews getMpnews() {
        return mpnews;
    }

    public void setMpnews(WxKFMpnews mpnews) {
        this.mpnews = mpnews;
    }
}

package com.demo.external.service.weixin.wxapi.domain.msg.kfmsg;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 微信客服信息请求模型:
 * 图文信息
 *
 * @Author: kxw
 * @Create: 17:03
 */
public class WxKFMsgNewsBase {

    @JSONField(name = "touser")
    @JsonProperty("touser")
    private String touser;

    @JSONField(name = "msgtype")
    @JsonProperty("msgtype")
    private String msgtype = "news";

    @JSONField(name = "news")
    @JsonProperty("news")
    private WxKFMsgNews news;

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

    public WxKFMsgNews getNews() {
        return news;
    }

    public void setNews(WxKFMsgNews news) {
        this.news = news;
    }
}

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
public class WxKFMsgText {

    @JSONField(name = "content")
    @JsonProperty("content")
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

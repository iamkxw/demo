package com.demo.external.service.weixin.wxapi.domain.msg;

/**
 * 微信地理位置信息
 *
 * @author kxw
 * @time 16/1/19 11:53
 */
public class WxPushTextMessage extends WxPushBaseMessage {

    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
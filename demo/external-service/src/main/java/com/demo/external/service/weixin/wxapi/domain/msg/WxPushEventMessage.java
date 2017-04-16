package com.demo.external.service.weixin.wxapi.domain.msg;

/**
 * 微信事件信息
 *
 * @author kxw
 * @time 16/1/19 11:53
 */
public class WxPushEventMessage extends WxPushBaseMessage {

    private String event;

    private String eventKey;

    private String ticket;

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getEventKey() {
        return eventKey;
    }

    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }
}
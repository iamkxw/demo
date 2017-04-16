package com.demo.external.service.weixin.wxapi.domain.msg;

/**
 * 微信地理位置信息
 *
 * @author kxw
 * @time 16/1/19 11:53
 */
public class WxPushLocationMessage extends WxPushBaseMessage {

    private Double Location_X;

    private Double Location_Y;

    private String Scale;

    private String Label;

    public Double getLocation_X() {
        return Location_X;
    }

    public void setLocation_X(Double location_X) {
        Location_X = location_X;
    }

    public Double getLocation_Y() {
        return Location_Y;
    }

    public void setLocation_Y(Double location_Y) {
        Location_Y = location_Y;
    }

    public String getScale() {
        return Scale;
    }

    public void setScale(String scale) {
        Scale = scale;
    }

    public String getLabel() {
        return Label;
    }

    public void setLabel(String label) {
        Label = label;
    }
}
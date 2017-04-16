package com.demo.external.service.weixin.wxapi.domain.token;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WxTicket {

    @JsonProperty("errcode")
    private Integer errcode;

    @JsonProperty("errmsg")
    private String errmsg;

    @JsonProperty("ticket")
    private String ticket;

    @JsonProperty("expires_in")
    private Long expiresIn;

    private WxTicket() {
    }

    public String getTicket() {
        return ticket;
    }

    public Long getExpiresIn() {
        return expiresIn;
    }
}

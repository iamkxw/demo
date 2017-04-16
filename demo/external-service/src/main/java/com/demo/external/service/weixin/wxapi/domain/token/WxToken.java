package com.demo.external.service.weixin.wxapi.domain.token;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WxToken {

    @JsonProperty("access_token")
    private String accessToken;

    @JsonProperty("expires_in")
    private Long expiresIn;

    private WxToken() {
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public Long getExpiresIn() {
        return this.expiresIn;
    }
}

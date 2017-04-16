package com.demo.external.service.weixin.wxapi.domain.auth;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * 微信用户信息
 * 通过用户信息接口获取到的用户信息
 *
 * @Author: kxw
 * @Create: 11:34
 */
public class WxUser {

    @JsonProperty("subscribe")
    private Long subscribe;

    @JsonProperty("openid")
    private String openid;

    @JsonProperty("nickname")
    private String nickname;

    @JsonProperty("sex")
    private Byte sex;

    @JsonProperty("city")
    private String city;

    @JsonProperty("province")
    private String province;

    @JsonProperty("country")
    private String country;

    @JsonProperty("language")
    private String language;

    @JsonProperty("headimgurl")
    private String headimgurl;

    @JsonProperty("subscribe_time")
    private Long subscribe_time;

    @JsonProperty("remark")
    private String remark;

    @JsonProperty("groupid")
    private Integer groupid;

    @JsonProperty("unionid")
    private String unionid;

    @JsonProperty("tagid_list")
    private List tagIdList;

    public Long getSubscribe() {
        return subscribe;
    }

    public void setSubscribe(Long subscribe) {
        this.subscribe = subscribe;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Byte getSex() {
        return this.sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getHeadimgurl() {
        return headimgurl;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }

    public Long getSubscribe_time() {
        return subscribe_time;
    }

    public void setSubscribe_time(Long subscribe_time) {
        this.subscribe_time = subscribe_time;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getGroupid() {
        return groupid;
    }

    public void setGroupid(Integer groupid) {
        this.groupid = groupid;
    }

    public List getTagIdList() {
        return tagIdList;
    }

    public void setTagIdList(List tagIdList) {
        this.tagIdList = tagIdList;
    }
}

package com.demo.external.service.weixin.wxapi.domain.msg.kfmsg;

import com.alibaba.fastjson.annotation.JSONCreator;
import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 微信文章模型
 *
 * @Author: kxw
 * @Create: 11:22
 */
public class WxArticle {

    /**
     * 图文消息标题
     */
    @JSONField(name = "title")
    @JsonProperty("title")
    private String title;
    /**
     * 图文消息描述
     */
    @JSONField(name = "description")
    @JsonProperty("description")
    private String desc;
    /**
     * 图片链接，支持JPG、PNG格式，较好的效果为大图360*200，小图200*200
     */
    @JSONField(name = "picurl")
    @JsonProperty("picurl")
    private String picUrl;
    /**
     * 点击图文消息跳转链接
     */
    @JSONField(name = "url")
    @JsonProperty("url")
    private String url;

    /**
     * @param title  标题
     * @param desc   描述
     * @param picUrl 图片链接
     * @param url    跳转URL
     */
    @JSONCreator
    public WxArticle(@JSONField(name = "title") String title,
                     @JSONField(name = "desc") String desc,
                     @JSONField(name = "picurl") String picUrl,
                     @JSONField(name = "url") String url) {
        this.title = title;
        this.desc = desc;
        this.picUrl = picUrl;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "Article [title=" + title + ", desc=" + desc + ", picUrl="
                + picUrl + ", url=" + url + "]";
    }
}

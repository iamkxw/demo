package com.demo.external.service.weixin.wxapi.domain.msg.kfmsg;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * 微信客服信息请求模型:
 * 图文信息
 *
 * @Author: kxw
 * @Create: 17:03
 */
public class WxKFMsgNews {

    @JSONField(name = "articles")
    @JsonProperty("articles")
    private List<WxArticle> articles = new ArrayList<>();

    public WxKFMsgNews addArticle(WxArticle... wxArticles) {
        for (WxArticle wxArticle : wxArticles) {
            this.articles.add(wxArticle);
        }
        return this;
    }

    public List<WxArticle> getArticles() {
        return articles;
    }

    public void setArticles(List<WxArticle> articles) {
        this.articles = articles;
    }
}

package com.demo.common.util;

import com.demo.common.exception.AppException;
import com.demo.common.log.AppLogger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 * Created by lixusheng on 10/12/16.
 */
public class JsoupUtil {

    /**
     * 通过传入网页的地址和需要解析的元素的Id来获取对应id的值
     *
     * @param url       解析网页的地址
     * @param parameter 解析网页的元素
     * @return
     * @throws Exception
     */
    public static int getVideoView(String url, String parameter) throws Exception {
        try {
            Document doc = Jsoup.connect(url).get();
            Element element = doc.getElementById(parameter);
            String result = element.text();
            return Integer.parseInt(result);
        } catch (Exception e) {
            AppLogger.utilLogger.warn("网页内容分析异常", e);
            throw new AppException("获取网页数据失败");
        }
    }
}

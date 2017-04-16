package com.demo.common.util;

import com.demo.common.log.AppLogger;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Json工具类
 * Created by kxw
 *
 * @DateTime 2016/5/11 15:12
 */
public class JsonUtil {

    public static ObjectMapper objectMapper;

    /**
     * 把指定jsonStr转化pojo对象
     * Created by kxw
     */
    public static <T> T readValue(String jsonStr, Class<T> valueType) {
        if (objectMapper == null) {
            objectMapper = new ObjectMapper();
        }

        try {
            return objectMapper.readValue(jsonStr, valueType);
        } catch (Exception e) {
            AppLogger.utilLogger.warn("文件上传异常", e);
        }

        return null;
    }
}
package com.demo.common.util;

import com.demo.common.exception.AppException;
import com.demo.common.log.AppLogger;
import org.apache.commons.lang3.StringUtils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lixusheng on 5/26/16.
 * UTC时间格式转化成简单的时间格式
 */
public class UTCTransferToTSUtil {

    public static Timestamp UTCToTS(String Utc) {

        SimpleDateFormat UTCFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            if (StringUtils.isNotBlank(Utc)) {
                Date date = UTCFormat.parse(Utc);
                Timestamp ts = Timestamp.valueOf(dateFormat.format(date));
                return ts;
            } else {
                throw new AppException("UTC时间转化失败");
            }
        } catch (Exception e) {
            AppLogger.utilLogger.warn("UTC时间转化失败", e);
            return null;
        }
    }
}

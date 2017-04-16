package com.demo.common.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间工具类
 *
 * @Author: kxw
 * @Create: 11:20
 */
public class TimeUtil {

    /**
     * 获取当日0时
     *
     * @Author: kxw
     */
    public static Timestamp getCurrentDayStartTime() {
        Calendar currentDate = Calendar.getInstance();

        currentDate.set(Calendar.HOUR_OF_DAY, 0);
        currentDate.set(Calendar.MINUTE, 0);
        currentDate.set(Calendar.SECOND, 0);
        currentDate.set(Calendar.MILLISECOND, 0);

        return new Timestamp(currentDate.getTime().getTime());
    }

    /**
     * 获取当前时间（TimeStamp）
     *
     * @Author: kxw
     */
    public static Timestamp getCurrentTime() {
        return new Timestamp(System.currentTimeMillis());
    }

    /**
     * 获取指定格式的当前时间(yyyyMMddHHmmss)
     *
     * @Author: kxw
     */
    public static String getCurrentTimeStr() {

        Date date = new Date(System.currentTimeMillis());

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");

        return dateFormat.format(date);
    }
}

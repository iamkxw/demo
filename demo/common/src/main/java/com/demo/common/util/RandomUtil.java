package com.demo.common.util;

import java.util.Random;

/**
 * 随机数生成
 * Created by Sawyer on 2016/6/13.
 */
public class RandomUtil {

    /**
     * 返回0-max的随机数
     * Created by Sawyer on 2016/8/23.
     */
    public static int random(int max) {
        Random r = new Random();
        return r.nextInt(max);
    }

    /**
     * 返回指定位数的随机数
     * Created by Sawyer on 2016/8/23.
     */
    public static int randomInt(int digit) {
        Random r = new Random();
        return r.nextInt((int) Math.pow(10, (double) digit) - 1);
    }

    /**
     * 返回指定位数的随机数，返回String，前面补0
     * Created by Sawyer on 2016/8/23.
     */
    public static String randomIntToString(int digit) {
        String format = "%0" + digit + "d";
        //如果8位，得到"%08d"，格式化表示一共8位，前面不足以0补。0代表前面要补的字符8代表字符串长度d表示参数为整数类型
        return String.format(format, randomInt(digit));
    }
}

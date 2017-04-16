package com.demo.common.util;

import com.demo.common.log.AppLogger;
import org.junit.Test;

import java.util.Random;

/**
 * 手机验证码生成工具类
 *
 * @author kxw
 * @version 2017/2/10 15:32
 */
public class CodeUtil {

    /**
     * 4位手机验证码生成
     * <p>created by kxw on 2017/2/10 15:23</p>
     */
    private static String genSmsCodeOn4() {
        return genSmsCode(4);
    }

    /**
     * 6位手机验证码生成
     * <p>created by kxw on 2017/2/10 15:23</p>
     */
    private static String genSmsCodeOn6() {
        return genSmsCode(6);
    }

    /**
     * n位手机验证码生成
     * <p>created by kxw on 2017/2/10 15:23</p>
     */
    private static String genSmsCode(int n) {
        if (n < 0) {
            return "";
        }

        Random rand = new Random();

        //首字为1-9
        int first = rand.nextInt(9) + 1;

        //剩余5位随机生成
        StringBuilder sb = new StringBuilder();
        sb.append(first == 4 ? 5 : first); //避免出现4
        for (int index = 0; index < n - 1; index++) {
            int tmp = rand.nextInt(10);
            sb.append(String.valueOf(tmp == 4 ? 5 : tmp));
        }

        return sb.toString();
    }

    @Test
    public void testGenSmsCode() {
        AppLogger.testLogger.info(genSmsCodeOn4());
        AppLogger.testLogger.info(genSmsCodeOn6());
    }
}
package com.demo.model.context;

import org.springframework.util.Assert;
import org.springframework.util.ReflectionUtils;

/**
 * 美颜社全局变量基于线程局部变量的实现
 *
 * @author kxw
 * @version 2016/12/29 17:25
 */
public class AppContextHolderThreadLocalStrategy implements AppContextHolderStrategy<AppContext> {

    private static final ThreadLocal<AppContext> contextHolder = new ThreadLocal<>();

    public void clearContext() {
        contextHolder.remove();
    }

    public AppContext getContext() {
        AppContext ctx = contextHolder.get();

        if (ctx == null) {
            ctx = createEmptyContext();
            contextHolder.set(ctx);
        }

        return ctx;
    }

    public void setContext(AppContext context) {
        Assert.notNull(context, "不可以给全局线程变量设置空值");
        contextHolder.set(context);
    }

    public AppContext createEmptyContext() {
        try {
            return new AppContext();
        } catch (Exception ex) {
            ReflectionUtils.handleReflectionException(ex);
            return null;
        }
    }
}

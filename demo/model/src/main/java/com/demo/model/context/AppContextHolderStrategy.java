package com.demo.model.context;

/**
 * 美颜社全局变量存储策略
 *
 * @author kxw
 * @version 2016/12/29 16:46
 */
public interface AppContextHolderStrategy<T> {

    void clearContext();

    T getContext();

    void setContext(T context);

    T createEmptyContext();
}

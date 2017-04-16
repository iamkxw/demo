package com.demo.model.context;

public class AppContextHolder {

    private static AppContextHolderStrategy<AppContext> strategy;
    private static int initializeCount = 0;

    static {
        initialize();
    }

    private static void initialize() {
        strategy = new AppContextHolderThreadLocalStrategy();
        initializeCount++;
    }

    public static void clearContext() {
        strategy.clearContext();
    }

    public static AppContext getContext() {
        return strategy.getContext();
    }

    public static void setContext(AppContext context) {
        strategy.setContext(context);
    }

    public static AppContextHolderStrategy getContextHolderStrategy() {
        return strategy;
    }

    public static AppContext createEmptyContext() {
        return strategy.createEmptyContext();
    }

    @Override
    public String toString() {
        return "SecurityContextHolder[strategy='" + "AppContextHolderStrategy" + "'; initializeCount="
                + initializeCount + "]";
    }
}

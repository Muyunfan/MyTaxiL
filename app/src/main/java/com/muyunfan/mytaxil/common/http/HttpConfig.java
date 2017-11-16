package com.muyunfan.mytaxil.common.http;

/**
 * 类名称：HttpConfig
 * 类描述：
 * 创建人：L.C.W
 * 创建时间：on 2017/11/16 0016 14:43
 * 修改人：
 * 修改时间：
 * 修改备注：
 */
public class HttpConfig {
    private static final String TEST_APP_ID = "e90928398db0130b0d6d21da7bde357e";
    private static final String TEST_APP_KEY = "514d8f8a2371bdf1566033f6664a24d2";
    private static final String PROD_APP_ID = "";
    private static final String PROD_APP_KEY = "";
    private static final String TEST_DOMAIN = "http://cloud.bmob.cn";
    private static final String PRO_DOMAIN = "";
    private static String currentAppID = "";
    private static String currentAppKey = "";
    private static String currentDomain = "";

    static {
        initDefualtConfig();
    }

    private static void initDefualtConfig() {
        useTestConfig();
    }

    public static void useTestConfig() {
        currentAppID = TEST_APP_ID;
        currentAppKey = TEST_APP_KEY;
        currentDomain = TEST_DOMAIN;
    }

    public static void useProductConfig() {
        currentAppID = PROD_APP_ID;
        currentAppKey = PROD_APP_KEY;
        currentDomain = PRO_DOMAIN;
    }

    public static String getCurrentAppID() {
        return currentAppID;
    }

    public static void setCurrentAppID(String currentAppID) {
        HttpConfig.currentAppID = currentAppID;
    }

    public static String getCurrentAppKey() {
        return currentAppKey;
    }

    public static void setCurrentAppKey(String currentAppKey) {
        HttpConfig.currentAppKey = currentAppKey;
    }

    public static String getCurrentDomain() {
        return currentDomain;
    }

    public static void setCurrentDomain(String currentDomain) {
        HttpConfig.currentDomain = currentDomain;
    }
}

package com.ggemo.cqhttpclient.common.utils;

import org.apache.http.HttpRequest;

public class HeaderUtil {
    private static final String COOKIE = "Cookie";

    public static void refreshHeader(HttpRequest httpPost, String name, String value) {
        httpPost.removeHeaders(name);
        httpPost.addHeader(name, value);
    }

    public static void refreshCookie(HttpRequest httpPost, String cookieStr){
        if (cookieStr != null && !cookieStr.isBlank() && !cookieStr.isEmpty()) {
            HeaderUtil.refreshHeader(httpPost, COOKIE, cookieStr);
        }
    }

    public static void setIfNotExist(HttpRequest httpPost, String name, String value){
        if (!httpPost.containsHeader(name)) {
            httpPost.addHeader(name, value);
        }
    }
}

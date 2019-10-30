package com.ggemo.cqhttpclient.vo.response;

/**
 * 这玩意都是空对象,就这么放着吧
 */
public class AsyncResponseData implements ResponseData {
    private static final AsyncResponseData INSTANCE = new AsyncResponseData();

    private AsyncResponseData() {
    }

    public static AsyncResponseData getInstance() {
        return INSTANCE;
    }
}

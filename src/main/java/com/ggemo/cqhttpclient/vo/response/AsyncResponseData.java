package com.ggemo.cqhttpclient.vo.response;

public class AsyncResponseData implements ResponseData{
    private static final AsyncResponseData INSTANCE = new AsyncResponseData();
    private AsyncResponseData() {
    }

    public static AsyncResponseData getInstance() {
        return INSTANCE;
    }
}

package com.ggemo.cqhttpclient.vo.response.impl;

import com.alibaba.fastjson.JSON;
import com.ggemo.cqhttpclient.vo.response.AbstractResponse;
import com.ggemo.cqhttpclient.vo.response.RetCode;
import com.ggemo.cqhttpclient.vo.response.responsedata.GetCookiesResponseData;

public class GetCookiesResponse extends AbstractResponse<GetCookiesResponseData> {
    public GetCookiesResponse(RetCode retCode, GetCookiesResponseData data) {
        super(retCode, data);
    }

    public static GetCookiesResponse parse(String json) {
        GetCookiesResponse res = JSON.parseObject(json, GetCookiesResponse.class);
        return res;
    }
}

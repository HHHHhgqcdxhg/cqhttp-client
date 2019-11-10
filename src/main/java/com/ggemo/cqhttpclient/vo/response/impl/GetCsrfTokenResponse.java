package com.ggemo.cqhttpclient.vo.response.impl;

import com.alibaba.fastjson.JSON;
import com.ggemo.cqhttpclient.vo.response.AbstractResponse;
import com.ggemo.cqhttpclient.vo.response.RetCode;
import com.ggemo.cqhttpclient.vo.response.responsedata.GetCsrfTokenResponseData;

/**
 * @author 清纯的小黄瓜
 */
public class GetCsrfTokenResponse extends AbstractResponse<GetCsrfTokenResponseData> {
    public GetCsrfTokenResponse(RetCode retCode, GetCsrfTokenResponseData data) {
        super(retCode, data);
    }

    public static GetCsrfTokenResponse parse(String json) {
        GetCsrfTokenResponse res = JSON.parseObject(json, GetCsrfTokenResponse.class);
        return res;
    }
}

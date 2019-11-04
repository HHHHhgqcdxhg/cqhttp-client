package com.ggemo.cqhttpclient.vo.response.impl;

import com.alibaba.fastjson.JSON;
import com.ggemo.cqhttpclient.vo.response.AbstractResponse;
import com.ggemo.cqhttpclient.vo.response.RetCode;
import com.ggemo.cqhttpclient.vo.response.responsedata.GetVersionInfoResponseData;

public class GetVersionInfoResponse extends AbstractResponse<GetVersionInfoResponseData> {
    public GetVersionInfoResponse(RetCode retCode, GetVersionInfoResponseData data) {
        super(retCode, data);
    }

    public static GetVersionInfoResponse parse(String json) {
        GetVersionInfoResponse res = JSON.parseObject(json, GetVersionInfoResponse.class);
        return res;
    }
}

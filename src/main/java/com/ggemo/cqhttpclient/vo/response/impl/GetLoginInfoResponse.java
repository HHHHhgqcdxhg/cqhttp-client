package com.ggemo.cqhttpclient.vo.response.impl;

import com.alibaba.fastjson.JSON;
import com.ggemo.cqhttpclient.vo.response.AbstractResponse;
import com.ggemo.cqhttpclient.vo.response.RetCode;
import com.ggemo.cqhttpclient.vo.response.responsedata.GetLoginInfoResponseData;

public class GetLoginInfoResponse extends AbstractResponse<GetLoginInfoResponseData> {
    public GetLoginInfoResponse(RetCode retCode, GetLoginInfoResponseData data) {
        super(retCode, data);
    }

    public static GetLoginInfoResponse parse(String json) {
        GetLoginInfoResponse res = JSON.parseObject(json, GetLoginInfoResponse.class);
        return res;
    }
}

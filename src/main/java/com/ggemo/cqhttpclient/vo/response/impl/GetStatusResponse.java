package com.ggemo.cqhttpclient.vo.response.impl;

import com.alibaba.fastjson.JSON;
import com.ggemo.cqhttpclient.vo.response.AbstractResponse;
import com.ggemo.cqhttpclient.vo.response.RetCode;
import com.ggemo.cqhttpclient.vo.response.responsedata.GetStatusResponseData;

public class GetStatusResponse extends AbstractResponse<GetStatusResponseData> {
    public GetStatusResponse(RetCode retCode, GetStatusResponseData data) {
        super(retCode, data);
    }

    public static GetStatusResponse parse(String json) {
        GetStatusResponse res = JSON.parseObject(json, GetStatusResponse.class);
        return res;
    }
}

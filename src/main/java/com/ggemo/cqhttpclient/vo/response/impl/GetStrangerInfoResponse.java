package com.ggemo.cqhttpclient.vo.response.impl;

import com.alibaba.fastjson.JSON;
import com.ggemo.cqhttpclient.vo.response.AbstractResponse;
import com.ggemo.cqhttpclient.vo.response.RetCode;
import com.ggemo.cqhttpclient.vo.response.responsedata.GetStrangerInfoResponseData;

public class GetStrangerInfoResponse extends AbstractResponse<GetStrangerInfoResponseData> {
    public GetStrangerInfoResponse(RetCode retCode, GetStrangerInfoResponseData data) {
        super(retCode, data);
    }

    public static GetStrangerInfoResponse parse(String json) {
        GetStrangerInfoResponse res = JSON.parseObject(json, GetStrangerInfoResponse.class);
        return res;
    }
}

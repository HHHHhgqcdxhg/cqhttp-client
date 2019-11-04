package com.ggemo.cqhttpclient.vo.response.impl;

import com.alibaba.fastjson.JSON;
import com.ggemo.cqhttpclient.vo.response.AbstractResponse;
import com.ggemo.cqhttpclient.vo.response.RetCode;
import com.ggemo.cqhttpclient.vo.response.responsedata.SetGroupBanResponseData;

public class SetGroupBanResponse extends AbstractResponse<SetGroupBanResponseData> {
    public SetGroupBanResponse(RetCode retCode, SetGroupBanResponseData data) {
        super(retCode, data);
    }

    public static SetGroupBanResponse parse(String json) {
        SetGroupBanResponse res = JSON.parseObject(json, SetGroupBanResponse.class);
        return res;
    }
}

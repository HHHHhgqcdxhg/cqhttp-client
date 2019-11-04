package com.ggemo.cqhttpclient.vo.response.impl;

import com.alibaba.fastjson.JSON;
import com.ggemo.cqhttpclient.vo.response.AbstractResponse;
import com.ggemo.cqhttpclient.vo.response.RetCode;
import com.ggemo.cqhttpclient.vo.response.responsedata.SetGroupAnonymousResponseData;

public class SetGroupAnonymousResponse extends AbstractResponse<SetGroupAnonymousResponseData> {
    public SetGroupAnonymousResponse(RetCode retCode, SetGroupAnonymousResponseData data) {
        super(retCode, data);
    }

    public static SetGroupAnonymousResponse parse(String json) {
        SetGroupAnonymousResponse res = JSON.parseObject(json, SetGroupAnonymousResponse.class);
        return res;
    }
}

package com.ggemo.cqhttpclient.vo.response.impl;

import com.alibaba.fastjson.JSON;
import com.ggemo.cqhttpclient.vo.response.AbstractResponse;
import com.ggemo.cqhttpclient.vo.response.RetCode;
import com.ggemo.cqhttpclient.vo.response.responsedata.SetGroupLeaveResponseData;

public class SetGroupLeaveResponse extends AbstractResponse<SetGroupLeaveResponseData> {
    public SetGroupLeaveResponse(RetCode retCode, SetGroupLeaveResponseData data) {
        super(retCode, data);
    }

    public static SetGroupLeaveResponse parse(String json) {
        SetGroupLeaveResponse res = JSON.parseObject(json, SetGroupLeaveResponse.class);
        return res;
    }
}

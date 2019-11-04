package com.ggemo.cqhttpclient.vo.response.impl;

import com.alibaba.fastjson.JSON;
import com.ggemo.cqhttpclient.vo.response.AbstractResponse;
import com.ggemo.cqhttpclient.vo.response.RetCode;
import com.ggemo.cqhttpclient.vo.response.responsedata.SetGroupAdminResponseData;

public class SetGroupAdminResponse extends AbstractResponse<SetGroupAdminResponseData> {
    public SetGroupAdminResponse(RetCode retCode, SetGroupAdminResponseData data) {
        super(retCode, data);
    }

    public static SetGroupAdminResponse parse(String json) {
        SetGroupAdminResponse res = JSON.parseObject(json, SetGroupAdminResponse.class);
        return res;
    }
}

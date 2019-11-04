package com.ggemo.cqhttpclient.vo.response.impl;

import com.alibaba.fastjson.JSON;
import com.ggemo.cqhttpclient.vo.response.AbstractResponse;
import com.ggemo.cqhttpclient.vo.response.RetCode;
import com.ggemo.cqhttpclient.vo.response.responsedata.SetRestartPluginResponseData;

public class SetRestartPluginResponse extends AbstractResponse<SetRestartPluginResponseData> {
    public SetRestartPluginResponse(RetCode retCode, SetRestartPluginResponseData data) {
        super(retCode, data);
    }

    public static SetRestartPluginResponse parse(String json) {
        SetRestartPluginResponse res = JSON.parseObject(json, SetRestartPluginResponse.class);
        return res;
    }
}

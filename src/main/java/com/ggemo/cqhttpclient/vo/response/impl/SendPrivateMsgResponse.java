package com.ggemo.cqhttpclient.vo.response.impl;

import com.alibaba.fastjson.JSON;
import com.ggemo.cqhttpclient.vo.response.AbstractResponse;
import com.ggemo.cqhttpclient.vo.response.RetCode;
import com.ggemo.cqhttpclient.vo.response.responsedata.SendPrivateMsgResponseData;

public class SendPrivateMsgResponse extends AbstractResponse<SendPrivateMsgResponseData> {
    public SendPrivateMsgResponse(RetCode retCode, SendPrivateMsgResponseData data) {
        super(retCode, data);
    }

    public static SendPrivateMsgResponse parse(String json) {
        SendPrivateMsgResponse res = JSON.parseObject(json, SendPrivateMsgResponse.class);
        return res;
    }
}

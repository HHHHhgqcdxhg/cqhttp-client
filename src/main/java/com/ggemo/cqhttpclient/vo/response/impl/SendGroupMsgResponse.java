package com.ggemo.cqhttpclient.vo.response.impl;

import com.alibaba.fastjson.JSON;
import com.ggemo.cqhttpclient.vo.response.AbstractResponse;
import com.ggemo.cqhttpclient.vo.response.RetCode;
import com.ggemo.cqhttpclient.vo.response.responsedata.SendGroupMsgResponseData;

public class SendGroupMsgResponse extends AbstractResponse<SendGroupMsgResponseData> {
    public SendGroupMsgResponse(RetCode retCode, SendGroupMsgResponseData data) {
        super(retCode, data);
    }

    public static SendGroupMsgResponse parse(String json) {
        SendGroupMsgResponse res = JSON.parseObject(json, SendGroupMsgResponse.class);
        return res;
    }
}

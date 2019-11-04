package com.ggemo.cqhttpclient.vo.response.impl;

import com.alibaba.fastjson.JSON;
import com.ggemo.cqhttpclient.vo.response.AbstractResponse;
import com.ggemo.cqhttpclient.vo.response.RetCode;
import com.ggemo.cqhttpclient.vo.response.responsedata.SendMsgResponseData;

public class SendMsgResponse extends AbstractResponse<SendMsgResponseData> {
    public SendMsgResponse(RetCode retCode, SendMsgResponseData data) {
        super(retCode, data);
    }

    public static SendMsgResponse parse(String json) {
        SendMsgResponse res = JSON.parseObject(json, SendMsgResponse.class);
        return res;
    }
}

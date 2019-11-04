package com.ggemo.cqhttpclient.vo.response.impl;

import com.alibaba.fastjson.JSON;
import com.ggemo.cqhttpclient.vo.response.AbstractResponse;
import com.ggemo.cqhttpclient.vo.response.RetCode;
import com.ggemo.cqhttpclient.vo.response.responsedata.SendLikeResponseData;

public class SendLikeResponse extends AbstractResponse<SendLikeResponseData> {
    public SendLikeResponse(RetCode retCode, SendLikeResponseData data) {
        super(retCode, data);
    }

    public static SendLikeResponse parse(String json) {
        SendLikeResponse res = JSON.parseObject(json, SendLikeResponse.class);
        return res;
    }
}

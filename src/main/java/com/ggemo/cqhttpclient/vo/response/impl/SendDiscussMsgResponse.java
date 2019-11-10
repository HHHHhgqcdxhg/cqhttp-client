package com.ggemo.cqhttpclient.vo.response.impl;

import com.alibaba.fastjson.JSON;
import com.ggemo.cqhttpclient.vo.response.AbstractResponse;
import com.ggemo.cqhttpclient.vo.response.RetCode;
import com.ggemo.cqhttpclient.vo.response.responsedata.SendDiscussMsgResponseData;

/**
 * @author 清纯的小黄瓜
 */
public class SendDiscussMsgResponse extends AbstractResponse<SendDiscussMsgResponseData> {
    public SendDiscussMsgResponse(RetCode retCode, SendDiscussMsgResponseData data) {
        super(retCode, data);
    }

    public static SendDiscussMsgResponse parse(String json) {
        SendDiscussMsgResponse res = JSON.parseObject(json, SendDiscussMsgResponse.class);
        return res;
    }
}

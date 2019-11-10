package com.ggemo.cqhttpclient.vo.response.impl;

import com.alibaba.fastjson.JSON;
import com.ggemo.cqhttpclient.vo.response.AbstractResponse;
import com.ggemo.cqhttpclient.vo.response.RetCode;
import com.ggemo.cqhttpclient.vo.response.responsedata.CanSendRecordResponseData;

/**
 * @author 清纯的小黄瓜
 */
public class CanSendRecordResponse extends AbstractResponse<CanSendRecordResponseData> {
    public CanSendRecordResponse(RetCode retCode, CanSendRecordResponseData data) {
        super(retCode, data);
    }

    public static CanSendRecordResponse parse(String json) {
        CanSendRecordResponse res = JSON.parseObject(json, CanSendRecordResponse.class);
        return res;
    }
}

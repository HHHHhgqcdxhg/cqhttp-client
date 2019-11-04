package com.ggemo.cqhttpclient.vo.response.impl;

import com.alibaba.fastjson.JSON;
import com.ggemo.cqhttpclient.vo.response.AbstractResponse;
import com.ggemo.cqhttpclient.vo.response.RetCode;
import com.ggemo.cqhttpclient.vo.response.responsedata.CanSendImageResponseData;

/**
 * @author 清纯的小黄瓜
 */
public class CanSendImageResponse extends AbstractResponse<CanSendImageResponseData> {
    public CanSendImageResponse(RetCode retCode, CanSendImageResponseData data) {
        super(retCode, data);
    }

    public static CanSendImageResponse parse(String json) {
        CanSendImageResponse res = JSON.parseObject(json, CanSendImageResponse.class);
        return res;
    }
}

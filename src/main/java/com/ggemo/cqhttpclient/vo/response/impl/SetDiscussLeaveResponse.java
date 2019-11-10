package com.ggemo.cqhttpclient.vo.response.impl;

import com.alibaba.fastjson.JSON;
import com.ggemo.cqhttpclient.vo.response.AbstractResponse;
import com.ggemo.cqhttpclient.vo.response.RetCode;
import com.ggemo.cqhttpclient.vo.response.responsedata.SetDiscussLeaveResponseData;

/**
 * @author 清纯的小黄瓜
 */
public class SetDiscussLeaveResponse extends AbstractResponse<SetDiscussLeaveResponseData> {
    public SetDiscussLeaveResponse(RetCode retCode, SetDiscussLeaveResponseData data) {
        super(retCode, data);
    }

    public static SetDiscussLeaveResponse parse(String json) {
        SetDiscussLeaveResponse res = JSON.parseObject(json, SetDiscussLeaveResponse.class);
        return res;
    }
}

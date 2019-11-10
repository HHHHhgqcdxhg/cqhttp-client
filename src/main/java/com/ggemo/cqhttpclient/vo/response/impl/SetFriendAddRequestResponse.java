package com.ggemo.cqhttpclient.vo.response.impl;

import com.alibaba.fastjson.JSON;
import com.ggemo.cqhttpclient.vo.response.AbstractResponse;
import com.ggemo.cqhttpclient.vo.response.RetCode;
import com.ggemo.cqhttpclient.vo.response.responsedata.SetFriendAddRequestResponseData;

/**
 * @author 清纯的小黄瓜
 */
public class SetFriendAddRequestResponse extends AbstractResponse<SetFriendAddRequestResponseData> {
    public SetFriendAddRequestResponse(RetCode retCode, SetFriendAddRequestResponseData data) {
        super(retCode, data);
    }

    public static SetFriendAddRequestResponse parse(String json) {
        SetFriendAddRequestResponse res = JSON.parseObject(json, SetFriendAddRequestResponse.class);
        return res;
    }
}

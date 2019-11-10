package com.ggemo.cqhttpclient.vo.response.impl;

import com.alibaba.fastjson.JSON;
import com.ggemo.cqhttpclient.vo.response.AbstractResponse;
import com.ggemo.cqhttpclient.vo.response.RetCode;
import com.ggemo.cqhttpclient.vo.response.responsedata.GetFriendListResponseData;

/**
 * @author 清纯的小黄瓜
 */
public class GetFriendListResponse extends AbstractResponse<GetFriendListResponseData> {
    public GetFriendListResponse(RetCode retCode, GetFriendListResponseData data) {
        super(retCode, data);
    }

    public static GetFriendListResponse parse(String json) {
        GetFriendListResponse res = JSON.parseObject(json, GetFriendListResponse.class);
        return res;
    }
}

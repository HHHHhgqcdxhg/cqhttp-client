package com.ggemo.cqhttpclient.vo.response.impl;

import com.alibaba.fastjson.JSON;
import com.ggemo.cqhttpclient.vo.response.AbstractResponse;
import com.ggemo.cqhttpclient.vo.response.RetCode;
import com.ggemo.cqhttpclient.vo.response.responsedata.GetGroupMemberInfoResponseData;

/**
 * @author 清纯的小黄瓜
 */
public class GetGroupMemberInfoResponse extends AbstractResponse<GetGroupMemberInfoResponseData> {
    public GetGroupMemberInfoResponse(RetCode retCode, GetGroupMemberInfoResponseData data) {
        super(retCode, data);
    }

    public static GetGroupMemberInfoResponse parse(String json) {
        GetGroupMemberInfoResponse res = JSON.parseObject(json, GetGroupMemberInfoResponse.class);
        return res;
    }
}

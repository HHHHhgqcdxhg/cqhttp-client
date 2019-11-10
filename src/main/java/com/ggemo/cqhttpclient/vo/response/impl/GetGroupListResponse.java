package com.ggemo.cqhttpclient.vo.response.impl;

import com.alibaba.fastjson.JSON;
import com.ggemo.cqhttpclient.vo.response.AbstractResponse;
import com.ggemo.cqhttpclient.vo.response.RetCode;
import com.ggemo.cqhttpclient.vo.response.responsedata.GetGroupListResponseData;

/**
 * @author 清纯的小黄瓜
 */
public class GetGroupListResponse extends AbstractResponse<GetGroupListResponseData> {
    public GetGroupListResponse(RetCode retCode, GetGroupListResponseData data) {
        super(retCode, data);
    }

    public static GetGroupListResponse parse(String json) {
        GetGroupListResponse res = JSON.parseObject(json, GetGroupListResponse.class);
        return res;
    }
}

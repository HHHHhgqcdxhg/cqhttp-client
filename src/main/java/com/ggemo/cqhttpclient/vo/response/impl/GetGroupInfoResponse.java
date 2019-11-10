package com.ggemo.cqhttpclient.vo.response.impl;

import com.alibaba.fastjson.JSON;
import com.ggemo.cqhttpclient.vo.response.AbstractResponse;
import com.ggemo.cqhttpclient.vo.response.RetCode;
import com.ggemo.cqhttpclient.vo.response.responsedata.GetGroupInfoResponseData;

/**
 * @author 清纯的小黄瓜
 */
public class GetGroupInfoResponse extends AbstractResponse<GetGroupInfoResponseData> {
    public GetGroupInfoResponse(RetCode retCode, GetGroupInfoResponseData data) {
        super(retCode, data);
    }

    public static GetGroupInfoResponse parse(String json) {
        GetGroupInfoResponse res = JSON.parseObject(json, GetGroupInfoResponse.class);
        return res;
    }
}

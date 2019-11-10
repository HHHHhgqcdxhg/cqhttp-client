package com.ggemo.cqhttpclient.vo.response.impl;

import com.alibaba.fastjson.JSON;
import com.ggemo.cqhttpclient.vo.response.AbstractResponse;
import com.ggemo.cqhttpclient.vo.response.RetCode;
import com.ggemo.cqhttpclient.vo.response.responsedata.GetCredentialsResponseData;

/**
 * @author 清纯的小黄瓜
 */
public class GetCredentialsResponse extends AbstractResponse<GetCredentialsResponseData> {
    public GetCredentialsResponse(RetCode retCode, GetCredentialsResponseData data) {
        super(retCode, data);
    }

    public static GetCredentialsResponse parse(String json) {
        GetCredentialsResponse res = JSON.parseObject(json, GetCredentialsResponse.class);
        return res;
    }
}

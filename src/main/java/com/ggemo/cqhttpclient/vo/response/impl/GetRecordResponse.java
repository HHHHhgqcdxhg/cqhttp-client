package com.ggemo.cqhttpclient.vo.response.impl;

import com.alibaba.fastjson.JSON;
import com.ggemo.cqhttpclient.vo.response.AbstractResponse;
import com.ggemo.cqhttpclient.vo.response.RetCode;
import com.ggemo.cqhttpclient.vo.response.responsedata.GetRecordResponseData;

/**
 * @author 清纯的小黄瓜
 */
public class GetRecordResponse extends AbstractResponse<GetRecordResponseData> {
    public GetRecordResponse(RetCode retCode, GetRecordResponseData data) {
        super(retCode, data);
    }

    public static GetRecordResponse parse(String json) {
        GetRecordResponse res = JSON.parseObject(json, GetRecordResponse.class);
        return res;
    }
}

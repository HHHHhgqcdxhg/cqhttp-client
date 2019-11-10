package com.ggemo.cqhttpclient.vo.response.impl;

import com.alibaba.fastjson.JSON;
import com.ggemo.cqhttpclient.vo.response.AbstractResponse;
import com.ggemo.cqhttpclient.vo.response.RetCode;
import com.ggemo.cqhttpclient.vo.response.responsedata.GetImageResponseData;

/**
 * @author 清纯的小黄瓜
 */
public class GetImageResponse extends AbstractResponse<GetImageResponseData> {
    public GetImageResponse(RetCode retCode, GetImageResponseData data) {
        super(retCode, data);
    }

    public static GetImageResponse parse(String json) {
        GetImageResponse res = JSON.parseObject(json, GetImageResponse.class);
        return res;
    }
}

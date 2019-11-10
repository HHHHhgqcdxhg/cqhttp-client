package com.ggemo.cqhttpclient.vo.response.impl;

import com.alibaba.fastjson.JSON;
import com.ggemo.cqhttpclient.vo.response.AbstractResponse;
import com.ggemo.cqhttpclient.vo.response.RetCode;
import com.ggemo.cqhttpclient.vo.response.responsedata.CleanDataDirResponseData;

/**
 * @author 清纯的小黄瓜
 */
public class CleanDataDirResponse extends AbstractResponse<CleanDataDirResponseData> {
    public CleanDataDirResponse(RetCode retCode, CleanDataDirResponseData data) {
        super(retCode, data);
    }

    public static CleanDataDirResponse parse(String json) {
        CleanDataDirResponse res = JSON.parseObject(json, CleanDataDirResponse.class);
        return res;
    }
}

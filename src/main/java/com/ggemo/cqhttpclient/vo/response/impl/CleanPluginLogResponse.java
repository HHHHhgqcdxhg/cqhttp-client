package com.ggemo.cqhttpclient.vo.response.impl;

import com.alibaba.fastjson.JSON;
import com.ggemo.cqhttpclient.vo.response.AbstractResponse;
import com.ggemo.cqhttpclient.vo.response.RetCode;
import com.ggemo.cqhttpclient.vo.response.responsedata.CleanPluginLogResponseData;

/**
 * @author 清纯的小黄瓜
 */
public class CleanPluginLogResponse extends AbstractResponse<CleanPluginLogResponseData> {
    public CleanPluginLogResponse(RetCode retCode, CleanPluginLogResponseData data) {
        super(retCode, data);
    }

    public static CleanPluginLogResponse parse(String json) {
        CleanPluginLogResponse res = JSON.parseObject(json, CleanPluginLogResponse.class);
        return res;
    }
}

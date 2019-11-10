package com.ggemo.cqhttpclient.vo.response.impl;

import com.alibaba.fastjson.JSON;
import com.ggemo.cqhttpclient.vo.response.AbstractResponse;
import com.ggemo.cqhttpclient.vo.response.RetCode;
import com.ggemo.cqhttpclient.vo.response.responsedata.SetGroupCardResponseData;

/**
 * @author 清纯的小黄瓜
 */
public class SetGroupCardResponse extends AbstractResponse<SetGroupCardResponseData> {
    public SetGroupCardResponse(RetCode retCode, SetGroupCardResponseData data) {
        super(retCode, data);
    }

    public static SetGroupCardResponse parse(String json) {
        SetGroupCardResponse res = JSON.parseObject(json, SetGroupCardResponse.class);
        return res;
    }
}

package com.ggemo.cqhttpclient.vo.response.impl;

import com.alibaba.fastjson.JSON;
import com.ggemo.cqhttpclient.vo.response.AbstractResponse;
import com.ggemo.cqhttpclient.vo.response.RetCode;
import com.ggemo.cqhttpclient.vo.response.responsedata.SetGroupSpecialTitleResponseData;

/**
 * @author 清纯的小黄瓜
 */
public class SetGroupSpecialTitleResponse extends AbstractResponse<SetGroupSpecialTitleResponseData> {
    public SetGroupSpecialTitleResponse(RetCode retCode, SetGroupSpecialTitleResponseData data) {
        super(retCode, data);
    }

    public static SetGroupSpecialTitleResponse parse(String json) {
        SetGroupSpecialTitleResponse res = JSON.parseObject(json, SetGroupSpecialTitleResponse.class);
        return res;
    }
}

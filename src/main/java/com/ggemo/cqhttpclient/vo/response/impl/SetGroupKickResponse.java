package com.ggemo.cqhttpclient.vo.response.impl;

import com.alibaba.fastjson.JSON;
import com.ggemo.cqhttpclient.vo.response.AbstractResponse;
import com.ggemo.cqhttpclient.vo.response.RetCode;
import com.ggemo.cqhttpclient.vo.response.responsedata.SetGroupKickResponseData;

/**
 * @author 清纯的小黄瓜
 */
public class SetGroupKickResponse extends AbstractResponse<SetGroupKickResponseData> {
    public SetGroupKickResponse(RetCode retCode, SetGroupKickResponseData data) {
        super(retCode, data);
    }

    public static SetGroupKickResponse parse(String json) {
        SetGroupKickResponse res = JSON.parseObject(json, SetGroupKickResponse.class);
        return res;
    }
}

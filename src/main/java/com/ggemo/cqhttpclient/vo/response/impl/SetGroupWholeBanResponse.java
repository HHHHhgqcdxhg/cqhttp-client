package com.ggemo.cqhttpclient.vo.response.impl;

import com.alibaba.fastjson.JSON;
import com.ggemo.cqhttpclient.vo.response.AbstractResponse;
import com.ggemo.cqhttpclient.vo.response.RetCode;
import com.ggemo.cqhttpclient.vo.response.responsedata.SetGroupWholeBanResponseData;

public class SetGroupWholeBanResponse extends AbstractResponse<SetGroupWholeBanResponseData> {
    public SetGroupWholeBanResponse(RetCode retCode, SetGroupWholeBanResponseData data) {
        super(retCode, data);
    }

    public static SetGroupWholeBanResponse parse(String json) {
        SetGroupWholeBanResponse res = JSON.parseObject(json, SetGroupWholeBanResponse.class);
        return res;
    }
}

package com.ggemo.cqhttpclient.vo.response.impl;

import com.alibaba.fastjson.JSON;
import com.ggemo.cqhttpclient.vo.response.AbstractResponse;
import com.ggemo.cqhttpclient.vo.response.RetCode;
import com.ggemo.cqhttpclient.vo.response.responsedata.DeleteMsgResponseData;

/**
 * @author 清纯的小黄瓜
 */
public class DeleteMsgResponse extends AbstractResponse<DeleteMsgResponseData> {
    public DeleteMsgResponse(RetCode retCode, DeleteMsgResponseData data) {
        super(retCode, data);
    }

    public static DeleteMsgResponse parse(String json) {
        DeleteMsgResponse res = JSON.parseObject(json, DeleteMsgResponse.class);
        return res;
    }
}

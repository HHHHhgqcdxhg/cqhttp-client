package com.ggemo.cqhttpclient.apis.apis;

import com.ggemo.cqhttpclient.apis.Api;
import com.ggemo.cqhttpclient.vo.request.requestData.SendGroupMsgRequest;
import com.ggemo.cqhttpclient.vo.response.Response;
import com.ggemo.cqhttpclient.vo.response.responsedata.SendGroupMsgResponse;

public class SendGroupMsgApi implements Api<SendGroupMsgRequest, Response<SendGroupMsgResponse>> {
    @Override
    public Response<SendGroupMsgResponse> request(SendGroupMsgRequest request) {

        return null;
    }

    @Override
    public Response<SendGroupMsgResponse> request(Object... objects) {
        return null;
    }
}

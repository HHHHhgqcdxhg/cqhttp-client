package com.ggemo.cqhttpclient.apis.impl;

import com.ggemo.cqhttpclient.apis.AbstractApi;
import com.ggemo.cqhttpclient.apis.Api;
import com.ggemo.cqhttpclient.apis.ApiEnum;
import com.ggemo.cqhttpclient.requests.HttpPostRequests;
import com.ggemo.cqhttpclient.vo.request.impl.SendGroupMsgRequest;
import com.ggemo.cqhttpclient.vo.response.AbstractResponse;
import com.ggemo.cqhttpclient.vo.response.impl.SendGroupMsgResponse;
import com.ggemo.cqhttpclient.vo.response.responsedata.SendGroupMsgResponseData;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class SendGroupMsgApi extends AbstractApi<SendGroupMsgRequest, AbstractResponse<SendGroupMsgResponseData>> implements Api<SendGroupMsgRequest, AbstractResponse<SendGroupMsgResponseData>> {

    public SendGroupMsgApi(String baseUrl, Header header, RequestConfig requestConfig) {
        super(baseUrl, ApiEnum.SEND_GROUP_MSG, header, requestConfig);
    }

    @Override
    public SendGroupMsgResponse request(HttpPostRequests requests, SendGroupMsgRequest request) throws IOException {
        this.httpPostThreadLocal.set(this.httpPost);
        HttpPost httpPost = this.httpPostThreadLocal.get();
        try {
            UrlEncodedFormEntity entity = request.getEntity();
            if (entity != null) {
                httpPost.setEntity(entity);
            }
            HttpResponse httpResponse = requests.request(httpPost);
            HttpEntity responseEntity = httpResponse.getEntity();
            String responseString = EntityUtils.toString(responseEntity);
            SendGroupMsgResponse res = SendGroupMsgResponse.parse(responseString);
            return res;
        } finally {
            this.httpPostThreadLocal.remove();
        }
    }

    public SendGroupMsgResponse request(HttpPostRequests requests, int groupId, String msg, boolean autoEscape) throws IOException {
        SendGroupMsgRequest request = new SendGroupMsgRequest(groupId, msg, autoEscape);
        return request(requests, request);
    }
}

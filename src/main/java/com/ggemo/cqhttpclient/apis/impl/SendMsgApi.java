package com.ggemo.cqhttpclient.apis.impl;

import com.ggemo.cqhttpclient.apis.AbstractApi;
import com.ggemo.cqhttpclient.apis.Api;
import com.ggemo.cqhttpclient.apis.ApiEnum;
import com.ggemo.cqhttpclient.requests.HttpPostRequests;
import com.ggemo.cqhttpclient.vo.request.impl.SendMsgRequest;
import com.ggemo.cqhttpclient.vo.response.AbstractResponse;
import com.ggemo.cqhttpclient.vo.response.impl.SendMsgResponse;
import com.ggemo.cqhttpclient.vo.response.responsedata.SendMsgResponseData;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class SendMsgApi extends AbstractApi<SendMsgRequest, AbstractResponse<SendMsgResponseData>> implements Api<SendMsgRequest, AbstractResponse<SendMsgResponseData>> {

    public SendMsgApi(String baseUrl, Header header, RequestConfig requestConfig) {
        super(baseUrl, ApiEnum.SEND_MSG, header, requestConfig);
    }

    @Override
    public SendMsgResponse request(HttpPostRequests requests, SendMsgRequest request) throws IOException {
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
            SendMsgResponse res = SendMsgResponse.parse(responseString);
            return res;
        } finally {
            this.httpPostThreadLocal.remove();
        }
    }

    public SendMsgResponse request(HttpPostRequests requests,String messageType,int userId,int groupId,int discussId,String message,boolean autoEscape) throws IOException {
        SendMsgRequest request = new SendMsgRequest(messageType, userId, groupId, discussId, message, autoEscape);
        return request(requests, request);
    }
}

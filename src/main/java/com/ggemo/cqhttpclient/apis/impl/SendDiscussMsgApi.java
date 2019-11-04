package com.ggemo.cqhttpclient.apis.impl;

import com.ggemo.cqhttpclient.apis.AbstractApi;
import com.ggemo.cqhttpclient.apis.Api;
import com.ggemo.cqhttpclient.apis.ApiEnum;
import com.ggemo.cqhttpclient.requests.HttpPostRequests;
import com.ggemo.cqhttpclient.vo.request.impl.SendDiscussMsgRequest;
import com.ggemo.cqhttpclient.vo.response.AbstractResponse;
import com.ggemo.cqhttpclient.vo.response.impl.SendDiscussMsgResponse;
import com.ggemo.cqhttpclient.vo.response.responsedata.SendDiscussMsgResponseData;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class SendDiscussMsgApi extends AbstractApi<SendDiscussMsgRequest, AbstractResponse<SendDiscussMsgResponseData>> implements Api<SendDiscussMsgRequest, AbstractResponse<SendDiscussMsgResponseData>> {

    public SendDiscussMsgApi(String baseUrl, Header header, RequestConfig requestConfig) {
        super(baseUrl, ApiEnum.SEND_DISCUSS_MSG, header, requestConfig);
    }

    @Override
    public SendDiscussMsgResponse request(HttpPostRequests requests, SendDiscussMsgRequest request) throws IOException {
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
            SendDiscussMsgResponse res = SendDiscussMsgResponse.parse(responseString);
            return res;
        } finally {
            this.httpPostThreadLocal.remove();
        }
    }

    public SendDiscussMsgResponse request(HttpPostRequests requests,int discussId,String message,boolean autoEscape) throws IOException {
        SendDiscussMsgRequest request = new SendDiscussMsgRequest(discussId, message, autoEscape);
        return request(requests, request);
    }
}

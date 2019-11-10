package com.ggemo.cqhttpclient.apis.impl;

import com.ggemo.cqhttpclient.apis.AbstractApi;
import com.ggemo.cqhttpclient.apis.Api;
import com.ggemo.cqhttpclient.apis.ApiEnum;
import com.ggemo.cqhttpclient.requests.HttpPostRequests;
import com.ggemo.cqhttpclient.vo.request.impl.SendPrivateMsgRequest;
import com.ggemo.cqhttpclient.vo.response.AbstractResponse;
import com.ggemo.cqhttpclient.vo.response.impl.SendPrivateMsgResponse;
import com.ggemo.cqhttpclient.vo.response.responsedata.SendPrivateMsgResponseData;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @author 清纯的小黄瓜
 */
public class SendPrivateMsgApi extends AbstractApi<SendPrivateMsgRequest, AbstractResponse<SendPrivateMsgResponseData>> implements Api<SendPrivateMsgRequest, AbstractResponse<SendPrivateMsgResponseData>> {

    public SendPrivateMsgApi(String baseUrl, Header header, RequestConfig requestConfig) {
        super(baseUrl, ApiEnum.SEND_PRIVATE_MSG, header, requestConfig);
    }

    @Override
    public SendPrivateMsgResponse request(HttpPostRequests requests, SendPrivateMsgRequest request) throws IOException {
        HttpPost httpPost = this.getHttpPost();
        try {
            UrlEncodedFormEntity entity = request.getEntity();
            if (entity != null) {
                httpPost.setEntity(entity);
            }
            HttpResponse httpResponse = requests.request(httpPost);
            HttpEntity responseEntity = httpResponse.getEntity();
            String responseString = EntityUtils.toString(responseEntity);
            SendPrivateMsgResponse res = SendPrivateMsgResponse.parse(responseString);
            return res;
        } finally {
            this.giveBackHttpPost();
        }
    }

    public SendPrivateMsgResponse request(HttpPostRequests requests,long userId,String message,boolean autoEscape) throws IOException {
        SendPrivateMsgRequest request = new SendPrivateMsgRequest(userId, message, autoEscape);
        return request(requests, request);
    }
}

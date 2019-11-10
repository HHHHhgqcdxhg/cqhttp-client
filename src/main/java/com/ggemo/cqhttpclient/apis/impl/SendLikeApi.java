package com.ggemo.cqhttpclient.apis.impl;

import com.ggemo.cqhttpclient.apis.AbstractApi;
import com.ggemo.cqhttpclient.apis.Api;
import com.ggemo.cqhttpclient.apis.ApiEnum;
import com.ggemo.cqhttpclient.requests.HttpPostRequests;
import com.ggemo.cqhttpclient.vo.request.impl.SendLikeRequest;
import com.ggemo.cqhttpclient.vo.response.AbstractResponse;
import com.ggemo.cqhttpclient.vo.response.impl.SendLikeResponse;
import com.ggemo.cqhttpclient.vo.response.responsedata.SendLikeResponseData;
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
public class SendLikeApi extends AbstractApi<SendLikeRequest, AbstractResponse<SendLikeResponseData>> implements Api<SendLikeRequest, AbstractResponse<SendLikeResponseData>> {

    public SendLikeApi(String baseUrl, Header header, RequestConfig requestConfig) {
        super(baseUrl, ApiEnum.SEND_LIKE, header, requestConfig);
    }

    @Override
    public SendLikeResponse request(HttpPostRequests requests, SendLikeRequest request) throws IOException {
        HttpPost httpPost = this.getHttpPost();
        try {
            UrlEncodedFormEntity entity = request.getEntity();
            if (entity != null) {
                httpPost.setEntity(entity);
            }
            HttpResponse httpResponse = requests.request(httpPost);
            HttpEntity responseEntity = httpResponse.getEntity();
            String responseString = EntityUtils.toString(responseEntity);
            SendLikeResponse res = SendLikeResponse.parse(responseString);
            return res;
        } finally {
            this.giveBackHttpPost();
        }
    }

    public SendLikeResponse request(HttpPostRequests requests,int userId,int times) throws IOException {
        SendLikeRequest request = new SendLikeRequest(userId, times);
        return request(requests, request);
    }
}

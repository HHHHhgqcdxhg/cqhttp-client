package com.ggemo.cqhttpclient.apis.impl;

import com.ggemo.cqhttpclient.apis.AbstractApi;
import com.ggemo.cqhttpclient.apis.Api;
import com.ggemo.cqhttpclient.apis.ApiEnum;
import com.ggemo.cqhttpclient.requests.HttpPostRequests;
import com.ggemo.cqhttpclient.vo.request.impl.CanSendImageRequest;
import com.ggemo.cqhttpclient.vo.response.AbstractResponse;
import com.ggemo.cqhttpclient.vo.response.impl.CanSendImageResponse;
import com.ggemo.cqhttpclient.vo.response.responsedata.CanSendImageResponseData;
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
public class CanSendImageApi extends AbstractApi<CanSendImageRequest, AbstractResponse<CanSendImageResponseData>> implements Api<CanSendImageRequest, AbstractResponse<CanSendImageResponseData>> {

    public CanSendImageApi(String baseUrl, Header header, RequestConfig requestConfig) {
        super(baseUrl, ApiEnum.CAN_SEND_IMAGE, header, requestConfig);
    }

    @Override
    public CanSendImageResponse request(HttpPostRequests requests, CanSendImageRequest request) throws IOException {
        HttpPost httpPost = this.getHttpPost();
        try {
            UrlEncodedFormEntity entity = request.getEntity();
            if (entity != null) {
                httpPost.setEntity(entity);
            }
            HttpResponse httpResponse = requests.request(httpPost);
            HttpEntity responseEntity = httpResponse.getEntity();
            String responseString = EntityUtils.toString(responseEntity);
            CanSendImageResponse res = CanSendImageResponse.parse(responseString);
            return res;
        } finally {
            this.giveBackHttpPost();
        }
    }

    public CanSendImageResponse request(HttpPostRequests requests) throws IOException {
        CanSendImageRequest request = new CanSendImageRequest();
        return request(requests, request);
    }
}

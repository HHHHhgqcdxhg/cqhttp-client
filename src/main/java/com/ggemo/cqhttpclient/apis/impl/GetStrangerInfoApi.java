package com.ggemo.cqhttpclient.apis.impl;

import com.ggemo.cqhttpclient.apis.AbstractApi;
import com.ggemo.cqhttpclient.apis.Api;
import com.ggemo.cqhttpclient.apis.ApiEnum;
import com.ggemo.cqhttpclient.requests.HttpPostRequests;
import com.ggemo.cqhttpclient.vo.request.impl.GetStrangerInfoRequest;
import com.ggemo.cqhttpclient.vo.response.AbstractResponse;
import com.ggemo.cqhttpclient.vo.response.impl.GetStrangerInfoResponse;
import com.ggemo.cqhttpclient.vo.response.responsedata.GetStrangerInfoResponseData;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class GetStrangerInfoApi extends AbstractApi<GetStrangerInfoRequest, AbstractResponse<GetStrangerInfoResponseData>> implements Api<GetStrangerInfoRequest, AbstractResponse<GetStrangerInfoResponseData>> {

    public GetStrangerInfoApi(String baseUrl, Header header, RequestConfig requestConfig) {
        super(baseUrl, ApiEnum.GET_STRANGER_INFO, header, requestConfig);
    }

    @Override
    public GetStrangerInfoResponse request(HttpPostRequests requests, GetStrangerInfoRequest request) throws IOException {
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
            GetStrangerInfoResponse res = GetStrangerInfoResponse.parse(responseString);
            return res;
        } finally {
            this.httpPostThreadLocal.remove();
        }
    }

    public GetStrangerInfoResponse request(HttpPostRequests requests,int userId,boolean noCache) throws IOException {
        GetStrangerInfoRequest request = new GetStrangerInfoRequest(userId, noCache);
        return request(requests, request);
    }
}

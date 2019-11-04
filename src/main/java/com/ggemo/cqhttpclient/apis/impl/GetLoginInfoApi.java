package com.ggemo.cqhttpclient.apis.impl;

import com.ggemo.cqhttpclient.apis.AbstractApi;
import com.ggemo.cqhttpclient.apis.Api;
import com.ggemo.cqhttpclient.apis.ApiEnum;
import com.ggemo.cqhttpclient.requests.HttpPostRequests;
import com.ggemo.cqhttpclient.vo.request.impl.GetLoginInfoRequest;
import com.ggemo.cqhttpclient.vo.response.AbstractResponse;
import com.ggemo.cqhttpclient.vo.response.impl.GetLoginInfoResponse;
import com.ggemo.cqhttpclient.vo.response.responsedata.GetLoginInfoResponseData;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class GetLoginInfoApi extends AbstractApi<GetLoginInfoRequest, AbstractResponse<GetLoginInfoResponseData>> implements Api<GetLoginInfoRequest, AbstractResponse<GetLoginInfoResponseData>> {

    public GetLoginInfoApi(String baseUrl, Header header, RequestConfig requestConfig) {
        super(baseUrl, ApiEnum.GET_LOGIN_INFO, header, requestConfig);
    }

    @Override
    public GetLoginInfoResponse request(HttpPostRequests requests, GetLoginInfoRequest request) throws IOException {
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
            GetLoginInfoResponse res = GetLoginInfoResponse.parse(responseString);
            return res;
        } finally {
            this.httpPostThreadLocal.remove();
        }
    }

    public GetLoginInfoResponse request(HttpPostRequests requests) throws IOException {
        GetLoginInfoRequest request = new GetLoginInfoRequest();
        return request(requests, request);
    }
}

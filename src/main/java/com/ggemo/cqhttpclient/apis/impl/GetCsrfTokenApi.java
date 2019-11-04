package com.ggemo.cqhttpclient.apis.impl;

import com.ggemo.cqhttpclient.apis.AbstractApi;
import com.ggemo.cqhttpclient.apis.Api;
import com.ggemo.cqhttpclient.apis.ApiEnum;
import com.ggemo.cqhttpclient.requests.HttpPostRequests;
import com.ggemo.cqhttpclient.vo.request.impl.GetCsrfTokenRequest;
import com.ggemo.cqhttpclient.vo.response.AbstractResponse;
import com.ggemo.cqhttpclient.vo.response.impl.GetCsrfTokenResponse;
import com.ggemo.cqhttpclient.vo.response.responsedata.GetCsrfTokenResponseData;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class GetCsrfTokenApi extends AbstractApi<GetCsrfTokenRequest, AbstractResponse<GetCsrfTokenResponseData>> implements Api<GetCsrfTokenRequest, AbstractResponse<GetCsrfTokenResponseData>> {

    public GetCsrfTokenApi(String baseUrl, Header header, RequestConfig requestConfig) {
        super(baseUrl, ApiEnum.GET_CSRF_TOKEN, header, requestConfig);
    }

    @Override
    public GetCsrfTokenResponse request(HttpPostRequests requests, GetCsrfTokenRequest request) throws IOException {
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
            GetCsrfTokenResponse res = GetCsrfTokenResponse.parse(responseString);
            return res;
        } finally {
            this.httpPostThreadLocal.remove();
        }
    }

    public GetCsrfTokenResponse request(HttpPostRequests requests) throws IOException {
        GetCsrfTokenRequest request = new GetCsrfTokenRequest();
        return request(requests, request);
    }
}

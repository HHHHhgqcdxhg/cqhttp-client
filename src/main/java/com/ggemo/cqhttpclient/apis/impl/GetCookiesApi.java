package com.ggemo.cqhttpclient.apis.impl;

import com.ggemo.cqhttpclient.apis.AbstractApi;
import com.ggemo.cqhttpclient.apis.Api;
import com.ggemo.cqhttpclient.apis.ApiEnum;
import com.ggemo.cqhttpclient.requests.HttpPostRequests;
import com.ggemo.cqhttpclient.vo.request.impl.GetCookiesRequest;
import com.ggemo.cqhttpclient.vo.response.AbstractResponse;
import com.ggemo.cqhttpclient.vo.response.impl.GetCookiesResponse;
import com.ggemo.cqhttpclient.vo.response.responsedata.GetCookiesResponseData;
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
public class GetCookiesApi extends AbstractApi<GetCookiesRequest, AbstractResponse<GetCookiesResponseData>> implements Api<GetCookiesRequest, AbstractResponse<GetCookiesResponseData>> {

    public GetCookiesApi(String baseUrl, Header header, RequestConfig requestConfig) {
        super(baseUrl, ApiEnum.GET_COOKIES, header, requestConfig);
    }

    @Override
    public GetCookiesResponse request(HttpPostRequests requests, GetCookiesRequest request) throws IOException {
        HttpPost httpPost = this.getHttpPost();
        try {
            UrlEncodedFormEntity entity = request.getEntity();
            if (entity != null) {
                httpPost.setEntity(entity);
            }
            HttpResponse httpResponse = requests.request(httpPost);
            HttpEntity responseEntity = httpResponse.getEntity();
            String responseString = EntityUtils.toString(responseEntity);
            GetCookiesResponse res = GetCookiesResponse.parse(responseString);
            return res;
        } finally {
            this.giveBackHttpPost();
        }
    }

    public GetCookiesResponse request(HttpPostRequests requests,String domain) throws IOException {
        GetCookiesRequest request = new GetCookiesRequest(domain);
        return request(requests, request);
    }
}

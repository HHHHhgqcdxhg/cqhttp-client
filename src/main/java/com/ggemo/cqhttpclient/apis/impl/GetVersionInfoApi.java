package com.ggemo.cqhttpclient.apis.impl;

import com.ggemo.cqhttpclient.apis.AbstractApi;
import com.ggemo.cqhttpclient.apis.Api;
import com.ggemo.cqhttpclient.apis.ApiEnum;
import com.ggemo.cqhttpclient.requests.HttpPostRequests;
import com.ggemo.cqhttpclient.vo.request.impl.GetVersionInfoRequest;
import com.ggemo.cqhttpclient.vo.response.AbstractResponse;
import com.ggemo.cqhttpclient.vo.response.impl.GetVersionInfoResponse;
import com.ggemo.cqhttpclient.vo.response.responsedata.GetVersionInfoResponseData;
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
public class GetVersionInfoApi extends AbstractApi<GetVersionInfoRequest, AbstractResponse<GetVersionInfoResponseData>> implements Api<GetVersionInfoRequest, AbstractResponse<GetVersionInfoResponseData>> {

    public GetVersionInfoApi(String baseUrl, Header header, RequestConfig requestConfig) {
        super(baseUrl, ApiEnum.GET_VERSION_INFO, header, requestConfig);
    }

    @Override
    public GetVersionInfoResponse request(HttpPostRequests requests, GetVersionInfoRequest request) throws IOException {
        HttpPost httpPost = this.getHttpPost();
        try {
            UrlEncodedFormEntity entity = request.getEntity();
            if (entity != null) {
                httpPost.setEntity(entity);
            }
            HttpResponse httpResponse = requests.request(httpPost);
            HttpEntity responseEntity = httpResponse.getEntity();
            String responseString = EntityUtils.toString(responseEntity);
            GetVersionInfoResponse res = GetVersionInfoResponse.parse(responseString);
            return res;
        } finally {
            this.giveBackHttpPost();
        }
    }

    public GetVersionInfoResponse request(HttpPostRequests requests) throws IOException {
        GetVersionInfoRequest request = new GetVersionInfoRequest();
        return request(requests, request);
    }
}

package com.ggemo.cqhttpclient.apis.impl;

import com.ggemo.cqhttpclient.apis.AbstractApi;
import com.ggemo.cqhttpclient.apis.Api;
import com.ggemo.cqhttpclient.apis.ApiEnum;
import com.ggemo.cqhttpclient.requests.HttpPostRequests;
import com.ggemo.cqhttpclient.vo.request.impl.GetCredentialsRequest;
import com.ggemo.cqhttpclient.vo.response.AbstractResponse;
import com.ggemo.cqhttpclient.vo.response.impl.GetCredentialsResponse;
import com.ggemo.cqhttpclient.vo.response.responsedata.GetCredentialsResponseData;
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
public class GetCredentialsApi extends AbstractApi<GetCredentialsRequest, AbstractResponse<GetCredentialsResponseData>> implements Api<GetCredentialsRequest, AbstractResponse<GetCredentialsResponseData>> {

    public GetCredentialsApi(String baseUrl, Header header, RequestConfig requestConfig) {
        super(baseUrl, ApiEnum.GET_CREDENTIALS, header, requestConfig);
    }

    @Override
    public GetCredentialsResponse request(HttpPostRequests requests, GetCredentialsRequest request) throws IOException {
        HttpPost httpPost = this.getHttpPost();
        try {
            UrlEncodedFormEntity entity = request.getEntity();
            if (entity != null) {
                httpPost.setEntity(entity);
            }
            HttpResponse httpResponse = requests.request(httpPost);
            HttpEntity responseEntity = httpResponse.getEntity();
            String responseString = EntityUtils.toString(responseEntity);
            GetCredentialsResponse res = GetCredentialsResponse.parse(responseString);
            return res;
        } finally {
            this.giveBackHttpPost();
        }
    }

    public GetCredentialsResponse request(HttpPostRequests requests) throws IOException {
        GetCredentialsRequest request = new GetCredentialsRequest();
        return request(requests, request);
    }
}

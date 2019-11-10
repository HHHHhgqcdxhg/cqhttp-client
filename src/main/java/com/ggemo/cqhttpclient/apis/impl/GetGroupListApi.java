package com.ggemo.cqhttpclient.apis.impl;

import com.ggemo.cqhttpclient.apis.AbstractApi;
import com.ggemo.cqhttpclient.apis.Api;
import com.ggemo.cqhttpclient.apis.ApiEnum;
import com.ggemo.cqhttpclient.requests.HttpPostRequests;
import com.ggemo.cqhttpclient.vo.request.impl.GetGroupListRequest;
import com.ggemo.cqhttpclient.vo.response.AbstractResponse;
import com.ggemo.cqhttpclient.vo.response.impl.GetGroupListResponse;
import com.ggemo.cqhttpclient.vo.response.responsedata.GetGroupListResponseData;
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
public class GetGroupListApi extends AbstractApi<GetGroupListRequest, AbstractResponse<GetGroupListResponseData>> implements Api<GetGroupListRequest, AbstractResponse<GetGroupListResponseData>> {

    public GetGroupListApi(String baseUrl, Header header, RequestConfig requestConfig) {
        super(baseUrl, ApiEnum.GET_GROUP_LIST, header, requestConfig);
    }

    @Override
    public GetGroupListResponse request(HttpPostRequests requests, GetGroupListRequest request) throws IOException {
        HttpPost httpPost = this.getHttpPost();
        try {
            UrlEncodedFormEntity entity = request.getEntity();
            if (entity != null) {
                httpPost.setEntity(entity);
            }
            HttpResponse httpResponse = requests.request(httpPost);
            HttpEntity responseEntity = httpResponse.getEntity();
            String responseString = EntityUtils.toString(responseEntity);
            GetGroupListResponse res = GetGroupListResponse.parse(responseString);
            return res;
        } finally {
            this.giveBackHttpPost();
        }
    }

    public GetGroupListResponse request(HttpPostRequests requests) throws IOException {
        GetGroupListRequest request = new GetGroupListRequest();
        return request(requests, request);
    }
}

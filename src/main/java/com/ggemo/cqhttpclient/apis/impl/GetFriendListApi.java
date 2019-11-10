package com.ggemo.cqhttpclient.apis.impl;

import com.ggemo.cqhttpclient.apis.AbstractApi;
import com.ggemo.cqhttpclient.apis.Api;
import com.ggemo.cqhttpclient.apis.ApiEnum;
import com.ggemo.cqhttpclient.requests.HttpPostRequests;
import com.ggemo.cqhttpclient.vo.request.impl.GetFriendListRequest;
import com.ggemo.cqhttpclient.vo.response.AbstractResponse;
import com.ggemo.cqhttpclient.vo.response.impl.GetFriendListResponse;
import com.ggemo.cqhttpclient.vo.response.responsedata.GetFriendListResponseData;
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
public class GetFriendListApi extends AbstractApi<GetFriendListRequest, AbstractResponse<GetFriendListResponseData>> implements Api<GetFriendListRequest, AbstractResponse<GetFriendListResponseData>> {

    public GetFriendListApi(String baseUrl, Header header, RequestConfig requestConfig) {
        super(baseUrl, ApiEnum.GET_FRIEND_LIST, header, requestConfig);
    }

    @Override
    public GetFriendListResponse request(HttpPostRequests requests, GetFriendListRequest request) throws IOException {
        HttpPost httpPost = this.getHttpPost();
        try {
            UrlEncodedFormEntity entity = request.getEntity();
            if (entity != null) {
                httpPost.setEntity(entity);
            }
            HttpResponse httpResponse = requests.request(httpPost);
            HttpEntity responseEntity = httpResponse.getEntity();
            String responseString = EntityUtils.toString(responseEntity);
            GetFriendListResponse res = GetFriendListResponse.parse(responseString);
            return res;
        } finally {
            this.giveBackHttpPost();
        }
    }

    public GetFriendListResponse request(HttpPostRequests requests) throws IOException {
        GetFriendListRequest request = new GetFriendListRequest();
        return request(requests, request);
    }
}

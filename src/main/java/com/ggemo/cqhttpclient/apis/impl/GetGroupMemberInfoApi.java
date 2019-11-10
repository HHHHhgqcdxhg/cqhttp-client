package com.ggemo.cqhttpclient.apis.impl;

import com.ggemo.cqhttpclient.apis.AbstractApi;
import com.ggemo.cqhttpclient.apis.Api;
import com.ggemo.cqhttpclient.apis.ApiEnum;
import com.ggemo.cqhttpclient.requests.HttpPostRequests;
import com.ggemo.cqhttpclient.vo.request.impl.GetGroupMemberInfoRequest;
import com.ggemo.cqhttpclient.vo.response.AbstractResponse;
import com.ggemo.cqhttpclient.vo.response.impl.GetGroupMemberInfoResponse;
import com.ggemo.cqhttpclient.vo.response.responsedata.GetGroupMemberInfoResponseData;
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
public class GetGroupMemberInfoApi extends AbstractApi<GetGroupMemberInfoRequest, AbstractResponse<GetGroupMemberInfoResponseData>> implements Api<GetGroupMemberInfoRequest, AbstractResponse<GetGroupMemberInfoResponseData>> {

    public GetGroupMemberInfoApi(String baseUrl, Header header, RequestConfig requestConfig) {
        super(baseUrl, ApiEnum.GET_GROUP_MEMBER_INFO, header, requestConfig);
    }

    @Override
    public GetGroupMemberInfoResponse request(HttpPostRequests requests, GetGroupMemberInfoRequest request) throws IOException {
        HttpPost httpPost = this.getHttpPost();
        try {
            UrlEncodedFormEntity entity = request.getEntity();
            if (entity != null) {
                httpPost.setEntity(entity);
            }
            HttpResponse httpResponse = requests.request(httpPost);
            HttpEntity responseEntity = httpResponse.getEntity();
            String responseString = EntityUtils.toString(responseEntity);
            GetGroupMemberInfoResponse res = GetGroupMemberInfoResponse.parse(responseString);
            return res;
        } finally {
            this.giveBackHttpPost();
        }
    }

    public GetGroupMemberInfoResponse request(HttpPostRequests requests,int groupId,int userId,boolean noCache) throws IOException {
        GetGroupMemberInfoRequest request = new GetGroupMemberInfoRequest(groupId, userId, noCache);
        return request(requests, request);
    }
}

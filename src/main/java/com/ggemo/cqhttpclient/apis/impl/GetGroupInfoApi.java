package com.ggemo.cqhttpclient.apis.impl;

import com.ggemo.cqhttpclient.apis.AbstractApi;
import com.ggemo.cqhttpclient.apis.Api;
import com.ggemo.cqhttpclient.apis.ApiEnum;
import com.ggemo.cqhttpclient.requests.HttpPostRequests;
import com.ggemo.cqhttpclient.vo.request.impl.GetGroupInfoRequest;
import com.ggemo.cqhttpclient.vo.response.AbstractResponse;
import com.ggemo.cqhttpclient.vo.response.impl.GetGroupInfoResponse;
import com.ggemo.cqhttpclient.vo.response.responsedata.GetGroupInfoResponseData;
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
public class GetGroupInfoApi extends AbstractApi<GetGroupInfoRequest, AbstractResponse<GetGroupInfoResponseData>> implements Api<GetGroupInfoRequest, AbstractResponse<GetGroupInfoResponseData>> {

    public GetGroupInfoApi(String baseUrl, Header header, RequestConfig requestConfig) {
        super(baseUrl, ApiEnum.GET_GROUP_INFO, header, requestConfig);
    }

    @Override
    public GetGroupInfoResponse request(HttpPostRequests requests, GetGroupInfoRequest request) throws IOException {
        HttpPost httpPost = this.getHttpPost();
        try {
            UrlEncodedFormEntity entity = request.getEntity();
            if (entity != null) {
                httpPost.setEntity(entity);
            }
            HttpResponse httpResponse = requests.request(httpPost);
            HttpEntity responseEntity = httpResponse.getEntity();
            String responseString = EntityUtils.toString(responseEntity);
            GetGroupInfoResponse res = GetGroupInfoResponse.parse(responseString);
            return res;
        } finally {
            this.giveBackHttpPost();
        }
    }

    public GetGroupInfoResponse request(HttpPostRequests requests,int groupId,boolean noCache) throws IOException {
        GetGroupInfoRequest request = new GetGroupInfoRequest(groupId, noCache);
        return request(requests, request);
    }
}

package com.ggemo.cqhttpclient.apis.impl;

import com.ggemo.cqhttpclient.apis.AbstractApi;
import com.ggemo.cqhttpclient.apis.Api;
import com.ggemo.cqhttpclient.apis.ApiEnum;
import com.ggemo.cqhttpclient.requests.HttpPostRequests;
import com.ggemo.cqhttpclient.vo.request.impl.SetDiscussLeaveRequest;
import com.ggemo.cqhttpclient.vo.response.AbstractResponse;
import com.ggemo.cqhttpclient.vo.response.impl.SetDiscussLeaveResponse;
import com.ggemo.cqhttpclient.vo.response.responsedata.SetDiscussLeaveResponseData;
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
public class SetDiscussLeaveApi extends AbstractApi<SetDiscussLeaveRequest, AbstractResponse<SetDiscussLeaveResponseData>> implements Api<SetDiscussLeaveRequest, AbstractResponse<SetDiscussLeaveResponseData>> {

    public SetDiscussLeaveApi(String baseUrl, Header header, RequestConfig requestConfig) {
        super(baseUrl, ApiEnum.SET_DISCUSS_LEAVE, header, requestConfig);
    }

    @Override
    public SetDiscussLeaveResponse request(HttpPostRequests requests, SetDiscussLeaveRequest request) throws IOException {
        HttpPost httpPost = this.getHttpPost();
        try {
            UrlEncodedFormEntity entity = request.getEntity();
            if (entity != null) {
                httpPost.setEntity(entity);
            }
            HttpResponse httpResponse = requests.request(httpPost);
            HttpEntity responseEntity = httpResponse.getEntity();
            String responseString = EntityUtils.toString(responseEntity);
            SetDiscussLeaveResponse res = SetDiscussLeaveResponse.parse(responseString);
            return res;
        } finally {
            this.giveBackHttpPost();
        }
    }

    public SetDiscussLeaveResponse request(HttpPostRequests requests,int discussId) throws IOException {
        SetDiscussLeaveRequest request = new SetDiscussLeaveRequest(discussId);
        return request(requests, request);
    }
}

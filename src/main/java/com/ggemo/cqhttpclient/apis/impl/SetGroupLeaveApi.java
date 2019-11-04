package com.ggemo.cqhttpclient.apis.impl;

import com.ggemo.cqhttpclient.apis.AbstractApi;
import com.ggemo.cqhttpclient.apis.Api;
import com.ggemo.cqhttpclient.apis.ApiEnum;
import com.ggemo.cqhttpclient.requests.HttpPostRequests;
import com.ggemo.cqhttpclient.vo.request.impl.SetGroupLeaveRequest;
import com.ggemo.cqhttpclient.vo.response.AbstractResponse;
import com.ggemo.cqhttpclient.vo.response.impl.SetGroupLeaveResponse;
import com.ggemo.cqhttpclient.vo.response.responsedata.SetGroupLeaveResponseData;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class SetGroupLeaveApi extends AbstractApi<SetGroupLeaveRequest, AbstractResponse<SetGroupLeaveResponseData>> implements Api<SetGroupLeaveRequest, AbstractResponse<SetGroupLeaveResponseData>> {

    public SetGroupLeaveApi(String baseUrl, Header header, RequestConfig requestConfig) {
        super(baseUrl, ApiEnum.SET_GROUP_LEAVE, header, requestConfig);
    }

    @Override
    public SetGroupLeaveResponse request(HttpPostRequests requests, SetGroupLeaveRequest request) throws IOException {
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
            SetGroupLeaveResponse res = SetGroupLeaveResponse.parse(responseString);
            return res;
        } finally {
            this.httpPostThreadLocal.remove();
        }
    }

    public SetGroupLeaveResponse request(HttpPostRequests requests,int groupId,boolean isDismiss) throws IOException {
        SetGroupLeaveRequest request = new SetGroupLeaveRequest(groupId, isDismiss);
        return request(requests, request);
    }
}

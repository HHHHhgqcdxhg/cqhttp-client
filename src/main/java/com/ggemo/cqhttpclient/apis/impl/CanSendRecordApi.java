package com.ggemo.cqhttpclient.apis.impl;

import com.ggemo.cqhttpclient.apis.AbstractApi;
import com.ggemo.cqhttpclient.apis.Api;
import com.ggemo.cqhttpclient.apis.ApiEnum;
import com.ggemo.cqhttpclient.requests.HttpPostRequests;
import com.ggemo.cqhttpclient.vo.request.impl.CanSendRecordRequest;
import com.ggemo.cqhttpclient.vo.response.AbstractResponse;
import com.ggemo.cqhttpclient.vo.response.impl.CanSendRecordResponse;
import com.ggemo.cqhttpclient.vo.response.responsedata.CanSendRecordResponseData;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class CanSendRecordApi extends AbstractApi<CanSendRecordRequest, AbstractResponse<CanSendRecordResponseData>> implements Api<CanSendRecordRequest, AbstractResponse<CanSendRecordResponseData>> {

    public CanSendRecordApi(String baseUrl, Header header, RequestConfig requestConfig) {
        super(baseUrl, ApiEnum.CAN_SEND_RECORD, header, requestConfig);
    }

    @Override
    public CanSendRecordResponse request(HttpPostRequests requests, CanSendRecordRequest request) throws IOException {
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
            CanSendRecordResponse res = CanSendRecordResponse.parse(responseString);
            return res;
        } finally {
            this.httpPostThreadLocal.remove();
        }
    }

    public CanSendRecordResponse request(HttpPostRequests requests) throws IOException {
        CanSendRecordRequest request = new CanSendRecordRequest();
        return request(requests, request);
    }
}

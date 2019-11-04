package com.ggemo.cqhttpclient.apis.impl;

import com.ggemo.cqhttpclient.apis.AbstractApi;
import com.ggemo.cqhttpclient.apis.Api;
import com.ggemo.cqhttpclient.apis.ApiEnum;
import com.ggemo.cqhttpclient.requests.HttpPostRequests;
import com.ggemo.cqhttpclient.vo.request.impl.SetGroupCardRequest;
import com.ggemo.cqhttpclient.vo.response.AbstractResponse;
import com.ggemo.cqhttpclient.vo.response.impl.SetGroupCardResponse;
import com.ggemo.cqhttpclient.vo.response.responsedata.SetGroupCardResponseData;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class SetGroupCardApi extends AbstractApi<SetGroupCardRequest, AbstractResponse<SetGroupCardResponseData>> implements Api<SetGroupCardRequest, AbstractResponse<SetGroupCardResponseData>> {

    public SetGroupCardApi(String baseUrl, Header header, RequestConfig requestConfig) {
        super(baseUrl, ApiEnum.SET_GROUP_CARD, header, requestConfig);
    }

    @Override
    public SetGroupCardResponse request(HttpPostRequests requests, SetGroupCardRequest request) throws IOException {
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
            SetGroupCardResponse res = SetGroupCardResponse.parse(responseString);
            return res;
        } finally {
            this.httpPostThreadLocal.remove();
        }
    }

    public SetGroupCardResponse request(HttpPostRequests requests,int groupId,int userId,String card) throws IOException {
        SetGroupCardRequest request = new SetGroupCardRequest(groupId, userId, card);
        return request(requests, request);
    }
}

package com.ggemo.cqhttpclient.apis.impl;

import com.ggemo.cqhttpclient.apis.AbstractApi;
import com.ggemo.cqhttpclient.apis.Api;
import com.ggemo.cqhttpclient.apis.ApiEnum;
import com.ggemo.cqhttpclient.requests.HttpPostRequests;
import com.ggemo.cqhttpclient.vo.request.impl.SetGroupSpecialTitleRequest;
import com.ggemo.cqhttpclient.vo.response.AbstractResponse;
import com.ggemo.cqhttpclient.vo.response.impl.SetGroupSpecialTitleResponse;
import com.ggemo.cqhttpclient.vo.response.responsedata.SetGroupSpecialTitleResponseData;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class SetGroupSpecialTitleApi extends AbstractApi<SetGroupSpecialTitleRequest, AbstractResponse<SetGroupSpecialTitleResponseData>> implements Api<SetGroupSpecialTitleRequest, AbstractResponse<SetGroupSpecialTitleResponseData>> {

    public SetGroupSpecialTitleApi(String baseUrl, Header header, RequestConfig requestConfig) {
        super(baseUrl, ApiEnum.SET_GROUP_SPECIAL_TITLE, header, requestConfig);
    }

    @Override
    public SetGroupSpecialTitleResponse request(HttpPostRequests requests, SetGroupSpecialTitleRequest request) throws IOException {
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
            SetGroupSpecialTitleResponse res = SetGroupSpecialTitleResponse.parse(responseString);
            return res;
        } finally {
            this.httpPostThreadLocal.remove();
        }
    }

    public SetGroupSpecialTitleResponse request(HttpPostRequests requests,int groupId,int userId,String specialTitle,int duration) throws IOException {
        SetGroupSpecialTitleRequest request = new SetGroupSpecialTitleRequest(groupId, userId, specialTitle, duration);
        return request(requests, request);
    }
}

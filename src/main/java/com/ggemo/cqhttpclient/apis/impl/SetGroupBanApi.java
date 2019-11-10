package com.ggemo.cqhttpclient.apis.impl;

import com.ggemo.cqhttpclient.apis.AbstractApi;
import com.ggemo.cqhttpclient.apis.Api;
import com.ggemo.cqhttpclient.apis.ApiEnum;
import com.ggemo.cqhttpclient.requests.HttpPostRequests;
import com.ggemo.cqhttpclient.vo.request.impl.SetGroupBanRequest;
import com.ggemo.cqhttpclient.vo.response.AbstractResponse;
import com.ggemo.cqhttpclient.vo.response.impl.SetGroupBanResponse;
import com.ggemo.cqhttpclient.vo.response.responsedata.SetGroupBanResponseData;
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
public class SetGroupBanApi extends AbstractApi<SetGroupBanRequest, AbstractResponse<SetGroupBanResponseData>> implements Api<SetGroupBanRequest, AbstractResponse<SetGroupBanResponseData>> {

    public SetGroupBanApi(String baseUrl, Header header, RequestConfig requestConfig) {
        super(baseUrl, ApiEnum.SET_GROUP_BAN, header, requestConfig);
    }

    @Override
    public SetGroupBanResponse request(HttpPostRequests requests, SetGroupBanRequest request) throws IOException {
        HttpPost httpPost = this.getHttpPost();
        try {
            UrlEncodedFormEntity entity = request.getEntity();
            if (entity != null) {
                httpPost.setEntity(entity);
            }
            HttpResponse httpResponse = requests.request(httpPost);
            HttpEntity responseEntity = httpResponse.getEntity();
            String responseString = EntityUtils.toString(responseEntity);
            SetGroupBanResponse res = SetGroupBanResponse.parse(responseString);
            return res;
        } finally {
            this.giveBackHttpPost();
        }
    }

    public SetGroupBanResponse request(HttpPostRequests requests,int groupId,int userId,int duration) throws IOException {
        SetGroupBanRequest request = new SetGroupBanRequest(groupId, userId, duration);
        return request(requests, request);
    }
}

package com.ggemo.cqhttpclient.apis.impl;

import com.ggemo.cqhttpclient.apis.AbstractApi;
import com.ggemo.cqhttpclient.apis.Api;
import com.ggemo.cqhttpclient.apis.ApiEnum;
import com.ggemo.cqhttpclient.requests.HttpPostRequests;
import com.ggemo.cqhttpclient.vo.request.impl.SetGroupKickRequest;
import com.ggemo.cqhttpclient.vo.response.AbstractResponse;
import com.ggemo.cqhttpclient.vo.response.impl.SetGroupKickResponse;
import com.ggemo.cqhttpclient.vo.response.responsedata.SetGroupKickResponseData;
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
public class SetGroupKickApi extends AbstractApi<SetGroupKickRequest, AbstractResponse<SetGroupKickResponseData>> implements Api<SetGroupKickRequest, AbstractResponse<SetGroupKickResponseData>> {

    public SetGroupKickApi(String baseUrl, Header header, RequestConfig requestConfig) {
        super(baseUrl, ApiEnum.SET_GROUP_KICK, header, requestConfig);
    }

    @Override
    public SetGroupKickResponse request(HttpPostRequests requests, SetGroupKickRequest request) throws IOException {
        HttpPost httpPost = this.getHttpPost();
        try {
            UrlEncodedFormEntity entity = request.getEntity();
            if (entity != null) {
                httpPost.setEntity(entity);
            }
            HttpResponse httpResponse = requests.request(httpPost);
            HttpEntity responseEntity = httpResponse.getEntity();
            String responseString = EntityUtils.toString(responseEntity);
            SetGroupKickResponse res = SetGroupKickResponse.parse(responseString);
            return res;
        } finally {
            this.giveBackHttpPost();
        }
    }

    public SetGroupKickResponse request(HttpPostRequests requests,int groupId,int userId,boolean rejectAddRequest) throws IOException {
        SetGroupKickRequest request = new SetGroupKickRequest(groupId, userId, rejectAddRequest);
        return request(requests, request);
    }
}

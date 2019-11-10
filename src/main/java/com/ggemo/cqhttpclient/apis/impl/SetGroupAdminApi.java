package com.ggemo.cqhttpclient.apis.impl;

import com.ggemo.cqhttpclient.apis.AbstractApi;
import com.ggemo.cqhttpclient.apis.Api;
import com.ggemo.cqhttpclient.apis.ApiEnum;
import com.ggemo.cqhttpclient.requests.HttpPostRequests;
import com.ggemo.cqhttpclient.vo.request.impl.SetGroupAdminRequest;
import com.ggemo.cqhttpclient.vo.response.AbstractResponse;
import com.ggemo.cqhttpclient.vo.response.impl.SetGroupAdminResponse;
import com.ggemo.cqhttpclient.vo.response.responsedata.SetGroupAdminResponseData;
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
public class SetGroupAdminApi extends AbstractApi<SetGroupAdminRequest, AbstractResponse<SetGroupAdminResponseData>> implements Api<SetGroupAdminRequest, AbstractResponse<SetGroupAdminResponseData>> {

    public SetGroupAdminApi(String baseUrl, Header header, RequestConfig requestConfig) {
        super(baseUrl, ApiEnum.SET_GROUP_ADMIN, header, requestConfig);
    }

    @Override
    public SetGroupAdminResponse request(HttpPostRequests requests, SetGroupAdminRequest request) throws IOException {
        HttpPost httpPost = this.getHttpPost();
        try {
            UrlEncodedFormEntity entity = request.getEntity();
            if (entity != null) {
                httpPost.setEntity(entity);
            }
            HttpResponse httpResponse = requests.request(httpPost);
            HttpEntity responseEntity = httpResponse.getEntity();
            String responseString = EntityUtils.toString(responseEntity);
            SetGroupAdminResponse res = SetGroupAdminResponse.parse(responseString);
            return res;
        } finally {
            this.giveBackHttpPost();
        }
    }

    public SetGroupAdminResponse request(HttpPostRequests requests,int groupId,int userId,boolean enable) throws IOException {
        SetGroupAdminRequest request = new SetGroupAdminRequest(groupId, userId, enable);
        return request(requests, request);
    }
}

package com.ggemo.cqhttpclient.apis.impl;

import com.ggemo.cqhttpclient.apis.AbstractApi;
import com.ggemo.cqhttpclient.apis.Api;
import com.ggemo.cqhttpclient.apis.ApiEnum;
import com.ggemo.cqhttpclient.requests.HttpPostRequests;
import com.ggemo.cqhttpclient.vo.request.impl.SetFriendAddRequestRequest;
import com.ggemo.cqhttpclient.vo.response.AbstractResponse;
import com.ggemo.cqhttpclient.vo.response.impl.SetFriendAddRequestResponse;
import com.ggemo.cqhttpclient.vo.response.responsedata.SetFriendAddRequestResponseData;
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
public class SetFriendAddRequestApi extends AbstractApi<SetFriendAddRequestRequest, AbstractResponse<SetFriendAddRequestResponseData>> implements Api<SetFriendAddRequestRequest, AbstractResponse<SetFriendAddRequestResponseData>> {

    public SetFriendAddRequestApi(String baseUrl, Header header, RequestConfig requestConfig) {
        super(baseUrl, ApiEnum.SET_FRIEND_ADD_REQUEST, header, requestConfig);
    }

    @Override
    public SetFriendAddRequestResponse request(HttpPostRequests requests, SetFriendAddRequestRequest request) throws IOException {
        HttpPost httpPost = this.getHttpPost();
        try {
            UrlEncodedFormEntity entity = request.getEntity();
            if (entity != null) {
                httpPost.setEntity(entity);
            }
            HttpResponse httpResponse = requests.request(httpPost);
            HttpEntity responseEntity = httpResponse.getEntity();
            String responseString = EntityUtils.toString(responseEntity);
            SetFriendAddRequestResponse res = SetFriendAddRequestResponse.parse(responseString);
            return res;
        } finally {
            this.giveBackHttpPost();
        }
    }

    public SetFriendAddRequestResponse request(HttpPostRequests requests,String flag,boolean approve,String remark) throws IOException {
        SetFriendAddRequestRequest request = new SetFriendAddRequestRequest(flag, approve, remark);
        return request(requests, request);
    }
}

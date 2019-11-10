package com.ggemo.cqhttpclient.apis.impl;

import com.ggemo.cqhttpclient.apis.AbstractApi;
import com.ggemo.cqhttpclient.apis.Api;
import com.ggemo.cqhttpclient.apis.ApiEnum;
import com.ggemo.cqhttpclient.requests.HttpPostRequests;
import com.ggemo.cqhttpclient.vo.request.impl.SetGroupAnonymousRequest;
import com.ggemo.cqhttpclient.vo.response.AbstractResponse;
import com.ggemo.cqhttpclient.vo.response.impl.SetGroupAnonymousResponse;
import com.ggemo.cqhttpclient.vo.response.responsedata.SetGroupAnonymousResponseData;
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
public class SetGroupAnonymousApi extends AbstractApi<SetGroupAnonymousRequest, AbstractResponse<SetGroupAnonymousResponseData>> implements Api<SetGroupAnonymousRequest, AbstractResponse<SetGroupAnonymousResponseData>> {

    public SetGroupAnonymousApi(String baseUrl, Header header, RequestConfig requestConfig) {
        super(baseUrl, ApiEnum.SET_GROUP_ANONYMOUS, header, requestConfig);
    }

    @Override
    public SetGroupAnonymousResponse request(HttpPostRequests requests, SetGroupAnonymousRequest request) throws IOException {
        HttpPost httpPost = this.getHttpPost();
        try {
            UrlEncodedFormEntity entity = request.getEntity();
            if (entity != null) {
                httpPost.setEntity(entity);
            }
            HttpResponse httpResponse = requests.request(httpPost);
            HttpEntity responseEntity = httpResponse.getEntity();
            String responseString = EntityUtils.toString(responseEntity);
            SetGroupAnonymousResponse res = SetGroupAnonymousResponse.parse(responseString);
            return res;
        } finally {
            this.giveBackHttpPost();
        }
    }

    public SetGroupAnonymousResponse request(HttpPostRequests requests,int groupId,boolean enable) throws IOException {
        SetGroupAnonymousRequest request = new SetGroupAnonymousRequest(groupId, enable);
        return request(requests, request);
    }
}

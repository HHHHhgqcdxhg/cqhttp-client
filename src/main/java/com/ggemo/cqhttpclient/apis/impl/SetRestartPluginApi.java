package com.ggemo.cqhttpclient.apis.impl;

import com.ggemo.cqhttpclient.apis.AbstractApi;
import com.ggemo.cqhttpclient.apis.Api;
import com.ggemo.cqhttpclient.apis.ApiEnum;
import com.ggemo.cqhttpclient.requests.HttpPostRequests;
import com.ggemo.cqhttpclient.vo.request.impl.SetRestartPluginRequest;
import com.ggemo.cqhttpclient.vo.response.AbstractResponse;
import com.ggemo.cqhttpclient.vo.response.impl.SetRestartPluginResponse;
import com.ggemo.cqhttpclient.vo.response.responsedata.SetRestartPluginResponseData;
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
public class SetRestartPluginApi extends AbstractApi<SetRestartPluginRequest, AbstractResponse<SetRestartPluginResponseData>> implements Api<SetRestartPluginRequest, AbstractResponse<SetRestartPluginResponseData>> {

    public SetRestartPluginApi(String baseUrl, Header header, RequestConfig requestConfig) {
        super(baseUrl, ApiEnum.SET_RESTART_PLUGIN, header, requestConfig);
    }

    @Override
    public SetRestartPluginResponse request(HttpPostRequests requests, SetRestartPluginRequest request) throws IOException {
        HttpPost httpPost = this.getHttpPost();
        try {
            UrlEncodedFormEntity entity = request.getEntity();
            if (entity != null) {
                httpPost.setEntity(entity);
            }
            HttpResponse httpResponse = requests.request(httpPost);
            HttpEntity responseEntity = httpResponse.getEntity();
            String responseString = EntityUtils.toString(responseEntity);
            SetRestartPluginResponse res = SetRestartPluginResponse.parse(responseString);
            return res;
        } finally {
            this.giveBackHttpPost();
        }
    }

    public SetRestartPluginResponse request(HttpPostRequests requests,int delay) throws IOException {
        SetRestartPluginRequest request = new SetRestartPluginRequest(delay);
        return request(requests, request);
    }
}

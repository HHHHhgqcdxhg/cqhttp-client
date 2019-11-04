package com.ggemo.cqhttpclient.apis.impl;

import com.ggemo.cqhttpclient.apis.AbstractApi;
import com.ggemo.cqhttpclient.apis.Api;
import com.ggemo.cqhttpclient.apis.ApiEnum;
import com.ggemo.cqhttpclient.requests.HttpPostRequests;
import com.ggemo.cqhttpclient.vo.request.impl.CleanPluginLogRequest;
import com.ggemo.cqhttpclient.vo.response.AbstractResponse;
import com.ggemo.cqhttpclient.vo.response.impl.CleanPluginLogResponse;
import com.ggemo.cqhttpclient.vo.response.responsedata.CleanPluginLogResponseData;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class CleanPluginLogApi extends AbstractApi<CleanPluginLogRequest, AbstractResponse<CleanPluginLogResponseData>> implements Api<CleanPluginLogRequest, AbstractResponse<CleanPluginLogResponseData>> {

    public CleanPluginLogApi(String baseUrl, Header header, RequestConfig requestConfig) {
        super(baseUrl, ApiEnum.CLEAN_PLUGIN_LOG, header, requestConfig);
    }

    @Override
    public CleanPluginLogResponse request(HttpPostRequests requests, CleanPluginLogRequest request) throws IOException {
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
            CleanPluginLogResponse res = CleanPluginLogResponse.parse(responseString);
            return res;
        } finally {
            this.httpPostThreadLocal.remove();
        }
    }

    public CleanPluginLogResponse request(HttpPostRequests requests) throws IOException {
        CleanPluginLogRequest request = new CleanPluginLogRequest();
        return request(requests, request);
    }
}

package com.ggemo.cqhttpclient.apis.impl;

import com.ggemo.cqhttpclient.apis.AbstractApi;
import com.ggemo.cqhttpclient.apis.Api;
import com.ggemo.cqhttpclient.apis.ApiEnum;
import com.ggemo.cqhttpclient.requests.HttpPostRequests;
import com.ggemo.cqhttpclient.vo.request.impl.CleanDataDirRequest;
import com.ggemo.cqhttpclient.vo.response.AbstractResponse;
import com.ggemo.cqhttpclient.vo.response.impl.CleanDataDirResponse;
import com.ggemo.cqhttpclient.vo.response.responsedata.CleanDataDirResponseData;
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
public class CleanDataDirApi extends AbstractApi<CleanDataDirRequest, AbstractResponse<CleanDataDirResponseData>> implements Api<CleanDataDirRequest, AbstractResponse<CleanDataDirResponseData>> {

    public CleanDataDirApi(String baseUrl, Header header, RequestConfig requestConfig) {
        super(baseUrl, ApiEnum.CLEAN_DATA_DIR, header, requestConfig);
    }

    @Override
    public CleanDataDirResponse request(HttpPostRequests requests, CleanDataDirRequest request) throws IOException {
        HttpPost httpPost = this.getHttpPost();
        try {
            UrlEncodedFormEntity entity = request.getEntity();
            if (entity != null) {
                httpPost.setEntity(entity);
            }
            HttpResponse httpResponse = requests.request(httpPost);
            HttpEntity responseEntity = httpResponse.getEntity();
            String responseString = EntityUtils.toString(responseEntity);
            CleanDataDirResponse res = CleanDataDirResponse.parse(responseString);
            return res;
        } finally {
            this.giveBackHttpPost();
        }
    }

    public CleanDataDirResponse request(HttpPostRequests requests,String dataDir) throws IOException {
        CleanDataDirRequest request = new CleanDataDirRequest(dataDir);
        return request(requests, request);
    }
}

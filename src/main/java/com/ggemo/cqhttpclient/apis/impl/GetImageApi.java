package com.ggemo.cqhttpclient.apis.impl;

import com.ggemo.cqhttpclient.apis.AbstractApi;
import com.ggemo.cqhttpclient.apis.Api;
import com.ggemo.cqhttpclient.apis.ApiEnum;
import com.ggemo.cqhttpclient.requests.HttpPostRequests;
import com.ggemo.cqhttpclient.vo.request.impl.GetImageRequest;
import com.ggemo.cqhttpclient.vo.response.AbstractResponse;
import com.ggemo.cqhttpclient.vo.response.impl.GetImageResponse;
import com.ggemo.cqhttpclient.vo.response.responsedata.GetImageResponseData;
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
public class GetImageApi extends AbstractApi<GetImageRequest, AbstractResponse<GetImageResponseData>> implements Api<GetImageRequest, AbstractResponse<GetImageResponseData>> {

    public GetImageApi(String baseUrl, Header header, RequestConfig requestConfig) {
        super(baseUrl, ApiEnum.GET_IMAGE, header, requestConfig);
    }

    @Override
    public GetImageResponse request(HttpPostRequests requests, GetImageRequest request) throws IOException {
        HttpPost httpPost = this.getHttpPost();
        try {
            UrlEncodedFormEntity entity = request.getEntity();
            if (entity != null) {
                httpPost.setEntity(entity);
            }
            HttpResponse httpResponse = requests.request(httpPost);
            HttpEntity responseEntity = httpResponse.getEntity();
            String responseString = EntityUtils.toString(responseEntity);
            GetImageResponse res = GetImageResponse.parse(responseString);
            return res;
        } finally {
            this.giveBackHttpPost();
        }
    }

    public GetImageResponse request(HttpPostRequests requests,String file) throws IOException {
        GetImageRequest request = new GetImageRequest(file);
        return request(requests, request);
    }
}

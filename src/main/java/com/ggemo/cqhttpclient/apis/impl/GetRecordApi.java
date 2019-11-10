package com.ggemo.cqhttpclient.apis.impl;

import com.ggemo.cqhttpclient.apis.AbstractApi;
import com.ggemo.cqhttpclient.apis.Api;
import com.ggemo.cqhttpclient.apis.ApiEnum;
import com.ggemo.cqhttpclient.requests.HttpPostRequests;
import com.ggemo.cqhttpclient.vo.request.impl.GetRecordRequest;
import com.ggemo.cqhttpclient.vo.response.AbstractResponse;
import com.ggemo.cqhttpclient.vo.response.impl.GetRecordResponse;
import com.ggemo.cqhttpclient.vo.response.responsedata.GetRecordResponseData;
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
public class GetRecordApi extends AbstractApi<GetRecordRequest, AbstractResponse<GetRecordResponseData>> implements Api<GetRecordRequest, AbstractResponse<GetRecordResponseData>> {

    public GetRecordApi(String baseUrl, Header header, RequestConfig requestConfig) {
        super(baseUrl, ApiEnum.GET_RECORD, header, requestConfig);
    }

    @Override
    public GetRecordResponse request(HttpPostRequests requests, GetRecordRequest request) throws IOException {
        HttpPost httpPost = this.getHttpPost();
        try {
            UrlEncodedFormEntity entity = request.getEntity();
            if (entity != null) {
                httpPost.setEntity(entity);
            }
            HttpResponse httpResponse = requests.request(httpPost);
            HttpEntity responseEntity = httpResponse.getEntity();
            String responseString = EntityUtils.toString(responseEntity);
            GetRecordResponse res = GetRecordResponse.parse(responseString);
            return res;
        } finally {
            this.giveBackHttpPost();
        }
    }

    public GetRecordResponse request(HttpPostRequests requests,String file,String outFormat,boolean fullPath) throws IOException {
        GetRecordRequest request = new GetRecordRequest(file, outFormat, fullPath);
        return request(requests, request);
    }
}

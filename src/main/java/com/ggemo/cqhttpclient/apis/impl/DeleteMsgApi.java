package com.ggemo.cqhttpclient.apis.impl;

import com.ggemo.cqhttpclient.apis.AbstractApi;
import com.ggemo.cqhttpclient.apis.Api;
import com.ggemo.cqhttpclient.apis.ApiEnum;
import com.ggemo.cqhttpclient.requests.HttpPostRequests;
import com.ggemo.cqhttpclient.vo.request.impl.DeleteMsgRequest;
import com.ggemo.cqhttpclient.vo.response.AbstractResponse;
import com.ggemo.cqhttpclient.vo.response.impl.DeleteMsgResponse;
import com.ggemo.cqhttpclient.vo.response.responsedata.DeleteMsgResponseData;
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
public class DeleteMsgApi extends AbstractApi<DeleteMsgRequest, AbstractResponse<DeleteMsgResponseData>> implements Api<DeleteMsgRequest, AbstractResponse<DeleteMsgResponseData>> {

    public DeleteMsgApi(String baseUrl, Header header, RequestConfig requestConfig) {
        super(baseUrl, ApiEnum.DELETE_MSG, header, requestConfig);
    }

    @Override
    public DeleteMsgResponse request(HttpPostRequests requests, DeleteMsgRequest request) throws IOException {
        HttpPost httpPost = this.getHttpPost();
        try {
            UrlEncodedFormEntity entity = request.getEntity();
            if (entity != null) {
                httpPost.setEntity(entity);
            }
            HttpResponse httpResponse = requests.request(httpPost);
            HttpEntity responseEntity = httpResponse.getEntity();
            String responseString = EntityUtils.toString(responseEntity);
            DeleteMsgResponse res = DeleteMsgResponse.parse(responseString);
            return res;
        } finally {
            this.giveBackHttpPost();
        }
    }

    public DeleteMsgResponse request(HttpPostRequests requests,int messageId) throws IOException {
        DeleteMsgRequest request = new DeleteMsgRequest(messageId);
        return request(requests, request);
    }
}

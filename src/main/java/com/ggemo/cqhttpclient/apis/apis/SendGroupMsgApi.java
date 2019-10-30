package com.ggemo.cqhttpclient.apis.apis;

import com.ggemo.cqhttpclient.apis.AbstractApi;
import com.ggemo.cqhttpclient.apis.Api;
import com.ggemo.cqhttpclient.apis.ApiEnum;
import com.ggemo.cqhttpclient.requests.HttpPostRequests;
import com.ggemo.cqhttpclient.vo.request.requestData.SendGroupMsgRequest;
import com.ggemo.cqhttpclient.vo.response.Response;
import com.ggemo.cqhttpclient.vo.response.responsedata.SendGroupMsgResponse;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public class SendGroupMsgApi extends AbstractApi<SendGroupMsgRequest, Response<SendGroupMsgResponse>> implements Api<SendGroupMsgRequest, Response<SendGroupMsgResponse>> {

    public SendGroupMsgApi(String baseUrl, Header header, RequestConfig requestConfig) {
        super(baseUrl, ApiEnum.SEND_GROUP_MSG, header, requestConfig);
    }

    @Override
    public Response<SendGroupMsgResponse> request(HttpPostRequests requests, SendGroupMsgRequest request) throws IOException {
        this.httpPostThreadLocal.set(this.httpPost);
        HttpPost httpPost = this.httpPostThreadLocal.get();
        try {
            httpPost.setEntity(request.getEntity());
            HttpResponse httpResponse = requests.request(httpPost);
            InputStream s = httpResponse.getEntity().getContent();
            return null;
        }finally {
            this.httpPostThreadLocal.remove();
        }

    }

    public Response<SendGroupMsgResponse> request(HttpPostRequests requests, int groupId, String msg, boolean autoEscape) throws IOException {
        SendGroupMsgRequest request = new SendGroupMsgRequest(groupId, msg, autoEscape);
        return request(requests, request);
    }
}

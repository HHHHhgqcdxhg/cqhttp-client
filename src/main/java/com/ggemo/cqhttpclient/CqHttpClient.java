package com.ggemo.cqhttpclient;

import com.ggemo.cqhttpclient.apis.apis.SendGroupMsgApi;
import com.ggemo.cqhttpclient.requests.BaseRequests;
import com.ggemo.cqhttpclient.requests.HttpPostRequests;
import com.ggemo.cqhttpclient.vo.request.Request;
import com.ggemo.cqhttpclient.vo.response.Response;
import com.ggemo.cqhttpclient.vo.response.responsedata.SendGroupMsgResponse;
import org.apache.http.Header;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.message.BasicHeader;

import javax.sound.sampled.Port;
import java.io.IOException;

public class CqHttpClient {
    private String host;
    private int port;
    private String accessToken;

    private HttpPostRequests requests;

    private Header accessTokenHeader = null;
    private RequestConfig requestConfig = null;

    private String baseUrl;

    private SendGroupMsgApi sendGroupMsgApi;

    public CqHttpClient(String host, int port) {
        this.host = host;
        this.port = port;
        this.requests = new HttpPostRequests();
        this.baseUrl = String.format("http://%s:%d", host, port);
        initApis();
    }

    public CqHttpClient(String host, int port, String accessToken) {
        this(host,port);
        this.setAccessToken(accessToken);
    }

    public CqHttpClient(String host, int port, RequestConfig requestConfig) {
        this(host, port);

        this.requestConfig = requestConfig;
    }

    public CqHttpClient(String host, int port, String accessToken, RequestConfig requestConfig) {
        this(host, port);

        this.requestConfig = requestConfig;
        this.setAccessToken(accessToken);
    }

    private void setAccessToken(String accessToken){
        this.accessToken = accessToken;
        this.setAccessTokenHeader();
    }

    private void setAccessTokenHeader() {
        if(this.accessToken == null){
            return;
        }
        this.accessTokenHeader = new BasicHeader("Authorization", "Token " + this.accessToken);
    }

    private void initApis(){
        this.sendGroupMsgApi = new SendGroupMsgApi(this.baseUrl, this.accessTokenHeader, this.requestConfig);
    }

    private Response<SendGroupMsgResponse> sendGroupMsg(int groupId, String msg, boolean autoEscape) throws IOException {
        return this.sendGroupMsgApi.request(this.requests, groupId, msg, autoEscape);
    }
}

package com.ggemo.cqhttpclient;

import com.ggemo.cqhttpclient.apis.impl.SendGroupMsgApi;
import com.ggemo.cqhttpclient.requests.HttpPostRequests;
import com.ggemo.cqhttpclient.vo.response.response.SendGroupMsgResponse;
import net.jcip.annotations.ThreadSafe;
import org.apache.http.Header;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.message.BasicHeader;

import java.io.IOException;

@ThreadSafe
public class CqHttpClient {
    private String baseUrl;
    private String accessToken;

    private HttpPostRequests requests;

    private Header accessTokenHeader = null;
    private RequestConfig requestConfig = null;

//    private String baseUrl;

    private SendGroupMsgApi sendGroupMsgApi = null;

    public CqHttpClient(String baseUrl) {
        if(baseUrl.charAt(baseUrl.length() - 1) != '/'){
            baseUrl += "/";
        }
        this.baseUrl = baseUrl;
        this.requests = new HttpPostRequests();
    }

    public CqHttpClient(String baseUrl, String accessToken) {
        this(baseUrl);
        this.setAccessToken(accessToken);
    }

    public CqHttpClient(String baseUrl, RequestConfig requestConfig) {
        this(baseUrl);

        this.requestConfig = requestConfig;
    }

    public CqHttpClient(String baseUrl, String accessToken, RequestConfig requestConfig) {
        this(baseUrl);

        this.requestConfig = requestConfig;
        this.setAccessToken(accessToken);
    }

    private void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
        this.setAccessTokenHeader();
    }

    private void setAccessTokenHeader() {
        if (this.accessToken == null) {
            return;
        }
        this.accessTokenHeader = new BasicHeader("Authorization", "Token " + this.accessToken);
    }

    private SendGroupMsgApi getSendGroupMsgApi(){
        if(this.sendGroupMsgApi == null){
            synchronized (SendGroupMsgApi.class){
                if (this.sendGroupMsgApi == null) {
                    this.sendGroupMsgApi = new SendGroupMsgApi(this.baseUrl, this.accessTokenHeader, this.requestConfig);
                }
            }
        }
        return this.sendGroupMsgApi;
    }

    public SendGroupMsgResponse sendGroupMsg(int groupId, String msg, boolean autoEscape) throws IOException {
        return this.getSendGroupMsgApi().request(this.requests, groupId, msg, autoEscape);
    }

    public SendGroupMsgResponse sendGroupMsg(int groupId, String msg) throws IOException {
        return this.getSendGroupMsgApi().request(this.requests, groupId, msg, false);
    }
}

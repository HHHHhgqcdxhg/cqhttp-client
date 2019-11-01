package com.ggemo.cqhttpclient;

import com.ggemo.cqhttpclient.apis.impl.GetStatusApi;
import com.ggemo.cqhttpclient.apis.impl.SendGroupMsgApi;
import com.ggemo.cqhttpclient.apis.impl.SendPrivateMsgApi;
import com.ggemo.cqhttpclient.requests.HttpPostRequests;
import com.ggemo.cqhttpclient.vo.response.impl.GetStatusResponse;
import com.ggemo.cqhttpclient.vo.response.impl.SendGroupMsgResponse;
import com.ggemo.cqhttpclient.vo.response.impl.SendPrivateMsgResponse;
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

    private SendGroupMsgApi sendGroupMsgApi = null;
    private GetStatusApi getStatusApi = null;

    public CqHttpClient(String baseUrl) {
        if (baseUrl.charAt(baseUrl.length() - 1) != '/') {
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

    private SendGroupMsgApi getSendGroupMsgApi() {
        if (this.sendGroupMsgApi == null) {
            synchronized (SendGroupMsgApi.class) {
                if (this.sendGroupMsgApi == null) {
                    this.sendGroupMsgApi = new SendGroupMsgApi(this.baseUrl, this.accessTokenHeader, this.requestConfig);
                }
            }
        }
        return this.sendGroupMsgApi;
    }

    private GetStatusApi getGetStatusApi() {
        if (this.getStatusApi == null) {
            synchronized (GetStatusApi.class) {
                if (this.getStatusApi == null) {
                    this.getStatusApi = new GetStatusApi(this.baseUrl, this.accessTokenHeader, this.requestConfig);
                }
            }
        }
        return this.getStatusApi;
    }

    /**
     * {baseDescribe}
     * {detailDescribe}
     *
     * @param groupId 啊啊啊这里填注释
     * @param msg
     * @param autoEscape
     * @return SendGroupMsgResponse实例
     * @throws IOException
     */
    public SendGroupMsgResponse sendGroupMsg(int groupId, String msg, boolean autoEscape) throws IOException {
        return this.getSendGroupMsgApi().request(this.requests, groupId, msg, autoEscape);
    }

    public SendGroupMsgResponse sendGroupMsg(int groupId, String msg) throws IOException {
        return this.sendGroupMsg(groupId, msg, false);
    }

    public GetStatusResponse getStatus() throws IOException {
        return this.getGetStatusApi().request(this.requests);
    }

    // ====================SendPrivateMsgApi部分====================
    private SendPrivateMsgApi sendPrivateMsgApi = null;

    // 惰性生成SendPrivateMsg实例
    private SendPrivateMsgApi getSendPrivateMsgApi(){
        if(this.sendPrivateMsgApi == null){
            synchronized (SendPrivateMsgApi.class){
                if (this.sendPrivateMsgApi == null) {
                    this.sendPrivateMsgApi = new SendPrivateMsgApi(this.baseUrl, this.accessTokenHeader, this.requestConfig);
                }
            }
        }
        return this.sendPrivateMsgApi;
    }


    /**
     *  发送私聊消息
     *
     * @param userId 对方 QQ 号
     * @param message 要发送的内容
     * @param autoEscape 消息内容是否作为纯文本发送（即不解析 CQ 码），只在 `message` 字段是字符串时有效

     * @return SendPrivateMsgResponse实例
     * @throws IOException
     */
    public SendPrivateMsgResponse sendPrivateMsg(long userId, String message, boolean autoEscape) throws IOException {
        return this.getSendPrivateMsgApi().request(this.requests, userId, message, autoEscape);
    }

    /**
     *  发送私聊消息
     *
     * @param userId 对方 QQ 号
     * @param message 要发送的内容

     * @return SendPrivateMsgResponse实例
     * @throws IOException
     */
    public SendPrivateMsgResponse sendPrivateMsg(long userId, String message) throws IOException {
        return this.sendPrivateMsg(userId, message, false);
    }

    public static void main(String[] args) {

    }
}

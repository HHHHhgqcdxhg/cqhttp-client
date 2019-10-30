package com.ggemo.cqhttpclient.apis;

import com.ggemo.cqhttpclient.requests.HttpPostRequests;
import com.ggemo.cqhttpclient.vo.request.Request;
import com.ggemo.cqhttpclient.vo.request.requestData.SendGroupMsgRequest;
import com.ggemo.cqhttpclient.vo.response.Response;
import com.ggemo.cqhttpclient.vo.response.responsedata.SendGroupMsgResponse;
import org.apache.http.Header;
import org.apache.http.HttpHeaders;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.regex.Pattern;

public abstract class AbstractApi<Req extends Request, Res extends Response> implements Api<Req, Res>{
    protected HttpPost httpPost;
    protected ThreadLocal<HttpPost> httpPostThreadLocal;

    public AbstractApi(String baseUrl, ApiEnum apiEnum, Header header, RequestConfig requestConfig) {
        this.httpPost = new HttpPost(baseUrl + apiEnum.getRoute());
        if(header != null) {
            this.httpPost.setHeader(header);
        }

        if(requestConfig != null){
            this.httpPost.setConfig(requestConfig);
        }

        httpPostThreadLocal = new ThreadLocal<>();
    }
}

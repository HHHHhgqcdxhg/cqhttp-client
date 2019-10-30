package com.ggemo.cqhttpclient.apis;

import com.ggemo.cqhttpclient.vo.request.Request;
import com.ggemo.cqhttpclient.vo.response.AbstractResponse;
import org.apache.http.Header;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;

public abstract class AbstractApi<Req extends Request, Res extends AbstractResponse> implements Api<Req, Res> {
    protected HttpPost httpPost;
    protected ThreadLocal<HttpPost> httpPostThreadLocal;

    public AbstractApi(String baseUrl, ApiEnum apiEnum, Header header, RequestConfig requestConfig) {
        this.httpPost = new HttpPost(baseUrl + apiEnum.getRoute());
        if (header != null) {
            this.httpPost.setHeader(header);
        }

        if (requestConfig != null) {
            this.httpPost.setConfig(requestConfig);
        }

        httpPostThreadLocal = new ThreadLocal<>();
    }
}

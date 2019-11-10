package com.ggemo.cqhttpclient.apis;

import com.ggemo.cqhttpclient.common.ThreadObjectPool;
import com.ggemo.cqhttpclient.common.utils.HeaderUtil;
import com.ggemo.cqhttpclient.vo.request.Request;
import com.ggemo.cqhttpclient.vo.response.AbstractResponse;
import org.apache.http.Header;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;

public abstract class AbstractApi<Req extends Request, Res extends AbstractResponse> implements Api<Req, Res> {
    private String baseUrl;
    private Header header;

    private ThreadObjectPool<HttpPost> pool;

    private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.102 Safari/537.36";

    public AbstractApi(String baseUrl, ApiEnum apiEnum, Header header, RequestConfig requestConfig) {
        this.baseUrl = baseUrl + apiEnum.getRoute();
        this.header = header;
        this.pool = new ThreadObjectPool<>();
    }

    protected HttpPost getHttpPost(){
        HttpPost httpPost = pool.get();
        if (httpPost == null) {
            httpPost = createHttpPost();
            httpPost = pool.putAngGet(httpPost);
        }
        return httpPost;
    }

    protected void giveBackHttpPost(){
        pool.giveBack();
    }

    public HttpPost createHttpPost(){
        HttpPost httpPost = new HttpPost(baseUrl);
        if (header != null) {
            httpPost.setHeader(header);
        }
        HeaderUtil.setIfNotExist(httpPost, "User-Agent", USER_AGENT);
        return httpPost;
    }
}

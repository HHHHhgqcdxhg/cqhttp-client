package com.ggemo.cqhttpclient.requests;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;

import java.io.IOException;

public abstract class BaseRequests {
    HttpClient httpClient;

    ThreadLocal<HttpClient> httpClientThreadLocal = new ThreadLocal<>();

    public BaseRequests() {
        this.httpClient = HttpClients.createDefault();
    }

    /**
     * 发起请求
     *
     * @param httpPost
     * @return
     * @throws IOException
     */
    public abstract HttpResponse request(HttpPost httpPost) throws IOException;
}

package com.ggemo.cqhttpclient.requests;

import com.ggemo.cqhttpclient.utils.EntityUtil;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;

import java.io.IOException;
import java.util.Map;

public abstract class BaseRequests {
    HttpClient httpClient;

    Header accessTokenHeader;

    RequestConfig requestConfig = null;

    ThreadLocal<HttpClient> httpClientThreadLocal = new ThreadLocal<>();

    public BaseRequests(String accessToken) {
        this.accessTokenHeader = new BasicHeader("Authorization", "Token " + accessToken);
        this.httpClient = HttpClients.createDefault();
    }

    public BaseRequests() {
        this.accessTokenHeader = null;
        this.httpClient = HttpClients.createDefault();
    }

    public void setRequestConfig(RequestConfig requestConfig) {
        this.requestConfig = requestConfig;
    }

    /**
     * 发起请求
     *
     * @param url
     * @param entity
     * @return
     * @throws IOException
     */
    public abstract HttpResponse request(String url, UrlEncodedFormEntity entity) throws IOException;

    public HttpResponse request(String url, Map<String, String> data) throws IOException {
        UrlEncodedFormEntity entity = EntityUtil.fromMap(data);
        return request(url, entity);
    }
}

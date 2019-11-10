package com.ggemo.cqhttpclient.requests;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

import java.io.IOException;

public class HttpPostRequests{
    private CloseableHttpClient httpClient;
    private static HttpPostRequests INSTANCE;
    private static RequestConfig requestConfig = null;

    public static void setRequestConfig(RequestConfig requestConfig){
        HttpPostRequests.requestConfig = requestConfig;
    }

    private HttpPostRequests() {
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        cm.setMaxTotal(100);
        HttpClientBuilder clientbuilder =
                HttpClients.custom().setConnectionManager(cm);
        if(HttpPostRequests.requestConfig != null){
            clientbuilder.setDefaultRequestConfig(requestConfig);
        }
        this.httpClient = clientbuilder.build();
    }

    public static HttpPostRequests getInstance() {
        if (INSTANCE == null) {
            synchronized (HttpPostRequests.class) {
                if (INSTANCE == null) {
                    INSTANCE = new HttpPostRequests();
                }
            }
        }
        return INSTANCE;
    }

    public CloseableHttpResponse request(HttpPost httpPost) throws IOException {

        return httpClient.execute(httpPost);
    }

    public CloseableHttpResponse request(HttpGet httpGet) throws IOException {
        return httpClient.execute(httpGet);
    }
}

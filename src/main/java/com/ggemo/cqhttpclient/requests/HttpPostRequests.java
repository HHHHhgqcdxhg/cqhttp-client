package com.ggemo.cqhttpclient.requests;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;

import java.io.IOException;

public class HttpPostRequests extends BaseRequests {

    public HttpPostRequests() {
        super();
    }

    @Override
    public HttpResponse request(HttpPost httpPost) throws IOException {
        this.httpClientThreadLocal.set(this.httpClient);
        HttpClient httpClient = this.httpClientThreadLocal.get();
        try {
            HttpResponse response = httpClient.execute(httpPost);
            return response;
        } finally {
            this.httpClientThreadLocal.remove();
        }
    }
}

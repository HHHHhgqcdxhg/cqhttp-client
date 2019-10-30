package com.ggemo.cqhttpclient.requests;

import com.ggemo.cqhttpclient.utils.EntityUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class HttpPostRequests extends BaseRequests {

    public HttpPostRequests(String accessToken) {
        super(accessToken);
    }

    public HttpPostRequests() {
        super();
    }

    @Override
    public HttpResponse request(String url, UrlEncodedFormEntity entity) throws IOException {
        this.httpClientThreadLocal.set(this.httpClient);
        HttpClient httpClient = this.httpClientThreadLocal.get();

        try {
            HttpPost httpPost = new HttpPost(url);

            if(this.requestConfig != null){
                httpPost.setConfig(this.requestConfig);
            }

            httpPost.setEntity(entity);

            if (this.accessTokenHeader != null) {
                httpPost.addHeader(this.accessTokenHeader);
            }

            HttpResponse response = httpClient.execute(httpPost);
            return response;
        }finally {
            this.httpClientThreadLocal.remove();
        }
    }
}

package com.ggemo.cqhttpclient.apis;

import com.ggemo.cqhttpclient.requests.HttpPostRequests;
import com.ggemo.cqhttpclient.vo.request.Request;
import com.ggemo.cqhttpclient.vo.response.Response;
import org.apache.http.client.HttpClient;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * @author 清纯的小黄瓜
 */
public interface Api<Req extends Request, Res extends Response> {
    /**
     * 通过Request对象请求api
     * @param request
     * @return
     */
    Res request(HttpPostRequests requests, Req request) throws IOException;
}

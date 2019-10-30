package com.ggemo.cqhttpclient.apis;

import com.ggemo.cqhttpclient.vo.request.Request;
import com.ggemo.cqhttpclient.vo.response.Response;

/**
 * @author 清纯的小黄瓜
 */
public interface Api<Req extends Request, Res extends Response> {
    /**
     * 通过Request对象请求api
     * @param request
     * @return
     */
    public Res request(Req request);

    /**
     * 通过各个参数请求api
     * @param objects
     * @return
     */
    public Res request(Object... objects);
}

package com.ggemo.cqhttpclient.vo.request.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import com.ggemo.cqhttpclient.vo.request.Request;
import org.apache.http.message.BasicNameValuePair;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 清纯的小黄瓜
 */
@Data
@AllArgsConstructor
public class GetStrangerInfoRequest implements Request {
    
    private static String USER_ID = "user_id";
    int userId;

    private static String NO_CACHE = "no_cache";
    boolean noCache;

    
    @Override
    public UrlEncodedFormEntity getEntity() throws UnsupportedEncodingException {
        List<NameValuePair> kvs = new ArrayList<>(2);
        kvs.add(new BasicNameValuePair(USER_ID, Integer.toString(userId)));
        kvs.add(new BasicNameValuePair(NO_CACHE, Boolean.toString(noCache)));
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(kvs, "utf-8");
        return entity;
    }
}

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
public class SendDiscussMsgRequest implements Request {
    
    private static String DISCUSS_ID = "discuss_id";
    int discussId;

    private static String MESSAGE = "message";
    String message;

    private static String AUTO_ESCAPE = "auto_escape";
    boolean autoEscape;

    
    @Override
    public UrlEncodedFormEntity getEntity() throws UnsupportedEncodingException {
        List<NameValuePair> kvs = new ArrayList<>(3);
        kvs.add(new BasicNameValuePair(DISCUSS_ID, Integer.toString(discussId)));
        kvs.add(new BasicNameValuePair(MESSAGE, message));
        kvs.add(new BasicNameValuePair(AUTO_ESCAPE, Boolean.toString(autoEscape)));
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(kvs, "utf-8");
        return entity;
    }
}

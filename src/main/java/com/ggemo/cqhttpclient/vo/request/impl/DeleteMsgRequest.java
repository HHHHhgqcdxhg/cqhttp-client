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
public class DeleteMsgRequest implements Request {
    
    private static String MESSAGE_ID = "message_id";
    int messageId;

    
    @Override
    public UrlEncodedFormEntity getEntity() throws UnsupportedEncodingException {
        List<NameValuePair> kvs = new ArrayList<>(1);
        kvs.add(new BasicNameValuePair(MESSAGE_ID, Integer.toString(messageId)));
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(kvs, "utf-8");
        return entity;
    }
}

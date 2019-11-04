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
public class SetGroupCardRequest implements Request {
    
    private static String GROUP_ID = "group_id";
    int groupId;

    private static String USER_ID = "user_id";
    int userId;

    private static String CARD = "card";
    String card;

    
    @Override
    public UrlEncodedFormEntity getEntity() throws UnsupportedEncodingException {
        List<NameValuePair> kvs = new ArrayList<>(3);
        kvs.add(new BasicNameValuePair(GROUP_ID, Integer.toString(groupId)));
        kvs.add(new BasicNameValuePair(USER_ID, Integer.toString(userId)));
        kvs.add(new BasicNameValuePair(CARD, card));
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(kvs, "utf-8");
        return entity;
    }
}

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
public class SetGroupSpecialTitleRequest implements Request {
    
    private static String GROUP_ID = "group_id";
    int groupId;

    private static String USER_ID = "user_id";
    int userId;

    private static String SPECIAL_TITLE = "special_title";
    String specialTitle;

    private static String DURATION = "duration";
    int duration;

    
    @Override
    public UrlEncodedFormEntity getEntity() throws UnsupportedEncodingException {
        List<NameValuePair> kvs = new ArrayList<>(4);
        kvs.add(new BasicNameValuePair(GROUP_ID, Integer.toString(groupId)));
        kvs.add(new BasicNameValuePair(USER_ID, Integer.toString(userId)));
        kvs.add(new BasicNameValuePair(SPECIAL_TITLE, specialTitle));
        kvs.add(new BasicNameValuePair(DURATION, Integer.toString(duration)));
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(kvs, "utf-8");
        return entity;
    }
}

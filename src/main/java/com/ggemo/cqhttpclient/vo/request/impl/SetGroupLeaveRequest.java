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
public class SetGroupLeaveRequest implements Request {
    
    private static String GROUP_ID = "group_id";
    int groupId;

    private static String IS_DISMISS = "is_dismiss";
    boolean isDismiss;

    
    @Override
    public UrlEncodedFormEntity getEntity() throws UnsupportedEncodingException {
        List<NameValuePair> kvs = new ArrayList<>(2);
        kvs.add(new BasicNameValuePair(GROUP_ID, Integer.toString(groupId)));
        kvs.add(new BasicNameValuePair(IS_DISMISS, Boolean.toString(isDismiss)));
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(kvs, "utf-8");
        return entity;
    }
}

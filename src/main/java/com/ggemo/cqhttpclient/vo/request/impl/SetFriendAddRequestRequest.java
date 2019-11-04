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
public class SetFriendAddRequestRequest implements Request {
    
    private static String FLAG = "flag";
    String flag;

    private static String APPROVE = "approve";
    boolean approve;

    private static String REMARK = "remark";
    String remark;

    
    @Override
    public UrlEncodedFormEntity getEntity() throws UnsupportedEncodingException {
        List<NameValuePair> kvs = new ArrayList<>(3);
        kvs.add(new BasicNameValuePair(FLAG, flag));
        kvs.add(new BasicNameValuePair(APPROVE, Boolean.toString(approve)));
        kvs.add(new BasicNameValuePair(REMARK, remark));
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(kvs, "utf-8");
        return entity;
    }
}

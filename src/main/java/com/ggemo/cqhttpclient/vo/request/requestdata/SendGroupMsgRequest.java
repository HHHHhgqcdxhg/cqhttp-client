package com.ggemo.cqhttpclient.vo.request.requestdata;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import com.ggemo.cqhttpclient.vo.request.Request;
import org.apache.http.message.BasicNameValuePair;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class SendGroupMsgRequest implements Request {
    private final static String GROUP_ID = "group_id";
    private final static String MESSAGE = "message";
    private final static String AUTO_ESCAPE = "auto_escape";

    int groupId;
    String message;
    boolean autoEscape;

    @Override
    public UrlEncodedFormEntity getEntity() throws UnsupportedEncodingException {
        List<NameValuePair> kvs = new ArrayList<>(3);
        kvs.add(new BasicNameValuePair(GROUP_ID, Integer.toString(groupId)));
        kvs.add(new BasicNameValuePair(MESSAGE, message));
        kvs.add(new BasicNameValuePair(AUTO_ESCAPE, Boolean.toString(autoEscape)));
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(kvs, "utf-8");
        return entity;
    }
}

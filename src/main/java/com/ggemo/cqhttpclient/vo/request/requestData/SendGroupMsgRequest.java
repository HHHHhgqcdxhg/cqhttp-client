package com.ggemo.cqhttpclient.vo.request.requestData;

import com.ggemo.cqhttpclient.apis.ApiEnum;
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
    int groupId;
    String message;
    boolean autoEscape;

    @Override
    public UrlEncodedFormEntity getEntity() throws UnsupportedEncodingException {
        List<NameValuePair> kvs = new ArrayList<>(3);
        kvs.add(new BasicNameValuePair("group_id", Integer.toString(groupId)));
        kvs.add(new BasicNameValuePair("message", message));
        kvs.add(new BasicNameValuePair("auto_escape", Boolean.toString(autoEscape)));
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(kvs, "utf-8");
        return entity;
    }
}

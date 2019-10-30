package com.ggemo.cqhttpclient.utils;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EntityUtil {
    public static UrlEncodedFormEntity fromMap(Map<String, String> map) throws UnsupportedEncodingException {
        List<NameValuePair> kvs = new ArrayList<>(map.size());
        for (String k : map.keySet()) {
            kvs.add(new BasicNameValuePair(k, map.get(k)));
        }
        UrlEncodedFormEntity entity1 = null;
        entity1 = new UrlEncodedFormEntity(kvs, "utf-8");
        return entity1;
    }
}

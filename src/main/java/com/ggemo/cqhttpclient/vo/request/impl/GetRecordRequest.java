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
public class GetRecordRequest implements Request {
    
    private static String FILE = "file";
    String file;

    private static String OUT_FORMAT = "out_format";
    String outFormat;

    private static String FULL_PATH = "full_path";
    boolean fullPath;

    
    @Override
    public UrlEncodedFormEntity getEntity() throws UnsupportedEncodingException {
        List<NameValuePair> kvs = new ArrayList<>(3);
        kvs.add(new BasicNameValuePair(FILE, file));
        kvs.add(new BasicNameValuePair(OUT_FORMAT, outFormat));
        kvs.add(new BasicNameValuePair(FULL_PATH, Boolean.toString(fullPath)));
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(kvs, "utf-8");
        return entity;
    }
}

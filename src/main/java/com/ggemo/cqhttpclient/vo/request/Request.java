package com.ggemo.cqhttpclient.vo.request;

import org.apache.http.client.entity.UrlEncodedFormEntity;

import java.io.UnsupportedEncodingException;

/**
 * @author 清纯的小黄瓜
 */
public interface Request {
    /**
     * 返回Request实例对应的Entity
     *
     * @return
     */
    public UrlEncodedFormEntity getEntity() throws UnsupportedEncodingException;
}

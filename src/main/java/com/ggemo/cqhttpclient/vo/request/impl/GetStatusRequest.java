package com.ggemo.cqhttpclient.vo.request.impl;

import com.ggemo.cqhttpclient.vo.request.Request;
import org.apache.http.client.entity.UrlEncodedFormEntity;

public class GetStatusRequest implements Request {
    @Override
    public UrlEncodedFormEntity getEntity() {
        return null;
    }
}

package com.ggemo.cqhttpclient.exceptions;

import com.ggemo.cqhttpclient.vo.response.RetCode;

public class CqHttpServerException extends CqHttpException {
    public CqHttpServerException(RetCode retCode) {
        super(retCode);
    }
}

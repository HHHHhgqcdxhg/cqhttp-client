package com.ggemo.cqhttpclient.exceptions;

import com.ggemo.cqhttpclient.vo.response.RetCode;

public class CqException extends CqHttpException {
    public CqException(RetCode retCode) {
        super(retCode);
    }
}

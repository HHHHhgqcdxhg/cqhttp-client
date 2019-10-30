package com.ggemo.cqhttpclient.exceptions;

import com.ggemo.cqhttpclient.vo.response.RetCode;

public abstract class CqHttpException extends Exception{
    CqHttpException(RetCode retCode) {
        super(retCode.getDescription());
    }

    private CqHttpException() {
    }

    private CqHttpException(String message) {
        super(message);
    }

    private CqHttpException(String message, Throwable cause) {
        super(message, cause);
    }

    private CqHttpException(Throwable cause) {
        super(cause);
    }
}

package com.ggemo.cqhttpclient.exceptions;

import com.ggemo.cqhttpclient.vo.response.RetCode;

/**
 * 本框架的Exception
 * @author 清纯的小黄瓜
 */
public abstract class BaseCqHttpException extends Exception{
    BaseCqHttpException(RetCode retCode) {
        super(retCode.getDescription());
    }

    private BaseCqHttpException() {
    }

    private BaseCqHttpException(String message) {
        super(message);
    }

    private BaseCqHttpException(String message, Throwable cause) {
        super(message, cause);
    }

    private BaseCqHttpException(Throwable cause) {
        super(cause);
    }
}

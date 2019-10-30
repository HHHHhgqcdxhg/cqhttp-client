package com.ggemo.cqhttpclient.exceptions;

import com.ggemo.cqhttpclient.vo.response.RetCode;

/**
 * 这里的是酷q异常, 错误码为负数
 */
public class CqException extends BaseCqHttpException {
    public CqException(RetCode retCode) {
        super(retCode);
    }
}

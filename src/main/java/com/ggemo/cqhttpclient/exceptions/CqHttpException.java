package com.ggemo.cqhttpclient.exceptions;

import com.ggemo.cqhttpclient.vo.response.RetCode;

/**
 * 这里的是cqhttp异常, 错误码为正数
 * @author 清纯的小黄瓜
 */
public class CqHttpException extends BaseCqHttpException {
    public CqHttpException(RetCode retCode) {
        super(retCode);
    }
}

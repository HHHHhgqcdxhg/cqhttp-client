package com.ggemo.cqhttpclient.vo.response;

import com.ggemo.cqhttpclient.exceptions.CqHttpException;

public class Response<T extends  ResponseData> {
    private RetCode retCode;
    private Status status;
    private T resData;

    public Response(RetCode retCode, T resData) {
        this.retCode = retCode;
        this.status = Status.getStatus(retCode);
        this.resData = resData;
    }

    public T getResData() throws CqHttpException {
        if(this.retCode == RetCode.RET_CODE_0){
            return resData;
        }else if(this.retCode == RetCode.RET_CODE_1){
            return resData;
        }
        else{
            throw retCode.getException();
        }
    }

}

package com.ggemo.cqhttpclient.vo.response;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Status {
    /**
     * OK
     */
    OK("ok"),

    ASYNC("async"),

    FAILED("failed");

    String status;

    public static Status getStatus(RetCode retCode) {
        if(retCode.getRetCode() == 0){
            return OK;
        }else if(retCode.getRetCode() == 1){
            return ASYNC;
        }else{
            return FAILED;
        }
    }
}

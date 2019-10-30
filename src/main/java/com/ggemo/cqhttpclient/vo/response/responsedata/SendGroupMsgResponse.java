package com.ggemo.cqhttpclient.vo.response.responsedata;

import lombok.Getter;
import lombok.ToString;
import com.ggemo.cqhttpclient.vo.response.ResponseData;

@Getter
@ToString
public class SendGroupMsgResponse implements ResponseData {
    private int groupId;
    private String message;
    private boolean autoEscape;

    public SendGroupMsgResponse(int groupId, String message, boolean autoEscape) {
        this.groupId = groupId;
        this.message = message;
        this.autoEscape = autoEscape;
    }
}

package com.ggemo.cqhttpclient.vo.response.responsedata;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import com.ggemo.cqhttpclient.vo.response.ResponseData;

@ToString
@Getter
@Setter
@AllArgsConstructor
public class SendGroupMsgResponseData implements ResponseData {
    private int messageId;
}

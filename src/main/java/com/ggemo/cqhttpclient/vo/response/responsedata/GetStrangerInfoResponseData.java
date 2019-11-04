package com.ggemo.cqhttpclient.vo.response.responsedata;

import com.ggemo.cqhttpclient.vo.response.ResponseData;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetStrangerInfoResponseData implements ResponseData {
        long userId;
    String nickname;
    String sex;
    int age;

}

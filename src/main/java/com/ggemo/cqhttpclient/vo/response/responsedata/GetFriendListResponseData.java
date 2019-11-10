package com.ggemo.cqhttpclient.vo.response.responsedata;

import com.ggemo.cqhttpclient.vo.response.ResponseData;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author 清纯的小黄瓜
 */
@Data
@AllArgsConstructor
public class GetFriendListResponseData implements ResponseData {
        long userId;
    String nickname;
    String remark;

}

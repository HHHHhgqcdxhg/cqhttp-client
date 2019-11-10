package com.ggemo.cqhttpclient.vo.response.responsedata;

import com.ggemo.cqhttpclient.vo.response.ResponseData;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author 清纯的小黄瓜
 */
@Data
@AllArgsConstructor
public class GetGroupMemberInfoResponseData implements ResponseData {
        long groupId;
    long userId;
    String nickname;
    String card;
    String sex;
    int age;
    String area;
    int joinTime;
    int lastSentTime;
    String level;
    String role;
    boolean unfriendly;
    String title;
    int titleExpireTime;
    boolean cardChangeable;

}

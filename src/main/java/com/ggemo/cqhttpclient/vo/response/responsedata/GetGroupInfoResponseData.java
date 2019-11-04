package com.ggemo.cqhttpclient.vo.response.responsedata;

import com.ggemo.cqhttpclient.vo.response.ResponseData;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetGroupInfoResponseData implements ResponseData {
        long groupId;
    String groupName;
    int memberCount;
    int maxMemberCount;

}

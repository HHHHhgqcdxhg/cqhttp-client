package com.ggemo.cqhttpclient.vo.response.responsedata;

import com.ggemo.cqhttpclient.vo.response.ResponseData;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetGroupListResponseData implements ResponseData {
        long groupId;
    String groupName;

}

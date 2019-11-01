package com.ggemo.cqhttpclient.apis;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author 清纯的小黄瓜
 */

@Getter
@AllArgsConstructor
public enum ApiEnum {
    /**
     * 发送群消息
     */
    SEND_GROUP_MSG("send_group_msg", "发送群消息",""),
    GET_STATUS("get_status","get_status",""),
    SEND_PRIVATE_MSG("send_private_msg", " 发送私聊消息", "");

    private String route;
    private String description;
    private String describeDetail;
}

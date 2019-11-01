package com.ggemo.cqhttpclient.apis;

import org.apache.http.client.methods.HttpPost;

public enum ApiEnum {
    /**
     * 发送群消息
     */
    SEND_GROUP_MSG("send_group_msg", "发送群消息"),
    GET_STATUS("get_status","get_status");

    private String route;
    private String description;

    ApiEnum(String route, String description) {
        this.route = route;
        this.description = description;
    }

    public String getRoute() {
        return route;
    }

    public String getDescription() {
        return description;
    }
}

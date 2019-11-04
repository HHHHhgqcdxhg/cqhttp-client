package com.ggemo.cqhttpclient.vo.response.responsedata;

import com.ggemo.cqhttpclient.vo.response.ResponseData;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetVersionInfoResponseData implements ResponseData {
        String coolqDirectory;
    String coolqEdition;
    String pluginVersion;
    int pluginBuildNumber;
    String pluginBuildConfiguration;

}

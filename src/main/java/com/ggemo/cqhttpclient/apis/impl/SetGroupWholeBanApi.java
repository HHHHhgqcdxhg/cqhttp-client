package com.ggemo.cqhttpclient.apis.impl;

import com.ggemo.cqhttpclient.apis.AbstractApi;
import com.ggemo.cqhttpclient.apis.Api;
import com.ggemo.cqhttpclient.apis.ApiEnum;
import com.ggemo.cqhttpclient.requests.HttpPostRequests;
import com.ggemo.cqhttpclient.vo.request.impl.SetGroupWholeBanRequest;
import com.ggemo.cqhttpclient.vo.response.AbstractResponse;
import com.ggemo.cqhttpclient.vo.response.impl.SetGroupWholeBanResponse;
import com.ggemo.cqhttpclient.vo.response.responsedata.SetGroupWholeBanResponseData;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @author 清纯的小黄瓜
 */
public class SetGroupWholeBanApi extends AbstractApi<SetGroupWholeBanRequest, AbstractResponse<SetGroupWholeBanResponseData>> implements Api<SetGroupWholeBanRequest, AbstractResponse<SetGroupWholeBanResponseData>> {

    public SetGroupWholeBanApi(String baseUrl, Header header, RequestConfig requestConfig) {
        super(baseUrl, ApiEnum.SET_GROUP_WHOLE_BAN, header, requestConfig);
    }

    @Override
    public SetGroupWholeBanResponse request(HttpPostRequests requests, SetGroupWholeBanRequest request) throws IOException {
        HttpPost httpPost = this.getHttpPost();
        try {
            UrlEncodedFormEntity entity = request.getEntity();
            if (entity != null) {
                httpPost.setEntity(entity);
            }
            HttpResponse httpResponse = requests.request(httpPost);
            HttpEntity responseEntity = httpResponse.getEntity();
            String responseString = EntityUtils.toString(responseEntity);
            SetGroupWholeBanResponse res = SetGroupWholeBanResponse.parse(responseString);
            return res;
        } finally {
            this.giveBackHttpPost();
        }
    }

    public SetGroupWholeBanResponse request(HttpPostRequests requests,int groupId,boolean enable) throws IOException {
        SetGroupWholeBanRequest request = new SetGroupWholeBanRequest(groupId, enable);
        return request(requests, request);
    }
}

package com.ggemo.cqhttpclient.vo.response;

import com.ggemo.cqhttpclient.exceptions.BaseCqHttpException;
import com.ggemo.cqhttpclient.exceptions.CqException;
import com.ggemo.cqhttpclient.exceptions.CqHttpException;
import lombok.Getter;

@Getter
public enum RetCode {
    /**
     * 返回的状态码
     */
    RET_CODE_0(0, "操作成功"),
    RET_CODE_1(1, "操作已进入异步执行"),
    RET_CODE_100(100, "参数缺失或参数无效"),
    RET_CODE_102(102, ""),
    RET_CODE_103(103, "酷 Q 函数返回的数据无效"),
    RET_CODE_104(104, "操作失败"),
    RET_CODE_201(201, "由于酷 Q 提供的凭证（Cookie 和 CSRF Token）失效导致请求 QQ 相关接口失败"),

    RET_CODE_cq_5(-5, "日志功能未启用"),
    RET_CODE_cq_6(-6, "日志优先级错误"),
    RET_CODE_cq_7(-7, "数据入库失败"),

    RET_CODE_cq_997(-997, "应用未启用"),
    RET_CODE_cq_998(-998, "应用调用在 auth 声明之外的 Api"),
    RET_CODE_cq_1000(-1000, "发生未知错误");


    int retCode;
    String description;
    BaseCqHttpException exception;

    RetCode(int retCode, String description) {
        this.retCode = retCode;
        this.description = description;
        if (retCode > 0) {
            this.description += " 详见https://github.com/richardchien/coolq-http-api/blob/master/docs/4.9/API.md#响应说明";
            this.exception = new CqHttpException(this);
        } else if (retCode < 0) {
            this.description += "详见https://docs.cqp.im/dev/v9/errorcode/";
            this.exception = new CqException(this);
        }
    }

    public static RetCode getFromRetCode(int r) {
        switch (r) {
            case 0:
                return RET_CODE_0;
            case 1:
                return RET_CODE_1;
            case 100:
                return RET_CODE_100;
            case 102:
                return RET_CODE_102;
            case 103:
                return RET_CODE_103;
            case 104:
                return RET_CODE_104;
            case 201:
                return RET_CODE_201;
            case -5:
                return RET_CODE_cq_5;
            case -6:
                return RET_CODE_cq_6;
            case -7:
                return RET_CODE_cq_7;
            case -997:
                return RET_CODE_cq_997;
            case -998:
                return RET_CODE_cq_998;
            case -1000:
                return RET_CODE_cq_1000;
            default:
                return RET_CODE_cq_1000;
        }
    }
}

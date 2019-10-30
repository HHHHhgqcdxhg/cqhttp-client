package com.ggemo.cqhttpclient.vo.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.ggemo.cqhttpclient.exceptions.BaseCqHttpException;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public abstract class AbstractResponse<T extends  ResponseData> {
    private RetCode retCode;

    private Status status;

    public T data;

    public AbstractResponse(RetCode retCode, T data) {
        this.retCode = retCode;
        this.status = Status.getStatus(this.retCode);
        this.data = data;
    }

    public T getData() throws BaseCqHttpException {
        if(this.retCode == RetCode.RET_CODE_0){
            return data;
        }else if(this.retCode == RetCode.RET_CODE_1){
            return data;
        }
        else{
            throw retCode.getException();
        }
    }

    @JSONField(name = "retcode")
    public  void setRetCode(int r){
        this.retCode = RetCode.getFromRetCode(r);
        this.status = Status.getStatus(this.retCode);
    }

    @Override
    public String toString() {
        return "AbstractResponse{" +
                "retCode=" + retCode +
                ", status=" + status +
                ", data=" + data +
                '}';
    }

    public static <D extends ResponseData> AbstractResponse<D> parse(String json){
        throw new UnsupportedOperationException();
    };
}

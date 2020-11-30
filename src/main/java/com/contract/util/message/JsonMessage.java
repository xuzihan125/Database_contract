package com.contract.util.message;

import java.io.Serializable;


public class JsonMessage<T> implements Serializable {
    private static final long serialVersionUID = 3863559687276427577L;
    public String resMsg;
    //返回给调用者的错误码（如：100001）
    private String resCode;
    //数据
    private T data;

    public JsonMessage() {

    }

    public JsonMessage(T obj, String code, String name) {
        this.data = obj;
        this.resCode = code;
        this.resMsg = name;
    }
}
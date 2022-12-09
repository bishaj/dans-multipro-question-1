package com.dans.multi.pro.test.model.base;

public class Response {
    public static SingleBaseResponse<Object> SuccessSingleBaseResponse(Object value) {
        SingleBaseResponse<Object> resp = new SingleBaseResponse<>();
        resp.setValue(value);
        resp.setCode(200);
        return resp;
    }

}

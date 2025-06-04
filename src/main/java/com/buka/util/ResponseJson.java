package com.buka.util;

import com.buka.http.HttpCode;


public class ResponseJson {
    private int code;
    private String msg;
    private Object data;

    public ResponseJson() {
    }

    public ResponseJson(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    public ResponseJson(HttpCode httpCode, Object data){
        this.code=httpCode.getCode();
        this.msg=httpCode.getMsg();
        this.data=data;
    }
    
    public static ResponseJson getOK(String msg) {
        return new ResponseJson(HttpCode.SUCCESS.getCode(),msg, null);
    }
    public static ResponseJson getOK() {
        return new ResponseJson(HttpCode.SUCCESS, null);
    }

    public static ResponseJson getOK(Object data) {
        return new ResponseJson(HttpCode.SUCCESS, data);
    }

    public static ResponseJson getError(String msg) {
        return new ResponseJson(HttpCode.ERROR.getCode(), msg, null);
    }

    public static ResponseJson getError() {
        return new ResponseJson(HttpCode.ERROR, null);
    }

    public static ResponseJson getError(Object data) {
        return new ResponseJson(HttpCode.ERROR, data);
    }
    public static ResponseJson getResponseJson(HttpCode code, String message) {
        return new ResponseJson(HttpCode.ERROR.getCode(),message, null);
    }

    public static ResponseJson getInstance(HttpCode httpCode, Object data) {

        return new ResponseJson(httpCode.getCode(),httpCode.getMsg(),data);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

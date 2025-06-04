package com.buka.http;

public enum HttpCode {
    SUCCESS(200,"成功"),
    ERROR(-1,"错误"),
    NOTLOGIN(501,"未登录"),
    USERNAMEEXIST(502,"用户名重复"),
    SYSTEMERROR(500,"系统错误");
    private int code;
    private String msg;
    HttpCode(int code, String msg){
        this.code=code;
        this.msg=msg;
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
}

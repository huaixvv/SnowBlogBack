package com.zx.dsblog.result;

import lombok.Data;

public class CodeMsg {

    private int code;
    private String msg;

    //通用错误吗
    public static CodeMsg SUCCESS = new CodeMsg(200200, "success");
    public static CodeMsg FAILED =  new CodeMsg(500500, "failed");



    private CodeMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public CodeMsg fillArgs(Object... args){
        int code = this.code;
        String message = String.format(this.msg, args);
        return new CodeMsg(code, message);
    }


    public int getCode() {
        return code;
    }


    public String getMsg() {
        return msg;
    }
}

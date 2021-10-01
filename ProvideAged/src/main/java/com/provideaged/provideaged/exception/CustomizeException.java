package com.provideaged.provideaged.exception;

import com.provideaged.provideaged.enums.ReturnCode;

/**
 * @ClassName: CustomizeException
 * @Description: 自定义异常
 * @author: 巫运辰
 * @date: 2021/08/27 18:09
 */
public class CustomizeException extends Exception{
    private int code;
    private String msg;
    public CustomizeException(int code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public CustomizeException(ReturnCode returnCode) {
        super(returnCode.getMessage());
        this.code = returnCode.getCode();
        this.msg = returnCode.getMessage();
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
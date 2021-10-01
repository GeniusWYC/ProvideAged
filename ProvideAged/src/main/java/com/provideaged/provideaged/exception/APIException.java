package com.provideaged.provideaged.exception;

import com.provideaged.provideaged.enums.ReturnCode;

/**
 * @ClassName: APIException
 * @Description: 自定义接口错误异常
 * @author: 巫运辰
 * @date: 2021/08/25 15:30
 */
public class APIException extends RuntimeException{
    private int code;
    private String msg;

    public APIException() {
        this(ReturnCode.RC9999.getCode(), ReturnCode.RC9999.getMessage());
    }

    public APIException(String msg) {
        this(ReturnCode.RC9999.getCode(), msg);
    }

    public APIException(int code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }
}
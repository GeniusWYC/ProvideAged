package com.provideaged.provideaged.exception;

import com.provideaged.provideaged.enums.ReturnCode;

/**
 * @ClassName: FieldExistsException
 * @Description: 自定义数据库字段已存在异常
 * @author: 巫运辰
 * @date: 2021/08/26 10:02
 */
public class FieldExistsException extends Exception{
    private int code;
    private String msg;

    public FieldExistsException() {
        this(ReturnCode.RC1002.getCode(), ReturnCode.RC1002.getMessage());
    }

    public FieldExistsException(String msg) {
        this(ReturnCode.RC1002.getCode(), msg);
    }

    public FieldExistsException(int code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }
}
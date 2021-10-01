package com.provideaged.provideaged.exception;

import com.provideaged.provideaged.enums.ReturnCode;
import org.springframework.web.bind.MissingServletRequestParameterException;

/**
 * @ClassName: MissingParameterException
 * @Description: 自定义参数缺失异常
 * @author: 巫运辰
 * @date: 2021/08/25 17:53
 */
public class MissingParameterException extends MissingServletRequestParameterException {
    private int code;
    private String msg;

    public MissingParameterException() {
        this(ReturnCode.RC9999.getCode(), ReturnCode.RC9999.getMessage());
    }

    public MissingParameterException(String msg) {
        this(ReturnCode.RC9999.getCode(), msg);
    }

    public MissingParameterException(int code, String msg) {
        super("参数缺失",msg);
        this.code = code;
        this.msg = msg;
    }
}
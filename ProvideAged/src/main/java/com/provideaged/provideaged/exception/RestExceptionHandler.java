package com.provideaged.provideaged.exception;

import com.provideaged.provideaged.base.ResultData;
import com.provideaged.provideaged.enums.ReturnCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @ClassName: RestExceptionHandler
 * @Description: 全局异常处理器
 * @author: 巫运辰
 * @date: 2021/08/24 16:20
 */
@RestControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultData<String> MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        // 从异常对象中拿到ObjectError对象
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        // 然后提取错误提示信息进行返回
        return new ResultData<>(ReturnCode.RC1001, objectError.getDefaultMessage());
    }

    @ExceptionHandler(APIException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultData<String> APIExceptionHandler(APIException e) {
        return new ResultData<>(ReturnCode.RC9999, e.getMessage());
    }

    @ExceptionHandler(FieldExistsException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultData<String> AccountExceptionHandler(FieldExistsException e){
        return new ResultData<>(ReturnCode.RC1002);
    }

    @ExceptionHandler(CustomizeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultData<String> CustomizeExceptionHandler(CustomizeException e){
        return new ResultData<>(e.getCode(),e.getMessage());
    }
}
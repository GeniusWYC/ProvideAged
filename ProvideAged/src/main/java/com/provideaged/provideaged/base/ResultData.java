package com.provideaged.provideaged.base;

import com.provideaged.provideaged.enums.ReturnCode;
import lombok.Data;
import lombok.Getter;

/**
 * @ClassName: ResultData
 * @Description: 结果状态
 * @author: 巫运辰
 * @date: 2021/08/24 16:06
 */
@Getter
public class ResultData<T> {
    private int status;
    private String message;
    private T data = null;

    public ResultData (T data){
        this(ReturnCode.RC1000,data);
    }

    public ResultData(int resultCode,String message) {
        this.status = resultCode;
        this.message = message;
    }

    public ResultData(ReturnCode resultCode, T data) {
        this.status = resultCode.getCode();
        this.message = resultCode.getMessage();
        this.data = data;
    }

    public ResultData(ReturnCode resultCode) {
        this.status = resultCode.getCode();
        this.message = resultCode.getMessage();
    }

//    public static <T> ResultData<T> query(T data) {
//        ResultData<T> resultData = new ResultData<>();
//        if (data != null){
//            resultData.setStatus(ReturnCode.RC2000.getCode());
//            resultData.setMessage(ReturnCode.RC2000.getMessage());
//        } else {
//            resultData.setStatus(ReturnCode.RC2001.getCode());
//            resultData.setMessage(ReturnCode.RC2001.getMessage());
//        }
//
//        resultData.setData(data);
//        return resultData;
//    }
//    public static <T> ResultData<T> saveSuccess() {
//        ResultData<T> resultData = new ResultData<>();
//        resultData.setStatus(ReturnCode.RC3000.getCode());
//        resultData.setMessage(ReturnCode.RC3000.getMessage());
//        return resultData;
//    }
//
//    public static <T> ResultData<T> deleteSuccess() {
//        ResultData<T> resultData = new ResultData<>();
//        resultData.setStatus(ReturnCode.RC4000.getCode());
//        resultData.setMessage(ReturnCode.RC4000.getMessage());
//        return resultData;
//    }
//
//
//    public static <t> ResultData<t> fail(int code, String message) {
//        ResultData<t> resultData = new ResultData<>();
//        resultData.setStatus(code);
//        resultData.setMessage(message);
//        return resultData;
//    }
}
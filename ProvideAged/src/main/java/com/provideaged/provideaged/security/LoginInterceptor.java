package com.provideaged.provideaged.security;

import com.provideaged.provideaged.base.ResultData;
import com.provideaged.provideaged.enums.ReturnCode;
import com.provideaged.provideaged.exception.CustomizeException;
import com.provideaged.provideaged.exception.FieldExistsException;
import io.jsonwebtoken.Claims;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @ClassName: LoginInterceptor
 * @Description: 登录拦截器
 * @author: 巫运辰
 * @date: 2021/08/27 15:58
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 简单的白名单，登录这个接口直接放行

//        if (request.getMethod().toUpperCase().equals("OPTIONS")){
//            System.out.println("拦截器欲请求");
//            return true;
//        }
        System.out.println("jwt拦截器");
        String data = request.getRequestURI();
        if ("/API/User/login".equals(data)) {
            return true;
        }

        System.out.println(response.getStatus());
        // 从请求头中获取token字符串并解析
        Claims claims = JwtUtil.parse(request.getHeader("Authorization"));
        // 已登录就直接放行
        if (claims != null) {
            return true;
        }
        System.out.println("ReturnCode.RC1005");
        throw new CustomizeException(ReturnCode.RC1005);
        // 走到这里就代表是其他接口，且没有登录
        // 设置响应数据类型为json（前后端分离）
//        response.setContentType("application/json;charset=utf-8");
//        PrintWriter out = response.getWriter();
//        // 设置响应内容，结束请求
//        out.write(new ResultData<>(ReturnCode.RC1005,null).toString());
//        out.flush();
//        out.close();
        //return false;
    }
}
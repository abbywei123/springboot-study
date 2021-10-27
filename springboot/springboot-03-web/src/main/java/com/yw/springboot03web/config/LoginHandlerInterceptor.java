package com.yw.springboot03web.config;


import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       Object loginUSer=request.getSession().getAttribute("loginUser");

       if (loginUSer==null){
           request.setAttribute("msg","没有权限，请先登录");
           request.getRequestDispatcher("/index.html").forward(request,response);
           return false;
       }else{
           return true;
       }


    }
}

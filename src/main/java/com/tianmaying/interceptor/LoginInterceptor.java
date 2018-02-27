package com.tianmaying.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Hao on 2/27/18.
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //attribute is key value pair in Session
        if (request.getSession().getAttribute("CURRENT_USER") != null)
            return true;
        else {
            response.sendRedirect("/login?next=" + request.getRequestURI());
            return false;
        }
    }

}

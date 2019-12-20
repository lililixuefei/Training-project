package com.xuefei.interceptor;


import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义拦截器
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
    /**
     * 预处理 controller方法执行前
     * return true 放行，执行下一个拦截器，如果没有执行controller中的方法
     * return false 不放行
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {

        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/");
            return false;
        }
        return true;
    }
}
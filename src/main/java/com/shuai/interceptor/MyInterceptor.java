package com.shuai.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author shuaion 2018/5/25
 *
 * 测试拦截器
 *
 * 拦截器是spring架构的一个概念，拦截器是在action请求到Controller之前所进行的操作。
 * 其实拦截器是有三个方法，分别在进入Controller之前，return前，return后执行。
 *
 **/
public class MyInterceptor implements HandlerInterceptor {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /*
    * 创建一个拦截器，实现HandlerInterceptor接口，重写此接口的三个方法，
    * preHandle、postHandle、afterCompletion，
    * 只有第一个方法返回true时，才会进入Controller，否则不会处理Controller内容，也不会执行后边两个方法。
    * */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("-------MyInterceptor---preHandle-----");

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.info("-------MyInterceptor---postHandle-----");

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        logger.info("-------MyInterceptor---afterCompletion-----");

    }
}

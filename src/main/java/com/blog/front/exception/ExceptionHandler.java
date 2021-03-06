package com.blog.front.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 描述：全局异常拦截器
 * @author: hecj
 */
public class ExceptionHandler implements HandlerExceptionResolver {

	@Override
    public ModelAndView resolveException(HttpServletRequest request,
        HttpServletResponse response, Object handler, Exception ex) {
		return new ModelAndView("common/404");
    }
}
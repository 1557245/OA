package com.woniuxy.oa.handlerinterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class LoginHandlerInterceptor implements HandlerInterceptor{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Object account = request.getSession().getAttribute("account");
		if(account!=null) {
			return true;
		}else {
			//请求转发与重定向模板引擎不起作用
			request.getRequestDispatcher("/index.html").forward(request, response);
			return false;
		}
		
	}
}

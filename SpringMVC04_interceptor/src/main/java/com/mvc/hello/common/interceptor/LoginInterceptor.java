package com.mvc.hello.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

	Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
	
	//dispacter 와 controller 사이
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		logger.info("[INTERCEPTOR] preHandle");

		// Spring 3.2 이상 : servlet-context.xml에서 <exclude-mapping-path>를 사용할 수 있다.
		if(request.getRequestURI().contains("/login") || request.getRequestURI().contains("/loginajax.do")) {
			return true;
		}
		
		if(request.getSession().getAttribute("dto") == null) {
			response.sendRedirect("/interceptor");
			return false;
		}
		
		//controller가 정상 동작 여부
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		logger.info("[INTERCEPTOR] postHandle");
	}

	// 화면이 완성된 후에
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		logger.info("[INTERCEPTOR] afterCompletion");
	}

}

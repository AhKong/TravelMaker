package com.cafe24.travelMaker.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class MsgIntercepter extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		String sessionId = (String) session.getAttribute("SID"); // 다운 캐스팅 
		if(sessionId ==null) {
			response.sendRedirect("/login");
			return false;
			//false 인터셉터 컨트롤러로 향함 모든 컨트롤러에 내가 요청한거에 대한 거가 접근이 되겠져 ? 앞으로 회원가입 뭐뭐무머,, 누른다고 해도 인터셉터를 거쳐야함 

		}
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		

	}
}

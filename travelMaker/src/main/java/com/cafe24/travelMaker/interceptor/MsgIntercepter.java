package com.cafe24.travelMaker.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.cafe24.travelMaker.service.MsgService;

@Component
public class MsgIntercepter extends HandlerInterceptorAdapter{
	@Autowired private MsgService msgService;

	
    @Override
    public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception { 
		  HttpSession session = request.getSession();
	  
		  String sessionId = (String) session.getAttribute("SID"); // 다운 캐스팅
		  if(sessionId !=null) {
			  session.setAttribute("unReadMsgCtn", msgService.countUnReadMsg(sessionId));
		   }
		  return true; 
		  }

}
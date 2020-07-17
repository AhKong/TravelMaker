package com.cafe24.travelMaker.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.cafe24.travelMaker.service.MsgService;
import com.cafe24.travelMaker.service.NoticeService;

@Component
public class MsgIntercepter extends HandlerInterceptorAdapter{
	@Autowired private MsgService msgService;
	@Autowired private NoticeService noticeService;
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,ModelAndView modelAndView) throws Exception {
	
		super.postHandle(request, response, handler, modelAndView);
		HttpSession session = request.getSession();
		System.out.println(session+"<------sesesfd");
		  
		  String sessionId = (String) session.getAttribute("SID"); // 다운 캐스팅
		  System.out.println(sessionId +"<----sessionId");
		  if(sessionId !=null) { 
			  session.setAttribute("unReadMsgCtn",msgService.countUnReadMsg(sessionId)); 
			  session.setAttribute("noticeNum",noticeService.noticeNum(sessionId));
		  }
	}
    

}
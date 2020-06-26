package com.cafe24.travelMaker.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.cafe24.travelMaker.interceptor.MsgIntercepter;



@Configuration
public class WebConfig implements WebMvcConfigurer{

	@Autowired
	private MsgIntercepter msgInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		registry.addInterceptor(msgInterceptor)
				.addPathPatterns("/**")
				.excludePathPatterns("/");

	}
}

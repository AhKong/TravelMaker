package com.cafe24.travelMaker.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import java.util.*;

import com.cafe24.travelMaker.interceptor.CommonInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer{

	@Autowired
	private CommonInterceptor commonInterceptor;
	private List<String> excluedPathList = new ArrayList<String>();
	
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		excluedPathList.add("/");
		excluedPathList.add("/dist/");
		excluedPathList.add("/fileupload");
		excluedPathList.add("/plugins");
		
		registry.addInterceptor(commonInterceptor)
				.addPathPatterns("/**");
			

	}
}

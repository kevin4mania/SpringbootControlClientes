package com.kr.demo.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{
	
//	@Override
//	public void addInterceptors(InterceptorRegistry registro) {
//		registro.addInterceptor(locateChan)
//	}
	
	@Override
	public void addViewControllers(ViewControllerRegistry registro){
		registro.addViewController("/").setViewName("index");
		registro.addViewController("/login");
		registro.addViewController("/errores/403").setViewName("/errores/403");
	}

}

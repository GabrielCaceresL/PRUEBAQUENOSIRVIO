package com.fomacionbdi.springboot.app.ouath.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fomacionbdi.springboot.app.ouath.controllador.Interceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

	@Autowired
	private Interceptor interceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(interceptor);
	}
	
	
	
}

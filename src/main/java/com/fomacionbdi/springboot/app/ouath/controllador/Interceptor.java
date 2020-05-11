package com.fomacionbdi.springboot.app.ouath.controllador;

import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Service
public class Interceptor implements HandlerInterceptor{

	private static final Logger log = LoggerFactory.getLogger(Interceptor.class);
	private static final Map<String, String> requestInterceptor = new HashMap<>();
	private static final Collection<String> responseInterceptor = new HashSet<>();
 	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		log.info("Iniciando PreHandle");
		getInfo(request, response);
		requestInterceptor.forEach((k,v) -> log.info("REQUEST key: {} -value: {}",k,v));
		responseInterceptor.forEach((k) -> log.info("RESPONSE key: {} ",k));
		log.info("Finalizando PreHandle");
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		log.info("Iniciando PostHandle");
		getInfo(request, response);
		requestInterceptor.forEach((k,v) -> log.info("REQUEST key: {} -value: {}",k,v));
		responseInterceptor.forEach((k) -> log.info("RESPONSE key: {} ",k));
		log.info("Finalizando PostHandle");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		log.info("Iniciando AfterCompletion");
		getInfo(request, response);
		requestInterceptor.forEach((k,v) -> log.info("REQUEST key: {} -value: {}",k,v));
		responseInterceptor.forEach((k) -> log.info("RESPONSE key: {} ",k));
		log.info("Finalizando AfterCompletion");
	}
	
	private void getInfo(HttpServletRequest request, HttpServletResponse response) {
		Enumeration<String> headerName = request.getHeaderNames();
		
		while(headerName.hasMoreElements()) {
			String key = headerName.nextElement();
			String value = request.getHeader(key);
			requestInterceptor.put(key, value);			
		}
		responseInterceptor.addAll(response.getHeaderNames());
	}
	
	
}

package com.statflo.api;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.statflo.api.model.LogAccess;
import com.statflo.api.repository.mongodb.LogAccessRepository;

@Component
public class LogInterceptor extends HandlerInterceptorAdapter {
	
	@Autowired
	private LogAccessRepository logAccessRepository;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		String contentType = request.getContentType();
		String method = request.getMethod();
		String userIp = request.getRemoteAddr();
		
		String url = request.getRequestURL().toString();
		String queryString = request.getQueryString();
		
		String fullUrl = url;
		
		if(queryString != null) {
			fullUrl += "?" + queryString;
		}
		
		LogAccess logAccess = new LogAccess(contentType, method, userIp, fullUrl);
		
		logAccessRepository.save(logAccess);
		
		return super.preHandle(request, response, handler);
	}

   
}
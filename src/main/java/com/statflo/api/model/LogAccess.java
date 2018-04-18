package com.statflo.api.model;

import org.springframework.data.annotation.Id;

public class LogAccess {
	
	@Id
	private String id;
	private String contentType, method, userIp, fullUrl;

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getUserIp() {
		return userIp;
	}

	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFullUrl() {
		return fullUrl;
	}

	public void setFullUrl(String fullUrl) {
		this.fullUrl = fullUrl;
	}

	public LogAccess(String contentType, String method, String userIp, String fullUrl) {
		this.contentType = contentType;
		this.method = method;
		this.userIp = userIp;
		this.fullUrl = fullUrl;
	}
	
}
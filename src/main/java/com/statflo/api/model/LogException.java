package com.statflo.api.model;

import java.util.List;

import com.statflo.api.model.errors.ApiError;
import org.springframework.data.annotation.Id;

public class LogException {
	
    @Id
    public String id;

	private String method, status, message;
	private List<String> errors;
	
	public LogException(ApiError apiError, String method) {
		this.status = apiError.getStatus().toString();
		this.message = apiError.getMessage();
		this.errors = apiError.getErrors();
		this.method = method;
	}
	
	public LogException() {}
	
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<String> getErrors() {
		return errors;
	}
	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
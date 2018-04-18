package com.statflo.api.model.swaggerView;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

public class UserView {
	
	@NotNull
	@ApiModelProperty(example="aaaaaaaaaaaaaaaaaa", notes="bbbbbbbbbbbbbbbbbbbb")
	private String name; 
	
	@NotNull
	private String role;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
}
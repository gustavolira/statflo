package com.statflo.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.statflo.api.model.User;
import com.statflo.api.model.swaggerView.UserView;
import com.statflo.api.service.UserService;

import io.swagger.annotations.ApiOperation;

@RestController()
@RequestMapping(value="/users", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserController {
	
	@Autowired
	private UserService service;
	
	@PostMapping
	@ApiOperation(value = "Save users", notes = "API to save users")
	public ResponseEntity<User> save(@Valid @RequestBody UserView userView) {
		User user = new User();
		BeanUtils.copyProperties(userView, user);
		
		this.service.save(user);
		
		return ResponseEntity.status(HttpStatus.CREATED).build();
		
	}
	
	@GetMapping
	@ApiOperation(value = "Get Users", notes = "Find users by role name")
	public List<User> find(@RequestParam("role") String role) {
		return this.service.findByRole(role);
	}

}

package com.statflo.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.statflo.api.model.User;
import com.statflo.api.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public void save(User user) {
		this.repo.save(user);
	}
	
	public List<User> findByRole(String role) {
		return this.repo.findByRole(role);
		
	}
	
	public List<User> findAll() {
		return this.repo.findAll();
	}

}

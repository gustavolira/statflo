package com.statflo.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.statflo.api.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	public List<User> findByRole(String role);

}

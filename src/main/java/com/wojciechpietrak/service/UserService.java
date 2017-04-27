package com.wojciechpietrak.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.wojciechpietrak.model.User;



public interface UserService extends UserDetailsService{
	
	
	void save(User user);

	List<User> findAll();

	User findByEmail(String email) ;

}

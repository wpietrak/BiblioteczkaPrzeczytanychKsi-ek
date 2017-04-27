package com.wojciechpietrak.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.wojciechpietrak.dao.UserRepository;
import com.wojciechpietrak.model.User;
import com.wojciechpietrak.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		User user = userRepository.findByEmail(email);
		
		if (user==null){
			throw new UsernameNotFoundException("Brak u¿ytkownika: "+email);	
			}
		List<GrantedAuthority> authorities = new ArrayList<>(); 
		
		if (user.getRole()== User.Role.ADMIN){
			authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		}else if (user.getRole()== User.Role.USER){
			authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		}
	
		return new org.springframework.security.core.userdetails.User(user.getEmail(), 
				user.getPassword(), authorities );
	}

	@Override
	public void save(User user) {
		userRepository.save(user);
		
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
		
	}

	@Override
	public User findByEmail(String email) {
		
		return userRepository.findByEmail(email);
	}
}

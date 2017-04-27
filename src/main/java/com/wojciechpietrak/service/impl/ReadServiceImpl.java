package com.wojciechpietrak.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wojciechpietrak.dao.ReadRepository;
import com.wojciechpietrak.model.Read;
import com.wojciechpietrak.model.User;
import com.wojciechpietrak.service.ReadService;

@Service
public class ReadServiceImpl implements ReadService{

	@Autowired
	private ReadRepository readRepository; 
	
	@Override
	public List<Read> findByUser(User user) {
		return readRepository.findByUser(user);
	
	}
	@Override
	public void save(Read read) {
		
		
	}
}

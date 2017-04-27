package com.wojciechpietrak.service;

import java.util.List;

import com.wojciechpietrak.model.Read;
import com.wojciechpietrak.model.User;


public interface ReadService {

	List<Read> findByUser(User user);

	void save(Read read);
}

package com.wojciechpietrak.service;

import java.util.List;

import com.wojciechpietrak.model.Book;


public interface BookToReadService {

	List<Book> findAll();

	void save(Book book);

	Book findById(Long id);

	void delete(Long id);
}

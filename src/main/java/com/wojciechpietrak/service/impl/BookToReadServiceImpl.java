package com.wojciechpietrak.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wojciechpietrak.dao.BookToReadRepository;
import com.wojciechpietrak.model.Book;
import com.wojciechpietrak.service.BookToReadService;

@Service
public class BookToReadServiceImpl implements BookToReadService{

	  @Autowired
	    private BookToReadRepository bookToReadRepository;

	    @Override
	    public List<Book> findAll() {
	        return bookToReadRepository.findAll();
	    }

		@Override
		public void save(Book book) {
			bookToReadRepository.save(book);
			
		}

		@Override
		public Book findById(Long id) {
			
			return bookToReadRepository.findOne(id);
		}

		@Override
		public void delete(Long id) {
			bookToReadRepository.delete(id);
			
		}

}

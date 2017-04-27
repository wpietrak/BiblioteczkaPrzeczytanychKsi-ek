package com.wojciechpietrak.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.wojciechpietrak.model.Book;

@Repository
public interface BookToReadRepository extends JpaRepository<Book, Long>{

	public List<Book> findAll(); 
	public List<Book> findByAuthor (String author);
	
}

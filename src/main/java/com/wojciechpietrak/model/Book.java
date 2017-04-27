package com.wojciechpietrak.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "book")
public class Book extends BaseEntity {

	@Column(name = "title")
	private String title;

	@Column(name = "author")
	private String author;
	
	@OneToMany(mappedBy = "book", fetch = FetchType.LAZY)
    private List<Read> reads;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Book(String title, String author) {
		super();
		this.title = title;
		this.author = author;

	}

	public Book() {
		super();
	}

}

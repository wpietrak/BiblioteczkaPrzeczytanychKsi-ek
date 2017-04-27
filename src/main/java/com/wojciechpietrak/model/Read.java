package com.wojciechpietrak.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "readed")
public class Read extends BaseEntity{
	

	 public enum Status { IN_PROGRESS, FINISHED }
	 

		public Date getAddDate() {
			return addDate;
		}

	    @Column(name = "add_date")
	    private Date addDate;


	    @Enumerated(EnumType.STRING)
	    private Status status = Status.IN_PROGRESS;

	    @ManyToOne(fetch = FetchType.EAGER)
	    @JoinColumn(name = "book_id")
	    private Book book;

	    @ManyToOne(fetch = FetchType.EAGER)
	    @JoinColumn(name = "user_id")
	    private User user;


		public void setAddDate(Date addDate) {
			this.addDate = addDate;
		}

		public Status getStatus() {
			return status;
		}

		public void setStatus(Status status) {
			this.status = status;
		}

	public Book getBook() {
			return book;
		}

		public void setBook(Book book) {
			this.book = book;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public Read(Date addDate, Status status, Book book, User user) {
			super();
			this.addDate = addDate;
			this.status = status;
			this.book = book;
			this.user = user;
		}

		public Read() {
			
		}

		public Read(Book book, User user) {
			addDate = new Date();
	        this.book = book;
	        this.user = user;
		}

	
	    
}

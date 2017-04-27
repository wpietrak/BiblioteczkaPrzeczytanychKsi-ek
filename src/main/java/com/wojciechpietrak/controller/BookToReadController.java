package com.wojciechpietrak.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wojciechpietrak.model.Book;
import com.wojciechpietrak.service.BookToReadService;

@Controller
public class BookToReadController {

	
	@Autowired
	private BookToReadService bookToReadService;

	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public String getBooksPage(Model model) {

		List<Book> bookList = bookToReadService.findAll();

		model.addAttribute("bookList", bookList);
		return "books";
	}

	@RequestMapping(value = "/book/create", method = RequestMethod.GET)
	public String getCreateBookForm(Model model) {
		
		model.addAttribute("book", new Book());
		return "book-create";
	}
	@RequestMapping(value="/book/edit/{id}", method=RequestMethod.GET)
	public String getEditBookForm(Model model, @PathVariable Long id){
		Book book = bookToReadService.findById(id);
		model.addAttribute("book", book );
		return "book-create";
	}

	@RequestMapping(value = "/book/save", method = RequestMethod.POST)
	 public String postCreateBookForm( @ModelAttribute Book book) {

		bookToReadService.save(book);

		return "redirect:/books";
	}

	@RequestMapping (value = "/book/delete/{id}", method = RequestMethod.POST)
	public String postDeleteBook(@PathVariable Long id){
		bookToReadService.delete(id);
		return "redirect:/books";
	}

}

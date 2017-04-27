package com.wojciechpietrak.controller;


import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.wojciechpietrak.model.Book;
import com.wojciechpietrak.model.Read;
import com.wojciechpietrak.model.User;
import com.wojciechpietrak.service.BookToReadService;
import com.wojciechpietrak.service.ReadService;
import com.wojciechpietrak.service.UserService;


@Controller
public class ReadController {
	@Autowired
	private ReadService readService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BookToReadService bookToReadService;
	
	@RequestMapping(value="/read", method=RequestMethod.GET)
	public String getReadsPage(Model model, Principal principal){
		
/*		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		authentication.getPrincipal();*/
		
		String email = principal.getName();
		User user = userService.findByEmail(email);
		List<Read> reads = readService.findByUser(user);
		
		model.addAttribute("read", reads);
		return "read";
	}
	
	
	
	@RequestMapping(value = "/read/book/{id}" , method = RequestMethod.POST)
	public String readBook(@PathVariable Long id, Principal principal) {
/*	public String readBook(@PathVariable Long bookId, Principal principal){*/
		
		Book book = bookToReadService.findById(id);
		User user = userService.findByEmail(principal.getName());
		
		Read read = new Read(book, user);
		
		readService.save(read);
		
		return"redirect:/read";
		
	}

}

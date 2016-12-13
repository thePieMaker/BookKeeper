package com.marieindustries.controllers;

import java.util.ArrayList;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.marieindustries.beans.*;
import com.marieindustries.dao.DAO;

@Controller
public class HomeController {
	DAO dao = new DAO();
	
	@RequestMapping("/")
	public String showIndex(Model model){
		return "index";
	}
	
	@RequestMapping("/secure")
	public String showSecure(Model model){
		return "secure";
	}
	
	@RequestMapping("/addBook")
	public String showAddBook(Model model){
		model.addAttribute("book", new Book());
		return "addBook";
	}
	
	@RequestMapping("savebook")
	public String saveBook(Model model, @ModelAttribute Book book){
		dao.addBook(book);
		model.addAttribute("book", new Book());
		return "addBook";
	}
	
	@RequestMapping("searchBook")
	public String searchBook(Model model, @ModelAttribute Book book){
		if(book != null){
			System.out.println(book.getGenre());
		ArrayList<Book> books = (ArrayList<Book>) 									
		dao.queryByCategory(book.getGenre());
		model.addAttribute("booklist", books);
		}
		return "searchBook";
	}
	
	@RequestMapping("/createAccount")
	public String createAccount(Model model) {
		return "createAccount";
	}
	
	@RequestMapping("/register")
	public String register(Model model, @RequestParam String username, @RequestParam String password) {
		String encryptedPassword = new BCryptPasswordEncoder().encode(password);
		User user = new User(username, encryptedPassword, true);

		UserRole userRole = new UserRole(user, "ROLE_USER");
		user.getUserRole().add(userRole);

		DAO dao = new DAO();
		dao.createUser(user);
		
	
		
		model.addAttribute("accountCreated", true);
		return "index";
	}

	
	



}

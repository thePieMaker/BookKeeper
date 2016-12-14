package com.marieindustries.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@RequestMapping("/home")
	public String showSecure(Model model){
		//model.addAttribute("username", username);
		return "home";
	}
	
	@RequestMapping("/addBook")
	public String showAddBook(Model model){
		model.addAttribute("livre", new Livre());
		return "addBook";
	}
	
	@RequestMapping("/view")
	public String showContacts(Model model){
		model.addAttribute("livres", dao.getLivres());
		
		return "view";
	}
	
	
	
	@RequestMapping("/savebook")
	public String saveBook(Model model, @ModelAttribute Livre livre){
		dao.addLivre(livre);
		model.addAttribute("livre", new Livre());
		return "addBook";
	}
	
	@RequestMapping("/searchBook")
	public String searchBook(Model model, @ModelAttribute Livre livre){
		if(livre != null){
			System.out.println(livre.getGenre());
		ArrayList<Livre> books = (ArrayList<Livre>) 									
		dao.queryByCategory(livre.getGenre());
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

		/*UserRole userRole = new UserRole(user, "ROLE_USER");
		user.getUserRole().add(userRole);*/

		DAO dao = new DAO();
		dao.createUser(user);
		
	
		
		model.addAttribute("accountCreated", true);
		return "index";
	}

	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    return "index";
	

	}
	
	@RequestMapping("/deleteLivre/{id}")
	public String deleteLivre(Model model, @PathVariable int id){
		dao.deleteLivre(id);
		model.addAttribute("livres", dao.getLivres());
		return "view";
	}
	
	@RequestMapping("/editLivre/{id}")
	public String editLivre(Model model, @PathVariable int id){
		Livre livre = dao.getLivre(id);
		dao.deleteLivre(id);
		model.addAttribute("livre", livre);
		return "addBook";
	}

}

package edu.ccsu.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String welcome() {
		return "table";
	}
	
	@RequestMapping("/login")
	public String login(){		
		return "login";
	}

}
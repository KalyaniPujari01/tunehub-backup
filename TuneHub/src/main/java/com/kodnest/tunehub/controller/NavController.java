package com.kodnest.tunehub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NavController {

	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	
	@GetMapping("/registration")
	public String registration() {
		return "registration";
	}
	
	@GetMapping("/newsong")
	public String newsong() {
		return "newsong";
	}
	
	

	
}

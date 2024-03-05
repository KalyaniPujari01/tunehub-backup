package com.kodnest.tunehub.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;`
import org.springframework.web.bind.annotation.RequestParam;

import com.kodnest.tunehub.entity.Song;
import com.kodnest.tunehub.entity.User;
import com.kodnest.tunehub.serviceimpl.UserServiceImpl;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	@Autowired
	UserServiceImpl userserviceimpl;


	@PostMapping("/register")
	public String addUser(@ModelAttribute User user) {
		// so , email taken from registration form
		String email = user.getEmail();

		// this statement is checking if email as entered in registration form is presnt in db or not
		boolean status = userserviceimpl.emailExists(email);


		if(status == false) {
			userserviceimpl.addUser(user);
			System.out.println("user added");
		}
		else {
			System.out.println("User already exists");
		}

		//		System.out.println(user.getUsername() +" " + user.getEmail() + " " + user.getPassword() + " " 
		//				+ user.getGender() + " " + user.getRole() + "" + user.getAddress());

		return "home";
	}
	
	
	// checks the duplicate is present or not using iframe link (song-link)
	
	@PostMapping("/validate")
	public String validate(@RequestParam("email") String email , 
			@RequestParam("password") String password , HttpSession session) {

		if(userserviceimpl.validateUser(email , password) == true){
			String role = userserviceimpl.getRole(email);
			
			session.setAttribute("email", email);

			if(role.equals("admin")) {
				return "adminhome";
			}
			else {
				return "customerhome";
			}	
		}
		else {
			return "login";
		}
	}
	
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "login";
	}
	
	
	
	
	
	
}
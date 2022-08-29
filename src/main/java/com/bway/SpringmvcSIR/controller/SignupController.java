package com.bway.SpringmvcSIR.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bway.SpringmvcSIR.model.User;
import com.bway.SpringmvcSIR.repository.UserRepository;

@Controller
public class SignupController {
	
	@Autowired
	private UserRepository userRepo;

	@GetMapping("/signup")
	public String showSignupForm() {

		return "SignupForm";
	}

	@PostMapping("/signup")
	public String saveUser(@ModelAttribute User u) {

		u.setPassword(DigestUtils.md5DigestAsHex(u.getPassword().getBytes()));
		
		userRepo.save(u);
		
		return "LoginForm";
	}

}

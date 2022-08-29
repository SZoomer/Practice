package com.bway.SpringmvcSIR.controller;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bway.SpringmvcSIR.model.User;
import com.bway.SpringmvcSIR.repository.UserRepository;

@Controller
public class LoginController {
	
	@Autowired
	 private UserRepository userRepo;
	
	//@RequestMapping(value ="/login", method = RequestMethod.GET)
	@GetMapping("/login")
	public String showLoginForm() {
		
		return "LoginForm";
	}

	@PostMapping("/login")
	public String doLogin(@ModelAttribute User  u, Model model, HttpSession session) {
		
		
		u.setPassword(DigestUtils.md5DigestAsHex(u.getPassword().getBytes()));
		
		User usr = userRepo.findByUserNameAndPassword(u.getUserName(), u.getPassword());
		
		if(usr != null) {
			model.addAttribute("uname", u.getUserName());
			session.setAttribute("activeuser", usr);
			
			return "home";
		}
		
		model.addAttribute("message","user not found!!");
		
		return "LoginForm";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		
		session.invalidate();
		
		return "LoginForm";
	}
	
	
}

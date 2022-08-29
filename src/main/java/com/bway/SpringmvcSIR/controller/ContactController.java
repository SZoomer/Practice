
 package com.bway.SpringmvcSIR.controller;

import org.springframework.beans.factory.annotation.Autowired; 
/*import org.springframework.mail.SimpleMailMessage; 
import org.springframework.mail.javamail.JavaMailSender;*/
 import org.springframework.stereotype.Controller; 
 import org.springframework.ui.Model; 
 import org.springframework.web.bind.annotation.GetMapping; 
 import org.springframework.web.bind.annotation.PostMapping; 
 import org.springframework.web.bind.annotation.RequestParam;

import com.bway.SpringmvcSIR.repository.JavaMailSender;

 @Controller 
 public class ContactController {
 
 @Autowired 
 private JavaMailSender javaMailSender;
  
  @GetMapping("/contact") 
  public String showContactForm() {
  
	  return "ContactForm"; 
  }
  
  @PostMapping("/contact") 
  public String doContact(@RequestParam String email,
		  				@RequestParam String subject,
		  				@RequestParam String message, Model model) {
  
	  sendEmail(email,subject,message);
  
	  return "ContactForm";
	}

private void sendEmail(String email, String subject, String message) {
	
	
}
  
  
	
/*
 * private void sendEmail(String email, String subject, String message) {
 * 
 * SimpleMailMessage msg = new SimpleMailMessage(); msg.setTo(email);
 * 
 * msg.setSubject(subject); msg.setText(message);
 * 
 * javaMailSender.send(msg);
 * 
 * }
 */
	 
  
  }
 
package com.bway.SpringmvcSIR.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bway.SpringmvcSIR.model.Employee;
import com.bway.SpringmvcSIR.repository.EmployeeRepository;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeRepository empRepo;

	@GetMapping("/employee")
	public String showEmployeeForm() {

		return "EmployeeForm";
	}

	@PostMapping("/employee")
	public String saveEmp(@ModelAttribute Employee emp) {

		empRepo.save(emp);

		return "EmployeeForm";
	}

	@GetMapping("/list")
	public String empList(Model model) {

		model.addAttribute("emplist", empRepo.findAll());

		return "EmployeeList";
	}

	
	
	@GetMapping("/delete")
	public String deleteEmp(@RequestParam long id) {

		empRepo.deleteById(id);

		return "redirect:list";
	}
	
	@GetMapping("/edit")
	public String editEmp(@RequestParam long id, Model model) {
		
		
		model.addAttribute("emodel",empRepo.getById(id));
		
		return "EditForm";
	}

	@PostMapping("/update")
	public String updateEmp(@ModelAttribute Employee emp) {
		
		empRepo.save(emp);
		
		return  "redirect:/list";
	}
	
}







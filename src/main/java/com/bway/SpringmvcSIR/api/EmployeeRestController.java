package com.bway.SpringmvcSIR.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bway.SpringmvcSIR.model.Employee;
import com.bway.SpringmvcSIR.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/emp")
public class EmployeeRestController {

	@Autowired
	private EmployeeRepository empRepo;
	
	@GetMapping("/list")
	public List<Employee> getAllEmps(){
		
		return empRepo.findAll();
	}
	
	@PostMapping("/add")
	public String addEmp(@RequestBody Employee emp) {
		
		empRepo.save(emp);
		return "Student Added";
	}
	
	@PutMapping("/update")											//------PutMapping is for Update used in API
	public String updateEmp(@RequestBody Employee emp) {
		
		empRepo.save(emp);
		
		return "Update Success";
	}
	
	@DeleteMapping("/delete/{id}")									// --------- For API
	public String deleteEmp(@PathVariable long id) {
		
		empRepo.deleteById(id);
		
		return "Deleted";
	}
	
	@GetMapping("/{id}")
	public Employee getOneEmp(@PathVariable long id) {
		
		return empRepo.getById(id);
	}
	
	@GetMapping("/j2o")
	public String convertJSONToObject() {							//------ Converting JSON to Object (For Single data)  Reverse JSON
		
		RestTemplate temp = new RestTemplate();
		Employee e1 = temp.getForObject("http://localhost/api/emp/3", Employee.class);
		
		return "FirstName = "+e1.getFname();		
		
	}
	
	@GetMapping("/jar2oar")
	public String convertJSONArrayToObjectArray() {							//------ Converting JSON to Object (For Multiple data)  Reverse JSON (J Array)
		
		RestTemplate temp = new RestTemplate();
		Employee[] emplist = temp.getForObject("http://localhost/api/emp/employeelist", Employee[].class);
		
		return "FirstName = "+emplist[0].getFname();		
		
	}
	
	
}

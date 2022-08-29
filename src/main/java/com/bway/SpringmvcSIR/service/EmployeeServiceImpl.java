package com.bway.SpringmvcSIR.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bway.SpringmvcSIR.model.Employee;
import com.bway.SpringmvcSIR.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository empRepo;
	
	@Override
	public void addEmp(Employee emp) {
		empRepo.save(emp);
		
	}

	@Override
	public void deleteEmp(long id) {
		empRepo.deleteById(id);
		
	}

	@Override
	public List<Employee> getAllEmp() {
		return empRepo.findAll();
	}

	@Override
	public Employee getEmpById(long id) {
		return empRepo.getById(id);
	}

	@Override
	public void updateEmp(Employee emp) {
		empRepo.save(emp);
		
	}

	
	
}

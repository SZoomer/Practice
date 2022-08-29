package com.bway.SpringmvcSIR.service;

import java.util.List;

import com.bway.SpringmvcSIR.model.Employee;

public interface EmployeeService {
	
	void addEmp(Employee emp);
	
	void deleteEmp(long id);
	
	List<Employee> getAllEmp();
	
	Employee getEmpById(long id);
	
	void updateEmp(Employee emp);

}

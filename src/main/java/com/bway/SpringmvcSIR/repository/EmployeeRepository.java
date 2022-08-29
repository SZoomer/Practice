package com.bway.SpringmvcSIR.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bway.SpringmvcSIR.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
	

}

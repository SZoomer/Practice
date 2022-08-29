package com.bway.SpringmvcSIR.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bway.SpringmvcSIR.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	 User findByUserNameAndPassword(String un, String psw);
	
}

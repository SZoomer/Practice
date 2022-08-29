package com.bway.SpringmvcSIR.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bway.SpringmvcSIR.model.Contact;

public interface JavaMailSender extends JpaRepository<Contact, Integer>{


}

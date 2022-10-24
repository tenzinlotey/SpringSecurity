package com.customTable.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.customTable.model.Customer;
import com.customTable.model.CustomerData;
import com.customTable.service.CustomerService;

@RestController
public class RegistrationController {

	@Autowired
	CustomerService customerService;
	
	
	BCryptPasswordEncoder BCryptEncoder = new BCryptPasswordEncoder();
	
	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@RequestBody  CustomerData data){
		Customer customer = new Customer(data.getEmail(),data.getPassword(),data.getName(),data.getRole());
		String hashpwd = BCryptEncoder.encode(customer.getPassword());
		customer.setPassword(hashpwd);
		System.out.println(customer);
		Customer cus = customerService.saveUser(customer);
		return ResponseEntity.status(HttpStatus.CREATED).body(cus);
	}
}

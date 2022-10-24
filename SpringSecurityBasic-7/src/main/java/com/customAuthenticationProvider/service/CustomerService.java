package com.customAuthenticationProvider.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customAuthenticationProvider.customerRepo.CustomerRepo;
import com.customAuthenticationProvider.model.Customer;


@Service
public class CustomerService {

	@Autowired
	CustomerRepo customerRepo;
	
	public Customer saveUser(Customer customer) {
		return customerRepo.save(customer);
	}
}

package com.customTable.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customTable.customerRepo.CustomerRepo;
import com.customTable.model.Customer;


@Service
public class CustomerService {

	@Autowired
	CustomerRepo customerRepo;
	
	public Customer saveUser(Customer customer) {
		return customerRepo.save(customer);
	}
}

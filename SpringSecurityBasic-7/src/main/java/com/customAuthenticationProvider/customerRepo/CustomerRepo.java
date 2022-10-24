package com.customAuthenticationProvider.customerRepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.customAuthenticationProvider.model.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long>{

	List<Customer> findByEmail(String email);
}

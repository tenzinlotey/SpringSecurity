package com.customTable.customerRepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.customTable.model.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long>{

	List<Customer> findByEmail(String email);
}

//package com.customAuthenticationProvider.customUserDetailService;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.customAuthenticationProvider.customerRepo.CustomerRepo;
//import com.customAuthenticationProvider.model.Customer;
//
//@Service
//public class CustomDetailService implements UserDetailsService{
//	
//	@Autowired
//	CustomerRepo customerRepo;
//	
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//	String userName,password = null;
//	List<GrantedAuthority> authorities = null;
//	List<Customer> customer = customerRepo.findByEmail(username);
//	System.out.println("Inside loadUserByUSerName"+customer.get(0));
//	if(customer.size() == 0) {
//		throw new UsernameNotFoundException(username);
//	}
//	else {
//		userName = customer.get(0).getEmail();
//		password = customer.get(0).getPassword();
//		authorities = new ArrayList<>();
//		authorities.add( new SimpleGrantedAuthority(customer.get(0).getRole()));
//	}
//	return new User(userName, password, authorities);
//	
//	}
//
//}

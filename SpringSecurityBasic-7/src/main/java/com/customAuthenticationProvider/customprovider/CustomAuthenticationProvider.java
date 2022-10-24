package com.customAuthenticationProvider.customprovider;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.customAuthenticationProvider.customerRepo.CustomerRepo;
import com.customAuthenticationProvider.model.Customer;

@Component
public class CustomAuthenticationProvider  implements AuthenticationProvider{

	@Autowired
	CustomerRepo customerRepo;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		// TODO Auto-generated method stub
		String username = authentication.getName();
		String pwd = authentication.getCredentials().toString();
		List<Customer> customer = customerRepo.findByEmail(username);
		System.out.println("inside customauthentication provider");
		if(customer.size()>0) {
			if(passwordEncoder.matches(pwd, customer.get(0).getPassword())) {
				List<GrantedAuthority> authorities = new ArrayList<>();
				authorities.add(new SimpleGrantedAuthority(customer.get(0).getRole()));
				return new UsernamePasswordAuthenticationToken(username,pwd, authorities);
			}
			else {
				throw new BadCredentialsException("Bad credentials");
			}
		}
		else {
			throw new BadCredentialsException("no user registered with this details");
		}
		}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	}

}

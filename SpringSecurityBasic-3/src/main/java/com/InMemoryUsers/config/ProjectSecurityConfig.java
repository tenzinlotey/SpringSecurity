package com.InMemoryUsers.config;

import java.net.PasswordAuthentication;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http)  throws Exception{
		http.authorizeRequests().antMatchers("/account","/details").authenticated()
		.antMatchers("/abouts","/welcome").permitAll().and()
		.formLogin().and().httpBasic();
		return http.build();
	}
	
	@Bean
	public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
		
//		First approach to use plain text password using withDefaultPasswordEncoder() method
		
//		UserDetails admin = User.withDefaultPasswordEncoder()
//				.username("admin")
//				.password("12345")
//				.authorities("admin")
//				.build();
//		
//		UserDetails user = User.withDefaultPasswordEncoder()
//				.username("user")
//				.password("user")
//				.authorities("read")
//				.build();
		
//		Second approach to use plain text password using PasswordEncoder method and returning NoOpPasswordEncoder
		
		UserDetails admin = User.withUsername("admin")
				.password("12345")
				.authorities("admin")
				.build();
		
		UserDetails user = User.withUsername("user")
				.password("user")
				.authorities("read")
				.build();
		
		return new InMemoryUserDetailsManager(admin,user);
	}
	
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}
 
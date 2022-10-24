package com.customAuthenticationProvider.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeHttpRequests().antMatchers("/account","/detail").authenticated().
		antMatchers("/welcome","/about","/register").permitAll().and()
		.formLogin().and()
		.httpBasic();
		return http.build();
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return  new BCryptPasswordEncoder();
	}
}

package com.InMemoryUsers.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
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
		UserDetails admin = User.withDefaultPasswordEncoder()
				.username("admin")
				.password("12345")
				.authorities("admin")
				.build();
		
		UserDetails user = User.withDefaultPasswordEncoder()
				.username("user")
				.password("user")
				.authorities("read")
				.build();
		
		return new InMemoryUserDetailsManager(admin,user);
	}
}
 
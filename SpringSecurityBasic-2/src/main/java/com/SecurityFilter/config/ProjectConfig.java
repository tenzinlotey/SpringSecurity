package com.SecurityFilter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectConfig {

	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception{
		http.authorizeRequests().antMatchers("/abouts","/welcome").permitAll()
		.antMatchers("/details","/account").authenticated().and().formLogin().and().httpBasic();
		return http.build();
	}
}

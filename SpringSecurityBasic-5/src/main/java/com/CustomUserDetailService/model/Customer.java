package com.CustomUserDetailService.model;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Customer {

	@Id
	
	private Long id;
	private String email;
	private String password;
	private String name;
}

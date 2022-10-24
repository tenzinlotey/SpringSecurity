package com.customTable.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerData {

	private String email;
	private String password;
	private String name;
	private String role;
}

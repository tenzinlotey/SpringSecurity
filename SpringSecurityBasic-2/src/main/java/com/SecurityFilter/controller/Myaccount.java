package com.SecurityFilter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class Myaccount {

	@GetMapping("/")
	public String getMyAccount() {
		return "MyAccount controller";
	}
}

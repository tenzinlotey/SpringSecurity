package com.JdbcUsersManager.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AboutsController {

	@GetMapping("/abouts")
	public String getAbouts() {
		return "Abouts contoller";
	}
}

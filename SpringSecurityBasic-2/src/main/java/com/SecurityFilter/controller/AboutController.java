package com.SecurityFilter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/abouts")
public class AboutController {

	@GetMapping("")
	public String getAbouts() {
		return "About controller";
	}
}

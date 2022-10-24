package com.CustomUserDetailService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DetailsController {

	@GetMapping("/details")
	public String getDetails() {
		return "Details Controller";
	}
}

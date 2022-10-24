package com.customTable.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AboutsController {

	@GetMapping("/about")
	public String getAbouts() {
		return "Abouts Controller";
	}
}

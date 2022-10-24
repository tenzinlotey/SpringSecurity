package com.customTable.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DetailsController {

	@GetMapping("/detail")
	public String getDetails() {
		return "Details Controller";
	}
}

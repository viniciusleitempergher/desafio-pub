package com.viniciusleitempergher.desafiopub.accountservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
	@GetMapping("account-service/hello")
	public String retrieveHello() {
		return "hello, world!";
	}
}

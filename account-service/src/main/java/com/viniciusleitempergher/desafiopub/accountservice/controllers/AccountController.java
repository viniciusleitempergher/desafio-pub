package com.viniciusleitempergher.desafiopub.accountservice.controllers;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.viniciusleitempergher.desafiopub.accountservice.requests.CreateAccountRequest;
import com.viniciusleitempergher.desafiopub.accountservice.responses.AccountCreatedResponse;
import com.viniciusleitempergher.desafiopub.accountservice.services.AccountService;

@RestController
@RequestMapping(value = "/account-service")
public class AccountController {

	@Resource(name = "accountService")
	private AccountService accountService;

	@PostMapping("/account")
	@ResponseStatus(code = HttpStatus.CREATED)
	public AccountCreatedResponse createAccount(@RequestBody CreateAccountRequest requestData) {
		return accountService.createAccount(requestData);
	}

	@PutMapping("/account/{id}")
	public void editAccount(@PathVariable String id, @RequestBody CreateAccountRequest requestData) {
		accountService.editAccount(id, requestData);
	}
	
	@DeleteMapping("/account/{id}")
	public void removeAccount(@PathVariable String id) {
		accountService.removeAccount(id);
	}
}

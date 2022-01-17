package com.viniciusleitempergher.desafiopub.expendingbalanceservice.controllers;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.viniciusleitempergher.desafiopub.expendingbalanceservice.requests.CreateExpendingBalanceRequest;
import com.viniciusleitempergher.desafiopub.expendingbalanceservice.services.ExpendingBalanceService;

@RestController
@RequestMapping("/expending-balance-service")
public class ExpendingBalanceController {

	@Resource(name = "expendingBalanceService")
	private ExpendingBalanceService expendingService;

	@PostMapping("/expending")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void createExpending(@RequestBody CreateExpendingBalanceRequest requestData) {
		expendingService.add(requestData);
	}

}

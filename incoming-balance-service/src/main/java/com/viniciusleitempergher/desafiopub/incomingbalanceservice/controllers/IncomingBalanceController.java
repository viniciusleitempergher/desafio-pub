package com.viniciusleitempergher.desafiopub.incomingbalanceservice.controllers;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viniciusleitempergher.desafiopub.incomingbalanceservice.requests.CreateIncomingBalanceRequest;
import com.viniciusleitempergher.desafiopub.incomingbalanceservice.services.IncomingBalanceService;

@RestController
@RequestMapping("/incoming-balance-service")
public class IncomingBalanceController {

	@Resource(name = "incomingBalanceService")
	private IncomingBalanceService incomingBalanceService;

	@PostMapping("/incoming-balance")
	public void createIncomingBalance(@RequestBody CreateIncomingBalanceRequest requestData) {
		incomingBalanceService.add(requestData);
	}
}

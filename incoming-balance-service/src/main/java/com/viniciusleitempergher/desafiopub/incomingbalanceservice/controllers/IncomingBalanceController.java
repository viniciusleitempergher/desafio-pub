package com.viniciusleitempergher.desafiopub.incomingbalanceservice.controllers;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.viniciusleitempergher.desafiopub.incomingbalanceservice.requests.CreateIncomingBalanceRequest;
import com.viniciusleitempergher.desafiopub.incomingbalanceservice.responses.BalanceResponse;
import com.viniciusleitempergher.desafiopub.incomingbalanceservice.responses.IncomingBalanceList;
import com.viniciusleitempergher.desafiopub.incomingbalanceservice.services.IncomingBalanceService;

@RestController
@RequestMapping("/incoming-balance-service")
public class IncomingBalanceController {

	@Resource(name = "incomingBalanceService")
	private IncomingBalanceService incomingBalanceService;

	@PostMapping("/incoming-balance")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void createIncomingBalance(@RequestBody CreateIncomingBalanceRequest requestData) {
		incomingBalanceService.add(requestData);
	}

	@PutMapping("/incoming-balance/edit/{target}")
	public void editIncomingBalance(@PathVariable String target,
			@RequestBody CreateIncomingBalanceRequest requestData) {
		incomingBalanceService.edit(target, requestData);
	}

	@DeleteMapping("/incoming-balance/{target}")
	public void removeIncomingBalance(@PathVariable String target) {
		incomingBalanceService.remove(target);
	}

	@GetMapping("/incoming-balance")
	public IncomingBalanceList listIncomingBalances(@RequestParam String dataInicial, @RequestParam String dataFinal,
			@RequestParam @Nullable String tipoReceita) {
		return incomingBalanceService.getFromPeriod(dataInicial, dataFinal, tipoReceita);
	}
	
	@GetMapping("/incoming-balance/totalbalance")
	public BalanceResponse totalReceitas() {
		return incomingBalanceService.getTotalBalance();
	}
}

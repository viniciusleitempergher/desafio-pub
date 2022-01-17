package com.viniciusleitempergher.desafiopub.expendingbalanceservice.controllers;

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

import com.viniciusleitempergher.desafiopub.expendingbalanceservice.requests.CreateExpendingBalanceRequest;
import com.viniciusleitempergher.desafiopub.expendingbalanceservice.responses.ExpendingBalanceList;
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

	@PutMapping("/expending/edit/{target}")
	public void editExpending(@PathVariable String target, @RequestBody CreateExpendingBalanceRequest requestData) {
		expendingService.edit(target, requestData);
	}

	@DeleteMapping("/expending/{target}")
	public void removeExpending(@PathVariable String target) {
		expendingService.remove(target);
	}

	@GetMapping("/expending")
	public ExpendingBalanceList listIncomingBalances(@RequestParam String dataInicial, @RequestParam String dataFinal,
			@RequestParam @Nullable String tipoDespesa) {
		return expendingService.getFromPeriod(dataInicial, dataFinal, tipoDespesa);
	}
}

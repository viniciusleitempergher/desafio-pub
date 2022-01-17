package com.viniciusleitempergher.desafiopub.expendingbalanceservice.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viniciusleitempergher.desafiopub.expendingbalanceservice.models.ExpendingBalance;
import com.viniciusleitempergher.desafiopub.expendingbalanceservice.proxies.AccountProxy;
import com.viniciusleitempergher.desafiopub.expendingbalanceservice.repositories.ExpendingBalanceRepository;
import com.viniciusleitempergher.desafiopub.expendingbalanceservice.requests.CreateExpendingBalanceRequest;
import com.viniciusleitempergher.desafiopub.expendingbalanceservice.responses.BadRequest;

@Service("expendingBalanceService")
public class ExpendingBalanceService {

	@Autowired
	private ExpendingBalanceRepository expendingRepository;

	@Autowired
	private AccountProxy accountProxy;

	public void add(CreateExpendingBalanceRequest requestData) {

		validateType(requestData.getTipoDespesa());

		accountProxy.subBalance(requestData.getContaId().toString(), requestData.getValor().doubleValue());

		ExpendingBalance expendingBalance = new ExpendingBalance();
		expendingBalance.setContaId(requestData.getContaId());
		expendingBalance.setDataPagamento(formatAndValidateDate(requestData.getDataPagamento()));
		expendingBalance.setDataPagamentoEsperado(formatAndValidateDate(requestData.getDataPagamentoEsperado()));
		expendingBalance.setTipoDespesa(requestData.getTipoDespesa());
		expendingBalance.setValor(requestData.getValor());

		expendingRepository.save(expendingBalance);

	}

	private void validateType(String tipoDespesa) {
		if (!tipoDespesa.equals("alimentação") && !tipoDespesa.equals("educação") && !tipoDespesa.equals("lazer")
				&& !tipoDespesa.equals("moradia") && !tipoDespesa.equals("roupa") && !tipoDespesa.equals("saúde")
				&& !tipoDespesa.equals("transporte") && !tipoDespesa.equals("outros")) {
			throw new BadRequest("Tipo de despesa inválido!");
		}
	}

	private Date formatAndValidateDate(String date) {
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
		try {
			return formatador.parse(date);
		} catch (ParseException e) {
			throw new BadRequest("Data inválida!");
		}
	}
}

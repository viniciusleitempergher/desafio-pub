package com.viniciusleitempergher.desafiopub.incomingbalanceservice.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viniciusleitempergher.desafiopub.incomingbalanceservice.models.IncomingBalance;
import com.viniciusleitempergher.desafiopub.incomingbalanceservice.proxies.AccountProxy;
import com.viniciusleitempergher.desafiopub.incomingbalanceservice.repositories.IncomingBalanceRepository;
import com.viniciusleitempergher.desafiopub.incomingbalanceservice.requests.CreateIncomingBalanceRequest;
import com.viniciusleitempergher.desafiopub.incomingbalanceservice.responses.BadRequest;

@Service("incomingBalanceService")
public class IncomingBalanceService {

	@Autowired
	private IncomingBalanceRepository incomingBalanceRepository;

	@Autowired
	private AccountProxy accountProxy;

	public void add(CreateIncomingBalanceRequest requestData) {
		String tipoReceita = requestData.getTipoReceita();
		if (!tipoReceita.equals("salário") && !tipoReceita.equals("presente") && !tipoReceita.equals("prêmio")
				&& !tipoReceita.equals("outros")) {
			throw new BadRequest("Tipo de receita inválido!");
		}

		IncomingBalance incomingBalance = new IncomingBalance();

		accountProxy.addBalance(requestData.getContaId().toString(), requestData.getValor().doubleValue());

		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");

		try {
			incomingBalance.setDataRecebimento(formatador.parse(requestData.getDataRecebimento()));
			incomingBalance.setDataRecebimentoEsperado(formatador.parse(requestData.getDataRecebimentoEsperado()));
		} catch (ParseException e) {
			throw new BadRequest("Data inválida!");
		}

		incomingBalance.setDescricao(requestData.getDescricao());
		incomingBalance.setContaId(requestData.getContaId());
		incomingBalance.setTipoReceita(requestData.getTipoReceita());
		incomingBalance.setValor(requestData.getValor());

		incomingBalanceRepository.save(incomingBalance);
	}

}

package com.viniciusleitempergher.desafiopub.incomingbalanceservice.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viniciusleitempergher.desafiopub.incomingbalanceservice.models.IncomingBalance;
import com.viniciusleitempergher.desafiopub.incomingbalanceservice.proxies.AccountProxy;
import com.viniciusleitempergher.desafiopub.incomingbalanceservice.repositories.IncomingBalanceRepository;
import com.viniciusleitempergher.desafiopub.incomingbalanceservice.requests.CreateIncomingBalanceRequest;
import com.viniciusleitempergher.desafiopub.incomingbalanceservice.responses.BadRequest;
import com.viniciusleitempergher.desafiopub.incomingbalanceservice.responses.NotFound;

@Service("incomingBalanceService")
public class IncomingBalanceService {

	@Autowired
	private IncomingBalanceRepository incomingBalanceRepository;

	@Autowired
	private AccountProxy accountProxy;

	public void add(CreateIncomingBalanceRequest requestData) {
		String tipoReceita = requestData.getTipoReceita();
		validateType(tipoReceita);

		IncomingBalance incomingBalance = new IncomingBalance();

		accountProxy.addBalance(requestData.getContaId().toString(), requestData.getValor().doubleValue());

		incomingBalance.setDataRecebimento(formatAndValidateDate(requestData.getDataRecebimento()));
		incomingBalance.setDataRecebimentoEsperado(formatAndValidateDate(requestData.getDataRecebimentoEsperado()));

		incomingBalance.setDescricao(requestData.getDescricao());
		incomingBalance.setContaId(requestData.getContaId());
		incomingBalance.setTipoReceita(requestData.getTipoReceita());
		incomingBalance.setValor(requestData.getValor());

		incomingBalanceRepository.save(incomingBalance);
	}

	public void edit(String target, CreateIncomingBalanceRequest requestData) {
		validateType(requestData.getTipoReceita());

		IncomingBalance incomingBalance = incomingBalanceRepository.findById(UUID.fromString(target))
				.orElseThrow(() -> new NotFound("Receita não encontrada!"));

		// altera o saldo na conta, removendo o antigo saldo da receita e adicionando o
		// editado vvv
		accountProxy.subBalance(incomingBalance.getContaId().toString(), incomingBalance.getValor().doubleValue());
		accountProxy.addBalance(requestData.getContaId().toString(), requestData.getValor().doubleValue());

		incomingBalance.setContaId(requestData.getContaId());
		incomingBalance.setDataRecebimento(formatAndValidateDate(requestData.getDataRecebimento()));
		incomingBalance.setDataRecebimentoEsperado(formatAndValidateDate(requestData.getDataRecebimentoEsperado()));
		incomingBalance.setDescricao(requestData.getDescricao());
		incomingBalance.setTipoReceita(requestData.getTipoReceita());
		incomingBalance.setValor(requestData.getValor());

		incomingBalanceRepository.save(incomingBalance);
	}

	private void validateType(String tipoReceita) {
		if (!tipoReceita.equals("salário") && !tipoReceita.equals("presente") && !tipoReceita.equals("prêmio")
				&& !tipoReceita.equals("outros")) {
			throw new BadRequest("Tipo de receita inválido!");
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

	public void remove(String id) {
		IncomingBalance incomingBalance = incomingBalanceRepository.findById(UUID.fromString(id))
				.orElseThrow(() -> new NotFound("Receita não encontrada!"));

		// Remover o saldo da receita da conta
		accountProxy.subBalance(incomingBalance.getContaId().toString(), incomingBalance.getValor().doubleValue());

		incomingBalanceRepository.delete(incomingBalance);
	}
}

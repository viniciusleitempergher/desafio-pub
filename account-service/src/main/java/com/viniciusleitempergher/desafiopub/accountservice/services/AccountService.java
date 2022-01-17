package com.viniciusleitempergher.desafiopub.accountservice.services;

import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.InvalidEndpointRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.viniciusleitempergher.desafiopub.accountservice.models.Account;
import com.viniciusleitempergher.desafiopub.accountservice.repositories.AccountRepository;
import com.viniciusleitempergher.desafiopub.accountservice.requests.CreateAccountRequest;
import com.viniciusleitempergher.desafiopub.accountservice.responses.AccountCreatedResponse;
import com.viniciusleitempergher.desafiopub.accountservice.responses.BadRequest;
import com.viniciusleitempergher.desafiopub.accountservice.responses.BalanceResponse;
import com.viniciusleitempergher.desafiopub.accountservice.responses.ListAccountsResponse;
import com.viniciusleitempergher.desafiopub.accountservice.responses.NotFound;

@Service("accountService")
public class AccountService {
	@Autowired
	private AccountRepository accountRepository;

	public AccountCreatedResponse createAccount(CreateAccountRequest request) {
		Account account = new Account();
		account.setInstituicaoFinanceira(request.getInstituicaoFinanceira());
		account.setSaldo(BigDecimal.valueOf(0));

		// Validação do tipo da conta
		String tipoConta = request.getTipoConta();

		validateAccountType(tipoConta);

		account.setTipoConta(tipoConta);

		accountRepository.save(account);

		return new AccountCreatedResponse(account.getId().toString());
	}

	public void editAccount(String id, CreateAccountRequest requestData) {
		validateAccountType(requestData.getTipoConta());

		UUID uuid = UUID.fromString(id);

		Account account = accountRepository.findById(uuid).orElseThrow(() -> new NotFound("Conta não encontrada!"));

		account.setInstituicaoFinanceira(requestData.getInstituicaoFinanceira());
		account.setTipoConta(requestData.getTipoConta());

		accountRepository.save(account);
	}

	private void validateAccountType(String tipoConta) {
		if (!tipoConta.equals("carteira") && !tipoConta.equals("conta corrente") && !tipoConta.equals("poupança")) {
			throw new BadRequest("Tipo de conta inválido!");
		}
	}

	public void removeAccount(String id) {
		UUID uuid = UUID.fromString(id);

		Account account = accountRepository.findById(uuid).orElseThrow(() -> new NotFound("Conta não encontrada!"));

		accountRepository.delete(account);
	}

	public ListAccountsResponse listAccounts() {
		ListAccountsResponse response = new ListAccountsResponse();

		response.setAccounts(accountRepository.findAll());

		return response;
	}

	public BalanceResponse listTotalBalance() {
		BigDecimal totalBalance = BigDecimal.valueOf(0);

		for (Account account : accountRepository.findAll()) {
			totalBalance = totalBalance.add(account.getSaldo());
		}

		BalanceResponse response = new BalanceResponse();

		response.setSaldoTotal(totalBalance);

		return response;
	}

	public void transferBalance(String from, String to, double balance) {
		Account accountSender = accountRepository.findById(UUID.fromString(from))
				.orElseThrow(() -> new NotFound("Conta não encontrada!"));
		Account accountReceiver = accountRepository.findById(UUID.fromString(to))
				.orElseThrow(() -> new NotFound("Conta não encontrada!"));

		// Validar se o remetente tem saldo para efetuar a transação
		if (accountSender.getSaldo().compareTo(BigDecimal.valueOf(balance)) != 1
				&& accountSender.getSaldo().compareTo(BigDecimal.valueOf(balance)) != 0) {
			throw new BadRequest("Esta conta não tem saldo para essa transação!");
		}

		accountSender.setSaldo(accountSender.getSaldo().subtract(BigDecimal.valueOf(balance)));
		accountReceiver.setSaldo(accountReceiver.getSaldo().add(BigDecimal.valueOf(balance)));

		accountRepository.save(accountSender);
		accountRepository.save(accountReceiver);
	}
}

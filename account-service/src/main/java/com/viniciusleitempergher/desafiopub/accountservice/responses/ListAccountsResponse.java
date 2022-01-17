package com.viniciusleitempergher.desafiopub.accountservice.responses;

import java.util.List;

import com.viniciusleitempergher.desafiopub.accountservice.models.Account;

public class ListAccountsResponse {
	private List<Account> accounts;
	
	public ListAccountsResponse() {
		super();
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
}

package com.viniciusleitempergher.desafiopub.accountservice.responses;

public class AccountCreatedResponse {
	private String id;

	public AccountCreatedResponse(String id) {
		super();
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}

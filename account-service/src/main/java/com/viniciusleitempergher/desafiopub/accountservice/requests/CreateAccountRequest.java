package com.viniciusleitempergher.desafiopub.accountservice.requests;

public class CreateAccountRequest {
	private String tipoConta;
	private String instituicaoFinanceira;

	public CreateAccountRequest() {
		super();
	}

	public String getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(String tipoConta) {
		this.tipoConta = tipoConta;
	}

	public String getInstituicaoFinanceira() {
		return instituicaoFinanceira;
	}

	public void setInstituicaoFinanceira(String instituicaoFinanceira) {
		this.instituicaoFinanceira = instituicaoFinanceira;
	}
}

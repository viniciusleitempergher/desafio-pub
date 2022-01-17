package com.viniciusleitempergher.desafiopub.accountservice.responses;

import java.math.BigDecimal;

public class BalanceResponse {
	private BigDecimal saldoTotal;

	public BalanceResponse() {
		super();
	}

	public BigDecimal getSaldoTotal() {
		return saldoTotal;
	}

	public void setSaldoTotal(BigDecimal saldoTotal) {
		this.saldoTotal = saldoTotal;
	}

}

package com.viniciusleitempergher.desafiopub.expendingbalanceservice.responses;

import java.math.BigDecimal;

public class BalanceResponse {
	private BigDecimal totalReceitas;

	public BalanceResponse() {
		super();
	}

	public BigDecimal getSaldoTotal() {
		return totalReceitas;
	}

	public void setSaldoTotal(BigDecimal totalDespesas) {
		this.totalReceitas = totalDespesas;
	}

}

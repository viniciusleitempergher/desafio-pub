package com.viniciusleitempergher.desafiopub.expendingbalanceservice.requests;

import java.math.BigDecimal;
import java.util.UUID;

public class CreateExpendingBalanceRequest {
	private BigDecimal valor;
	private String dataPagamento;
	private String dataPagamentoEsperado;
	private String tipoDespesa;
	private UUID contaId;

	public CreateExpendingBalanceRequest() {
		super();
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(String dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public String getDataPagamentoEsperado() {
		return dataPagamentoEsperado;
	}

	public void setDataPagamentoEsperado(String dataPagamentoEsperado) {
		this.dataPagamentoEsperado = dataPagamentoEsperado;
	}

	public String getTipoDespesa() {
		return tipoDespesa;
	}

	public void setTipoDespesa(String tipoDespesa) {
		this.tipoDespesa = tipoDespesa;
	}

	public UUID getContaId() {
		return contaId;
	}

	public void setContaId(UUID contaId) {
		this.contaId = contaId;
	}

}

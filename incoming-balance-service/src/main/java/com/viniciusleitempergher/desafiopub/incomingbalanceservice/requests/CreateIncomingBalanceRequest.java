package com.viniciusleitempergher.desafiopub.incomingbalanceservice.requests;

import java.math.BigDecimal;
import java.util.UUID;

public class CreateIncomingBalanceRequest {
	private BigDecimal valor;
	private String dataRecebimento;
	private String dataRecebimentoEsperado;
	private String descricao;
	private String tipoReceita;
	private UUID contaId;

	public CreateIncomingBalanceRequest() {
		super();
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getDataRecebimento() {
		return dataRecebimento;
	}

	public void setDataRecebimento(String dataRecebimento) {
		this.dataRecebimento = dataRecebimento;
	}

	public String getDataRecebimentoEsperado() {
		return dataRecebimentoEsperado;
	}

	public void setDataRecebimentoEsperado(String dataRecebimentoEsperado) {
		this.dataRecebimentoEsperado = dataRecebimentoEsperado;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTipoReceita() {
		return tipoReceita;
	}

	public void setTipoReceita(String tipoReceita) {
		this.tipoReceita = tipoReceita;
	}

	public UUID getContaId() {
		return contaId;
	}

	public void setContaId(UUID contaId) {
		this.contaId = contaId;
	}
}

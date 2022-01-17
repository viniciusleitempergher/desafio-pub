package com.viniciusleitempergher.desafiopub.incomingbalanceservice.models;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.Type;

@Entity
public class IncomingBalance {
	@Id
	@GeneratedValue(generator = "uuid4")
	@Type(type = "org.hibernate.type.PostgresUUIDType")
	@Column(name = "id", updatable = false, unique = true, nullable = false, columnDefinition = "uuid")
	private UUID id;

	private BigDecimal valor;
	private Date dataRecebimento;
	private Date dataRecebimentoEsperado;
	private String descricao;
	private String tipoReceita;
	private UUID contaId;

	public IncomingBalance() {
		super();
	}

	public IncomingBalance(BigDecimal valor, Date dataRecebimento, Date dataRecebimentoEsperado, String descricao,
			String tipoReceita, UUID contaId) {
		super();
		this.valor = valor;
		this.dataRecebimento = dataRecebimento;
		this.dataRecebimentoEsperado = dataRecebimentoEsperado;
		this.descricao = descricao;
		this.tipoReceita = tipoReceita;
		this.contaId = contaId;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Date getDataRecebimento() {
		return dataRecebimento;
	}

	public void setDataRecebimento(Date dataRecebimento) {
		this.dataRecebimento = dataRecebimento;
	}

	public Date getDataRecebimentoEsperado() {
		return dataRecebimentoEsperado;
	}

	public void setDataRecebimentoEsperado(Date dataRecebimentoEsperado) {
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

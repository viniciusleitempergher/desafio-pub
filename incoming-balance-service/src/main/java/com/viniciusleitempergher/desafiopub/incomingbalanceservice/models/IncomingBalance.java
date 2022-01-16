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
}



package com.viniciusleitempergher.desafiopub.incomingbalanceservice.repositories;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.viniciusleitempergher.desafiopub.incomingbalanceservice.models.IncomingBalance;

public interface IncomingBalanceRepository extends JpaRepository<IncomingBalance, UUID> {
	List<IncomingBalance> findAllByDataRecebimentoLessThanEqualAndDataRecebimentoGreaterThanEqualAndTipoReceitaEquals(
			Date endDate, Date startDate, String tipoReceita);

}

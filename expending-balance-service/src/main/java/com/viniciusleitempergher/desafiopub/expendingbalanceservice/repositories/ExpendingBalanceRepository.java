package com.viniciusleitempergher.desafiopub.expendingbalanceservice.repositories;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.viniciusleitempergher.desafiopub.expendingbalanceservice.models.ExpendingBalance;

public interface ExpendingBalanceRepository extends JpaRepository<ExpendingBalance, UUID> {
	List<ExpendingBalance> findAllByDataPagamentoLessThanEqualAndDataPagamentoGreaterThanEqualAndTipoDespesaEquals(
			Date endDate, Date startDate, String tipoReceita);
}

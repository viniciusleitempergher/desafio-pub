package com.viniciusleitempergher.desafiopub.expendingbalanceservice.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.viniciusleitempergher.desafiopub.expendingbalanceservice.models.ExpendingBalance;

public interface ExpendingBalanceRepository extends JpaRepository<ExpendingBalance, UUID> {

}

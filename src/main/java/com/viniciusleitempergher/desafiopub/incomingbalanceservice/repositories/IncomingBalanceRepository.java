package com.viniciusleitempergher.desafiopub.incomingbalanceservice.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.viniciusleitempergher.desafiopub.incomingbalanceservice.models.IncomingBalance;

public interface IncomingBalanceRepository extends JpaRepository<IncomingBalance, UUID> {

}

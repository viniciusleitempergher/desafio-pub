package com.viniciusleitempergher.desafiopub.accountservice.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.viniciusleitempergher.desafiopub.accountservice.models.Account;

public interface AccountRepository extends JpaRepository<Account, UUID> {

}

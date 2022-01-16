package com.viniciusleitempergher.desafiopub.expendingbalanceservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ExpendingBalanceServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpendingBalanceServiceApplication.class, args);
	}

}

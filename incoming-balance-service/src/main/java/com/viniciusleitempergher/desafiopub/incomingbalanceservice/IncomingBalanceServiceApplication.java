package com.viniciusleitempergher.desafiopub.incomingbalanceservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class IncomingBalanceServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(IncomingBalanceServiceApplication.class, args);
	}

}

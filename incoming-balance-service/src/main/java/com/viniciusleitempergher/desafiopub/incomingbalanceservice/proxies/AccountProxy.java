package com.viniciusleitempergher.desafiopub.incomingbalanceservice.proxies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "account-service")
public interface AccountProxy {
	
	@PutMapping("account-service/account/add/{target}/balance/{balance}")
	public void addBalance(@PathVariable String target, @PathVariable double balance);

}

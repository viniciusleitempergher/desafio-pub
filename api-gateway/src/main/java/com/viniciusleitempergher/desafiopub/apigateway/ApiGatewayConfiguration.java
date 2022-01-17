package com.viniciusleitempergher.desafiopub.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {

		return builder.routes().route(p -> p.path("/account-service/**").uri("lb://account-service"))
				.route(p -> p.path("/expending-balance-service/**").uri("lb://expending-balance-service"))
				.route(p -> p.path("/incoming-balance-service/**").uri("lb://incoming-balance-service")).build();
	}

}

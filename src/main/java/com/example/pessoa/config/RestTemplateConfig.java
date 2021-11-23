package com.example.pessoa.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

	// Configura todas vez que instanciamos um restTemplate! Pega o Bean

	@Bean
	public RestTemplate restConfiguration(RestTemplateBuilder builder) {
		return builder.build();
	}
}

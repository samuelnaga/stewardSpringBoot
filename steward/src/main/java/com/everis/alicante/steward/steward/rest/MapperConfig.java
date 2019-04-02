package com.everis.alicante.steward.steward.rest;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
	
	@Bean
	public DozerBeanMapper getDozerMapper() {
		return new DozerBeanMapper();
	}

}

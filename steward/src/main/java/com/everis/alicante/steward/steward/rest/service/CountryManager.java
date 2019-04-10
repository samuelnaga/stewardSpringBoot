package com.everis.alicante.steward.steward.rest.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.alicante.steward.steward.persistence.entity.Country;
import com.everis.alicante.steward.steward.persistence.repository.CountryRepository;

@Service
public class CountryManager extends AbstractManager<Country, Long>{

	@Autowired
	private CountryRepository countryRepository;
	
	@Override
	CountryRepository getRepository() {
		return countryRepository;
	}
	
	public Iterable<Country> findByName(String name) {
		return this.getRepository().findByName(name);
	}
	
	public Iterable<Country> findAllOrderByName() {
		return this.getRepository().findAllByOrderByNameAsc();
	}
	
}

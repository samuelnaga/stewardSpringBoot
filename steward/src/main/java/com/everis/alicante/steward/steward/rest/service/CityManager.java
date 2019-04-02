package com.everis.alicante.steward.steward.rest.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.alicante.steward.steward.persistence.entity.City;
import com.everis.alicante.steward.steward.persistence.repository.CityRepository;

@Service
public class CityManager extends AbstractManager<City, Long>{

	@Autowired
	private CityRepository cityRepository;
	
	@Override
	CityRepository getRepository() {
		return cityRepository;
	}
	
	public Iterable<City> findByName(String name) {
		return this.getRepository().findByName(name);
	}
}

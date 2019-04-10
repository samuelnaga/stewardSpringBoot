package com.everis.alicante.steward.steward.persistence.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.everis.alicante.steward.steward.persistence.entity.Country;

public interface CountryRepository extends CrudRepository<Country, Long> {

	Iterable<Country> findByName(String name);

	Iterable<Country> findAllByOrderByNameAsc();
	// findBy
	// countBy
	// deleteBY
}

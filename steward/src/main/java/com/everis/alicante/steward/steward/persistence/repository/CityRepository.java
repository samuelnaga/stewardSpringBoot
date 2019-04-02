package com.everis.alicante.steward.steward.persistence.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.everis.alicante.steward.steward.persistence.entity.Building;
import com.everis.alicante.steward.steward.persistence.entity.City;
import com.everis.alicante.steward.steward.persistence.entity.Country;

public interface CityRepository extends CrudRepository<City, Long>{

	Iterable<City> findByName(String name);
}

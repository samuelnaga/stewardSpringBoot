package com.everis.alicante.steward.steward.persistence.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.everis.alicante.steward.steward.persistence.entity.Building;

public interface BuildingRepository extends CrudRepository<Building, Long>{

	Iterable<Building> findByName(String name);
}

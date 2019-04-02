package com.everis.alicante.steward.steward.persistence.repository;

import org.springframework.data.repository.CrudRepository;

import com.everis.alicante.steward.steward.persistence.entity.Workplace;

public interface WorkplaceRepository extends CrudRepository<Workplace, Long> {

	//Optional<Iterable<Workplace>> findBy();
	
	Iterable<Workplace> findByNumber(int number);
}

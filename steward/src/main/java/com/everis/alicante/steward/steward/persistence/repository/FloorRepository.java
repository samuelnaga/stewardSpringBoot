package com.everis.alicante.steward.steward.persistence.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.everis.alicante.steward.steward.persistence.entity.Floor;

public interface FloorRepository extends CrudRepository<Floor, Long>{

	Iterable<Floor> findByNumber(int number);
}

package com.everis.alicante.steward.steward.rest.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.alicante.steward.steward.persistence.entity.Floor;
import com.everis.alicante.steward.steward.persistence.repository.FloorRepository;

@Service
public class FloorManager extends AbstractManager<Floor, Long>{

	@Autowired
	private FloorRepository floorRepository;
	
	@Override
	FloorRepository getRepository() {
		return floorRepository;
	}
	
	public Iterable<Floor> findByNumber(int number) {
		return this.getRepository().findByNumber(number);
	}

}

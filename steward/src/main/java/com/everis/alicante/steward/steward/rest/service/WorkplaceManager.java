package com.everis.alicante.steward.steward.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.alicante.steward.steward.persistence.entity.Workplace;
import com.everis.alicante.steward.steward.persistence.repository.WorkplaceRepository;

@Service
public class WorkplaceManager extends AbstractManager<Workplace, Long>{

	@Autowired
	private WorkplaceRepository workplaceRepository;
	
	@Override
	WorkplaceRepository getRepository() {
		return workplaceRepository;
	}
	
	public Iterable<Workplace> findByNumber(int number) {
		return this.getRepository().findByNumber(number);
	}

}

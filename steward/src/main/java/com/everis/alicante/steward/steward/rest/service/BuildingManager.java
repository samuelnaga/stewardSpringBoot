package com.everis.alicante.steward.steward.rest.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.alicante.steward.steward.persistence.entity.Building;
import com.everis.alicante.steward.steward.persistence.repository.BuildingRepository;

@Service
public class BuildingManager extends AbstractManager<Building, Long> {

	@Autowired
	private BuildingRepository buildingRepository;

	public Iterable<Building> findByName(String name) {
		return this.getRepository().findByName(name);
	}

	@Override
	BuildingRepository getRepository() {
		return buildingRepository;
	}

}

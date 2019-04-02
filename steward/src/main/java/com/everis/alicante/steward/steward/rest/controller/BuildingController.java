package com.everis.alicante.steward.steward.rest.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.everis.alicante.steward.steward.persistence.dto.CityDTO;
import com.everis.alicante.steward.steward.persistence.dto.BuildingDTO;
import com.everis.alicante.steward.steward.persistence.dto.FloorDTO;
import com.everis.alicante.steward.steward.persistence.entity.Building;
import com.everis.alicante.steward.steward.persistence.entity.Building_;
import com.everis.alicante.steward.steward.rest.service.BuildingManager;

@RestController
public class BuildingController {

	@Autowired
	private BuildingManager manager;

	@Autowired
	private DozerBeanMapper mapper;
	
	@GetMapping("/buildings")
	public List<BuildingDTO> findAllBuildings(@RequestParam(value = "name", required = false) String name) {
		if(StringUtils.isEmpty(name)) {
			return this.manager.findAll().stream().map(building -> (BuildingDTO) mapper.map(building, BuildingDTO.class))
					.collect(Collectors.toList());
		} else {
			return StreamSupport.stream(this.manager.findByName(name).spliterator(), false).map(building -> (BuildingDTO) mapper.map(building, BuildingDTO.class)).collect(Collectors.toList());
		}
	}

	@GetMapping("/buildings/{id}")
	public BuildingDTO findBuilding(@PathVariable("id") Long id) {
		return mapper.map(
					this.manager.findById(id)
					.orElseThrow(() -> new IllegalArgumentException(String.format("The element[%s] does not exist", id))),
					BuildingDTO.class);
	}
	
	@GetMapping("/buildings/{id}/floors")
	public List<FloorDTO> getFloorsForBuilding(@PathVariable("id") Long id) {
		return this.manager.findById(id)
				.get().getFloors().stream()
				.map(floor -> (FloorDTO) mapper.map(floor, FloorDTO.class))
				.collect(Collectors.toList());
	}

	@PostMapping("/buildings")
	public BuildingDTO save(@RequestBody BuildingDTO building) {
		return mapper.map(this.manager.save(mapper.map(building, Building.class)), BuildingDTO.class);
	}

	@DeleteMapping("/buildings/{id}")
	public void delete(@PathVariable("id") Long id) {
		this.manager.deleteById(id);
	}
	
	@PutMapping("/buildings/{id}")
	public BuildingDTO update(@PathVariable("id") Long id,  @RequestBody BuildingDTO building) {
		return mapper.map(this.manager.findById(id)
				.map(buildingFromDB -> this.replaceBuildingValues(building, buildingFromDB))
				.map(buildingFromDBreplaced -> this.manager.save(buildingFromDBreplaced))
				.orElseThrow(() -> new IllegalArgumentException(String.format("The element[%s] does not exist", id))),
				BuildingDTO.class);
	}
	
	private Building replaceBuildingValues(final BuildingDTO origin, final Building target) {
		BeanUtils.copyProperties(origin, target, Building_.id.getName(), Building_.creationDate.getName());
		return target;
	}
	
	@GetMapping("/buildings/{id}/city")
	public CityDTO getCityOfBuilding(@PathVariable("id") Long id) {
		return mapper.map(this.manager.findById(id).get().getCity(), CityDTO.class);
	}
}

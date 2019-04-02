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

import com.everis.alicante.steward.steward.persistence.dto.BuildingDTO;
import com.everis.alicante.steward.steward.persistence.dto.FloorDTO;
import com.everis.alicante.steward.steward.persistence.dto.WorkplaceDTO;
import com.everis.alicante.steward.steward.persistence.entity.Floor;
import com.everis.alicante.steward.steward.persistence.entity.Floor_;
import com.everis.alicante.steward.steward.rest.service.FloorManager;

@RestController
public class FloorController {

	@Autowired
	private FloorManager manager;

	@Autowired
	private DozerBeanMapper mapper;
	
	@GetMapping("/floors")
	public List<FloorDTO> findAllBuildings(@RequestParam(value = "number", required = false) Integer number) {
		if (number == null) {
			return this.manager.findAll().stream().map(floor -> (FloorDTO) mapper.map(floor, FloorDTO.class))
					.collect(Collectors.toList());
		} else {
			return StreamSupport.stream(this.manager.findByNumber(number).spliterator(), false).map(floor -> (FloorDTO) mapper.map(floor, FloorDTO.class)).collect(Collectors.toList());
		}
	}

	@GetMapping("/floors/{id}")
	public FloorDTO findFloor(@PathVariable("id") Long id) {
		return mapper.map(this.manager.findById(id)
				.orElseThrow(() -> new IllegalArgumentException(String.format("The element[%s] does not exist", id))),
				FloorDTO.class);
	}
	
	@GetMapping("/floors/{id}/workplaces")
	public List<WorkplaceDTO> getWorkplacesForFloor(@PathVariable("id") Long id) {
		return this.manager.findById(id)
				.get().getWorkplaces().stream()
				.map(workplace -> (WorkplaceDTO) mapper.map(workplace, WorkplaceDTO.class))
				.collect(Collectors.toList());
	}

	@PostMapping("/floors")
	public FloorDTO save(@RequestBody FloorDTO floor) {
		return mapper.map(this.manager.save(mapper.map(floor, Floor.class)), FloorDTO.class);
	}

	@DeleteMapping("/floors/{id}")
	public void delete(@PathVariable("id") Long id) {
		this.manager.deleteById(id);
	}
	
	@PutMapping("/floors/{id}")
	public FloorDTO update(@PathVariable("id") Long id,  @RequestBody FloorDTO floor) {
		return mapper.map(this.manager.findById(id)
				.map(eFromDB -> this.replaceFloorValues(floor, eFromDB))
				.map(eFromDBreplaced -> this.manager.save(eFromDBreplaced))
				.orElseThrow(() -> new IllegalArgumentException(String.format("The element[%s] does not exist", id))),
				FloorDTO.class);
	}
	
	private Floor replaceFloorValues(final FloorDTO origin, final Floor target) {
		BeanUtils.copyProperties(origin, target, Floor_.id.getName(), Floor_.creationDate.getName());
		return target;
	}
	
	@GetMapping("/floors/{id}/building")
	public BuildingDTO getBuildingOfFloor(@PathVariable("id") Long id) {
		return mapper.map(this.manager.findById(id).get().getBuilding(), BuildingDTO.class);
	}
}


package com.everis.alicante.steward.steward.rest.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.everis.alicante.steward.steward.persistence.dto.FloorDTO;
import com.everis.alicante.steward.steward.persistence.dto.WorkplaceDTO;
import com.everis.alicante.steward.steward.persistence.entity.Workplace;
import com.everis.alicante.steward.steward.persistence.entity.Workplace_;
import com.everis.alicante.steward.steward.rest.service.WorkplaceManager;

@RestController
public class WorkplaceController {

	@Autowired
	private WorkplaceManager manager;

	@Autowired
	private DozerBeanMapper mapper;
	
	@GetMapping("/workplaces")
	public List<WorkplaceDTO> findAllBuildings(@RequestParam(value = "number", required = false) Integer number) {
		if (number == null) {
			return this.manager.findAll().stream().map(Workplace -> (WorkplaceDTO) mapper.map(Workplace, WorkplaceDTO.class))
					.collect(Collectors.toList());
		} else {
			return StreamSupport.stream(this.manager.findByNumber(number).spliterator(), false).map(Workplace -> (WorkplaceDTO) mapper.map(Workplace, WorkplaceDTO.class)).collect(Collectors.toList());
		}
	}
	
	@GetMapping("/workplaces/{id}")
	public WorkplaceDTO findFloor(@PathVariable("id") Long id) {
		return mapper.map(this.manager.findById(id)
				.orElseThrow(() -> new IllegalArgumentException(String.format("The element[%s] does not exist", id))),
				WorkplaceDTO.class);
	}
	
	@PostMapping("/workplaces")
	public WorkplaceDTO save(@RequestBody WorkplaceDTO workplace) {
		return mapper.map(this.manager.save(mapper.map(workplace, Workplace.class)), WorkplaceDTO.class);
	}

	@DeleteMapping("/workplaces/{id}")
	public void delete(@PathVariable("id") Long id) {
		this.manager.deleteById(id);
	}
	
	@PutMapping("/workplaces/{id}")
	public WorkplaceDTO update(@PathVariable("id") Long id,  @RequestBody WorkplaceDTO workplace) {
		return mapper.map(this.manager.findById(id)
				.map(e -> this.replaceWorkplaceValues(workplace, e))
				.map(e -> this.manager.save(e))
				.orElseThrow(() -> new IllegalArgumentException(String.format("The element[%s] does not exist", id))),
				WorkplaceDTO.class);
	}
	
	private Workplace replaceWorkplaceValues(final WorkplaceDTO origin, final Workplace target) {
		BeanUtils.copyProperties(origin, target, Workplace_.id.getName(), Workplace_.creationDate.getName());
		return target;
	}
	
	@GetMapping("/workplaces/{id}/floor")
	public FloorDTO getFloorOfWorkplace(@PathVariable("id") Long id) {
		return mapper.map(this.manager.findById(id).get().getFloor(), FloorDTO.class);
	}
}

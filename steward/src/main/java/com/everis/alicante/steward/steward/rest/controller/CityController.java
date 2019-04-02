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
import com.everis.alicante.steward.steward.persistence.dto.CountryDTO;
import com.everis.alicante.steward.steward.persistence.dto.CityDTO;
import com.everis.alicante.steward.steward.persistence.entity.City;
import com.everis.alicante.steward.steward.persistence.entity.City_;
import com.everis.alicante.steward.steward.rest.service.CityManager;

@RestController
//@RequestMapping("/cities")
public class CityController {

	@Autowired
	private CityManager manager;

	@Autowired
	private DozerBeanMapper mapper;
	
	
	@GetMapping("/cities")
	public List<CityDTO> findAllCities(@RequestParam(value = "name", required = false) String name) {
		if(StringUtils.isEmpty(name)) {
			return this.manager.findAll().stream().map(city -> (CityDTO) mapper.map(city, CityDTO.class))
					.collect(Collectors.toList());
		} else {
			return StreamSupport.stream(this.manager.findByName(name).spliterator(), false).map(city -> (CityDTO) mapper.map(city, CityDTO.class)).collect(Collectors.toList());
		}
	}
	
	@GetMapping("/cities/{id}")
	public CityDTO findCity(@PathVariable("id") Long id) {
		return mapper.map(
				this.manager.findById(id)
				.orElseThrow(() -> new IllegalArgumentException(String.format("The element[%s] does not exist", id))),
				CityDTO.class);
	}
	
	@GetMapping("/cities/{id}/buildings")
	public List<BuildingDTO> getBuildingsForCity(@PathVariable("id") Long id) {
		return this.manager.findById(id)
				.get().getBuildings().stream()
				.map(building -> (BuildingDTO) mapper.map(building, BuildingDTO.class))
				.collect(Collectors.toList());
	}
	
	@GetMapping("/cities/{id}/country")
	public CountryDTO getCountryOfCity(@PathVariable("id") Long id) {
		return mapper.map(this.manager.findById(id).get().getCountry(), CountryDTO.class);
	}

	@PostMapping("/cities")
	public CityDTO save(@RequestBody CityDTO city) {
		return mapper.map(this.manager.save(mapper.map(city, City.class)), CityDTO.class);
	}
	
	@PutMapping("/cities/{id}")
	public CityDTO update(@PathVariable("id") Long id,  @RequestBody CityDTO city) {
		return mapper.map(
				this.manager.findById(id)
				.map(cityFromDB -> this.replaceCityValues(city, cityFromDB))
				.map(cityFromDBreplaced -> this.manager.save(cityFromDBreplaced))
				.orElseThrow(() -> new IllegalArgumentException(String.format("The element[%s] does not exist", id))), 
				CityDTO.class);
	}
	
	private City replaceCityValues(final CityDTO origin, final City target) {
		BeanUtils.copyProperties(origin, target, City_.id.getName(), City_.creationDate.getName());
		return target;
	}

	@DeleteMapping("/cities/{id}")
	public void delete(@PathVariable("id") Long id) {
		this.manager.deleteById(id);
	}
	

}

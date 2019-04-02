package com.everis.alicante.steward.steward.rest.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.everis.alicante.steward.steward.persistence.dto.CityDTO;
import com.everis.alicante.steward.steward.persistence.dto.CountryDTO;
import com.everis.alicante.steward.steward.persistence.entity.Country;
import com.everis.alicante.steward.steward.persistence.entity.Country_;
import com.everis.alicante.steward.steward.rest.service.CountryManager;

@RestController
public class CountryController {

	@Autowired
	private CountryManager manager;

	@Autowired
	private DozerBeanMapper mapper;

	//@CrossOrigin
	@GetMapping("/countries")
	public List<CountryDTO> findAllCountries(@RequestParam(value = "name", required = false) String name) {
		if (StringUtils.isEmpty(name)) {
			return this.manager.findAll().stream().map(country -> (CountryDTO) mapper.map(country, CountryDTO.class))
					.collect(Collectors.toList());
		} else {
			return StreamSupport.stream(this.manager.findByName(name).spliterator(), false).map(country -> (CountryDTO) mapper.map(country, CountryDTO.class)).collect(Collectors.toList());
		}
	}

	@GetMapping("/countries/{id}")
	public CountryDTO findCountry(@PathVariable("id") Long id) {
		return mapper.map(
				this.manager.findById(id).orElseThrow(
						() -> new IllegalArgumentException(String.format("The element[%s] does not exist", id))),
				CountryDTO.class);
	}
	
	@GetMapping("/countries/{id}/cities")
	public List<CityDTO> getCitiesForCountry(@PathVariable("id") Long id) {
		return this.manager.findById(id)
				.get().getCities().stream()
				.map(city -> (CityDTO) mapper.map(city, CityDTO.class))
				.collect(Collectors.toList());
	}

	@PostMapping("/countries")
	public CountryDTO save(@RequestBody CountryDTO country) {
		return mapper.map(this.manager.save(mapper.map(country, Country.class)), CountryDTO.class);
	}

	@PutMapping("/countries/{id}")
	public CountryDTO update(@PathVariable("id") Long id, @RequestBody CountryDTO country) {
		return mapper.map(this.manager.findById(id)
				.map(countryFromDB -> this.replaceCountryValues(country, countryFromDB))
				.map(countryFromDBReplaced -> this.manager.save(countryFromDBReplaced))
				.orElseThrow(() -> new IllegalArgumentException(String.format("The element[%s] does not exist", id))),
				CountryDTO.class);
	}

	private Country replaceCountryValues(final CountryDTO origin, final Country target) {
		BeanUtils.copyProperties(origin, target, Country_.id.getName(), Country_.creationDate.getName());
		return target;
	}

	@DeleteMapping("/countries/{id}")
	public void delete(@PathVariable("id") Long id) {
		this.manager.deleteById(id);
	}

}

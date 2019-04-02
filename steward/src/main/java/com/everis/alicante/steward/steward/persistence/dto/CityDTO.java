package com.everis.alicante.steward.steward.persistence.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.everis.alicante.steward.steward.persistence.entity.Country;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CityDTO extends AuditableDTO {

	@Id
	private Long id;
	@NotNull
	private String name;
	
	@OneToMany(mappedBy="city", fetch=FetchType.EAGER, cascade=CascadeType.ALL, orphanRemoval=true)
	private List<BuildingDTO> buildings;

//	@ManyToOne(fetch=FetchType.LAZY)
//	private CountryDTO country;
}
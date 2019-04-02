package com.everis.alicante.steward.steward.persistence.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CountryDTO extends AuditableDTO{
	
	@Id
    private Long id;
	
	@NotNull
	private String name;
	
	@OneToMany(mappedBy="country", fetch=FetchType.EAGER, cascade=CascadeType.ALL, orphanRemoval=true)
	private List<CityDTO> cities;

}

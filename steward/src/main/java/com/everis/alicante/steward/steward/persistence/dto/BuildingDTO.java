package com.everis.alicante.steward.steward.persistence.dto;

import java.util.List;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BuildingDTO extends AuditableDTO{
	
	@Id
    private Long id;
	
	@NotNull
	private String name;
	
	private List<FloorDTO> floors;
	//private CityDTO city;
}

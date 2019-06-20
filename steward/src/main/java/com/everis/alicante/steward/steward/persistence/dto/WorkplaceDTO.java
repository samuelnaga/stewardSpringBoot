package com.everis.alicante.steward.steward.persistence.dto;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.everis.alicante.steward.steward.persistence.entity.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class WorkplaceDTO extends AuditableDTO {
	
	@Id
    private Long id;
	
	private int number;
	private float coordX;
	private float coordY;
	private int qrcode;
	//private FloorDTO floor;
	
//	@Column(nullable = true)
//	@OneToOne(mappedBy = "workplace")
//	private User user;
}

package com.everis.alicante.steward.steward.persistence.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDTO extends AuditableDTO{

	@Id
    private Long id;
	
	@NotNull
	private String name;
	
	@NotNull
	private String username;
	
	@NotNull
	private String password;
	
	@NotNull
	private Integer rol;
	
//	@Column(nullable = true)
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinTable(name = "user_workplace",
//		joinColumns = { @JoinColumn(name = "user_id", referencedColumnName = "id") },
//		inverseJoinColumns = { @JoinColumn(name = "workplace_id", referencedColumnName = "id") })
//	private Workplace workplace;
}

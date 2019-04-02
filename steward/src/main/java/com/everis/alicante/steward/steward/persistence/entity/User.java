package com.everis.alicante.steward.steward.persistence.entity;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User extends Auditable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String username;
	private String password;
	private Integer rol;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(name = "user_workplace",
		joinColumns = { @JoinColumn(name = "user_id", referencedColumnName = "id") },
		inverseJoinColumns = { @JoinColumn(name = "workplace_id", referencedColumnName = "id") })
	private Workplace workplace;
	
	
	
//	@Column(nullable = true)
//	private Integer workplace = 0;
//	@Column(nullable = true)
//	private Integer floor = 0;
//	@Column(nullable = true)
//	private String building = " ";
//	@Column(nullable = true)
//	private String city = " ";
//	@Column(nullable = true)
//	private String country = " ";
	
}

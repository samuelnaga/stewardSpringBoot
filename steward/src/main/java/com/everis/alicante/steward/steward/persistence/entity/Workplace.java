package com.everis.alicante.steward.steward.persistence.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Workplace extends Auditable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int number;
	private float coordX;
	private float coordY;
	private int qrcode;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Floor floor;
	
	@OneToOne(mappedBy = "workplace", cascade = CascadeType.ALL, orphanRemoval = true)
	private User user;
}
package com.everis.alicante.steward.steward.persistence.entity;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class City extends Auditable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Country country;
	
	@OneToMany(mappedBy="city", fetch=FetchType.EAGER, cascade=CascadeType.ALL, orphanRemoval=true)
	private Set<Building> buildings;
	
	//private Person createdBy;
	//private Person updatedBy;
	
	
//	public City() {}
//
//	public City(String name, Country country, Date creationDate, Date updatingDate/*, Person createdBy, Person updatedBy*/) {
//		this.name = name;
//		this.country = country;
//		//this.createdBy = createdBy;
//		this.creationDate = creationDate;
//		//this.updatedBy = updatedBy;
//		this.updatingDate = updatingDate;
//	}
	
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public Country getCountry() {
//		return country;
//	}
//
//	public void setCountry(Country country) {
//		this.country = country;
//	}

//	public Person getCreatedBy() {
//		return createdBy;
//	}

//	public void setCreatedBy(Person createdBy) {
//		this.createdBy = createdBy;
//	}

//	public Date getCreationDate() {
//		return creationDate;
//	}
//
//	public void setCreationDate(Date creationDate) {
//		this.creationDate = creationDate;
//	}
	
//	public Person getUpdatedBy() {
//		return updatedBy;
//	}
//
//	public void setUpdatedBy(Person updatedBy) {
//		this.updatedBy = updatedBy;
//	}
//	
//	public Date getUpdatingDate() {
//		return updatingDate;
//	}
//
//	public void setUpdatingDate(Date updatingDate) {
//		this.updatingDate = updatingDate;
//	}
	
}
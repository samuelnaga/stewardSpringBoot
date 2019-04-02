package com.everis.alicante.steward.steward.rest.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.everis.alicante.steward.steward.persistence.entity.Auditable;
import com.everis.alicante.steward.steward.persistence.entity.Country;

public abstract class AbstractManager <T extends Auditable, ID extends Serializable> {

	abstract CrudRepository<T, ID> getRepository();
	
	public List<T> findAll() {
		return (List<T>) this.getRepository().findAll();
	}
	
	public Optional<T> findById(ID id) {
		return this.getRepository().findById(id);
	}
	
	public T save(T entity) {
		return this.getRepository().save(entity);
	}
	
	public void deleteById(ID id) {
		this.getRepository().deleteById(id);
	}
	
	
	//public List<T> findCities(ID id) {
		//return this.getRepository.findById(id).get().getCities().stream().collect(Collectors.toList());
				
	//}
}

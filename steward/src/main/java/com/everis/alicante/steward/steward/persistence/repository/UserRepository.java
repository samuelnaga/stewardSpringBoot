package com.everis.alicante.steward.steward.persistence.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.everis.alicante.steward.steward.persistence.entity.User;

public interface UserRepository extends CrudRepository<User, Long>{
	Iterable<User> findByUsername(String username);
}

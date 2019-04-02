package com.everis.alicante.steward.steward.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.alicante.steward.steward.persistence.entity.User;
import com.everis.alicante.steward.steward.persistence.repository.UserRepository;

@Service
public class UserManager  extends AbstractManager<User, Long>{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	UserRepository getRepository() {
		return userRepository;
	}
	
	public Iterable<User> findByUsername(String username) {
		return this.getRepository().findByUsername(username);
	}
}

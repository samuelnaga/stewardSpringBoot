package com.everis.alicante.steward.steward.rest.controller;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.everis.alicante.steward.steward.persistence.dto.CityDTO;
import com.everis.alicante.steward.steward.persistence.dto.CountryDTO;
import com.everis.alicante.steward.steward.persistence.dto.FloorDTO;
import com.everis.alicante.steward.steward.persistence.dto.BuildingDTO;
import com.everis.alicante.steward.steward.persistence.dto.WorkplaceDTO;
import com.everis.alicante.steward.steward.persistence.dto.UserDTO;
import com.everis.alicante.steward.steward.persistence.entity.User;
import com.everis.alicante.steward.steward.rest.service.UserManager;

@RestController
public class UserController {

	@Autowired
	private UserManager manager;

	@Autowired
	private DozerBeanMapper mapper;
	
	//@CrossOrigin(origins = "http://localhost:8080")
	@GetMapping("/users")
	public List<UserDTO> findAllUsers(@RequestParam(value = "username", required = false) String username) {
		if(StringUtils.isEmpty(username)) {
			return this.manager.findAll().stream().map(user -> (UserDTO) mapper.map(user, UserDTO.class))
					.collect(Collectors.toList());
		} else {
			return StreamSupport.stream(this.manager.findByUsername(username).spliterator(), false).map(user -> (UserDTO) mapper.map(user, UserDTO.class)).collect(Collectors.toList());
		}
	}
	
	@GetMapping("/users/login")
	public UserDTO login(@RequestParam(value = "username", required = false) String username,
						 @RequestParam(value = "password", required = false) String password) {
		
		if(!StringUtils.isEmpty(username) && !StringUtils.isEmpty(password)) {
			List<UserDTO> list = StreamSupport.stream(this.manager.findByUsername(username).spliterator(), false).map(user -> (UserDTO) mapper.map(user, UserDTO.class)).collect(Collectors.toList());
			for (UserDTO usr : list) {
				if (usr.getUsername().contentEquals(username) && usr.getPassword().contentEquals(password)) {
					return usr;
				}
			}
		}
		
		return null;
	}
	
	@GetMapping("/users/{id}")
	public UserDTO findUser(@PathVariable("id") Long id) {
		return mapper.map(
				this.manager.findById(id)
				.orElseThrow(() -> new IllegalArgumentException(String.format("The element[%s] does not exist", id))),
				UserDTO.class);
	}
	
	@GetMapping("/users/{id}/workplace")
	public WorkplaceDTO getWorkplaceOfUser(@PathVariable("id") Long id) {
		return mapper.map(this.manager.findById(id).get().getWorkplace(), WorkplaceDTO.class);
	}
	
//	@GetMapping("/users/{id}/location")
//	public LocationDTO getLocationOfUser(@PathVariable("id") Long id) {
//		LocationDTO location = new LocationDTO();
//		
//		location.setWorkplace(this.getWorkplaceOfUser(id).getNumber());
//		location.setFloor();
//		return location;
//	}
	
}

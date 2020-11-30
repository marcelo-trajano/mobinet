package com.telefonica.mobinet.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telefonica.mobinet.model.User;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
	
	private static final List<User> USERS = Arrays.asList(new User(1, "Marcelo"), new User(2, "Nelson"));

	
	@GetMapping(path = "{id}") 
	public User getUser(@PathVariable("id") int id) throws IllegalAccessException {
		
		return USERS.stream().filter(user -> id == user.getId())
				.findFirst().orElseThrow(()-> new IllegalAccessException("User not found!"));
		
	}

}

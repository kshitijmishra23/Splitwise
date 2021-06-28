package com.splitwise.controller;

import com.splitwise.exceptions.UserAlreadyExistsException;
import com.splitwise.model.User;
import com.splitwise.repositories.IUserRepo;

public class UserController {
	private IUserRepo userRepository;
	
	public UserController(IUserRepo ur) {
		this.userRepository = ur;
	}
	
	
	public User registerUser(String userName, String password, String phNo) {
		User user = userRepository.saveUser(userName, password, phNo);
		
		return user;
	
	}

}

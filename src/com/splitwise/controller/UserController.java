package com.splitwise.controller;

import com.splitwise.model.User;
import com.splitwise.repositories.IUserRepo;
import com.splitwise.repositories.UserInMemoryRepository;

public class UserController {
	private IUserRepo userRepository;
	
	public UserController(IUserRepo ur) {
		this.userRepository = ur;
	}
	
	
	public User registerUser(String userName, String password, String phNo) {
		//check if a user with the same username is present or not
		UserInMemoryRepository ur = new UserInMemoryRepository();
		ur.findByUserName(userName);
		//if yes throw exception
		//else add the user to the user repository
		return null;
	}

}

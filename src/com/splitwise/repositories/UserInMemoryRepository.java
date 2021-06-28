package com.splitwise.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import com.splitwise.exceptions.UserAlreadyExistsException;
import com.splitwise.model.User;

public class UserInMemoryRepository implements IUserRepo{
	
	HashMap<Long, User> idToUserMap;
	HashMap<String, User> userNametoUserMap;
	
	
	public User findById(Long id) {
		return null;
	}
	
	public User findByUserName(String userName) {
		return null;
	}

	@Override
	public Set<User> getUsers(List<String> participants) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isUserPresent(String userName) {
		return userNametoUserMap.containsKey(userName);
	}

	@Override
	public User saveUser(User u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User saveUser(String userName, String password, String phNo) {
		if(isUserPresent(userName)) {
			throw new UserAlreadyExistsException("User with username "+
					userName +
					" already exists in the repo.");
		}
		User user = new User(userName, password, phNo);
		indexUser(user);
		return user;
	}

	private void indexUser(User user) {
		
		idToUserMap.put(user.getId(), user);
		userNametoUserMap.put(user.getUserName(), user);
	}
	

}

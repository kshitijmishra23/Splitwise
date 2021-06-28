package com.splitwise.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

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
	

}

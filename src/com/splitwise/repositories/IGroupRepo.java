package com.splitwise.repositories;

import com.splitwise.model.Group;

public interface IGroupRepo {
	
	Group findByID(Long id);
	boolean isGroupPresent(Long id);
	void saveGroup(Group group);

}

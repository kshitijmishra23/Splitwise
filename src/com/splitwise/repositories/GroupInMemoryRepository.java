package com.splitwise.repositories;

import java.util.HashMap;

import com.splitwise.exceptions.GroupAlreadyExistsException;
import com.splitwise.exceptions.GroupNotFoundException;
import com.splitwise.model.Group;

public class GroupInMemoryRepository implements IGroupRepo {
	
	HashMap<Long, Group> idToGroupMap;
	
	public GroupInMemoryRepository() {
		this.idToGroupMap = new HashMap<Long, Group>();
	}

	@Override
	public Group findByID(Long id) {
		if(isGroupPresent(id)) {
			throw new GroupNotFoundException("Group with id "+
		id+
		" does not exist in the repo.");
		}
		
		return idToGroupMap.get(id);
	}

	@Override
	public boolean isGroupPresent(Long id) {
		
		return idToGroupMap.containsKey(id);
	}

	@Override
	public void saveGroup(Group group) {
		if(isGroupPresent(group.getId())) {
			throw new GroupAlreadyExistsException("Group with id "+
		group.getId()+
		" already exists in the repo.\n");
		}
		idToGroupMap.put(group.getId(), group);
	}

}

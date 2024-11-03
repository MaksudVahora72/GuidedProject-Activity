package com.garbagefleet.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.garbagefleet.model.UserMaster;
import com.garbagefleet.repository.UserMasterRepository;

@Service
public class UserMasterService {
	
	private final UserMasterRepository umrepository;
	public UserMasterService(UserMasterRepository umrepository) {
		this.umrepository = umrepository;
	}
	
	//Select all Users
	public List<UserMaster> getAllUsers() {
		List<UserMaster> users = umrepository.findAll();
		return users;
	}
	
	//Create new user
	public UserMaster createNewUser(UserMaster user) {
		return umrepository.save(user);
	}
	
	//update the user based on id value
	public UserMaster updateUser(int id, UserMaster newdata) {
		UserMaster found = umrepository.findById(id).orElse(null);
		if(found != null) {
			found.setUsername(newdata.getUsername());
			found.setUserpassword(newdata.getUserpassword());
			found.setUtypeid(newdata.getUtypeid());
			found.setUseravail(newdata.getUseravail());
			found.setUseractive(newdata.getUseractive());
			umrepository.save(found);			
		}
		return found;
	}

	//Get user by id
	public UserMaster getUserById(int id) { 
		return umrepository.findById(id).get();
	}
	
	//Delete user by id
	public void deleteUser(int id) {
		umrepository.deleteById(id); 
	}

	//Set deactivate the user
	public void userSetInactive(int id, UserMaster newdata) {
		UserMaster found = umrepository.findById(id).orElse(null);
		if(found != null) {
			found.setUseractive(newdata.getUseractive());
			umrepository.save(found);			
		}
	}
	
	//Get all available users
	public List<UserMaster> getAllAvailableUsers(String flag) {
		return umrepository.findByUseravail(flag);
	}
	
	//Get all In-active users
	public List<UserMaster> getAllInActiveUsers(String flag) {
		return umrepository.findByUseractive(flag);
	}
}

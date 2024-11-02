package com.garbagefleet.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.garbagefleet.model.UserTypeMaster;
import com.garbagefleet.repository.UserTypeMasterRepository;

@Service
public class UserTypeMasterService {
	
	private final UserTypeMasterRepository utrepository;
	
	public UserTypeMasterService(UserTypeMasterRepository utrepository) {
		this.utrepository = utrepository;
	}
	
	//Select all usertype
	public List<UserTypeMaster> getAllUserTypes() {
		List<UserTypeMaster> lstutype = utrepository.findAll();
		System.out.println(lstutype.size());
		return lstutype;
	}
	
	//Create new usertype
	public UserTypeMaster createNewUserType(UserTypeMaster utype) {
		return utrepository.save(utype);
	}
	
	//update the usertype based on id value
	public UserTypeMaster updateUserType(int id, UserTypeMaster newdata) {
		UserTypeMaster found = utrepository.findById(id).orElse(null);
		if(found != null) {
			found.setUtype_desc(newdata.getUtype_desc());
			utrepository.save(found);			
		}
		return found;
	}

	//Get usertype by id
	public UserTypeMaster getUserTypeById(int id) { 
		return utrepository.findById(id).get();
	}
	
	//Delete usertype by id
	public void deleteUserType(int id) {
		utrepository.deleteById(id); 
	}
}

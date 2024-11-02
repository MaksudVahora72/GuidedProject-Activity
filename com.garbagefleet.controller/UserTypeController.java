package com.garbagefleet.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.garbagefleet.model.UserTypeMaster;
import com.garbagefleet.service.UserTypeMasterService;

@RestController
@RequestMapping("/api/v1")
public class UserTypeController {
	
	private UserTypeMasterService utypeservice;
	
	public UserTypeController(UserTypeMasterService utypeservice) {
		this.utypeservice = utypeservice;
	}
	//Get All UserTypes
	@GetMapping("/usertype")
	public ResponseEntity<List<UserTypeMaster>> getAllUsertypes() {
		List<UserTypeMaster> usertypes = utypeservice.getAllUserTypes();
		return ResponseEntity.ok().body(usertypes);
	}
	
	//Create new User Type
	@PostMapping("/usertype")
	public ResponseEntity<String> createUserType(@RequestBody UserTypeMaster usrtype) 	{
		utypeservice.createNewUserType(usrtype);
		return new ResponseEntity<String>("Record created ",HttpStatus.OK);
	}
	
	//Update user type
	@PutMapping("/usertype/{id}")
	public ResponseEntity<String> updateUserType(@PathVariable int id, 
			@RequestBody UserTypeMaster usertype) 	{

		UserTypeMaster found = utypeservice.getUserTypeById(id);
		if(found == null)
			return new ResponseEntity<String>("Record does not exists", HttpStatus.NOT_FOUND);
		else 
		{
			
			utypeservice.updateUserType(id, usertype);
			return new ResponseEntity<String>("Record has been updated", HttpStatus.OK);
		}
	}

	//Find usertype by ID
	@GetMapping("/usertype/{id}")
	public ResponseEntity<UserTypeMaster> getUserTypeById(@PathVariable int id) {
		UserTypeMaster usertype = utypeservice.getUserTypeById(id);
		if(usertype!=null)
			return new ResponseEntity<UserTypeMaster>(usertype, HttpStatus.OK);
		else 
			return new ResponseEntity<UserTypeMaster>(usertype, HttpStatus.NOT_FOUND); 
	}
	
	//Delete usertype by id
	@DeleteMapping("/usertype/{id}")
	public ResponseEntity<String> deleteUsertype(@PathVariable("id") int id) 	
	{
		UserTypeMaster found = utypeservice.getUserTypeById(id);
		if(found == null) 
			return new ResponseEntity<String>("Record Does not exists", HttpStatus.NOT_FOUND);
		else 
		{
			utypeservice.deleteUserType(id);
			return new ResponseEntity<String>("Record deleted successfully", HttpStatus.OK);
		}
	}
}

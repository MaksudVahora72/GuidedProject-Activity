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

import com.garbagefleet.model.InsuranceCompanyMaster;
import com.garbagefleet.model.UserMaster;
import com.garbagefleet.model.UserTypeMaster;
import com.garbagefleet.service.UserMasterService;
import com.garbagefleet.service.UserTypeMasterService;

@RestController
@RequestMapping("/api/v1")
public class UserController {

	private UserMasterService usrervice;
	
	public UserController(UserMasterService usrervice) {
		this.usrervice = usrervice;
	}
	//Get All Users
	@GetMapping("/user")
	public ResponseEntity<List<UserMaster>> getAllUsers() {
		List<UserMaster> users = usrervice.getAllUsers();
		return ResponseEntity.ok().body(users);
	}
	
	//Create new User
	@PostMapping("/user")
	public ResponseEntity<String> createUserType(@RequestBody UserMaster user) 	{
		usrervice.createNewUser(user);
		return new ResponseEntity<String>("Record created ",HttpStatus.OK);
	}
	
	//Find user by ID
	@GetMapping("/user/{id}")
	public ResponseEntity<UserMaster> getUserById(@PathVariable int id) {
		UserMaster user = usrervice.getUserById(id);
		if(user!=null)
			return new ResponseEntity<UserMaster>(user, HttpStatus.OK);
		else 
			return new ResponseEntity<UserMaster>(user, HttpStatus.NOT_FOUND); 
	}
	
	//Update user details
	@PutMapping("/user/{id}")
	public ResponseEntity<String> updateUserDetails(@PathVariable int id, 
			@RequestBody UserMaster user) 	{

		UserMaster found = usrervice.getUserById(id);
		if(found == null)
			return new ResponseEntity<String>("Record does not exists", HttpStatus.NOT_FOUND);
		else 
		{
			usrervice.updateUser(id, user);
			return new ResponseEntity<String>("Record has been updated", HttpStatus.OK);
		}
	}
	
	//Delete user by id
	@DeleteMapping("/user/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable int id) 	
	{
		UserMaster found = usrervice.getUserById(id);
		if(found == null) 
			return new ResponseEntity<String>("Record Does not exists", HttpStatus.NOT_FOUND);
		else 
		{
			usrervice.deleteUser(id);
			return new ResponseEntity<String>("Record deleted successfully", HttpStatus.OK);
		}
	}
	
	//Show all available users list
	@GetMapping("/useravail/{flag}")
	public ResponseEntity<List<UserMaster>> getAllAvailableUsers(@PathVariable String flag) {
		List<UserMaster> users = usrervice.getAllAvailableUsers(flag);
		return ResponseEntity.ok().body(users);
	}
	
	//Set the user deactivate status
	@PutMapping("/deactivateuser/{id}")
	public ResponseEntity<String> deActivateUser(@PathVariable int id, @RequestBody UserMaster user) 	
	{
		UserMaster found = usrervice.getUserById(id);
		if(found == null) 
			return new ResponseEntity<String>("Record Does not exists", HttpStatus.NOT_FOUND);
		else 
		{
			usrervice.userSetInactive(id, user);
			return new ResponseEntity<String>("User status updated successfully", HttpStatus.OK);
		}
	}

	//Show all in-active users list
	@GetMapping("/inactiveusers/{flag}")
	public ResponseEntity<List<UserMaster>> getAllInActiveUsers(@PathVariable String flag) {
		List<UserMaster> users = usrervice.getAllInActiveUsers(flag);
		return ResponseEntity.ok().body(users);
	}

}

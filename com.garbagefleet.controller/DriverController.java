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

import com.garbagefleet.model.DriverMaster;
import com.garbagefleet.model.UserMaster;
import com.garbagefleet.service.DriverService;

@RestController
@RequestMapping("/api/v1")
public class DriverController {
	
	private DriverService drvservice;
	
	public DriverController(DriverService drvservice) {
		this.drvservice = drvservice;
	}
	
	//Get All driver details
	@GetMapping("/driver")
	public ResponseEntity<List<DriverMaster>> getAllUsers() {
		List<DriverMaster> drivers = drvservice.getAllDrivers();
		return ResponseEntity.ok().body(drivers);
	}
	
	//Create new driver details
	@PostMapping("/driver")
	public ResponseEntity<String> createDriver(@RequestBody DriverMaster driver) 	{
		drvservice.createNewDriver(driver);
		return new ResponseEntity<String>("Record created ",HttpStatus.OK);
	}
	
	//Find driver by ID
	@GetMapping("/driver/{id}")
	public ResponseEntity<DriverMaster> getDriverById(@PathVariable int id) {
		DriverMaster driver = drvservice.getDriverById(id);
		if(driver!=null)
			return new ResponseEntity<DriverMaster>(driver, HttpStatus.OK);
		else 
			return new ResponseEntity<DriverMaster>(driver, HttpStatus.NOT_FOUND); 
	}
	
	//Update driver details
	@PutMapping("/driver/{id}")
	public ResponseEntity<String> updateDriverDetails(@PathVariable int id, 
			@RequestBody DriverMaster driver) 	{

		DriverMaster found = drvservice.getDriverById(id);
		if(found == null)
			return new ResponseEntity<String>("Record does not exists", HttpStatus.NOT_FOUND);
		else 
		{
			drvservice.updateDriver(id, driver);
			return new ResponseEntity<String>("Record has been updated", HttpStatus.OK);
		}
	}
	
	//Delete driver by id
	@DeleteMapping("/driver/{id}")
	public ResponseEntity<String> deleteDriver(@PathVariable int id) 	
	{
		DriverMaster found = drvservice.getDriverById(id);
		if(found == null) 
			return new ResponseEntity<String>("Record Does not exists", HttpStatus.NOT_FOUND);
		else 
		{
			drvservice.deleteDriver(id);
			return new ResponseEntity<String>("Record deleted successfully", HttpStatus.OK);
		}
	}

	//Set the driver deactivate status
	@PutMapping("/deactivatedriver/{id}")
	public ResponseEntity<String> deActivateDriver(@PathVariable int id, @RequestBody DriverMaster driver) 	
	{
		DriverMaster found = drvservice.getDriverById(id);
		if(found == null) 
			return new ResponseEntity<String>("Record Does not exists", HttpStatus.NOT_FOUND);
		else 
		{
			drvservice.driverSetInactive(id, driver);
			return new ResponseEntity<String>("driver status updated successfully", HttpStatus.OK);
		}
	}

	//Show all in-active driver list
	@GetMapping("/inactivedriver/{flag}")
	public ResponseEntity<List<DriverMaster>> getAllInActiveDrivers(@PathVariable String flag) {
		List<DriverMaster> drivers = drvservice.getAllInActiveDrivers(flag);
		return ResponseEntity.ok().body(drivers);
	}
}

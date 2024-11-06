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

import com.garbagefleet.model.ServiceCenterMaster;
import com.garbagefleet.service.ServiceCenterService;

@RestController
@RequestMapping("/api/v1")
public class ServiceCenterController {

	private ServiceCenterService srvservice;
	
	public ServiceCenterController(ServiceCenterService srvservice) {
		this.srvservice = srvservice;
	}
	//Get All Service Center Location
	@GetMapping("/service")
	public ResponseEntity<List<ServiceCenterMaster>> getAllCenters() {
		List<ServiceCenterMaster> centers = srvservice.getAllCenters();
		return ResponseEntity.ok().body(centers);
	}
	
	//Create new center location
	@PostMapping("/service")
	public ResponseEntity<String> createCenter(@RequestBody ServiceCenterMaster center) 	{
		srvservice.createNewCenter(center);
		return new ResponseEntity<String>("Record created ",HttpStatus.OK);
	}
	
	//Update center location
	@PutMapping("/service/{id}")
	public ResponseEntity<String> updateCenter(@PathVariable int id, 
			@RequestBody ServiceCenterMaster center) 	{

		ServiceCenterMaster found = srvservice.getCenterById(id);
		if(found == null)
			return new ResponseEntity<String>("Record does not exists", HttpStatus.NOT_FOUND);
		else 
		{
			srvservice.updateCenter(id, center);
			return new ResponseEntity<String>("Record has been updated", HttpStatus.OK);
		}
	}

	//Find center location by ID
	@GetMapping("/service/{id}")
	public ResponseEntity<ServiceCenterMaster> getUserTypeById(@PathVariable int id) {
		ServiceCenterMaster center = srvservice.getCenterById(id);
		if(center!=null)
			return new ResponseEntity<ServiceCenterMaster>(center, HttpStatus.OK);
		else 
			return new ResponseEntity<ServiceCenterMaster>(center, HttpStatus.NOT_FOUND); 
	}
	
	//Delete usertype by id
	@DeleteMapping("/service/{id}")
	public ResponseEntity<String> deleteUsertype(@PathVariable("id") int id) 	
	{
		ServiceCenterMaster found = srvservice.getCenterById(id);
		if(found == null) 
			return new ResponseEntity<String>("Record Does not exists", HttpStatus.NOT_FOUND);
		else 
		{
			srvservice.deleteCenter(id);
			return new ResponseEntity<String>("Record deleted successfully", HttpStatus.OK);
		}
	}
}

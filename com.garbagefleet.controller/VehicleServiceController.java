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

import com.garbagefleet.model.DesigMaster;
import com.garbagefleet.model.VehicleServiceMaster;
import com.garbagefleet.service.VehicleSrvService;

@RestController
@RequestMapping("/api/v1")
public class VehicleServiceController {

	private VehicleSrvService vsservice;
	
	public VehicleServiceController(VehicleSrvService vsservice) {
		this.vsservice = vsservice;
	}
	
	//Get All vehicle service details
	@GetMapping("/vehservice")
	public ResponseEntity<List<VehicleServiceMaster>> getAllServiceDetails() {
		List<VehicleServiceMaster> srvdetails = vsservice.getAllServices();
		return ResponseEntity.ok().body(srvdetails);
	}
	
	//Create new vehicle service details
	@PostMapping("/vehservice")
	public ResponseEntity<String> createDriver
		(@RequestBody VehicleServiceMaster service) 	{
		vsservice.createNewServiceEntry(service);
		return new ResponseEntity<String>("Record created ",HttpStatus.OK);
	}
	
	//Update vehicle service entry
	@PutMapping("/vehservice/{id}")
	public ResponseEntity<String> updateVehicleService(@PathVariable int id, 
			@RequestBody VehicleServiceMaster vservice) 	{

		VehicleServiceMaster found = vsservice.getVehServiceEntry(id);
		if(found == null)
			return new ResponseEntity<String>("Record does not exists", HttpStatus.NOT_FOUND);
		else 
		{
			vsservice.updateVehService(id, vservice);
			return new ResponseEntity<String>("Record has been updated", HttpStatus.OK);
		}
	}

	//Find vehicle service entry by ID
	@GetMapping("/vehservice/{id}")
	public ResponseEntity<VehicleServiceMaster> getVehServiceEntryById(@PathVariable int id) {
		
		VehicleServiceMaster serviceentry = vsservice.getVehServiceEntry(id);
		
		if(serviceentry !=null)
			return new ResponseEntity<VehicleServiceMaster>(serviceentry, HttpStatus.OK);
		else 
			return new ResponseEntity<VehicleServiceMaster>(serviceentry, HttpStatus.NOT_FOUND); 
	}
	
	//Delete vehicle service entry by id
	@DeleteMapping("/vehservice/{id}")
	public ResponseEntity<String> deleteUsertype(@PathVariable int id) 	
	{
		VehicleServiceMaster found = vsservice.getVehServiceEntry(id);
		
		if(found == null) 
			return new ResponseEntity<String>("Record Does not exists", HttpStatus.NOT_FOUND);
		else 
		{
			vsservice.deleteServiceEntry(id);
			return new ResponseEntity<String>("Record deleted successfully", HttpStatus.OK);
		}
	}
	
	//Update vehicle service entry status
	@PutMapping("/vehserviceupd/{id}")
	public ResponseEntity<String> updateServiceStatus(@PathVariable int id, 
			@RequestBody VehicleServiceMaster newdata) 	{

		VehicleServiceMaster found = vsservice.getVehServiceEntry(id);
		
		if(found == null)
			return new ResponseEntity<String>("Record does not exists", HttpStatus.NOT_FOUND);
		else 
		{
			System.out.println(newdata.getVehsrvstatus() + " " + found.getVehsrvstatus());
			
			found.setVehsrvstatus(newdata.getVehsrvstatus());
			vsservice.setServiceUpdate(found);
			return new ResponseEntity<String>("Record has been updated", HttpStatus.OK);
		}
	}
	
	//Get All vehicle service details
	@GetMapping("/vehserviceupd/{status}")
	public List<VehicleServiceMaster> getAllServicesStatus(@PathVariable String status) {
		List<VehicleServiceMaster> srvdetails = vsservice.getAllServicesStatus(status);
		return srvdetails;
	}
}

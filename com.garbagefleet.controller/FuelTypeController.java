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

import com.garbagefleet.model.VehicleFuelTypeMaster;
import com.garbagefleet.service.FuelTypeMasterService;

@RestController
@RequestMapping("/api/v1")
public class FuelTypeController {
	
	private FuelTypeMasterService ftypeservice;
	
	public FuelTypeController(FuelTypeMasterService ftypeservice) {
		this.ftypeservice = ftypeservice;
	}
	//Get All Vehicle FuelTypes
	@GetMapping("/vehftype")
	public ResponseEntity<List<VehicleFuelTypeMaster>> getAllUsertypes() {
		List<VehicleFuelTypeMaster> usertypes = ftypeservice.getAllFuelTypes();
		return ResponseEntity.ok().body(usertypes);
	}
	
	//Create new fuel Type
	@PostMapping("/vehftype")
	public ResponseEntity<String> createUserType(@RequestBody VehicleFuelTypeMaster vftype) 	{
		ftypeservice.createNewFuelType(vftype);
		return new ResponseEntity<String>("Record created ",HttpStatus.OK);
	}
	
	//Update fueltype
	@PutMapping("/vehftype/{id}")
	public ResponseEntity<String> updateUserType(@PathVariable int id, 
			@RequestBody VehicleFuelTypeMaster vftype) 	{

		VehicleFuelTypeMaster found = ftypeservice.getFuelTypeById(id);
		if(found == null)
			return new ResponseEntity<String>("Record does not exists", HttpStatus.NOT_FOUND);
		else 
		{
			
			ftypeservice.updateFuelType(id, vftype);
			return new ResponseEntity<String>("Record has been updated", HttpStatus.OK);
		}
	}

	//Find fueltype by ID
	@GetMapping("/vehftype/{id}")
	public ResponseEntity<VehicleFuelTypeMaster> getUserTypeById(@PathVariable int id) {
		VehicleFuelTypeMaster vftype = ftypeservice.getFuelTypeById(id);
		if(vftype!=null)
			return new ResponseEntity<VehicleFuelTypeMaster>(vftype, HttpStatus.OK);
		else 
			return new ResponseEntity<VehicleFuelTypeMaster>(vftype, HttpStatus.NOT_FOUND); 
	}
	
	//Delete fueltype by id
	@DeleteMapping("/vehftype/{id}")
	public ResponseEntity<String> deleteUsertype(@PathVariable("id") int id) 	
	{
		VehicleFuelTypeMaster found = ftypeservice.getFuelTypeById(id);
		if(found == null) 
			return new ResponseEntity<String>("Record Does not exists", HttpStatus.NOT_FOUND);
		else 
		{
			ftypeservice.deleteFuelType(id);
			return new ResponseEntity<String>("Record deleted successfully", HttpStatus.OK);
		}
	}
}

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
import com.garbagefleet.service.DesigMasterService;

@RestController
@RequestMapping("/api/v1")
public class DesignationController {

	private DesigMasterService desigservice;
	
	public DesignationController(DesigMasterService desigservice) {
		this.desigservice = desigservice;
	}
	
	//Get All Designation
	@GetMapping("/desig")
	public ResponseEntity<List<DesigMaster>> getAllDesignation() {
		List<DesigMaster> desigs = desigservice.getAllDesignation();
		return ResponseEntity.ok().body(desigs);
	}
	
	//Create new Designation
	@PostMapping("/desig")
	public ResponseEntity<String> createDesignation(@RequestBody DesigMaster designation) {
		desigservice.createNewDesignation(designation);
		return new ResponseEntity<String>("Record created ",HttpStatus.OK);
	}
	
	//Update Designation
	@PutMapping("/desig/{id}")
	public ResponseEntity<String> updateDesignation(@PathVariable int id, 
			@RequestBody DesigMaster desig) 	{

		DesigMaster found = desigservice.getDesignationById(id);
		if(found == null)
			return new ResponseEntity<String>("Record does not exists", HttpStatus.NOT_FOUND);
		else 
		{
			desigservice.updateDesignation(id, desig);
			return new ResponseEntity<String>("Record has been updated", HttpStatus.OK);
		}
	}

	//Find Designation by ID
	@GetMapping("/desig/{id}")
	public ResponseEntity<DesigMaster> getDesignationById(@PathVariable int id) {
		
		DesigMaster desig = desigservice.getDesignationById(id);
		
		if(desig !=null)
			return new ResponseEntity<DesigMaster>(desig, HttpStatus.OK);
		else 
			return new ResponseEntity<DesigMaster>(desig, HttpStatus.NOT_FOUND); 
	}
	
	//Delete Designation by id
	@DeleteMapping("/desig/{id}")
	public ResponseEntity<String> deleteUsertype(@PathVariable int id) 	
	{
		DesigMaster found = desigservice.getDesignationById(id);
		
		if(found == null) 
			return new ResponseEntity<String>("Record Does not exists", HttpStatus.NOT_FOUND);
		else 
		{
			desigservice.deleteDesignation(id);
			return new ResponseEntity<String>("Record deleted successfully", HttpStatus.OK);
		}
	}
}
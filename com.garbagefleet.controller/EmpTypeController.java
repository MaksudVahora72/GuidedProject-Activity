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

import com.garbagefleet.model.EmpTypeMaster;
import com.garbagefleet.service.EmployeeTypeService;

@RestController
@RequestMapping("/api/v1")
public class EmpTypeController {
	
	private EmployeeTypeService etypeservice;
	
	public EmpTypeController(EmployeeTypeService etypeservice) {
		this.etypeservice = etypeservice;
	}
	//Get All Employee Types
	@GetMapping("/emptype")
	public ResponseEntity<List<EmpTypeMaster>> getAllUsertypes() {
		List<EmpTypeMaster> usertypes = etypeservice.getAllEmpTypes();
		return ResponseEntity.ok().body(usertypes);
	}
	
	//Create new User Type
	@PostMapping("/emptype")
	public ResponseEntity<String> createEmpType(@RequestBody EmpTypeMaster emptype) 	{
		etypeservice.createNewEmpType(emptype);
		return new ResponseEntity<String>("Record created ",HttpStatus.OK);
	}
	
	//Update Employee type
	@PutMapping("/emptype/{id}")
	public ResponseEntity<String> updateEmpType(@PathVariable int id, 
			@RequestBody EmpTypeMaster emptype) 	{

		EmpTypeMaster found = etypeservice.getEmpTypeById(id);
		if(found == null)
			return new ResponseEntity<String>("Record does not exists", HttpStatus.NOT_FOUND);
		else 
		{
			
			etypeservice.updateEmpType(id, emptype);
			return new ResponseEntity<String>("Record has been updated", HttpStatus.OK);
		}
	}

	//Find emptype by ID
	@GetMapping("/emptype/{id}")
	public ResponseEntity<EmpTypeMaster> getEmpTypeById(@PathVariable int id) {
		EmpTypeMaster emptype = etypeservice.getEmpTypeById(id);
		if(emptype!=null)
			return new ResponseEntity<EmpTypeMaster>(emptype, HttpStatus.OK);
		else 
			return new ResponseEntity<EmpTypeMaster>(emptype, HttpStatus.NOT_FOUND); 
	}
	
	//Delete emptype by id
	@DeleteMapping("/emptype/{id}")
	public ResponseEntity<String> deleteEmptype(@PathVariable("id") int id) 	
	{
		EmpTypeMaster found = etypeservice.getEmpTypeById(id);
		if(found == null) 
			return new ResponseEntity<String>("Record Does not exists", HttpStatus.NOT_FOUND);
		else 
		{
			etypeservice.deleteEmpType(id);
			return new ResponseEntity<String>("Record deleted successfully", HttpStatus.OK);
		}
	}
}

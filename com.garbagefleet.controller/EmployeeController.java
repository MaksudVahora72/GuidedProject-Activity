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
import com.garbagefleet.model.EmployeeMaster;
import com.garbagefleet.service.DriverService;
import com.garbagefleet.service.EmployeeService;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

	private EmployeeService empservice;
	
	public EmployeeController(EmployeeService empservice) {
		this.empservice = empservice;
	}
	
	//Get All employees details
	@GetMapping("/employee")
	public ResponseEntity<List<EmployeeMaster>> getAllEmployees() {
		List<EmployeeMaster> employees = empservice.getAllEmployees();
		return ResponseEntity.ok().body(employees);
	}
	
	//Create new employee details
	@PostMapping("/employee")
	public ResponseEntity<String> createEmployee(
			@RequestBody EmployeeMaster employee) 	{
		empservice.createNewEmployee(employee);
		return new ResponseEntity<String>("Record created ",HttpStatus.OK);
	}
	
	//Find employee by ID
	@GetMapping("/employee/{id}")
	public ResponseEntity<EmployeeMaster> getEmployeeById(@PathVariable int id) {
		EmployeeMaster employee = empservice.getEmployeeById(id);
		if(employee!=null)
			return new ResponseEntity<EmployeeMaster>(employee, HttpStatus.OK);
		else 
			return new ResponseEntity<EmployeeMaster>(employee, HttpStatus.NOT_FOUND); 
	}
	
	//Update employee details
	@PutMapping("/employee/{id}")
	public ResponseEntity<String> updateEmployeeDetails(@PathVariable int id, 
			@RequestBody EmployeeMaster employee) 	{

		EmployeeMaster found = empservice.getEmployeeById(id);
		if(found == null)
			return new ResponseEntity<String>("Record does not exists", HttpStatus.NOT_FOUND);
		else 
		{
			empservice.updateEmployee(id, employee);
			return new ResponseEntity<String>("Record has been updated", HttpStatus.OK);
		}
	}
	
	//Delete employee by id
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable int id) 	
	{
		EmployeeMaster found = empservice.getEmployeeById(id);
		if(found == null) 
			return new ResponseEntity<String>("Record Does not exists", HttpStatus.NOT_FOUND);
		else 
		{
			empservice.deleteEmployee(id);
			return new ResponseEntity<String>("Record deleted successfully", HttpStatus.OK);
		}
	}
	
	//Set the employee deactivate status
	@PutMapping("/deactivateemployee/{id}")
	public ResponseEntity<String> deActivateEmployee
		(@PathVariable int id, @RequestBody EmployeeMaster employee) 	
	{
		EmployeeMaster found = empservice.getEmployeeById(id);
		if(found == null) 
			return new ResponseEntity<String>("Record Does not exists", HttpStatus.NOT_FOUND);
		else 
		{
			empservice.employeeSetInactive(id, employee);
			return new ResponseEntity<String>("employee status updated successfully", HttpStatus.OK);
		}
	}

	//Set the employee deactivate status
	@PutMapping("/changeimage/{id}")
	public ResponseEntity<String> changeImageEmployee
		(@PathVariable int id, @RequestBody EmployeeMaster employee) 	
	{
		EmployeeMaster found = empservice.getEmployeeById(id);
		if(found == null) 
			return new ResponseEntity<String>("Record Does not exists", HttpStatus.NOT_FOUND);
		else 
		{
			empservice.employeeSetImage(id, employee);
			return new ResponseEntity<String>("employee image updated successfully", HttpStatus.OK);
		}
	}

	//Show all in-active employee list
	@GetMapping("/inactiveemployees/{flag}")
	public ResponseEntity<List<EmployeeMaster>> getAllInActiveEmployees(@PathVariable String flag) {
		List<EmployeeMaster> employees = empservice.getAllInActiveEmployee(flag);
		return ResponseEntity.ok().body(employees);
	}
}

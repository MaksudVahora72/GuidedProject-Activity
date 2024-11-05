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
import com.garbagefleet.service.InsuranceCompanyService;

@RestController
@RequestMapping("/api/v1")
public class InsuranceController {

	private InsuranceCompanyService icservice;
	
	public InsuranceController(InsuranceCompanyService icservice) {
		this.icservice = icservice;
	}
	
	//Get All insurance company details
	@GetMapping("/insurance")
	public ResponseEntity<List<InsuranceCompanyMaster>> getAllInsurance() {
		List<InsuranceCompanyMaster> icdetails = icservice.getAllInsuranceCompany();
		return ResponseEntity.ok().body(icdetails);
	}
	
	//Create new insurance
	@PostMapping("/insurance")
	public ResponseEntity<String> createInsuranceCompany
			(@RequestBody InsuranceCompanyMaster insurance) {
		icservice.createNewInsurance(insurance);
		return new ResponseEntity<String>("Record created ",HttpStatus.OK);
	}
	
	//Update Insurance company details
	@PutMapping("/insurance/{id}")
	public ResponseEntity<String> updateInsurance(@PathVariable int id, 
			@RequestBody InsuranceCompanyMaster insurance) 	{

		InsuranceCompanyMaster found = icservice.getInsuranceById(id);
		if(found == null)
			return new ResponseEntity<String>("Record does not exists", HttpStatus.NOT_FOUND);
		else 
		{
			icservice.updateInsurance(id, insurance);
			return new ResponseEntity<String>("Record has been updated", HttpStatus.OK);
		}
	}
	
	//Delete insurance company by id
	@DeleteMapping("/insurance/{id}")
	public ResponseEntity<String> deleteInsurance(@PathVariable int id) 	
	{
		InsuranceCompanyMaster found = icservice.getInsuranceById(id);
		if(found == null) 
			return new ResponseEntity<String>("Record Does not exists", HttpStatus.NOT_FOUND);
		else 
		{
			icservice.deleteInsurance(id);
			return new ResponseEntity<String>("Record deleted successfully", HttpStatus.OK);
		}
	}
	
	//Set the insurance company deactivate status
	@PutMapping("/deactiveinsurance/{id}")
	public ResponseEntity<String> deActivateInsurance
		(@PathVariable int id, @RequestBody InsuranceCompanyMaster insurance) 	
	{
		InsuranceCompanyMaster found = icservice.getInsuranceById(id);
		if(found == null) 
			return new ResponseEntity<String>("Record Does not exists", HttpStatus.NOT_FOUND);
		else 
		{
			icservice.insuranceSetInactive(id, insurance);
			return new ResponseEntity<String>("Insurance company status updated successfully", HttpStatus.OK);
		}
	}

	//Show all in-active insurance company list
	@GetMapping("/inactiveinsurance/{flag}")
	public ResponseEntity<List<InsuranceCompanyMaster>> getAllInActiveInsuranceCompany
		(@PathVariable String flag) {
		List<InsuranceCompanyMaster> icdetails = icservice.getAllInActiveInsurance(flag);
		return ResponseEntity.ok().body(icdetails);
	}
}

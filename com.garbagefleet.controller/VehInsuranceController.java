package com.garbagefleet.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.garbagefleet.model.VehicleInsurance;
import com.garbagefleet.service.VehInsuranceService;

@RestController
@RequestMapping("/api/v1")
public class VehInsuranceController {

	private VehInsuranceService viservice;
	
	public VehInsuranceController(VehInsuranceService viservice) {
		this.viservice = viservice;
	}
	
	//Get All Vehicle insurance issued entries
	@GetMapping("/vehinsu")
	public ResponseEntity<List<VehicleInsurance>> getAllVehicleIsuranceEntries() {
		List<VehicleInsurance> vehissentries = viservice.getAllInsuranceEntries();
		return ResponseEntity.ok().body(vehissentries);
	}
	
	//Create new vehile issue entry
	@PostMapping("/vehinsu")
	public ResponseEntity<String> createVehIssueEntry(@RequestBody VehicleInsurance vehinsurance) 	{
		viservice.createVehicleEntry(vehinsurance);
		return new ResponseEntity<String>("Record created ",HttpStatus.OK);
	}
	
	//Update vehicle insurance entry
	@PutMapping("/vehinsu/{id}")
	public ResponseEntity<String> updateVehicleEntry(@PathVariable int id, 
			@RequestBody VehicleInsurance insuranceentry) 	{

		VehicleInsurance found = viservice.getVehEntryById(id);
		if(found == null)
			return new ResponseEntity<String>("Record does not exists", HttpStatus.NOT_FOUND);
		else 
		{
			viservice.updateVehEntry(id, insuranceentry);
			return new ResponseEntity<String>("Record has been updated", HttpStatus.OK);
		}
	}

	//Find insurance entry by ID
	@GetMapping("/vehinsu/{id}")
	public ResponseEntity<VehicleInsurance> getvehEntryById(@PathVariable int id) {
		VehicleInsurance insuentry = viservice.getVehEntryById(id);
		if(insuentry !=null)
			return new ResponseEntity<VehicleInsurance>(insuentry, HttpStatus.OK);
		else 
			return new ResponseEntity<VehicleInsurance>(insuentry, HttpStatus.NOT_FOUND); 
	}
	
	//Delete vehicle entry by id
	@DeleteMapping("/vehinsu/{id}")
	public ResponseEntity<String> deleteInsuranceEntry(@PathVariable("id") int id) 	
	{
		VehicleInsurance found = viservice.getVehEntryById(id);
		if(found == null) 
			return new ResponseEntity<String>("Record Does not exists", HttpStatus.NOT_FOUND);
		else 
		{
			viservice.deleteVehicleInsurance(id);
			return new ResponseEntity<String>("Record deleted successfully", HttpStatus.OK);
		}
	}
	
	//Find insurance entry based on transaction type
	@GetMapping("/vehinsupaytype/{paytype}")
	public ResponseEntity<List<VehicleInsurance>> getInsuranceEntryByPtype(@PathVariable String paytype) {
		return ResponseEntity.ok().body(viservice.getAllInsuEntriesBasedTranType(paytype));
	}
}

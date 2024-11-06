package com.garbagefleet.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.garbagefleet.model.UserMaster;
import com.garbagefleet.model.VehicleMaster;
import com.garbagefleet.service.VehicleService;

@RestController
@RequestMapping("/api/v1")
public class VehicleController {
	private VehicleService vehservice;
	
	public VehicleController(VehicleService vehservice) {
		this.vehservice = vehservice;
	}
	
	//Get All Vehicle details
	@GetMapping("/vehicle")
	public ResponseEntity<List<VehicleMaster>> getAllvehicle() {
		List<VehicleMaster> icdetails = vehservice.getAllVehicles();
		return ResponseEntity.ok().body(icdetails);
	}
	
	//Find user by ID
	@GetMapping("/vehicle/{id}")
	public ResponseEntity<VehicleMaster> getVehicleById(@PathVariable int id) {
		VehicleMaster vehicle = vehservice.getVehicleById(id);
		if(vehicle!=null)
			return new ResponseEntity<VehicleMaster>(vehicle, HttpStatus.OK);
		else 
			return new ResponseEntity<VehicleMaster>(vehicle, HttpStatus.NOT_FOUND); 
	}

	//Create new vehicle
	@PostMapping("/vehicle")
	public ResponseEntity<String> createVehicle
			(@RequestBody VehicleMaster vehicle) {
		vehservice.createNewVehicle(vehicle);
		return new ResponseEntity<String>("Record created ",HttpStatus.OK);
	}
	
	//Update vehicle company details
	@PutMapping("/vehicle/{id}")
	public ResponseEntity<String> updatevehicle(@PathVariable int id, 
			@RequestBody VehicleMaster vehicle) 	{

		VehicleMaster found = vehservice.getVehicleById(id);
		if(found == null)
			return new ResponseEntity<String>("Record does not exists", HttpStatus.NOT_FOUND);
		else 
		{
			vehservice.updateVehicle(id, vehicle);
			return new ResponseEntity<String>("Record has been updated", HttpStatus.OK);
		}
	}
	
	//Delete vehicle company by id
	@DeleteMapping("/vehicle/{id}")
	public ResponseEntity<String> deletevehicle(@PathVariable int id) 	
	{
		VehicleMaster found = vehservice.getVehicleById(id);
		if(found == null) 
			return new ResponseEntity<String>("Record Does not exists", HttpStatus.NOT_FOUND);
		else 
		{
			vehservice.deleteVehicle(id);
			return new ResponseEntity<String>("Record deleted successfully", HttpStatus.OK);
		}
	}

	//Show vehicle status list
	@GetMapping("/vehstatus/{flag}")
	public ResponseEntity<List<VehicleMaster>> getStatusWiseVehicles(@PathVariable String flag) {
		List<VehicleMaster> vehicles = vehservice.getStatusWiseVehicle(flag);
		return ResponseEntity.ok().body(vehicles);
	}

	//Show vehicle based on fuel type
	@GetMapping("/vehftypestatus/{ftype}")
	public ResponseEntity<List<VehicleMaster>> getVehiclesByFuleType
		(@PathVariable int ftype) {
		List<VehicleMaster> vehicles = vehservice.getVehicleByType(ftype);
		return ResponseEntity.ok().body(vehicles);
	}

	//Show vehicle insurance expiry details
	@GetMapping("/vehinsuexp")
	public ResponseEntity<List<VehicleMaster>> getInsuranceExpiry
		(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate, 
		 @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate){

		/*
		int year = LocalDate.now().getYear();
		int month = LocalDate.now().getMonthValue();
		
		YearMonth yearmonth = YearMonth.of(year, month);
		LocalDate fd = yearmonth.atDay(1);
		LocalDate ld = yearmonth.atEndOfMonth();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		*/
		List<VehicleMaster> vehicles = 
				vehservice.getVehicleInsuranceExpiry(startDate, endDate);
		return ResponseEntity.ok().body(vehicles);
	}
}

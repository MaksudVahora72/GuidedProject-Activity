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

import com.garbagefleet.model.EmployeeMaster;
import com.garbagefleet.model.VehicleRoute;
import com.garbagefleet.service.vehicleRouteService;

@RestController
@RequestMapping("/api/v1")
public class VehicleRouteController {

	private vehicleRouteService vrteservice;
	
	public VehicleRouteController(vehicleRouteService vrteservice) {
		this.vrteservice = vrteservice;
	}
	
	//Get All vehicle route details
	@GetMapping("/vehroute")
	public ResponseEntity<List<VehicleRoute>> getAllVehicleRoute() {
		List<VehicleRoute> vehroutes = vrteservice.getAllVehicleRoutes();
		return ResponseEntity.ok().body(vehroutes);
	}
	
	//Create new Vehicle route details
	@PostMapping("/vehroute")
	public ResponseEntity<String> createVehileRoute(@RequestBody VehicleRoute vehroute) {
		vrteservice.createNewVehicleRoute(vehroute);
		return new ResponseEntity<String>("Record created ",HttpStatus.OK);
	}
	
	//Update Vehicle route details
	@PutMapping("/vehroute/{id}")
	public ResponseEntity<String> updateVehicleRoute(@PathVariable int id, 
			@RequestBody VehicleRoute vehroute) 	{

		VehicleRoute found = vrteservice.getVehicleRouteById(id);
		if(found == null)
			return new ResponseEntity<String>("Record does not exists", HttpStatus.NOT_FOUND);
		else 
		{
			vrteservice.updateVehicleRoute(id, vehroute);
			return new ResponseEntity<String>("Record has been updated", HttpStatus.OK);
		}
	}

	//Find vehicle route details by ID
	@GetMapping("/vehroute/{id}")
	public ResponseEntity<VehicleRoute> getVehicleRouteById(@PathVariable int id) {
		
		VehicleRoute vehroute = vrteservice.getVehicleRouteById(id);
		
		if(vehroute !=null)
			return new ResponseEntity<VehicleRoute>(vehroute, HttpStatus.OK);
		else 
			return new ResponseEntity<VehicleRoute>(vehroute, HttpStatus.NOT_FOUND); 
	}
	
	//Delete vehicle route details by id
	@DeleteMapping("/vehroute/{id}")
	public ResponseEntity<String> deleteVehicleRoute(@PathVariable int id) 	
	{
		VehicleRoute found = vrteservice.getVehicleRouteById(id);
		
		if(found == null) 
			return new ResponseEntity<String>("Record Does not exists", HttpStatus.NOT_FOUND);
		else 
		{
			vrteservice.deleteVehicleRoute(id);
			return new ResponseEntity<String>("Record deleted successfully", HttpStatus.OK);
		}
	}
	
	//Get the vehicle route details based on location
	@GetMapping("/vehroutelocation/{location}")
	public ResponseEntity<List<VehicleRoute>> getByLocation(@PathVariable String location) {
		List<VehicleRoute> vehrtelocations = vrteservice.getAllVehicleBasedOnLocation(location);
		System.out.println("Found :" + vehrtelocations.size());
		return ResponseEntity.ok().body(vehrtelocations);
	}

	//Get the vehicle route details based on days
	@GetMapping("/vehroutedays/{days}")
	public ResponseEntity<List<VehicleRoute>> getByDays(@PathVariable String days) {
		List<VehicleRoute> vehrtedays = vrteservice.getAllVehicleBasedOnDays(days);
		return ResponseEntity.ok().body(vehrtedays);
	}
	
	//Get the vehicle route details based on location active or not
	@GetMapping("/vehrouteactive/{status}")
	public ResponseEntity<List<VehicleRoute>> getByStatus(@PathVariable String status) {
		List<VehicleRoute> vehrtestatus = vrteservice.getAllVehicleBasedOnStatus(status);
		return ResponseEntity.ok().body(vehrtestatus);
	}
	
	//Set the vehicle route active or not
	@PutMapping("/vehrouteactive/{id}")
	public ResponseEntity<String> setByStatus
		(@PathVariable int id, @RequestBody VehicleRoute newdata) {
		
		VehicleRoute found = vrteservice.getVehicleRouteById(id);
		if(found == null) 
			return new ResponseEntity<String>("Record Does not exists", HttpStatus.NOT_FOUND);
		else 
		{
			vrteservice.updateVehicleRouteActive(id, newdata);
			return ResponseEntity.ok().body("Vehicle route status updated successfully!");
		}
	}
}

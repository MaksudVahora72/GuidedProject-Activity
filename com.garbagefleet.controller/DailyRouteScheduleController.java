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

import com.garbagefleet.model.DailyRouteSchedule;
import com.garbagefleet.service.DailyRouteScheduleService;

@RestController
@RequestMapping("/api/v1")
public class DailyRouteScheduleController {

	private DailyRouteScheduleService dlyservice;
	
	public DailyRouteScheduleController(DailyRouteScheduleService dlyservice) {
		this.dlyservice = dlyservice;
	}
	
	//Get All daily vehicle schedule details
	@GetMapping("/dlyroute")
	public ResponseEntity<List<DailyRouteSchedule>> getAllDailySchedules() {
		List<DailyRouteSchedule> dlyschdetails = dlyservice.getAllDailyShedule();
		return ResponseEntity.ok().body(dlyschdetails);
	}
	
	//Create new daily schedule
	@PostMapping("/dlyroute")
	public ResponseEntity<String> createNewSchedule(@RequestBody DailyRouteSchedule dlyvehsch) {
		dlyservice.createNewDailyRouteSchedule(dlyvehsch);
		return new ResponseEntity<String>("Record created ",HttpStatus.OK);
	}
	
	//Update vehicle daily schedule route
	@PutMapping("/dlyroute/{id}")
	public ResponseEntity<String> updateDailySchedule(@PathVariable int id, 
			@RequestBody DailyRouteSchedule dlyvehsch) 	{

		DailyRouteSchedule found = dlyservice.getDailyRouteScheduleById(id);
		if(found == null)
			return new ResponseEntity<String>("Record does not exists", HttpStatus.NOT_FOUND);
		else 
		{
			found.setDlyrouteid(dlyvehsch.getDlyrouteid());
			found.setDlytrdate(dlyvehsch.getDlytrdate());
			found.setDrvid(dlyvehsch.getDrvid());
			found.setAllocatedby(dlyvehsch.getAllocatedby());
			found.setDlyvehreason(dlyvehsch.getDlyvehreason());
			found.setDlystatus(dlyvehsch.getDlystatus());
			
			dlyservice.updateDailyRouteSchedule(id, found);

			return new ResponseEntity<String>("Record has been updated", HttpStatus.OK);
		}
	}

	//Find daily route schedule by id
	@GetMapping("/dlyroute/{id}")
	public ResponseEntity<DailyRouteSchedule> getDailyRouteById(@PathVariable int id) {
		
		DailyRouteSchedule dlyvehsch = dlyservice.getDailyRouteScheduleById(id);
		
		if(dlyvehsch !=null)
			return new ResponseEntity<DailyRouteSchedule>(dlyvehsch, HttpStatus.OK);
		else 
			return new ResponseEntity<DailyRouteSchedule>(dlyvehsch, HttpStatus.NOT_FOUND); 
	}
	
	//Delete daily route schedule by id
	@DeleteMapping("/dlyroute/{id}")
	public ResponseEntity<String> deleteDailySchedule(@PathVariable int id) 	
	{
		DailyRouteSchedule found = dlyservice.getDailyRouteScheduleById(id);
	
		if(found == null) 
			return new ResponseEntity<String>("Record Does not exists", HttpStatus.NOT_FOUND);
		else 
		{
			dlyservice.deleteRouteSchedule(id);
			return new ResponseEntity<String>("Record deleted successfully", HttpStatus.OK);
		}
	}
	
	//Get the data based on driver id
	@GetMapping("/dlyroutedrv/{id}")
	public ResponseEntity<List<DailyRouteSchedule>> 
			getAllScheduleBasedOnDriverID(@PathVariable int id) {
		List<DailyRouteSchedule> dlyschdetails = 
				dlyservice.getAllDailySheduleBasedOnDriverID(id);
		return ResponseEntity.ok().body(dlyschdetails);
	}
	
	//Get the data based on allocated by
	@GetMapping("/dlyrouteallocatedby/{id}")
	public ResponseEntity<List<DailyRouteSchedule>> 
			getAllScheduleBasedOnAllocationBy(@PathVariable int id) {
		List<DailyRouteSchedule> dlyschdetails = 
				dlyservice.getAllDailySheduleBasedOnAllocatedBy(id);
		return ResponseEntity.ok().body(dlyschdetails);
	}

	//Get update the daily vehicle schedule status based on id
	@PutMapping("/dlyrouteupd/{id}")
	public ResponseEntity<String> DailStatusUpdate
		(@PathVariable int id, @RequestBody DailyRouteSchedule dlyschdata) 	
	{
		DailyRouteSchedule found = dlyservice.getDailyRouteScheduleById(id);
		if(found == null) 
			return new ResponseEntity<String>("Record Does not exists", HttpStatus.NOT_FOUND);
		else 
		{
			found.setDlystatus(dlyschdata.getDlystatus());
			dlyservice.updateVehicleRouteStatus(id, found);
			return new ResponseEntity<String>("Daily schedule route status updated successfully", HttpStatus.OK);
		}
	}
	
	//Get update the daily vehicle schedule reason based on id
	@PutMapping("/dlyrtereason/{id}")
	public ResponseEntity<String> DailyReasonUpdate
		(@PathVariable int id, @RequestBody DailyRouteSchedule dlyschdata) 	
	{
		DailyRouteSchedule found = dlyservice.getDailyRouteScheduleById(id);
		if(found == null) 
			return new ResponseEntity<String>("Record Does not exists", HttpStatus.NOT_FOUND);
		else 
		{
			found.setDlyvehreason(dlyschdata.getDlyvehreason());
			dlyservice.updateVehicleRouteReason(id, found);
			return new ResponseEntity<String>("Daily schedule route reason updated successfully", HttpStatus.OK);
		}
	}
}

package com.garbagefleet.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.garbagefleet.model.DailyRouteSchedule;
import com.garbagefleet.model.VehicleRoute;
import com.garbagefleet.repository.DailyRouteScheduleRepository;

@Service
public class DailyRouteScheduleService {

	private final DailyRouteScheduleRepository vdrrepository;
	
	public DailyRouteScheduleService
		(DailyRouteScheduleRepository vdrrepository) {
		this.vdrrepository = vdrrepository;
	}
	
	//Select all daily route schedule
	public List<DailyRouteSchedule> getAllDailyShedule() {
		List<DailyRouteSchedule> alldly = vdrrepository.findAll();
		return alldly;
	}
	
	//Create new daily route schedule
	public DailyRouteSchedule createNewDailyRouteSchedule
		(DailyRouteSchedule dlschedule) {
		return vdrrepository.save(dlschedule);
	}
	
	//update the daily schedule based on id value
	public DailyRouteSchedule updateDailyRouteSchedule
		(int id, DailyRouteSchedule newdata) {
		
		DailyRouteSchedule found = vdrrepository.findById(id).orElse(null);
		
		if(found != null) {
			vdrrepository.save(found);			
		}
		return found;
	}

	//Get daily schedule by id
	public DailyRouteSchedule getDailyRouteScheduleById(int id) { 
		return vdrrepository.findById(id).get();
	}
	
	//Delete daily schedule by id
	public void deleteRouteSchedule(int id) {
		vdrrepository.deleteById(id); 
	}
	
	//Get the data based on driver id
	public List<DailyRouteSchedule> 
		getAllDailySheduleBasedOnDriverID(int drvid) {
		List<DailyRouteSchedule> alldlyDrv = 
				vdrrepository.findByDrvid(drvid);
		return alldlyDrv;
	}
	
	//Get the data based on allocated by
	public List<DailyRouteSchedule> 
		getAllDailySheduleBasedOnAllocatedBy(int allocatedid) {
		List<DailyRouteSchedule> alldlyAllocated = 
			vdrrepository.findByAllocatedby(allocatedid);
		return alldlyAllocated;
	}
	
	//Get update the daily vehicle schedule status based on id
	public void updateVehicleRouteStatus
		(int id, DailyRouteSchedule newdata) {

		DailyRouteSchedule found = vdrrepository.findById(id).orElse(null);
		
		if(found != null) {
			found.setDlystatus(newdata.getDlystatus());
			vdrrepository.save(found);			
		}
	}

	//Get update the daily vehicle schedule reason based on id
	public void updateVehicleRouteReason
		(int id, DailyRouteSchedule newdata) {

		DailyRouteSchedule found = vdrrepository.findById(id).orElse(null);
	
		if(found != null) {
			found.setDlyvehreason(newdata.getDlyvehreason());
			vdrrepository.save(found);			
		}
	}	
}

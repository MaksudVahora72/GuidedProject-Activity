package com.garbagefleet.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.garbagefleet.model.VehicleMaster;
import com.garbagefleet.repository.VehicleRepository;

@Service
public class VehicleService {

	private final VehicleRepository vehrepository;
	
	public VehicleService(VehicleRepository vehrepository) {
		this.vehrepository = vehrepository;
	}
	
	//Select all vehicle details
	public List<VehicleMaster> getAllVehicles() {
		List<VehicleMaster> vehicles = vehrepository.findAll();
		return vehicles;
	}
	
	//Create new vehicle details
	public VehicleMaster createNewVehicle(
			VehicleMaster vehicle) {
		return vehrepository.save(vehicle);
	}
	
	//update the vehicle details based on id value
	public VehicleMaster updateVehicle(int id, VehicleMaster newdata) {
		VehicleMaster found = vehrepository.findById(id).orElse(null);
		
		if(found != null) {
			found.setVehdesc1(newdata.getVehdesc1());
			found.setVehdesc2(newdata.getVehdesc2());
			found.setVehmanudate(newdata.getVehmanudate());
			found.setVehpurdate(newdata.getVehpurdate());
			found.setVehregdate(newdata.getVehregdate());
			found.setVehregnumber(newdata.getVehregnumber());
			found.setVtypeid(newdata.getVtypeid());
			found.setVehenginenumber(newdata.getVehenginenumber());
			found.setVehchachiesnumber(newdata.getVehchachiesnumber());
			found.setVehcapacity(newdata.getVehcapacity());
			found.setVehgpsdeviceid(newdata.getVehgpsdeviceid());
			found.setVehinsuid(newdata.getVehinsuid());
			found.setVehinsuexpirydate(newdata.getVehinsuexpirydate());
			found.setVehlastservicedate(newdata.getVehlastservicedate());
			found.setVehstatus(newdata.getVehstatus());
			found.setVehactive(newdata.getVehactive());
			vehrepository.save(found);			
		}
		return found;
	}

	//Get vehicle details by id
	public VehicleMaster getVehicleById(int id) { 
		return vehrepository.findById(id).get();
	}
	
	//Delete vehicle details by id
	public void deleteVehicle(int id) {
		vehrepository.deleteById(id); 
	}
	
	//Get the status wise vehicle
	public List<VehicleMaster> getStatusWiseVehicle(String flag) {
		return vehrepository.findByVehstatus(flag);
	}
	
	//Get the vehicle based on vehicle type
	public List<VehicleMaster> getVehicleByType(int vtype) {
		return vehrepository.findByVtypeid(vtype);
	}
	
	//Get the vehicle insurance expiry based on current month
	public List<VehicleMaster> getVehicleInsuranceExpiry(LocalDateTime startDate, LocalDateTime endDate) {
		// TODO Auto-generated method stub
		return vehrepository.findByVehinsuexpirydateBetween(startDate, endDate);
	}
}

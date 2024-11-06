package com.garbagefleet.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.garbagefleet.model.VehicleServiceMaster;
import com.garbagefleet.repository.VehServiceRepository;

@Service
public class VehicleSrvService {

	private final VehServiceRepository vsrpository;
	
	public VehicleSrvService(VehServiceRepository vsrpository) {
		this.vsrpository = vsrpository;
	}
	
	//Select all vehicle service details
	public List<VehicleServiceMaster> getAllServices() {
		List<VehicleServiceMaster> srvdetails = vsrpository.findAll();
		return srvdetails;
	}
	
	//Create new vehicle service entry
	public VehicleServiceMaster createNewServiceEntry
		(VehicleServiceMaster vehsrventry) {
		return vsrpository.save(vehsrventry);
	}
	
	//update the service entry based on id value
	public VehicleServiceMaster updateVehService(int id, VehicleServiceMaster newdata) {
		VehicleServiceMaster found = vsrpository.findById(id).orElse(null);
		if(found != null) {
			found.setVehid(newdata.getVehid());
			found.setVehsrvtype(newdata.getVehsrvstatus());
			found.setVehcntid(newdata.getVehcntid());
			found.setVehsrvstdate(newdata.getVehsrvstdate());
			found.setVehsrveddate(newdata.getVehsrveddate());
			found.setVehnotes(newdata.getVehnotes());
			found.setVehsrvstatus(newdata.getVehsrvstatus());
			vsrpository.save(found);			
		}
		return found;
	}

	//Get service entry by id
	public VehicleServiceMaster getVehServiceEntry(int id) { 
		return vsrpository.findById(id).get();
	}
	
	//Delete service entry by id
	public void deleteServiceEntry(int id) {
		vsrpository.deleteById(id); 
	}

	//Get update the vehicle service status
	public void setServiceUpdate(VehicleServiceMaster newdata) {
		vsrpository.save(newdata);
	}
	
	//Get all service status entries
	public List<VehicleServiceMaster> getAllServicesStatus(String status) {
		List<VehicleServiceMaster> srvdetails = vsrpository.findByVehsrvstatus(status);
		return srvdetails;
	}
}

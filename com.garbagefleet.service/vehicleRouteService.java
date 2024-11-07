package com.garbagefleet.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.garbagefleet.model.VehicleRoute;
import com.garbagefleet.repository.VehicleRouteRepository;

@Service
public class vehicleRouteService {

	private final VehicleRouteRepository vrterepository;
	
	public vehicleRouteService(VehicleRouteRepository vrterepository) {
		this.vrterepository = vrterepository;
	}
	
	//Select all vehicle route details
	public List<VehicleRoute> getAllVehicleRoutes() {
		List<VehicleRoute> vehicleroutes = vrterepository.findAll();
		return vehicleroutes;
	}
	
	//Create new vehicle route details
	public VehicleRoute createNewVehicleRoute(
			VehicleRoute vehicleroute) {
		return vrterepository.save(vehicleroute);
	}
	
	//update the vehicle route details based on id value
	public VehicleRoute updateVehicleRoute(int id, VehicleRoute newdata) {
		
		VehicleRoute found = vrterepository.findById(id).orElse(null);
		
		if(found != null) {
			found.setRtename(newdata.getRtename());
			found.setRtedescription(newdata.getRtedescription());
			found.setRtestlocation(newdata.getRtestlocation());
			found.setRteedlocation(newdata.getRteedlocation());
			found.setRteesttime(newdata.getRteesttime());
			found.setRteedtime(newdata.getRteedtime());
			found.setRtedistance(newdata.getRtedistance());
			found.setRtesttime(newdata.getRtesttime());
			found.setRtedays(newdata.getRtedays());
			found.setVehid(newdata.getVehid());
			found.setRteactive(newdata.getRteactive());
			vrterepository.save(found);			
		}
		return found;
	}

	//Get vehicle route details by id
	public VehicleRoute getVehicleRouteById(int id) { 
		return vrterepository.findById(id).get();
	}
	
	//Delete vehicle route details by id
	public void deleteVehicleRoute(int id) {
		vrterepository.deleteById(id); 
	}

	//Select all vehicle route details based on location
	public List<VehicleRoute> getAllVehicleBasedOnLocation(String location) {
		List<VehicleRoute> vehicleroutes = 
				vrterepository.findByRtestlocation(location);
		return vehicleroutes;
	}

	//Select all vehicle route details based on active status or not
	public List<VehicleRoute> getAllVehicleBasedOnStatus(String status) {
		List<VehicleRoute> vehicleroutes = 
				vrterepository.findByRteactive(status);
		return vehicleroutes;
	}

	//Select all vehicle route details based on days
	public List<VehicleRoute> getAllVehicleBasedOnDays(String days) {
		List<VehicleRoute> vehicleroutes = 
				vrterepository.findByRtedays(days);
		return vehicleroutes;
	}

	//Set active status of vehicle route
	public void updateVehicleRouteActive(int id, VehicleRoute newdata) {

		VehicleRoute found = vrterepository.findById(id).orElse(null);
		
		if(found != null) {
			found.setRteactive(newdata.getRteactive());
			vrterepository.save(found);			
		}
	}
}

package com.garbagefleet.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.garbagefleet.model.ServiceCenterMaster;
import com.garbagefleet.repository.ServiceRepository;

@Service
public class ServiceCenterService {

	private final ServiceRepository srvrepository;
	
	public ServiceCenterService(ServiceRepository srvrepository) {
		this.srvrepository = srvrepository;
	}
	
	//Select all center location
	public List<ServiceCenterMaster> getAllCenters() {
		List<ServiceCenterMaster> centers = srvrepository.findAll();
		return centers;
	}
	
	//Create new center location
	public ServiceCenterMaster createNewCenter(ServiceCenterMaster center) {
		return srvrepository.save(center);
	}
	
	//update the center based on id value
	public ServiceCenterMaster updateCenter(int id, ServiceCenterMaster newdata) {
		ServiceCenterMaster found = srvrepository.findById(id).orElse(null);
		if(found != null) {
			found.setSrvcntname(newdata.getSrvcntname());
			found.setSrvcntaddress1(newdata.getSrvcntaddress1());
			found.setSrvcntaddress2(newdata.getSrvcntaddress2());
			found.setSrvcntcity(newdata.getSrvcntcity());
			found.setSrvcntcontact1(newdata.getSrvcntcontact1());
			found.setSrvcntaddress2(newdata.getSrvcntcontact1());
			found.setSrvcntemail(newdata.getSrvcntemail());
			srvrepository.save(found);			
		}
		return found;
	}

	//Get center location by id
	public ServiceCenterMaster getCenterById(int id) { 
		return srvrepository.findById(id).get();
	}
	
	//Delete center location by id
	public void deleteCenter(int id) {
		srvrepository.deleteById(id); 
	}
}

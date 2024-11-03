package com.garbagefleet.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.garbagefleet.model.VehicleFuelTypeMaster;
import com.garbagefleet.repository.FuelTypeRepository;

@Service
public class FuelTypeMasterService {
	
	private final FuelTypeRepository ftrepository;
	
	public FuelTypeMasterService(FuelTypeRepository ftrepository) {
		this.ftrepository = ftrepository;
	}
	
	//Select all fueltype
	public List<VehicleFuelTypeMaster> getAllFuelTypes() {
		List<VehicleFuelTypeMaster> lstftype = ftrepository.findAll();
		System.out.println(lstftype.size());
		return lstftype;
	}
	
	//Create new Fueltype
	public VehicleFuelTypeMaster createNewFuelType(VehicleFuelTypeMaster ftype) {
		return ftrepository.save(ftype);
	}
	
	//update the usertype based on id value
	public VehicleFuelTypeMaster updateFuelType(int id, VehicleFuelTypeMaster newdata) {
		VehicleFuelTypeMaster found = ftrepository.findById(id).orElse(null);
		if(found != null) {
			found.setVftype_desc(newdata.getVftype_desc());
			ftrepository.save(found);			
		}
		return found;
	}

	//Get fueltype by id
	public VehicleFuelTypeMaster getFuelTypeById(int id) { 
		return ftrepository.findById(id).get();
	}
	
	//Delete fueltype by id
	public void deleteFuelType(int id) {
		ftrepository.deleteById(id); 
	}
}

package com.garbagefleet.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.garbagefleet.model.VehicleInsurance;
import com.garbagefleet.repository.VehInsuranceRepository;

@Service
public class VehInsuranceService {

	private final VehInsuranceRepository virepository;
	
	public VehInsuranceService(VehInsuranceRepository virepository) {
		this.virepository = virepository;
	}
	
	//Select all vehicle insurance issued entries
	public List<VehicleInsurance> getAllInsuranceEntries() {
		List<VehicleInsurance> vientries = virepository.findAll();
		return vientries;
	}
	
	//Create new vehicle insurance entry
	public VehicleInsurance createVehicleEntry(VehicleInsurance vientry) {
		return virepository.save(vientry);
	}
	
	//update the insurance issued based on id value
	public VehicleInsurance updateVehEntry(int id, VehicleInsurance newdata) {
		VehicleInsurance found = virepository.findById(id).orElse(null);
		if(found != null) {
			found.setVtrandate(newdata.getVtrandate());
			found.setVehid(newdata.getVehid());
			found.setVinsudate(newdata.getVinsudate());
			found.setVinsuenddate(newdata.getVinsuenddate());
			found.setVidvvalue(newdata.getVidvvalue());
			found.setVinsuprem(newdata.getVinsuprem());
			found.setPaymenttype(newdata.getPaymenttype());
			found.setVinsucertnumber(newdata.getVinsucertnumber());
			found.setBankname(newdata.getBankname());
			found.setBankbranch(newdata.getBankbranch());
			virepository.save(found);			
		}
		return found;
	}

	//Get vehicle insurance entry by id
	public VehicleInsurance getVehEntryById(int id) { 
		return virepository.findById(id).get();
	}
	
	//Delete vehicle insurance entry by id
	public void deleteVehicleInsurance(int id) {
		virepository.deleteById(id); 
	}
	
	//Select all vehicle insurance issued entries based on tran type
	public List<VehicleInsurance> getAllInsuEntriesBasedTranType(String paytype) {
		List<VehicleInsurance> vientries = virepository.findByPaymenttype(paytype);
		return vientries;
	}
	
	
}

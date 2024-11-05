package com.garbagefleet.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.garbagefleet.model.DriverMaster;
import com.garbagefleet.repository.DriverRepository;

@Service
public class DriverService {
	private final DriverRepository drvrepository;
	
	public DriverService(DriverRepository drvrepository) {
		this.drvrepository = drvrepository;
	}
	
	//Select all driver details
	public List<DriverMaster> getAllDrivers() {
		List<DriverMaster> drivers = drvrepository.findAll();
		return drivers;
	}
	
	//Create new driver details
	public DriverMaster createNewDriver(
			DriverMaster driver) {
		return drvrepository.save(driver);
	}
	
	//update the driver details based on id value
	public DriverMaster updateDriver(int id, DriverMaster newdata) {
		DriverMaster found = drvrepository.findById(id).orElse(null);
		
		if(found != null) {
			found.setDrvfname(newdata.getDrvfname());
			found.setDrvsname(newdata.getDrvsname());
			found.setDrvaddress1(newdata.getDrvaddress1());
			found.setDrvaddress2(newdata.getDrvaddress1());
			found.setDrvcity(newdata.getDrvcity());
			found.setDrvstate(newdata.getDrvstate());
			found.setDrvgender(newdata.getDrvgender());
			found.setDrvbdate(newdata.getDrvbdate());
			found.setDrvmobile(newdata.getDrvmobile());
			found.setDrvemercontact(newdata.getDrvemercontact());
			found.setDrvjoindate(newdata.getDrvjoindate());
			found.setDrvadharcard(newdata.getDrvadharcard());
			found.setDrvexperience(newdata.getDrvexperience());
			found.setDrvlicnumber(newdata.getDrvlicnumber());
			found.setDrvlictype(newdata.getDrvlictype());
			found.setDrvlicissuedate(newdata.getDrvlicissuedate());
			found.setDrvlicenddate(newdata.getDrvlicenddate());
			found.setDrvsfttimings(newdata.getDrvsfttimings());
			found.setDrvimage(newdata.getDrvimage());
			found.setDrvmedicalhistory(newdata.getDrvmedicalhistory());
			found.setDrvactive(newdata.getDrvactive());
			drvrepository.save(found);			
		}
		return found;
	}

	//Get driver details by id
	public DriverMaster getDriverById(int id) { 
		return drvrepository.findById(id).get();
	}
	
	//Delete driver details by id
	public void deleteDriver(int id) {
		drvrepository.deleteById(id); 
	}

	//Set deactivate the driver
	public void driverSetInactive(int id, DriverMaster newdata) {
		DriverMaster found = drvrepository.findById(id).orElse(null);
		if(found != null) {
			found.setDrvactive(newdata.getDrvactive());
			drvrepository.save(found);			
		}
	}
	
	//Set deactivate the driver
	public void driverSetImage(int id, DriverMaster newdata) {
		DriverMaster found = drvrepository.findById(id).orElse(null);
		if(found != null) {
			found.setDrvimage(newdata.getDrvimage());
			drvrepository.save(found);			
		}
	}
		
	//Get all In-active driver details
	public List<DriverMaster> getAllInActiveDrivers(String flag) {
		return drvrepository.findByDrvactive(flag);
	}
}

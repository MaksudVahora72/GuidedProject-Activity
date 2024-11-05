package com.garbagefleet.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.garbagefleet.model.InsuranceCompanyMaster;
import com.garbagefleet.model.UserMaster;
import com.garbagefleet.repository.InsuranceCompanyRepository;

@Service
public class InsuranceCompanyService {

	private final InsuranceCompanyRepository icrepository;
	
	public InsuranceCompanyService(InsuranceCompanyRepository icrepository) {
		this.icrepository = icrepository;
	}
	
	//Select all insurance company details
	public List<InsuranceCompanyMaster> getAllInsuranceCompany() {
		List<InsuranceCompanyMaster> dsgs = icrepository.findAll();
		return dsgs;
	}
	
	//Create new Insurance company
	public InsuranceCompanyMaster createNewInsurance(
			InsuranceCompanyMaster insurance) {
		return icrepository.save(insurance);
	}
	
	//update the Insurance company based on id value
	public InsuranceCompanyMaster updateInsurance(int id, InsuranceCompanyMaster newdata) {
		InsuranceCompanyMaster found = icrepository.findById(id).orElse(null);
		
		if(found != null) {
			found.setInsucname(newdata.getInsucname());
			found.setInsucadd1(newdata.getInsucadd1());
			found.setInsucadd2(newdata.getInsucadd2());
			found.setInsuccity(newdata.getInsuccity());
			found.setInsucph1(newdata.getInsucph1());
			found.setInsucph1(newdata.getInsucph2());
			found.setInsucemail(newdata.getInsucemail());
			found.setInsucrefname(newdata.getInsucrefname());
			found.setInsucrefemail(newdata.getInsucrefemail());
			found.setInsucrefph(newdata.getInsucrefph());
			found.setInsucactive(newdata.getInsucactive());
			icrepository.save(found);			
		}
		return found;
	}

	//Get insurance company by id
	public InsuranceCompanyMaster getInsuranceById(int id) { 
		return icrepository.findById(id).get();
	}
	
	//Delete insurance by id
	public void deleteInsurance(int id) {
		icrepository.deleteById(id); 
	}

	//Set deactivate the insurance company
	public void insuranceSetInactive(int id, InsuranceCompanyMaster newdata) {
		InsuranceCompanyMaster found = icrepository.findById(id).orElse(null);
		if(found != null) {
			found.setInsucactive(newdata.getInsucactive());
			icrepository.save(found);			
		}
	}
		
	//Get all In-active insurance company details
	public List<InsuranceCompanyMaster> getAllInActiveInsurance(String flag) {
		return icrepository.findByinsucactive(flag);
	}
	
}

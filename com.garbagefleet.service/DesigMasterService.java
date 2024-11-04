package com.garbagefleet.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.garbagefleet.model.DesigMaster;
import com.garbagefleet.repository.DesigMasterRepository;

@Service
public class DesigMasterService {
	
	private final DesigMasterRepository dsgepository;
	
	public DesigMasterService(DesigMasterRepository dsgepository) {
		this.dsgepository = dsgepository;
	}
	
	//Select all designation
	public List<DesigMaster> getAllDesignation() {
		List<DesigMaster> dsgs = dsgepository.findAll();
		return dsgs;
	}
	
	//Create new designation
	public DesigMaster createNewDesignation(DesigMaster desig) {
		return dsgepository.save(desig);
	}
	
	//update the designation based on id value
	public DesigMaster updateDesignation(int id, DesigMaster newdata) {
		DesigMaster found = dsgepository.findById(id).orElse(null);
		if(found != null) {
			found.setDesig_desc(newdata.getDesig_desc());
			dsgepository.save(found);			
		}
		return found;
	}

	//Get designation by id
	public DesigMaster getDesignationById(int id) { 
		return dsgepository.findById(id).get();
	}
	
	//Delete designation by id
	public void deleteDesignation(int id) {
		dsgepository.deleteById(id); 
	}
}

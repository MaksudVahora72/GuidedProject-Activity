package com.garbagefleet.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.garbagefleet.model.EmpTypeMaster;
import com.garbagefleet.repository.EmployeeTypeRepository;

@Service
public class EmployeeTypeService {
	
	private final EmployeeTypeRepository etrepository;
	
	public EmployeeTypeService(EmployeeTypeRepository etrepository) {
		this.etrepository = etrepository;
	}
	
	//Select all employee type
	public List<EmpTypeMaster> getAllEmpTypes() {
		List<EmpTypeMaster> lstetype = etrepository.findAll();
		return lstetype;
	}
	
	//Create new Employee type
	public EmpTypeMaster createNewEmpType(EmpTypeMaster etype) {
		return etrepository.save(etype);
	}
	
	//update the emptype based on id value
	public EmpTypeMaster updateEmpType(int id, EmpTypeMaster newdata) {
		EmpTypeMaster found = etrepository.findById(id).orElse(null);
		if(found != null) {
			found.setEtype_desc(newdata.getEtype_desc());
			etrepository.save(found);			
		}
		return found;
	}

	//Get employee type by id
	public EmpTypeMaster getEmpTypeById(int id) { 
		return etrepository.findById(id).get();
	}
	
	//Delete Employee type by id
	public void deleteEmpType(int id) {
		etrepository.deleteById(id); 
	}
}

package com.garbagefleet.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.garbagefleet.model.EmployeeMaster;
import com.garbagefleet.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	private final EmployeeRepository emprepository;
	
	public EmployeeService(EmployeeRepository emprepository) {
		this.emprepository = emprepository;
	}
	
	//Select all employees details
	public List<EmployeeMaster> getAllEmployees() {
		List<EmployeeMaster> employees = emprepository.findAll();
		return employees;
	}
	
	//Create new employee details
	public EmployeeMaster createNewEmployee(
			EmployeeMaster employee) {
		return emprepository.save(employee);
	}
	
	//update the employee details based on id value
	public EmployeeMaster updateEmployee(int id, EmployeeMaster newdata) {
		EmployeeMaster found = emprepository.findById(id).orElse(null);
		
		if(found != null) {
			found.setEmpfname(newdata.getEmpfname());
			found.setEmpsname(newdata.getEmpsname());
			found.setEmpaddress1(newdata.getEmpaddress1());
			found.setEmpaddress2(newdata.getEmpaddress2());
			found.setEmpcity(newdata.getEmpcity());
			found.setEmpstate(newdata.getEmpstate());
			found.setEmptype(newdata.getEmptype());
			found.setEmpbdate(newdata.getEmpbdate());
			found.setEmpgender(newdata.getEmpgender());
			found.setEmpemail(newdata.getEmpemail());
			found.setEmpcontact1(newdata.getEmpcontact1());
			found.setEmpcontact2(newdata.getEmpcontact2());
			found.setEmpdesigId(newdata.getEmpdesigid());
			found.setEmpjdate(newdata.getEmpjdate());
			found.setEmpadharid(newdata.getEmpadharid());
			found.setEmppanid(newdata.getEmppanid());
			found.setEmpuserid(newdata.getEmpuserid());
			found.setEmpimage(newdata.getEmpimage());
			found.setEmpactive(newdata.getEmpactive());
			emprepository.save(found);			
		}
		return found;
	}

	//Get employee details by id
	public EmployeeMaster getEmployeeById(int id) { 
		return emprepository.findById(id).get();
	}
	
	//Delete employee details by id
	public void deleteEmployee(int id) {
		emprepository.deleteById(id); 
	}
	
	//Set deactivate the employee
	public void employeeSetInactive(int id, EmployeeMaster newdata) {
		EmployeeMaster found = emprepository.findById(id).orElse(null);
		if(found != null) {
			found.setEmpactive(newdata.getEmpactive());
			emprepository.save(found);			
		}
	}
	
	//Set newimage to the employee
	public void employeeSetImage(int id, EmployeeMaster newdata) {
		EmployeeMaster found = emprepository.findById(id).orElse(null);
		if(found != null) {
			found.setEmpimage(newdata.getEmpimage());
			emprepository.save(found);			
		}
	}
		
	//Get all In-active employee details
	public List<EmployeeMaster> getAllInActiveEmployee(String flag) {
		return emprepository.findByEmpactive(flag);
	}

}

package com.garbagefleet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.garbagefleet.model.EmployeeMaster;

@Repository
public interface EmployeeRepository 
	extends JpaRepository<EmployeeMaster, Integer>{
	List<EmployeeMaster> findByEmpactive(String empactive);

}

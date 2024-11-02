package com.garbagefleet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.garbagefleet.model.EmpTypeMaster;

@Repository
public interface EmployeeTypeRepository 
	extends JpaRepository<EmpTypeMaster, Integer> {
}

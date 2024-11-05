package com.garbagefleet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.garbagefleet.model.DriverMaster;

@Repository
public interface DriverRepository 
	extends JpaRepository<DriverMaster, Integer> {
	List<DriverMaster> findByDrvactive(String driveractive);
}

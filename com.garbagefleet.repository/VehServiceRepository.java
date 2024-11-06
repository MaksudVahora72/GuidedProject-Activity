package com.garbagefleet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.garbagefleet.model.VehicleServiceMaster;

@Repository
public interface VehServiceRepository 
	extends JpaRepository<VehicleServiceMaster, Integer> {
	List<VehicleServiceMaster> findByVehsrvstatus(String vehsrvstatus);
}

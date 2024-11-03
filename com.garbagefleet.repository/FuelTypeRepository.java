package com.garbagefleet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.garbagefleet.model.VehicleFuelTypeMaster;

@Repository
public interface FuelTypeRepository extends 
	JpaRepository<VehicleFuelTypeMaster, Integer>{
}

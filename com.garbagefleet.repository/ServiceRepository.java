package com.garbagefleet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.garbagefleet.model.ServiceCenterMaster;

@Repository
public interface ServiceRepository extends 
	JpaRepository<ServiceCenterMaster, Integer>{
}

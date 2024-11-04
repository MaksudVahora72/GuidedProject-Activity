package com.garbagefleet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.garbagefleet.model.DesigMaster;

@Repository
public interface DesigMasterRepository 
	extends JpaRepository<DesigMaster, Integer> {
}

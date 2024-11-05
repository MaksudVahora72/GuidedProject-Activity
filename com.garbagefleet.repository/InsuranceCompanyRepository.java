package com.garbagefleet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.garbagefleet.model.InsuranceCompanyMaster;

@Repository
public interface InsuranceCompanyRepository 
	extends JpaRepository<InsuranceCompanyMaster, Integer> {
	List<InsuranceCompanyMaster> findByinsucactive(String useractive);
}
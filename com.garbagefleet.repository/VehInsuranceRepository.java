package com.garbagefleet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.garbagefleet.model.VehicleInsurance;

@Repository
public interface VehInsuranceRepository 
 	extends JpaRepository<VehicleInsurance, Integer>	{
	List<VehicleInsurance> findByPaymenttype(String paymenttype);
}

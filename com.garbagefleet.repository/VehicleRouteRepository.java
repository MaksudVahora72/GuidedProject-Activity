package com.garbagefleet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.garbagefleet.model.VehicleRoute;

@Repository
public interface VehicleRouteRepository 
	extends JpaRepository<VehicleRoute, Integer> {
	
	List<VehicleRoute> findByRtestlocation(String rtestlocation);
	List<VehicleRoute> findByRteactive(String rteactive);
	List<VehicleRoute> findByRtedays(String rtedays);
}

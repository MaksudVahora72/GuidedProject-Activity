package com.garbagefleet.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.garbagefleet.model.VehicleMaster;

@Repository
public interface VehicleRepository 
	extends JpaRepository<VehicleMaster, Integer> {
	List<VehicleMaster> findByVehstatus(String vstatus);
	List<VehicleMaster> findByVtypeid(int vtype);
	List<VehicleMaster> findByVehinsuexpirydateBetween(LocalDateTime fd, LocalDateTime ld);	
}

package com.garbagefleet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.garbagefleet.model.DailyRouteSchedule;
import java.util.List;


@Repository
public interface DailyRouteScheduleRepository 
	extends JpaRepository<DailyRouteSchedule, Integer> {
	
	List<DailyRouteSchedule> findByAllocatedby(int allocatedby);
	List<DailyRouteSchedule> findByDrvid(int drvid);
}

package com.garbagefleet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.garbagefleet.model.UserMaster;

@Repository
public interface UserMasterRepository 
	extends JpaRepository<UserMaster, Integer> {
	List<UserMaster> findByUseravail(String useravail);
	List<UserMaster> findByUseractive(String useractive);
}

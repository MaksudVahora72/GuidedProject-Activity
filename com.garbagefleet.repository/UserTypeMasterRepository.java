package com.garbagefleet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.garbagefleet.model.UserTypeMaster;

@Repository
public interface UserTypeMasterRepository extends 
	JpaRepository<UserTypeMaster, Integer> {
}

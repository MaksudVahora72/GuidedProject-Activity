package com.garbagefleet.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="VehicleFuelTypeMaster")
public class VehicleFuelTypeMaster {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int vftype_id;
	
	private String vftype_desc;
	
	public int getVftype_id() {	return vftype_id; }
	public void setVftype_id(int vftype_id) { this.vftype_id = vftype_id; }
	
	public String getVftype_desc() { return vftype_desc; }
	public void setVftype_desc(String vftype_desc) { this.vftype_desc = vftype_desc; }

}

package com.garbagefleet.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="EmployeeTypeMaster")
public class EmpTypeMaster {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int etype_id;
	
	@Column(nullable = false, unique = true)
	private String etype_desc;
	
	public int getEtype_id() { return etype_id; }
	public void setEtype_id(int etype_id) { this.etype_id = etype_id; }
	
	public String getEtype_desc() { return etype_desc; }
	public void setEtype_desc(String etype_desc) { this.etype_desc = etype_desc; }
}

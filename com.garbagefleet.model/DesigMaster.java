package com.garbagefleet.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "DesigMaster")
public class DesigMaster {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int desig_id;
	
	@NotNull(message = "Designation should not be null")
	
	@Column(nullable = false, unique = true)
	private String desig_desc;
	
	public int getDesig_id() { return desig_id; }
	public void setDesig_id(int desig_id) { this.desig_id = desig_id; }
	
	public String getDesig_desc() { return desig_desc; }
	public void setDesig_desc(String desig_desc) { this.desig_desc = desig_desc;}

}

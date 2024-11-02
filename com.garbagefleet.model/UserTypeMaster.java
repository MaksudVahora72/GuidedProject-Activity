package com.garbagefleet.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "UserTypeMaster")
public class UserTypeMaster {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int utype_id;
	
	@Column(nullable = false, unique = true)
	private String utype_desc;
	
	public int getUtype_id() { return utype_id; }
	public void setUtype_id(int utype_id) { this.utype_id = utype_id; }
	
	public String getUtype_desc() { return utype_desc; }
	public void setUtype_desc(String utype_desc) { this.utype_desc = utype_desc; }

}

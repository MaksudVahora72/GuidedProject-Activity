package com.garbagefleet.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ServiceCenterMaster")
public class ServiceCenterMaster {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int srvcntid;
	private String srvcntname;
	private String srvcntaddress1;	
	private String srvcntaddress2;
	private String srvcntcity;
	
	@Column(nullable = false, unique = true)
	private String srvcntcontact1;

	@Column(nullable = false, unique = true)
	private String srvcntcontact2;

	@Column(nullable = false, unique = true)
	private String srvcntemail;

	public int getSrvcntid() {
		return srvcntid;
	}

	public void setSrvcntid(int srvcntid) {
		this.srvcntid = srvcntid;
	}

	public String getSrvcntname() {
		return srvcntname;
	}

	public void setSrvcntname(String srvcntname) {
		this.srvcntname = srvcntname;
	}

	public String getSrvcntaddress1() {
		return srvcntaddress1;
	}

	public void setSrvcntaddress1(String srvcntaddress1) {
		this.srvcntaddress1 = srvcntaddress1;
	}

	public String getSrvcntaddress2() {
		return srvcntaddress2;
	}

	public void setSrvcntaddress2(String srvcntaddress2) {
		this.srvcntaddress2 = srvcntaddress2;
	}

	public String getSrvcntcity() {
		return srvcntcity;
	}

	public void setSrvcntcity(String srvcntcity) {
		this.srvcntcity = srvcntcity;
	}

	public String getSrvcntcontact1() {
		return srvcntcontact1;
	}

	public void setSrvcntcontact1(String srvcntcontact1) {
		this.srvcntcontact1 = srvcntcontact1;
	}

	public String getSrvcntcontact2() {
		return srvcntcontact2;
	}

	public void setSrvcntcontact2(String srvcntcontact2) {
		this.srvcntcontact2 = srvcntcontact2;
	}

	public String getSrvcntemail() {
		return srvcntemail;
	}

	public void setSrvcntemail(String srvcntemail) {
		this.srvcntemail = srvcntemail;
	}	
}

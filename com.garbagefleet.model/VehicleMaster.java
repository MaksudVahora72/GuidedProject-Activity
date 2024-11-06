package com.garbagefleet.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "VehicleMaster")
public class VehicleMaster {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int vehid;
	
	@Column(nullable = false)
	private String vehdesc1;
	
	@Column(nullable = false)
	private String vehdesc2;
	private Date vehmanudate;	
	private Date vehpurdate;	
	private String vehregdate;
	
	@Column(nullable = false, unique = true)
	private String vehregnumber;
	private int vtypeid;
	private int vehcapacity;
	
	@Column(nullable = false, unique = true)
	private String vehchachiesnumber;
	
	@Column(nullable = false, unique = true)
	private String vehenginenumber;
	private String vehgpsdeviceid;
	
	@Column(nullable = false, unique = true)
	private int vehinsuid;
	private Date vehinsuexpirydate;
	private Date vehlastservicedate;
	private String vehstatus;
	private String vehactive;

	public int getVehid() {
		return vehid;
	}
	public void setVehid(int vehid) {
		this.vehid = vehid;
	}
	public String getVehdesc1() {
		return vehdesc1;
	}
	public void setVehdesc1(String vehdesc1) {
		this.vehdesc1 = vehdesc1;
	}
	public String getVehdesc2() {
		return vehdesc2;
	}
	public void setVehdesc2(String vehdesc2) {
		this.vehdesc2 = vehdesc2;
	}
	public Date getVehmanudate() {
		return vehmanudate;
	}
	public void setVehmanudate(Date vehmanudate) {
		this.vehmanudate = vehmanudate;
	}
	public Date getVehpurdate() {
		return vehpurdate;
	}
	public void setVehpurdate(Date vehpurdate) {
		this.vehpurdate = vehpurdate;
	}
	public String getVehregdate() {
		return vehregdate;
	}
	public void setVehregdate(String vehregdate) {
		this.vehregdate = vehregdate;
	}
	public String getVehregnumber() {
		return vehregnumber;
	}
	public void setVehregnumber(String vehregnumber) {
		this.vehregnumber = vehregnumber;
	}
	public int getVtypeid() {
		return vtypeid;
	}
	public void setVtypeid(int vtypeid) {
		this.vtypeid = vtypeid;
	}
	public int getVehcapacity() {
		return vehcapacity;
	}
	public void setVehcapacity(int vehcapacity) {
		this.vehcapacity = vehcapacity;
	}
	public String getVehchachiesnumber() {
		return vehchachiesnumber;
	}
	public void setVehchachiesnumber(String vehchachiesnumber) {
		this.vehchachiesnumber = vehchachiesnumber;
	}
	public String getVehenginenumber() {
		return vehenginenumber;
	}
	public void setVehenginenumber(String vehenginenumber) {
		this.vehenginenumber = vehenginenumber;
	}
	public String getVehgpsdeviceid() {
		return vehgpsdeviceid;
	}
	public void setVehgpsdeviceid(String vehgpsdeviceid) {
		this.vehgpsdeviceid = vehgpsdeviceid;
	}
	public int getVehinsuid() {
		return vehinsuid;
	}
	public void setVehinsuid(int vehinsuid) {
		this.vehinsuid = vehinsuid;
	}
	public Date getVehinsuexpirydate() {
		return vehinsuexpirydate;
	}
	public void setVehinsuexpirydate(Date vehinsuexpirydate) {
		this.vehinsuexpirydate = vehinsuexpirydate;
	}
	public Date getVehlastservicedate() {
		return vehlastservicedate;
	}
	public void setVehlastservicedate(Date vehlastservicedate) {
		this.vehlastservicedate = vehlastservicedate;
	}
	public String getVehstatus() {
		return vehstatus;
	}
	public void setVehstatus(String vehstatus) {
		this.vehstatus = vehstatus;
	}
	public String getVehactive() {
		return vehactive;
	}
	public void setVehactive(String vehactive) {
		this.vehactive = vehactive;
	}
}

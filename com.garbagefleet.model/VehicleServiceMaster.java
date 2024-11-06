package com.garbagefleet.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "VehicleServiceMaster")
public class VehicleServiceMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int vehsrvid;
	
	@Column(nullable = false)
	private int vehid;	
	private Date vehsrvstdate;
	private Date vehsrveddate;
	
	@Column(nullable = false)
	private String vehsrvtype;
	
	@Column(nullable = false)
	private int vehcntid;	
	private String vehnotes;
	private String vehsrvstatus;

	public int getVehsrvid() { return vehsrvid; }
	public void setVehsrvid(int vehsrvid) { this.vehsrvid = vehsrvid; }
	
	public int getVehid() { return vehid;}
	public void setVehid(int vehid) { this.vehid = vehid; }
	
	public Date getVehsrvstdate() { return vehsrvstdate; }
	public void setVehsrvstdate(Date vehsrvstdate) { this.vehsrvstdate = vehsrvstdate; }
	
	public Date getVehsrveddate() { return vehsrveddate; }
	public void setVehsrveddate(Date vehsrveddate) { this.vehsrveddate = vehsrveddate; }
	
	public String getVehsrvtype() { return vehsrvtype; }
	public void setVehsrvtype(String vehsrvtype) { this.vehsrvtype = vehsrvtype; }
	
	public int getVehcntid() { return vehcntid; }
	public void setVehcntid(int vehcntid) { this.vehcntid = vehcntid; }
	
	public String getVehnotes() { return vehnotes; }
	public void setVehnotes(String vehnotes) { this.vehnotes = vehnotes; }
	
	public String getVehsrvstatus() { return vehsrvstatus; }
	public void setVehsrvstatus(String vehsrvstatus) { this.vehsrvstatus = vehsrvstatus; }

}

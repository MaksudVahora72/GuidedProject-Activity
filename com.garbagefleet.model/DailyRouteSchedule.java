package com.garbagefleet.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="DailyRouteSchedule")
public class DailyRouteSchedule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int dlysrno;
	private Date dlytrdate;
	private int dlyrouteid;
	private int drvid;
	private int allocatedby;
	private String dlyvehreason;
	private String dlystatus;
	
	public int getDlysrno() { return dlysrno; }
	public void setDlysrno(int dlysrno) { this.dlysrno = dlysrno; }
	
	public Date getDlytrdate() { return dlytrdate; }
	public void setDlytrdate(Date dlytrdate) { this.dlytrdate = dlytrdate; }
	
	public int getDlyrouteid() { return dlyrouteid; }
	public void setDlyrouteid(int dlyrouteid) { this.dlyrouteid = dlyrouteid;}

	public int getDrvid() { return drvid; }
	public void setDrvid(int drvid) { this.drvid = drvid; }
	
	public int getAllocatedby() { return allocatedby; }
	public void setAllocatedby(int allocatedby) { this.allocatedby = allocatedby; }
	
	public String getDlyvehreason() { return dlyvehreason; }
	public void setDlyvehreason(String dlyvehreason) { this.dlyvehreason = dlyvehreason; }
	
	public String getDlystatus() { return dlystatus; }
	public void setDlystatus(String dlystatus) { this.dlystatus = dlystatus; }
	
	
	
}

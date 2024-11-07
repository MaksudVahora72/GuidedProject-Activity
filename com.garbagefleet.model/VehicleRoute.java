package com.garbagefleet.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "VehicleRoute")
public class VehicleRoute {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int rteid;
	private String rtename;
	private int vehid;
	private String rtedescription;
	private String rtestlocation;	
	private String rteedlocation;
	private String rtesttime;	
	private String rteedtime;	
	private String rtedistance;	
	private String rteesttime;
	private String rtedays;	
	private String rteactive;
	
	public int getRteid() { return rteid; }
	public void setRteid(int rteid) { this.rteid = rteid; }
	
	public String getRtename() { return rtename; }
	public void setRtename(String rtename) { this.rtename = rtename; }

	public int getVehid() { return vehid; }
	public void setVehid(int vehid) { this.vehid = vehid; }

	public String getRtedescription() { return rtedescription; }
	public void setRtedescription(String rtedescription) { this.rtedescription = rtedescription;}

	public String getRtestlocation() { return rtestlocation; }
	public void setRtestlocation(String rtestlocation) { this.rtestlocation = rtestlocation; }

	public String getRteedlocation() { return rteedlocation; }
	public void setRteedlocation(String rteedlocation) { this.rteedlocation = rteedlocation; }

	public String getRtesttime() { return rtesttime; }
	public void setRtesttime(String rtesttime) { this.rtesttime = rtesttime; }

	public String getRteedtime() { return rteedtime; }
	public void setRteedtime(String rteedtime) { this.rteedtime = rteedtime; }

	public String getRtedistance() { return rtedistance; }
	public void setRtedistance(String rtedistance) { this.rtedistance = rtedistance; }

	public String getRteesttime() { return rteesttime; }
	public void setRteesttime(String rteesttime) { this.rteesttime = rteesttime; }

	public String getRtedays() { return rtedays; }
	public void setRtedays(String rtedays) { this.rtedays = rtedays; }

	public String getRteactive() { return rteactive; }
	public void setRteactive(String rteactive) { this.rteactive = rteactive; }	
}

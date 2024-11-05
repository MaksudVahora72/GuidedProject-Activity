package com.garbagefleet.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "DriverMaster")
public class DriverMaster {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int drvid;

	@Column(nullable = false)
	private String drvfname;	
	@Column(nullable = false)
	private String drvsname;	
	@Column(nullable = false)
	private String drvaddress1;	
	private String drvaddress2;	
	private String drvcity;	
	private String drvstate;	
	@Column(nullable = false, unique = true)
	private String drvmobile;	
	@Column(nullable = false, unique = true)
	private String drvemercontact;	
	private String drvgender;	
	private String drvbdate;	
	private String drvjoindate;	
	private String drvsfttimings;
	@Column(nullable = false, unique = true)
	private String drvlicnumber;
	private String drvlictype;	
	private String drvlicissuedate;	
	private String drvlicenddate;	
	@Column(nullable = false, unique = true)
	private String drvadharcard;	
	private int drvexperience;	
	private String drvmedicalhistory;	
	private String drvimage;	
	private String drvactive;

	public int getDrvid() { return drvid; }
	public void setDrvid(int drvid) { this.drvid = drvid;}
	
	public String getDrvfname() { return drvfname; }
	public void setDrvfname(String drvfname) { this.drvfname = drvfname; }
	
	public String getDrvsname() { return drvsname; }
	public void setDrvsname(String drvsname) { this.drvsname = drvsname;}
	
	public String getDrvaddress1() { return drvaddress1; }
	public void setDrvaddress1(String drvaddress1) { this.drvaddress1 = drvaddress1;}
	
	public String getDrvaddress2() { return drvaddress2;}
	public void setDrvaddress2(String drvaddress2) { this.drvaddress2 = drvaddress2; }
	
	public String getDrvcity() { return drvcity; }
	public void setDrvcity(String drvcity) { this.drvcity = drvcity; }
	
	public String getDrvstate() { return drvstate; }
	public void setDrvstate(String drvstate) { this.drvstate = drvstate; }
	
	public String getDrvmobile() { return drvmobile; }
	public void setDrvmobile(String drvmobile) { this.drvmobile = drvmobile; }
	
	public String getDrvemercontact() { return drvemercontact; }
	public void setDrvemercontact(String drvemercontact) { this.drvemercontact = drvemercontact; }
	
	public String getDrvgender() { return drvgender; }
	public void setDrvgender(String drvgender) { this.drvgender = drvgender; }
	
	public String getDrvbdate() { return drvbdate; }
	public void setDrvbdate(String drvbdate) { this.drvbdate = drvbdate; }
	
	public String getDrvjoindate() { return drvjoindate; }
	public void setDrvjoindate(String drvjoindate) { this.drvjoindate = drvjoindate; }
	
	public String getDrvsfttimings() { return drvsfttimings; }
	public void setDrvsfttimings(String drvsfttimings) { this.drvsfttimings = drvsfttimings; }
	
	public String getDrvlicnumber() { return drvlicnumber; }
	public void setDrvlicnumber(String drvlicnumber) { this.drvlicnumber = drvlicnumber; }
	
	public String getDrvlictype() { return drvlictype; }
	public void setDrvlictype(String drvlictype) { this.drvlictype = drvlictype; }
	
	public String getDrvlicissuedate() { return drvlicissuedate; }
	public void setDrvlicissuedate(String drvlicissuedate) { this.drvlicissuedate = drvlicissuedate; }
	
	public String getDrvlicenddate() { return drvlicenddate; }
	public void setDrvlicenddate(String drvlicenddate) { this.drvlicenddate = drvlicenddate; }
	
	public String getDrvadharcard() { return drvadharcard; }
	public void setDrvadharcard(String drvadharcard) { this.drvadharcard = drvadharcard; }
	
	public int getDrvexperience() { return drvexperience; }
	public void setDrvexperience(int drvexperience) { this.drvexperience = drvexperience; }
	
	public String getDrvmedicalhistory() { return drvmedicalhistory; }
	public void setDrvmedicalhistory(String drvmedicalhistory) { this.drvmedicalhistory = drvmedicalhistory; }

	public String getDrvimage() { return drvimage; }
	public void setDrvimage(String drvimage) { this.drvimage = drvimage; }
	
	public String getDrvactive() { return drvactive; }
	public void setDrvactive(String drvactive) { this.drvactive = drvactive; }	
}

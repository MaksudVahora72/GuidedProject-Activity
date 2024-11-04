package com.garbagefleet.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "EmployeeMaster")
public class EmployeeMaster {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empid;
	private String empfname;
	private String empsname;
	private String empaddress1;
	private String empaddress2;
	private String empcity;
	private String empstate;
	
	@Column(nullable = false, unique = true)
	private String empcontact1;
	
	@Column(nullable = false, unique = true)
	private String empcontact2;		
	
	private String empgender;
	
	@Column(nullable = false, unique = true)
	private String empemail;
	
	private Date empbdate;
	private int empdesigid;
	private int emptype;
	private Date empjdate;
	
	@Column(nullable = false, unique = true)
	private String emppanid;
	
	@Column(nullable = false, unique = true)
	private String empadharid;
	
	private int empuserid;
	private String empimage;
	private String empactive;

	public int getEmpid() { return empid; }
	public void setEmpid(int empid) { this.empid = empid; }
	
	public String getEmpfname() { return empfname; }
	public void setEmpfname(String empfname) { this.empfname = empfname; }
	
	public String getEmpsname() { return empsname; }
	public void setEmpsname(String empsname) { this.empsname = empsname; }
	
	public String getEmpaddress1() { return empaddress1; }
	public void setEmpaddress1(String empaddress1) { this.empaddress1 = empaddress1; }
	
	public String getEmpaddress2() { return empaddress2; }
	public void setEmpaddress2(String empaddress2) { this.empaddress2 = empaddress2; }
	
	public String getEmpcity() { return empcity; }
	public void setEmpcity(String empcity) { this.empcity = empcity; }
	
	public String getEmpstate() { return empstate; }
	public void setEmpstate(String empstate) { this.empstate = empstate; }
	
	public String getEmpcontact1() { return empcontact1; }
	public void setEmpcontact1(String empcontact1) { this.empcontact1 = empcontact1; }
	
	public String getEmpcontact2() { return empcontact2; }
	public void setEmpcontact2(String empcontact2) { this.empcontact2 = empcontact2; }
	
	public String getEmpgender() { return empgender; }
	public void setEmpgender(String empgender) { this.empgender = empgender; }
	
	public String getEmpemail() { return empemail;}
	public void setEmpemail(String empemail) { this.empemail = empemail; }
	
	public Date getEmpbdate() { return empbdate; }
	public void setEmpbdate(Date empbdate) { this.empbdate = empbdate; }
	
	public int getEmpdesigid() { return empdesigid; }
	public void setEmpdesigId(int empdesigid) { this.empdesigid = empdesigid; }
	
	public int getEmptype() { return emptype; }
	public void setEmptype(int emptype) { this.emptype = emptype; }
	
	public Date getEmpjdate() { return empjdate; }
	public void setEmpjdate(Date empjdate) { this.empjdate = empjdate; }
	
	public String getEmppanid() { return emppanid; }
	public void setEmppanid(String emppanid) { this.emppanid = emppanid; }
	
	public String getEmpadharid() { return empadharid; }
	public void setEmpadharid(String empadharid) { this.empadharid = empadharid; }
	
	public int getEmpuserid() { return empuserid; }
	public void setEmpuserid(int empuserid) { this.empuserid = empuserid; }
	
	public String getEmpimage() { return empimage; }
	public void setEmpimage(String empimage) { this.empimage = empimage; }
	
	public String getEmpactive() { return empactive; }
	public void setEmpactive(String empactive) { this.empactive = empactive; }
}

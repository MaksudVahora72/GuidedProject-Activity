package com.garbagefleet.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;

@Entity
@Table(name="InsuranceCompanyMaster")
public class InsuranceCompanyMaster {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int insuid;
	
	private String insucname;
	private String insucadd1;
	private String insucadd2;
	private String insuccity;
	
	@Column(nullable = false, unique = true)
	private String insucph1;
	
	@Column(nullable = false, unique = true)
	private String insucph2;	

	@Column(nullable = false, unique = true)
	@Email
	private String insucemail;	
	private String insucrefname;	
	
	@Column(nullable = false, unique = true)
	private String insucrefph;
	
	@Column(nullable = false, unique = true)
	@Email
	private String insucrefemail;	
	private String insucactive;

	public int getInsuid() { return insuid; }
	public void setInsuid(int insuid) { this.insuid = insuid;}
	
	public String getInsucname() { return insucname; }
	public void setInsucname(String insucname) { this.insucname = insucname;}
	
	public String getInsucadd1() { return insucadd1; }
	public void setInsucadd1(String insucadd1) { this.insucadd1 = insucadd1; }
	
	public String getInsucadd2() { return insucadd2; }
	public void setInsucadd2(String insucadd2) { this.insucadd2 = insucadd2; }
	
	public String getInsuccity() { return insuccity; }
	public void setInsuccity(String insuccity) { this.insuccity = insuccity; }
	
	public String getInsucph1() { return insucph1; }
	public void setInsucph1(String insucph1) { this.insucph1 = insucph1; }
	
	public String getInsucph2() { return insucph2; }
	public void setInsucph2(String insucph2) { this.insucph2 = insucph2; }
	
	public String getInsucemail() { return insucemail; }
	public void setInsucemail(String insucemail) { this.insucemail = insucemail; }
	
	public String getInsucrefname() { return insucrefname; }
	public void setInsucrefname(String insucrefname) { this.insucrefname = insucrefname; }
	
	public String getInsucrefph() { return insucrefph; }
	public void setInsucrefph(String insucrefph) { this.insucrefph = insucrefph; }
	
	public String getInsucrefemail() { return insucrefemail; }
	public void setInsucrefemail(String insucrefemail) { this.insucrefemail = insucrefemail; }
	
	public String getInsucactive() { return insucactive; }
	public void setInsucactive(String insucactive) { this.insucactive = insucactive; }	
}

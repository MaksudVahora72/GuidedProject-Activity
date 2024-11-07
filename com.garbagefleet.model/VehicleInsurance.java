package com.garbagefleet.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "VehicleInsurance")
public class VehicleInsurance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int vinsuid;
	
	@Column(nullable = false)
	private Date vtrandate;
	
	@Column(nullable = false)
	private int vehid;
		
	@Column(unique = true)
	private String vinsucertnumber;
	
	@Column(nullable = false)
	private Date vinsudate;
	
	@Column(nullable = false)
	private Date vinsuenddate;

	@Column(nullable = false)
	private int vidvvalue;
	
	@Column(nullable = false)
	private int vinsuprem;
	private String paymenttype;
	private String bankname;
	private String bankbranch;
	
	public int getVinsuid() { return vinsuid; }
	public void setVinsuid(int vinsuid) { this.vinsuid = vinsuid; }
	
	public int getVehid() { return vehid; }
	public void setVehid(int vehid) { this.vehid = vehid; }
		
	public String getVinsucertnumber() { return vinsucertnumber; }
	public void setVinsucertnumber(String vinsucertnumber) {
		this.vinsucertnumber = vinsucertnumber;
	}
	
	public Date getVtrandate() { return vtrandate; }
	public void setVtrandate(Date vtrandate) { this.vtrandate = vtrandate; }
	
	public Date getVinsudate() { return vinsudate; }
	public void setVinsudate(Date vinsudate) { this.vinsudate = vinsudate; }
	
	public Date getVinsuenddate() { return vinsuenddate; }
	public void setVinsuenddate(Date vinsuenddate) {
		this.vinsuenddate = vinsuenddate;
	}
	
	public int getVidvvalue() { return vidvvalue; }
	public void setVidvvalue(int vidvvalue) { this.vidvvalue = vidvvalue; }
	
	public int getVinsuprem() { return vinsuprem; }
	public void setVinsuprem(int vinsuprem) { this.vinsuprem = vinsuprem; }
	
	public String getPaymenttype() { return paymenttype; }
	public void setPaymenttype(String paymenttype) { this.paymenttype = paymenttype; }

	public String getBankname() { return bankname; }
	public void setBankname(String bankname) { this.bankname = bankname; }
	
	public String getBankbranch() { return bankbranch; }
	public void setBankbranch(String bankbranch) { this.bankbranch = bankbranch; }
}

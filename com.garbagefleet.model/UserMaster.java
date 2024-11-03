package com.garbagefleet.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "UserMaster")
public class UserMaster {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userid;
	private int utypeid;
	
	@Column(nullable = false, unique = true)
	private String username;
	private String userpassword;
	private String useravail;
	private String useractive;

	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getUtypeid() {
		return utypeid;
	}
	public void setUtypeid(int utypeid) {
		this.utypeid = utypeid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpassword() {
		return userpassword;
	}
	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}
	public String getUseravail() {
		return useravail;
	}
	public void setUseravail(String useravail) {
		this.useravail = useravail;
	}
	public String getUseractive() {
		return useractive;
	}
	public void setUseractive(String useractive) {
		this.useractive = useractive;
	}
	
}

package com.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Admin {
	@Id
	private int adminId;
	private String adminEmailId;
	private String adminPassword;
	
	
	public Admin() {
		super();
	}
	
	
	public Admin(int adminId, String adminEmailId, String adminPassword) {
		super();
		this.adminId = adminId;
		this.adminEmailId = adminEmailId;
		this.adminPassword = adminPassword;
	}


	public String getAdminEmailId() {
		return adminEmailId;
	}
	public void setAdminEmailId(String adminEmailId) {
		this.adminEmailId = adminEmailId;
	}
	
	
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}


	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}


	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminEmailId=" + adminEmailId + ", adminPassword=" + adminPassword
				+ "]";
	}

}

package com.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class NGO{

	@Id
	private int ngoId;
	private String ngoName;
	private String ngoAddress;
	private int ngoPincode;
	private String ngoEmailId;
	private String ngoContactNumber;
	private String ngoWebsite;
	
	
	public NGO() {
		super();
	}
	
	public NGO(int ngoId, String ngoName, String ngoAddress, int ngoPincode, String ngoEmailId, String ngoContactNumber,
			String ngoWebsite) {
		super();
		this.ngoId = ngoId;
		this.ngoName = ngoName;
		this.ngoAddress = ngoAddress;
		this.ngoPincode = ngoPincode;
		this.ngoEmailId = ngoEmailId;
		this.ngoContactNumber = ngoContactNumber;
		this.ngoWebsite = ngoWebsite;
	}

	
	public int getNgoId() {
		return ngoId;
	}
	public void setNgoId(int ngoId) {
		this.ngoId = ngoId;
	}

	
	public String getNgoName() {
		return ngoName;
	}
	public void setNgoName(String ngoName) {
		this.ngoName = ngoName;
	}

	
	public String getNgoAddress() {
		return ngoAddress;
	}
	public void setNgoAddress(String ngoAddress) {
		this.ngoAddress = ngoAddress;
	}

	
	public int getNgoPincode() {
		return ngoPincode;
	}
	public void setNgoPincode(int ngoPincode) {
		this.ngoPincode = ngoPincode;
	}

	
	public String getNgoEmailId() {
		return ngoEmailId;
	}
	public void setNgoEmailId(String ngoEmailId) {
		this.ngoEmailId = ngoEmailId;
	}

	
	public String getNgoContactNumber() {
		return ngoContactNumber;
	}
	public void setContactNumber(String ngoContactNumber) {
		this.ngoContactNumber = ngoContactNumber;
	}

	
	public String getNgoWebsite() {
		return ngoWebsite;
	}
	public void setNgoWebsite(String ngoWebsite) {
		this.ngoWebsite = ngoWebsite;
	}

	@Override
	public String toString() {
		return "NGO [ngoId=" + ngoId + ", ngoName=" + ngoName + ", ngoAddress=" + ngoAddress + ", ngoPincode="
				+ ngoPincode + ", ngoEmailId=" + ngoEmailId + ", ngoContactNumber=" + ngoContactNumber + ", ngoWebsite="
				+ ngoWebsite + "]";
	}

		
}


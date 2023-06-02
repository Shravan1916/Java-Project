package com.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Donor {
	@Id
	private int donorId;
	private String donorName;
	private String donorGender; 
	final LocalDate donorRegistrationDate = LocalDate.now();
	private String donorEmailId;
	private String donorContactNumber;
	private int ngoId;
	private String donorAddress;
	private int donorPincode;
	private String donorType;
	
	
	public Donor() {
		super();
	}
	
	
	public Donor(int donorId, String donorName, String donorGender, String donorEmailId, String donorContactNumber,
			int ngoId, String donorAddress, int donorPincode, String donorType) {
		super();
		this.donorId = donorId;
		this.donorName = donorName;
		this.donorGender = donorGender;
		this.donorEmailId = donorEmailId;
		this.donorContactNumber = donorContactNumber;
		this.ngoId = ngoId;
		this.donorAddress = donorAddress;
		this.donorPincode = donorPincode;
		this.donorType = donorType;
	}


	public int getDonorId() {
		return donorId;
	}
	public void setDonorId(int donorId) {
		this.donorId = donorId;
	}


	public String getDonorName() {
		return donorName;
	}
	public void setDonorName(String donorName) {
		this.donorName = donorName;
	}


	public String getDonorGender() {
		return donorGender;
	}
	public void setDonorGender(String donorGender) {
		this.donorGender = donorGender;
	}


	public String getDonorEmailId() {
		return donorEmailId;
	}
	public void setDonorEmailId(String donorEmailId) {
		this.donorEmailId = donorEmailId;
	}


	public String getDonorContactNumber() {
		return donorContactNumber;
	}
	public void setDonorContactNumber(String donorContactNumber) {
		this.donorContactNumber = donorContactNumber;
	}


	public int getNgoId() {
		return ngoId;
	}
	public void setNgoId(int ngoId) {
		this.ngoId = ngoId;
	}


	public String getDonorAddress() {
		return donorAddress;
	}
	public void setDonorAddress(String donorAddress) {
		this.donorAddress = donorAddress;
	}


	public int getDonorPincode() {
		return donorPincode;
	}
	public void setDonorPincode(int donorPincode) {
		this.donorPincode = donorPincode;
	}


	public String getDonorType() {
		return donorType;
	}
	public void setDonorType(String donorType) {
		this.donorType = donorType;
	}


	public LocalDate getDonorRegistrationDate() {
		return donorRegistrationDate;
	}


	@Override
	public String toString() {
		return "Donor [donorId=" + donorId + ", donorName=" + donorName + ", donorGender=" + donorGender
				+ ", donorRegistrationDate=" + donorRegistrationDate + ", donorEmailId=" + donorEmailId
				+ ", donorContactNumber=" + donorContactNumber + ", ngoId=" + ngoId + ", donorAddress=" + donorAddress
				+ ", donorPincode=" + donorPincode + ", donorType=" + donorType + "]";
	}	
	
}

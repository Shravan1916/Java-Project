package com.model;

import java.time.DayOfWeek;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Donation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int donationId;
	final LocalDate donationDate = LocalDate.now();
	final DayOfWeek weekDay = DayOfWeek.from(donationDate);
	private String donationType;
	private int donationQuantity;
	private int ngoId;
	private int donorId;
	private String donationAddress;
	private int donationPincode;
	
	
	public Donation() {
		super();
	}
	
	
	public Donation(int donationId, String donationType, int donationQuantity, int ngoId, int donorId,
			String donationAddress, int donationPincode) {
		super();
		this.donationId = donationId;
		this.donationType = donationType;
		this.donationQuantity = donationQuantity;
		this.ngoId = ngoId;
		this.donorId = donorId;
		this.donationAddress = donationAddress;
		this.donationPincode = donationPincode;
	}
	
	
	public Donation(String donationType, int donationQuantity, int ngoId, int donorId, String donationAddress, int donationPincode) {
		super();
		this.donationType = donationType;
		this.donationQuantity = donationQuantity;
		this.ngoId = ngoId;
		this.donorId = donorId;
		this.donationAddress = donationAddress;
		this.donationPincode = donationPincode;
	}


	public int getDonationId() {
		return donationId;
	}
	public void setDonationId(int donationId) {
		this.donationId = donationId;
	}


	public String getDonationType() {
		return donationType;
	}
	public void setDonationType(String donationType) {
		this.donationType = donationType;
	}


	public int getDonationQuantity() {
		return donationQuantity;
	}
	public void setDonationQuantity(int donationQuantity) {
		this.donationQuantity = donationQuantity;
	}


	public int getNgoId() {
		return ngoId;
	}
	public void setNgoId(int ngoId) {
		this.ngoId = ngoId;
	}


	public int getDonorId() {
		return donorId;
	}
	public void setDonorId(int donorId) {
		this.donorId = donorId;
	}


	public String getDonationAddress() {
		return donationAddress;
	}
	public void setDonationAddress(String donationAddress) {
		this.donationAddress = donationAddress;
	}
	
	
	public int getDonationPincode() {
		return donationPincode;
	}
	public void setDonationPincode(int donationPincode) {
		this.donationPincode = donationPincode;
	}


	public LocalDate getDonationDate() {
		return donationDate;
	}


	public DayOfWeek getWeekDay() {
		return weekDay;
	}

	@Override
	public String toString() {
		return "Donation [donationId=" + donationId + ", donationDate=" + donationDate + ", weekDay=" + weekDay
				+ ", donationType=" + donationType + ", donationQuantity=" + donationQuantity + ", ngoId=" + ngoId
				+ ", donorId=" + donorId + ", donationAddress=" + donationAddress + ", donationPincode="
				+ donationPincode + "]";
	}

}

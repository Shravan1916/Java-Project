package com.services;

import java.util.List;

import com.model.Donation;

import Exceptions.InvalidPincodeException;
import Exceptions.NullValueException;
import Exceptions.ObjectNotFoundException;

public interface DonationServices {

	Donation addDonation(Donation donation) throws NullValueException, ObjectNotFoundException, InvalidPincodeException;
	Donation updateDonation(Donation donation) throws ObjectNotFoundException, NullValueException, InvalidPincodeException;
	void deleteDonationById(int donationId);
	void deleteDonationByGId(int donationId);
	void deleteDonationByNgoId(int ngoId);
	void deleteDonationByDonorId(int donorId);
	List<Donation> getAllDonatons();
	Donation getDonationById(int donationId);
	List<Donation> getDonationByType(String donationType);
	List<Donation> getDonationByNgoId(int ngoId) throws ObjectNotFoundException;
	List<Donation> getDonationByDonorId(int donorId) throws ObjectNotFoundException;
	List<Donation> getDonationByPincode(int donationPincode);
}

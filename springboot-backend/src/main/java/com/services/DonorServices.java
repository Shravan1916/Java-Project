package com.services;

import java.util.List;

import com.model.Donor;
import com.model.NGO;

import Exceptions.InvalidEmailException;
import Exceptions.InvalidGenderException;
import Exceptions.InvalidNgoIdException;
import Exceptions.InvalidPhoneNumberException;
import Exceptions.InvalidPincodeException;
import Exceptions.InvalidTypeException;
import Exceptions.NullValueException;
import Exceptions.ObjectNotFoundException;
import Exceptions.ValueAlreadyExistsException;

public interface DonorServices {

	Donor addDonors(Donor donor) throws ValueAlreadyExistsException, InvalidNgoIdException, NullValueException, InvalidGenderException, InvalidPincodeException, InvalidTypeException, InvalidEmailException, InvalidPhoneNumberException, ObjectNotFoundException;
	void deleteDonorById(int donorId);
	void deleteGreaterById(int donorId);
	void deleteDonorByNgoId(int ngoId) throws ObjectNotFoundException;
	Donor updateDonor(Donor donor) throws ValueAlreadyExistsException, InvalidNgoIdException, NullValueException, InvalidGenderException, InvalidPincodeException, InvalidTypeException, InvalidEmailException, InvalidPhoneNumberException, ObjectNotFoundException;
	List<Donor> getAllDonors();
	Donor getDonorById(int donorId);
	List<Donor> getDonorByName(String donorName) throws ObjectNotFoundException;
	Donor getDonorByEmail(String donorEmail);
	Donor getDonorByContactNumber(String donorContactNumber);
	List<Donor> getDonorByNgoId(int ngoId) throws ObjectNotFoundException;
	List<Donor> getDonorByPincode(int donorPincode);
}

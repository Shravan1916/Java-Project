package com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.DonorRepository;
import com.dao.NGORepository;
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

@Service
public class DonorServiceImplementation implements DonorServices{

	@Autowired
	DonorRepository DonorRepo;
	
	@Autowired
	NGORepository NGORepo;
	
	@Override
	public Donor addDonors(Donor donor) throws ValueAlreadyExistsException, InvalidNgoIdException, NullValueException, InvalidGenderException, InvalidPincodeException, InvalidTypeException, InvalidEmailException, InvalidPhoneNumberException, ObjectNotFoundException {
		if(donor.getDonorId() > 80400) {
			if(getDonorById(donor.getDonorId()) != null) {
				throw new ValueAlreadyExistsException("Donor with the same as donorId already exists ");
			}
		}
		else {
			throw new InvalidNgoIdException("Donor Id should be greater than 80400");
		}
		
		if(donor.getDonorName().length() == 0) {
			throw new NullValueException("Name can not be empty please enter valid user name");
		}
		String value = donor.getDonorGender();
		if(!value.equals("Female") && !value.equals("Male") && !value.equals("Others")) {
			throw new InvalidGenderException("Entered gender is invalid please enter among, 'Male', 'Female', 'Others'");
		}
		NGO ngoObj = NGORepo.findByNgoEmailId(donor.getDonorEmailId());
		Donor donorObj = getDonorByEmail(donor.getDonorEmailId());
		value = donor.getDonorEmailId();
		
		if(value.contains("@")) {
			if(ngoObj == null) {
				if(donorObj != null) {
					throw new ValueAlreadyExistsException("Donor with same contact emailId already exists with donorId: " + donorObj.getDonorId());
				}
			}
			else {
				throw new ValueAlreadyExistsException("NGO with same contact emailId already exists with ngoId " + ngoObj.getNgoId());
			}
		}
		else {
			throw new InvalidEmailException("Email which you are trying to add is invalid reenter it email is missing @");
		}
		
		value = donor.getDonorContactNumber();
		ngoObj = NGORepo.findByNgoContactNumber(donor.getDonorContactNumber());
		donorObj = getDonorByContactNumber(donor.getDonorContactNumber());
		if(value.length() == 10) {
			if(ngoObj == null) {
				if(donorObj != null) {
					throw new ValueAlreadyExistsException("Donor with same contact number already exists with donorId: " + donorObj.getDonorId());
				}
			}
			else {
				throw new ValueAlreadyExistsException("NGO with same contact number already exists with ngoId: " + ngoObj.getNgoId());
			}
		}
		else {
			throw new InvalidPhoneNumberException("Phone Number which you are trying to update is invalid reenter it");
		}
		
		ngoObj = NGORepo.findByNgoId(donor.getNgoId());
		if(ngoObj == null) {
			throw new ObjectNotFoundException("NGO of ngoId: " + donor.getNgoId() + " does not exists");
		}
		if(donor.getDonorAddress().length() == 0) {
			throw new NullValueException("Address can not be empty please enter valid user address");
		}
		if(donor.getDonorPincode() <= 0 || donor.getDonorPincode() > 835325) {
			throw new InvalidPincodeException("Pincode you entered is does not exists in India please enter Indian pincode only");
		}
		value = donor.getDonorType();
		if(!value.equals("Hotel") && !value.equals("Organisation") && !value.equals("Individual")) {
			throw new InvalidTypeException("Entered Type is invalid please enter among, 'Hotel', 'Organisation', 'Individual'");
		}
		
		return DonorRepo.save(donor);
	}

	@Override
	public List<Donor> getAllDonors() {
		return DonorRepo.findAllDonors();
	}
	
	@Override
	public void deleteDonorById(int donorId) {
		DonorRepo.deleteById(donorId);
	}
	
	@Override
	public void deleteGreaterById(int donorId) {
		DonorRepo.deleteByDonorId(donorId);		
	}

	@Override
	public Donor updateDonor(Donor donor) throws ValueAlreadyExistsException, InvalidNgoIdException, NullValueException, InvalidGenderException, InvalidPincodeException, InvalidTypeException, InvalidEmailException, InvalidPhoneNumberException, ObjectNotFoundException{		
		Donor newDonor = getDonorById(donor.getDonorId());
		if(newDonor == null) {
			throw new ObjectNotFoundException("Donor of donorId: " + donor.getDonorId() + " does not exists");
		}
		if(donor.getDonorName().length() == 0) {
			throw new NullValueException("Name can not be empty please enter valid user name");
		}
		String value = donor.getDonorGender();
		if(!value.equals("Female") && !value.equals("Male") && !value.equals("Others")) {
			throw new InvalidGenderException("Entered gender is invalid please enter among, 'Male', 'Female', 'Others'");
		}
		NGO ngoObj = NGORepo.findByNgoEmailId(donor.getDonorEmailId());
		Donor donorObj = getDonorByEmail(donor.getDonorEmailId());
		value = donor.getDonorEmailId();
		
		if(value.contains("@")) {
			if(ngoObj == null) {
				if(donorObj != null && !value.equals(newDonor.getDonorEmailId())) {
					throw new ValueAlreadyExistsException("Donor with same contact emailId already exists with donorId: " + donorObj.getDonorId());
				}
			}
			else {
				throw new ValueAlreadyExistsException("NGO with same contact emailId already exists with ngoId " + ngoObj.getNgoId());
			}
		}
		else {
			throw new InvalidEmailException("Email which you are trying to add is invalid reenter it email is missing @");
		}
		
		value = donor.getDonorContactNumber();
		ngoObj = NGORepo.findByNgoContactNumber(donor.getDonorContactNumber());
		donorObj = getDonorByContactNumber(donor.getDonorContactNumber());
		if(value.length() == 10) {
			if(ngoObj == null) {
				if(donorObj != null && !value.equals(newDonor.getDonorContactNumber())) {
					throw new ValueAlreadyExistsException("Donor with same contact number already exists with donorId: " + donorObj.getDonorId());
				}
			}
			else {
				throw new ValueAlreadyExistsException("NGO with same contact number already exists with ngoId: " + ngoObj.getNgoId());
			}
		}
		else {
			throw new InvalidPhoneNumberException("Phone Number which you are trying to update is invalid reenter it");
		}
		
		ngoObj = NGORepo.findByNgoId(donor.getNgoId());
		if(ngoObj == null) {
			throw new ObjectNotFoundException("NGO of ngoId: " + donor.getNgoId() + " does not exists");
		}
		if(donor.getDonorAddress().length() == 0) {
			throw new NullValueException("Address can not be empty please enter valid user address");
		}
		if(donor.getDonorPincode() <= 0 || donor.getDonorPincode() > 835325) {
			throw new InvalidPincodeException("Pincode you entered is does not exists in India please enter Indian pincode only");
		}
		value = donor.getDonorType();
		if(!value.equals("Hotel") && !value.equals("Organisation") && !value.equals("Individual")) {
			throw new InvalidTypeException("Entered Type is invalid please enter among, 'Hotel', 'Organisation', 'Individual'");
		}
		newDonor.setDonorName(donor.getDonorName());
		newDonor.setDonorGender(donor.getDonorGender());
		newDonor.setDonorContactNumber(donor.getDonorContactNumber());
		newDonor.setDonorEmailId(donor.getDonorEmailId());
		newDonor.setNgoId(donor.getNgoId());
		newDonor.setDonorAddress(donor.getDonorAddress());
		newDonor.setDonorPincode(donor.getDonorPincode());
		newDonor.setDonorType(donor.getDonorType());
		
		return DonorRepo.save(donor);
	}

	@Override
	public void deleteDonorByNgoId(int ngoId) throws ObjectNotFoundException {
		List<Donor> donorObj = getDonorByNgoId(ngoId);	
		if(donorObj.isEmpty()) {
			throw new ObjectNotFoundException("No donor found with ngoId " +  ngoId);
		}
		DonorRepo.deleteByNgoId(ngoId);
	}
	
	@Override
	public Donor getDonorById(int donorId) {
		return DonorRepo.findById(donorId).orElse(null);
	}

	@Override
	public List<Donor> getDonorByName(String donorName) throws ObjectNotFoundException {
		List<Donor> donorObj = DonorRepo.findByDonorName(donorName);
		if(donorObj.isEmpty()) {
			throw new ObjectNotFoundException("No Donor exists with name " + donorName + " try to search with other name");
		}
		return donorObj;
	}

	@Override
	public Donor getDonorByEmail(String donorEmail) {
		return DonorRepo.findByDonorEmailId(donorEmail);
	}

	@Override
	public Donor getDonorByContactNumber(String donorContactNumber) {
		return DonorRepo.findByDonorContactNumber(donorContactNumber);
	}

	@Override
	public List<Donor> getDonorByNgoId(int ngoId) throws ObjectNotFoundException {
		if(NGORepo.findByNgoId(ngoId) != null) {
			if(!DonorRepo.findByNgoId(ngoId).isEmpty()) {
				return DonorRepo.findByNgoId(ngoId);
			}
			else {
				throw new ObjectNotFoundException("Ngo with ngoId " + ngoId + " exsits but no donor found with ngoId " + ngoId);
			}
		}
		else {
			throw new ObjectNotFoundException("No NGO exists with ngoId: " + ngoId);
		}
	}

	@Override
	public List<Donor> getDonorByPincode(int donorPincode) {
		return DonorRepo.findByDonorPincode(donorPincode);
	}	
}

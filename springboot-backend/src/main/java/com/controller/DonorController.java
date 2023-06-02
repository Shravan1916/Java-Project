package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Donor;
import com.services.DonorServiceImplementation;

import Exceptions.InvalidEmailException;
import Exceptions.InvalidGenderException;
import Exceptions.InvalidNgoIdException;
import Exceptions.InvalidPhoneNumberException;
import Exceptions.InvalidPincodeException;
import Exceptions.InvalidTypeException;
import Exceptions.NullValueException;
import Exceptions.ObjectNotFoundException;
import Exceptions.ValueAlreadyExistsException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("")
public class DonorController {

	@Autowired
	DonorServiceImplementation DonorSerImpl;
	
	@PostMapping("/addDonor")
	Donor addDonor(@RequestBody Donor donor) throws ValueAlreadyExistsException, InvalidNgoIdException, NullValueException, InvalidGenderException, InvalidPincodeException, InvalidTypeException, InvalidEmailException, InvalidPhoneNumberException, ObjectNotFoundException{
		return DonorSerImpl.addDonors(donor);
	}
	
	
	@DeleteMapping("/deleteDonorById/{donorId}")
	void deleteDonorUId(@PathVariable int donorId) {
		DonorSerImpl.deleteDonorById(donorId);
	}
	
	
	@DeleteMapping("/deleteDonorByNgoId/{ngoId}")
	void deleteDonorUNgoId(@PathVariable int ngoId) throws ObjectNotFoundException{
		DonorSerImpl.deleteDonorByNgoId(ngoId);
	}
	
	
	@DeleteMapping("/deleteGDonorById/{donorId}")
	void deleteDonorGreaterUDonorId(@PathVariable int donorId){
		DonorSerImpl.deleteGreaterById(donorId);
	}
	
	
	@PutMapping("/updateDonor")
	Donor updateDonorit(@RequestBody Donor donor) throws ValueAlreadyExistsException, InvalidNgoIdException, NullValueException, InvalidGenderException, InvalidPincodeException, InvalidTypeException, InvalidEmailException, InvalidPhoneNumberException, ObjectNotFoundException {
		return DonorSerImpl.updateDonor(donor);
	}
	
	@GetMapping("/getAllDonor")
	List<Donor> getAllUDonor(){
		return DonorSerImpl.getAllDonors();
	}
	
	
	@GetMapping("/getDonorByName/{donorName}")
	List<Donor> getDonorUName(@PathVariable String donorName) throws ObjectNotFoundException{
		return DonorSerImpl.getDonorByName(donorName);
	}
	
	
	@GetMapping("/getDonorById/{donorId}")
	Donor getDonorUId(@PathVariable int donorId){
		return DonorSerImpl.getDonorById(donorId);
	}
	
	@GetMapping("/getDonorByPincode/{donorPincode}")
	List<Donor> getDonorUPincode(@PathVariable int donorPincode){
		return DonorSerImpl.getDonorByPincode(donorPincode);
	}
	
	//Below methods are just prepared for testing each and every module of Donor
	@GetMapping("/getDonorByEmail/{donorEmail}")
	Donor getDonorUEmail(@PathVariable String donorEmail){
		return DonorSerImpl.getDonorByEmail(donorEmail);
	}
	
	
	@GetMapping("/getDonorByContact/{donorContactNumber}")
	Donor getDonorContactNumber(@PathVariable String donorContactNumber){
		return DonorSerImpl.getDonorByContactNumber(donorContactNumber);
	}
	
	
	@GetMapping("/getDonorByNgoId/{ngoId}")
	List<Donor> getDonorUNgoId(@PathVariable int ngoId) throws ObjectNotFoundException{
		return DonorSerImpl.getDonorByNgoId(ngoId);
	}
	
}

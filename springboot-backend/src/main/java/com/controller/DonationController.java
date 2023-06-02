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

import com.model.Donation;
import com.services.DonationServiceImplementation;

import Exceptions.InvalidPincodeException;
import Exceptions.NullValueException;
import Exceptions.ObjectNotFoundException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("")
public class DonationController {
	
	@Autowired
	DonationServiceImplementation DonSerImpl;
	
	@PostMapping("/addDonation")
	Donation addUDonation(@RequestBody Donation donation) throws NullValueException, ObjectNotFoundException, InvalidPincodeException {
		return DonSerImpl.addDonation(donation);
	}
	
	@PutMapping("/updateDonation")
	Donation updateUDonation(@RequestBody Donation donation) throws ObjectNotFoundException, NullValueException, InvalidPincodeException {
		return DonSerImpl.updateDonation(donation);
	}
	
	@GetMapping("/getAllDonation")
	List<Donation> getAllUDonation(){
		return DonSerImpl.getAllDonatons();
	}
	
	@DeleteMapping("/DeleteDonationById/{donationId}")
	void deleteUDonationId(@PathVariable int donationId) {
		DonSerImpl.deleteDonationById(donationId);
	}
	
	
	@DeleteMapping("/DeleteByGId/{donationId}")
	void deleteUDonationGId(@PathVariable int donationId) {
		DonSerImpl.deleteDonationByGId(donationId);
	}
	
	@DeleteMapping("/DeleteByNgoId/{ngoId}")
	void deleteUNgoId(@PathVariable int ngoId) {
		DonSerImpl.deleteDonationByNgoId(ngoId);
	}	
	
	@DeleteMapping("/DeleteByDonorId/{donorId}")
	void deleteUDonorId(@PathVariable int donorId) {
		DonSerImpl.deleteDonationByDonorId(donorId);
	}
	
	@GetMapping("/getDonationById/{donationId}")
	Donation getDonationUId(@PathVariable int donationId){
		return DonSerImpl.getDonationById(donationId);
	}
	
	@GetMapping("/getDonationByType/{donationType}")
	List<Donation> getDonationUType(@PathVariable String donationType){
		return DonSerImpl.getDonationByType(donationType);
	}
	
	
	@GetMapping("/getDonationByNgoId/{ngoId}")
	List<Donation> getDonationUNgoId(@PathVariable int ngoId) throws ObjectNotFoundException{
		return DonSerImpl.getDonationByNgoId(ngoId);
	}
	
	
	@GetMapping("/getDonationByDonorId/{donorId}")
	List<Donation> getDonationUDonorId(@PathVariable int donorId) throws ObjectNotFoundException{
		return DonSerImpl.getDonationByDonorId(donorId);
	}
	
	
	@GetMapping("/getDonationByPincode/{donorPincode}")
	List<Donation> getDonationUDonorPincode(@PathVariable int donorPincode){
		return DonSerImpl.getDonationByPincode(donorPincode);
	}

}

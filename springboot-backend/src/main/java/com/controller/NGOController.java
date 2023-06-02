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


import com.model.NGO;
import com.services.NGOServiceImplementation;

import Exceptions.InvalidEmailException;
import Exceptions.InvalidNgoIdException;
import Exceptions.InvalidPhoneNumberException;
import Exceptions.InvalidPincodeException;
import Exceptions.InvalidWebsiteException;
import Exceptions.NullValueException;
import Exceptions.ObjectNotFoundException;
import Exceptions.ValueAlreadyExistsException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("")
public class NGOController {
	
	@Autowired
	 NGOServiceImplementation NGOSerImpl;
	
	@PostMapping("/addNgo")
	public NGO addSinNgo(@RequestBody NGO ngo) throws ValueAlreadyExistsException, NullValueException, InvalidPincodeException, InvalidEmailException, InvalidPhoneNumberException, InvalidWebsiteException, InvalidNgoIdException {
		return NGOSerImpl.addNgo(ngo);
	}
	
	
	@DeleteMapping("/deleteNgoId/{ngoId}")
	public void deleteUngoId(@PathVariable int ngoId) throws ObjectNotFoundException {
		NGOSerImpl.deleteNgoById(ngoId);
	}
	
	
	@DeleteMapping("/deleteNgoIdGreater/{ngoId}")
	public void deleteGUngoId(@PathVariable int ngoId) {
		NGOSerImpl.deleteByNgoIdGreater(ngoId);
	}
	
	
	@PutMapping("/updateNgo")
	public NGO updateUNgo(@RequestBody NGO ngo) throws ValueAlreadyExistsException, InvalidEmailException, InvalidPhoneNumberException, InvalidWebsiteException, NullValueException, InvalidPincodeException {
		return NGOSerImpl.updateNGO(ngo);
	}
	
	@GetMapping("/getNgoByName/{ngoName}")
	public List<NGO> getNgoUName(@PathVariable String ngoName) throws ObjectNotFoundException {
		return NGOSerImpl.getNgoByName(ngoName);
	}
	
	@GetMapping("/getAllNgo")
	public List<NGO> allNgos(){
		return NGOSerImpl.getAllNgo();
	}
	
	@GetMapping("/getNGOByPincode/{ngoPincode}")
	List<NGO> getNGOUPincode(@PathVariable int ngoPincode){
		return NGOSerImpl.getNgoByPincode(ngoPincode);
	}
	
	//Below methods are just prepared for testing each and every module of NGO
	@GetMapping("/getNgoById/{ngoId}")
	public NGO getNgoUId(@PathVariable int ngoId) {
		return NGOSerImpl.getNgoById(ngoId);
	}
	
	@GetMapping("/getNgoByEmail/{ngoEmail}")
	public NGO getNgoUEmail(@PathVariable String ngoEmail) {
		return NGOSerImpl.getNgoByEmail(ngoEmail);
	}
	
	@GetMapping("/getNgoByContact/{ngoNumber}")
	public NGO getNgoUNumber(@PathVariable String ngoNumber) {
		return NGOSerImpl.getNgoByContactNo(ngoNumber);
	}
	
	@GetMapping("/getNgoByWebsite/{ngoWebsite}")
	public NGO getNgoUWebsite(@PathVariable String ngoWebsite) {
		return NGOSerImpl.getNgoByNgoWebsite(ngoWebsite);
	}
	
	@PostMapping("/addNgos")
	public NGO addSinNgo() {
		return NGOSerImpl.addNGOIT();
	}
}

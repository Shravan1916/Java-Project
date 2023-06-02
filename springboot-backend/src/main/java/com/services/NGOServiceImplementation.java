package com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.NGORepository;
import com.model.Donation;
import com.model.NGO;

import Exceptions.InvalidEmailException;
import Exceptions.InvalidNgoIdException;
import Exceptions.InvalidPhoneNumberException;
import Exceptions.InvalidPincodeException;
import Exceptions.InvalidWebsiteException;
import Exceptions.NullValueException;
import Exceptions.ObjectNotFoundException;
import Exceptions.ValueAlreadyExistsException;

@Service
public class NGOServiceImplementation implements NGOService {

	@Autowired
	NGORepository NGORepo;
	
	
	@Override
	public NGO addNgo(NGO ngo) throws ValueAlreadyExistsException, NullValueException, InvalidPincodeException, InvalidEmailException, InvalidPhoneNumberException, InvalidWebsiteException, InvalidNgoIdException {
		if(ngo.getNgoId() > 80140) {
			if(getNgoById(ngo.getNgoId()) != null) {
				throw new ValueAlreadyExistsException("NGO with the same as ngoId already exists ");
			}
		}
		else {
			throw new InvalidNgoIdException("Ngo Id should be greater than 80140");	
		}
		if(ngo.getNgoName().length() == 0) {
			throw new NullValueException("Name can not be empty please enter valid NGO name");
		}
		if(ngo.getNgoAddress().length() == 0) {
			throw new NullValueException("Address can not be empty please enter valid NGO address");
		}
		if(ngo.getNgoPincode() <= 0 || ngo.getNgoPincode() > 835325) {
			throw new InvalidPincodeException("Pincode you entered is does not exists in India please enter Indian pincode only");
		}
		
		NGO ngoObj2 = NGORepo.findByNgoEmailId(ngo.getNgoEmailId());
		if(ngoObj2 == null) {
			if(!ngo.getNgoEmailId().contains("@")) {
				throw new InvalidEmailException("Email which you are trying to add is invalid reenter it email is missing @");
			}
		}else {
			throw new ValueAlreadyExistsException("NGO with same contact emailId already exists with ngoId " + ngoObj2.getNgoId());
		}
		
		ngoObj2 = NGORepo.findByNgoContactNumber(ngo.getNgoContactNumber());
		if(ngoObj2 == null) {
			if(ngo.getNgoContactNumber().length() != 10) {
				throw new InvalidPhoneNumberException("Phone Number which you are trying to update is invalid reenter it");
			}
		}
		else {
			throw new ValueAlreadyExistsException("NGO with same contact number already exists with ngoId " + ngoObj2.getNgoId());
		}
		
		ngoObj2 = NGORepo.findByNgoWebsite(ngo.getNgoWebsite());
		if(ngoObj2 == null) {
			if(!ngo.getNgoWebsite().contains("www.")) {
				throw new InvalidWebsiteException("Website which you are trying to update is invalid reenter it");
			}
		}
		else {
			throw new ValueAlreadyExistsException("NGO with same website already exists with ngoId " + ngoObj2.getNgoId());
		}
			
		return NGORepo.save(ngo);
	}
	

	@Override
	public void deleteNgoById(int ngoId) throws ObjectNotFoundException {
		NGO ngoObj = NGORepo.findById(ngoId).orElse(null);
		if(ngoObj == null){
			throw new ObjectNotFoundException("NGO with this " + ngoId + " do not exists");
		}
		NGORepo.deleteById(ngoId);
	}
	
	
	@Override
	public void deleteByNgoIdGreater(int ngoId) {
		NGORepo.deleteByNgoId(ngoId);
	}
	
	
	@Override
	public NGO updateNGO(NGO ngo) throws ValueAlreadyExistsException, InvalidEmailException, InvalidPhoneNumberException, InvalidWebsiteException, NullValueException, InvalidPincodeException{
		
		NGO ngoObj = NGORepo.findById(ngo.getNgoId()).orElse(ngo);
		if(!ngo.getNgoEmailId().contains("@")) {
			throw new InvalidEmailException("Email which you are trying to update is invalid reenter it");
		}
		NGO ngoObj2 = NGORepo.findByNgoEmailId(ngo.getNgoEmailId());
		if(ngoObj2 == null || ngoObj2 == ngoObj) {
			if(ngo.getNgoContactNumber().length() != 10) {
				throw new InvalidPhoneNumberException("Phone Number which you are trying to update is invalid reenter it");
			}
			ngoObj2 = NGORepo.findByNgoContactNumber(ngo.getNgoContactNumber());
			if(ngoObj2 == null || ngoObj2 == ngoObj) {
				if(!ngo.getNgoWebsite().contains("www.")) {
					throw new InvalidWebsiteException("Website which you are trying to update is invalid reenter it");
				}
				ngoObj2 = NGORepo.findByNgoWebsite(ngo.getNgoWebsite());
				if((ngoObj2 == null || ngoObj2 == ngoObj)) {
					ngoObj.setContactNumber(ngo.getNgoContactNumber());
					ngoObj.setNgoWebsite(ngo.getNgoWebsite());
					ngoObj.setNgoEmailId(ngo.getNgoEmailId());
					if(ngo.getNgoName().length() == 0){ 
						throw new NullValueException("Name can not be empty please enter your name");
					}
					ngoObj.setNgoName(ngo.getNgoName());
					if(ngo.getNgoPincode() < 0 && ngo.getNgoPincode() > 835324) {
						throw new InvalidPincodeException("Pincode you entered is does not exists in India please enter Indian pincode only one");
					}
					ngoObj.setNgoPincode(ngo.getNgoPincode());
					if(ngo.getNgoAddress().length() == 0) {
						throw new NullValueException("Address can not be empty please enter your address");
					}
					ngoObj.setNgoAddress(ngo.getNgoAddress());
		
					NGORepo.save(ngoObj);					
				}
				else {
					throw new ValueAlreadyExistsException("NGO with same website already exists with ngoId " + ngoObj2.getNgoId());
				}
			}
			else {
				throw new ValueAlreadyExistsException("NGO with same contact number already exists with ngoId " + ngoObj2.getNgoId());
			}
		}
		else {
			throw new ValueAlreadyExistsException("NGO with same contact emailId already exists with ngoId " + ngoObj2.getNgoId());
		}
		return NGORepo.save(ngoObj);
	}
	
	@Override
	public NGO getNgoById(int ngoId) {
		return NGORepo.findByNgoId(ngoId);
	}

	
	@Override
	public List<NGO> getNgoByName(String ngoName) throws ObjectNotFoundException {
		List<NGO> ngoObj =  NGORepo.findByNgoName(ngoName);
		if(ngoObj.isEmpty()) {
			throw new ObjectNotFoundException("No Ngo exists with name " + ngoName + " try to search with other name");
		}
		return ngoObj;
	}

	
	@Override
	public NGO getNgoByEmail(String ngoEmailId) {
		return NGORepo.findByNgoEmailId(ngoEmailId);
	}

	
	@Override
	public NGO getNgoByContactNo(String ngoContactNumber) {
		return NGORepo.findByNgoContactNumber(ngoContactNumber);
	}

	
	@Override
	public NGO getNgoByNgoWebsite(String ngoWebsite) {
		return NGORepo.findByNgoWebsite(ngoWebsite);
	}
	
	
	@Override
	public List<NGO> getAllNgo() {
		return NGORepo.findAlls();
	}

	@Override
	public List<NGO> getNgoByPincode(int ngoPincode) {
		return NGORepo.findByNgoPincode(ngoPincode);
	}


	@Override
	public NGO addNGOIT() {
		NGO ngoObj = new NGO(526, "shit",  "ngoAddressi", 666666, "ngoEmailIdi", "ngoContactNumber",
			"dngoWebsite");
		return NGORepo.save(ngoObj);
	}

}

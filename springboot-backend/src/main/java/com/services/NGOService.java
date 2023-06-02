package com.services;

import java.util.List;

import com.model.NGO;

import Exceptions.InvalidEmailException;
import Exceptions.InvalidNgoIdException;
import Exceptions.InvalidPhoneNumberException;
import Exceptions.InvalidPincodeException;
import Exceptions.InvalidWebsiteException;
import Exceptions.NullValueException;
import Exceptions.ObjectNotFoundException;
import Exceptions.ValueAlreadyExistsException;

public interface NGOService{
	NGO addNgo(NGO ngo) throws ValueAlreadyExistsException, NullValueException, InvalidPincodeException, InvalidEmailException, InvalidPhoneNumberException, InvalidWebsiteException, InvalidNgoIdException;
	void deleteNgoById(int ngoId) throws ObjectNotFoundException;
	void deleteByNgoIdGreater(int ngoId);
	NGO updateNGO(NGO ngo) throws ValueAlreadyExistsException, InvalidEmailException, InvalidPhoneNumberException, InvalidWebsiteException, NullValueException, InvalidPincodeException;
	NGO getNgoById(int ngoId);
	List<NGO> getNgoByName(String ngoName) throws ObjectNotFoundException;
	NGO getNgoByEmail(String ngoEmailId);
	NGO getNgoByContactNo(String ngoContactNumber);
	NGO getNgoByNgoWebsite(String ngoWebsite);
	List<NGO> getAllNgo();
	public List<NGO> getNgoByPincode(int ngoPincode);
	NGO addNGOIT();
}

package com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.DonationRepository;
import com.dao.DonorRepository;
import com.dao.NGORepository;
import com.model.Donation;
import com.model.Donor;
import com.model.NGO;

import Exceptions.InvalidPincodeException;
import Exceptions.NullValueException;
import Exceptions.ObjectNotFoundException;


@Service
public class DonationServiceImplementation implements DonationServices{

	
	@Autowired
	DonationRepository DonationRepo;
	
	@Autowired
	NGORepository NGORepo;
	
	@Autowired
	DonorRepository DonorRepo;
	
	@Override
	public Donation addDonation(Donation donation) throws NullValueException, ObjectNotFoundException, InvalidPincodeException {
		if(donation.getDonationType().length() == 0) {
			throw new NullValueException("Donation can not be empty please enter valid donation like 'cloths' , 'food, or wathever donated");
		}
		if(donation.getDonationQuantity() == 0) {
			throw new NullValueException("Quantity can not be empty or '0' Zero please enter exact number of quantity donated");
		}
		NGO ngoObj = NGORepo.findByNgoId(donation.getNgoId());
		if(ngoObj == null) {
			throw new ObjectNotFoundException("NGO of ngoId: " + donation.getNgoId() + " does not exists");
		}
		Donor donorObj = DonorRepo.findById(donation.getDonorId()).orElse(null);
		if(donorObj == null) {
			throw new ObjectNotFoundException("Donor of donorId: " + donation.getDonorId() + " does not exists");
		}
		if(donation.getDonationAddress().length() == 0) {
			throw new NullValueException("Address can not be empty please enter valid donation address");
		}
		if(donation.getDonationPincode() <= 0 || donation.getDonationPincode() > 835325) {
			throw new InvalidPincodeException("Pincode you entered is does not exists in India please enter Indian pincode only");
		}
		return DonationRepo.save(donation);
	}
	


	@Override
	public Donation updateDonation(Donation donation) throws ObjectNotFoundException, NullValueException, InvalidPincodeException {
		Donation newDonation = getDonationById(donation.getDonationId());
		if(newDonation == null) {
			throw new ObjectNotFoundException("Donation of donationId: " + donation.getDonationId() + " does not exists");	
		}
		if(donation.getDonationType().length() == 0) {
			throw new NullValueException("Donation can not be empty please enter valid donation like 'cloths' , 'food, or wathever donated");
		}
		if(donation.getDonationQuantity() == 0) {
			throw new NullValueException("Quantity can not be empty or '0' Zero please enter exact number of quantity donated");
		}
		NGO ngoObj = NGORepo.findByNgoId(donation.getNgoId());
		if(ngoObj == null) {
			throw new ObjectNotFoundException("NGO of ngoId: " + donation.getNgoId() + " does not exists");
		}
		Donor donorObj = DonorRepo.findById(donation.getDonorId()).orElse(null);
		if(donorObj == null) {
			throw new ObjectNotFoundException("Donor of donorId: " + donation.getDonorId() + " does not exists");
		}
		if(donation.getDonationAddress().length() == 0) {
			throw new NullValueException("Address can not be empty please enter valid donation address");
		}
		if(donation.getDonationPincode() <= 0 || donation.getDonationPincode() > 835325) {
			throw new InvalidPincodeException("Pincode you entered is does not exists in India please enter Indian pincode only");
		}
		newDonation.setDonationType(donation.getDonationType());
		newDonation.setDonationQuantity(donation.getDonationQuantity());
		newDonation.setNgoId(donation.getNgoId());
		newDonation.setDonorId(donation.getDonorId());
		newDonation.setDonationAddress(donation.getDonationAddress());
		newDonation.setDonationPincode(donation.getDonationPincode());
		return DonationRepo.save(newDonation);
	}
	
	@Override
	public void deleteDonationById(int donationId) {
		DonationRepo.deleteById(donationId);
	}

	@Override
	public void deleteDonationByGId(int donationId) {
		DonationRepo.deleteByDonationId(donationId);
	}

	@Override
	public void deleteDonationByNgoId(int ngoId) {
		DonationRepo.deleteByNgoId(ngoId);
	}

	@Override
	public void deleteDonationByDonorId(int donorId) {
		DonationRepo.deleteByDonorId(donorId);
	}

	
	@Override
	public List<Donation> getAllDonatons() {
		return DonationRepo.findAllDonations();
	}

	@Override
	public Donation getDonationById(int donationId) {
		return DonationRepo.findByDonationId(donationId);
	}

	@Override
	public List<Donation> getDonationByType(String donationType) {
		return DonationRepo.findByDonationType(donationType);
	}

	@Override
	public List<Donation> getDonationByNgoId(int ngoId) throws ObjectNotFoundException {
		NGO ngoObj = NGORepo.findByNgoId(ngoId);
		if(ngoObj == null) {
			throw new ObjectNotFoundException("NGO of ngoId: " + ngoId + " does not exists");
		}
		List<Donation> donations = DonationRepo.findByNgoId(ngoId);
		if(donations.isEmpty()) {
			throw new ObjectNotFoundException("Ngo with ngoId " + ngoId + " exsits but no donation found with ngoId: " + ngoId);
		}
		return donations;
	}

	@Override
	public List<Donation> getDonationByDonorId(int donorId) throws ObjectNotFoundException {
		Donor donorObj = DonorRepo.findById(donorId).orElse(null);
		if(donorObj == null) {
			throw new ObjectNotFoundException("Donor of donorId: " + donorId + " does not exists");
		}
		List<Donation> donations = DonationRepo.findByDonorId(donorId);
		if(donations.isEmpty()) {
			throw new ObjectNotFoundException("Donor with donorId:" + donorId + " exsits but no donation found with donorId " + donorId);
		}
		return DonationRepo.findByDonorId(donorId);
	}

	@Override
	public List<Donation> getDonationByPincode(int donationPincode) {
		return DonationRepo.findByDonationPincode(donationPincode);
	}

}

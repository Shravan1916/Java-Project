package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.Donor;

@Repository
public interface DonorRepository extends JpaRepository<Donor, Integer>{

	List<Donor> findByDonorName(String donorName);

	@Query("SELECT d from Donor d ORDER BY donorName")
	List<Donor> findAllDonors();

	Donor findByDonorEmailId(String donorEmail);

	Donor findByDonorContactNumber(String donorContactNumber);

	List<Donor> findByNgoId(int ngoId);

	@Query("DELETE from Donor d where d.donorId > :d")
	@Modifying
	@Transactional
	void deleteByDonorId(@Param("d")int donorId);
	
	@Query("DELETE from Donor d where d.ngoId = :d")
	@Modifying
	@Transactional
	void deleteByNgoId(@Param("d")int ngoId);

	List<Donor> findByDonorPincode(int donorPincode);
	
}

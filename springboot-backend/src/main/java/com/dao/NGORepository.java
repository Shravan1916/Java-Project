package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.model.NGO;


public interface NGORepository extends JpaRepository<NGO, Integer>{
	
	NGO findByNgoEmailId(String email);
	
	List<NGO> findByNgoName(String ngoName);
	
	NGO findByNgoContactNumber(String ngoContactNumber);

	NGO findByNgoWebsite(String ngoWebsite);
	
	@Query("SELECT n from NGO n ORDER BY ngoName")
	List<NGO> findAlls();

	
	@Query("DELETE from NGO n where n.ngoId > :n")
	@Modifying
	@Transactional
	void deleteByNgoId(@Param("n") int ngoId);

	NGO findByNgoId(int ngoId);

	List<NGO> findByNgoPincode(int ngoPincode);
}

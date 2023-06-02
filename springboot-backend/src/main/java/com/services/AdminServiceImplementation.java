package com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.AdminRepository;
import com.model.Admin;

@Service
public class AdminServiceImplementation implements AdminServices{

	@Autowired
	AdminRepository adminRepo;
	
	@Override
	public Admin addAdmin(Admin admin) {
		return adminRepo.save(admin);
	}

	@Override
	public Admin updateAdmin(Admin admin) {
		Admin newAdmin = adminRepo.findById(admin.getAdminId()).orElse(null);
		newAdmin.setAdminEmailId(admin.getAdminEmailId());
		newAdmin.setAdminPassword(admin.getAdminPassword());
		return adminRepo.save(newAdmin);
	}

	@Override
	public void deleteAdmin(int adminId) {
		adminRepo.deleteById(adminId);
	}

	@Override
	public Admin getAdminById(int adminId) {
		return adminRepo.findById(adminId).orElse(null);
	}

	@Override
	public List<Admin> getAllAdmin() {
		return adminRepo.findAll();
	}

}

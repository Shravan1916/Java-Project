package com.services;

import java.util.List;

import com.model.Admin;

public interface AdminServices {
	List<Admin> getAllAdmin();
	Admin addAdmin(Admin admin);
	Admin updateAdmin(Admin admin);
	void deleteAdmin(int adminId);
	Admin getAdminById(int adminId);
}

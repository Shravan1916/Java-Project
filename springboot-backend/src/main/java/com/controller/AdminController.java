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

import com.model.Admin;
import com.model.Donation;
import com.services.AdminServiceImplementation;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("")
public class AdminController {
	
	@Autowired 
	AdminServiceImplementation AdminSerImpl;
	
	@PostMapping("/addAdmin")
	Admin addUAdmin(@RequestBody Admin admin){
		return AdminSerImpl.addAdmin(admin);
	}
	
	@PutMapping("/updateAdmin")
	Admin updateUAdmin(@RequestBody Admin admin){
		return AdminSerImpl.updateAdmin(admin);
	}
	
	@DeleteMapping("/DeleteAdminById/{adminId}")
	void deleteUAdminId(@PathVariable int adminId) {
		AdminSerImpl.deleteAdmin(adminId);
	}
	
	@GetMapping("/getAllAdmin")
	List<Admin> getAllUAdmin(){
		return AdminSerImpl.getAllAdmin();
	}
	
	@GetMapping("/getAdminById/{adminId}")
	Admin getAdminUId(@PathVariable int adminId){
		return AdminSerImpl.getAdminById(adminId);
	}
}

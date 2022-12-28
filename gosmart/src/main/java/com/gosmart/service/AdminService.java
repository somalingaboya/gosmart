package com.gosmart.service;

import org.springframework.stereotype.Service;

import com.gosmart.repository.entity.AdminEntity;
@Service
public interface AdminService {
	
	
	public AdminEntity getAdmin(String adminEmailId, String adminPassword);
	public AdminEntity getAdmin(String adminEmailId);
	public void updateAdmin(AdminEntity adminEntity);
	
}

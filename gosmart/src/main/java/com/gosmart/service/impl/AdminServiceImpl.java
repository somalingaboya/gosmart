package com.gosmart.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gosmart.constants.AdminConstants;
import com.gosmart.exception.GoSmartException;
import com.gosmart.repository.AdminRepository;
import com.gosmart.repository.entity.AdminEntity;
import com.gosmart.service.AdminService;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
/*
 * 
 * */
@Service

@Slf4j
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminRepository repository;
	/* *
	 * 
	 * This method is used for the gettingEmployeeDetails by using emailId and Password
	 * @param adminEmailId This is the first parameter to getAdmin()
	 * @param adminPassword This is the second parameter to getAdmin()
	 * @return AdminEntity This returns AdminDetails
	 * */
	@Override
	public AdminEntity getAdmin(String adminEmailId, String adminPassword) 
		{
		log.info("{}-ServiceImpl  getAdmin() started",AdminConstants.ADMIN_ENTITY);
		AdminEntity adminEntity=null;
		try { 
			
			adminEntity=repository.findByAdminEmailIdAndAdminPassWord(adminEmailId, adminPassword);
			} 
			catch (Exception e)
			{
				log.error("{}-ServiceImpl getAdmin()-{}",AdminConstants.ADMIN_ENTITY,e.getMessage());
				throw new GoSmartException(e.getMessage());
			}
		return adminEntity;
		}
	
	@Override
	public AdminEntity getAdmin(String adminEmailId)
	{
		log.info("{}-ServiceImpl  getAdmin() started",AdminConstants.ADMIN_ENTITY);
		AdminEntity adminEntity=null;
			try 
			{
				
				adminEntity=repository.findByAdminEmailId(adminEmailId);
			}
			
			catch (Exception e) 
			{
				log.error("{}-ServiceImpl getAdmin()-{}",AdminConstants.ADMIN_ENTITY,e.getMessage());
				throw new GoSmartException(e.getMessage());
			}
		
		return adminEntity;
		}

	@Override
	public void updateAdmin(AdminEntity adminEntity) {
		try {
			repository.save(adminEntity);
			
		} catch (Exception e) {
			log.error("{}-ServiceImpl getAdmin()-{}",AdminConstants.ADMIN_ENTITY,e.getMessage());
			throw new GoSmartException(e.getMessage());
		}
		
	}

}

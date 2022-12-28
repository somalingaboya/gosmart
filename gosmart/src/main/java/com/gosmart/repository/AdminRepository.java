package com.gosmart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gosmart.repository.entity.AdminEntity;
@Repository
public interface AdminRepository extends JpaRepository<AdminEntity, Integer>{
	public AdminEntity findByAdminEmailIdAndAdminPassWord(String emailId, String password);
	public AdminEntity findByAdminEmailId(String emailId);
	


}

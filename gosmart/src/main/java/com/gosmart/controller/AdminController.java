package com.gosmart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gosmart.repository.entity.AdminEntity;
import com.gosmart.service.AdminService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/v1")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@PostMapping("/admin/login")
	public ResponseEntity<AdminEntity> getAdmin(@RequestBody AdminEntity adminEntity) {
		log.info("In AdminController... getAdmin() Method Started");
		try {
			AdminEntity admin = adminService.getAdmin(adminEntity.getAdminEmailId(), adminEntity.getAdminPassWord());
			if (admin != null) {
				log.info("In AdminController... getAdmin() Method details Successfully inserted");

				return new ResponseEntity<>(HttpStatus.OK); 

			} else {
				return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
			}
		} catch (Exception e) {
			log.error("In AdminController getAdmin() Method Error Message is:" + e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/admin/{emailId}")
	public ResponseEntity<AdminEntity> getAdmin(@PathVariable String emailId) {
		log.info("In AdminController... getAdmin() Method Started");

		try {
			AdminEntity admin = adminService.getAdmin(emailId);
			if (admin != null) {
				log.info("In AdminController... getAdmin() Method details Successfully inserted");

				return new ResponseEntity<>(HttpStatus.OK);

			} else {
				return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);

			}
		} catch (Exception e) {
			log.error("In AdminController getAdmin() Method Error Message is:" + e.getMessage());

			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		} 

	}
	@PostMapping("/updateadmin")
	public ResponseEntity<String> updateAdmin(@RequestBody AdminEntity adminEntity)
	{
		log.info("In AdminController... updateAdmin() Method Started");

		try {
			
				return new ResponseEntity<>("Success",HttpStatus.OK);

			
		} catch (Exception e) {
			log.error("In AdminController updateAdmin() Method Error Message is:" + e.getMessage());

			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
	
	
}

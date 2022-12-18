package com.gosmart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gosmart.repository.entity.UserContactDetailsEntity;
import com.gosmart.service.UserContactService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/v1")
public class UserContactController
{
	@Autowired
	private UserContactService service;
	
	@PostMapping("/user/contact/save")
	public ResponseEntity<Integer> insertUserContact(@RequestBody UserContactDetailsEntity userContactDetailsEntity)
	{
		
		log.info("In UserContactController... InsertUserContact() Method Started");

		try  
		{
			Integer userContactId=service.insertUserContact(userContactDetailsEntity);
			
			log.info("In UserContactController... User Details Succssfully Inserted");
			
			return new ResponseEntity<>(userContactId, HttpStatus.CREATED);
			

		} 
		catch (Exception e)
		{
			log.error("In UserConstactController InserUserContact() Method Error Message Is:"+e.getMessage());
			return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("user/contact/{id}")
	public ResponseEntity<UserContactDetailsEntity> getUserContact(@PathVariable Integer userContactId)
	{
		log.info("In UserContactController... GetUserContact() Method Started");

		try
		{
			UserContactDetailsEntity entity=service.getUserContact(userContactId);
			log.info("In UserContactController... User Details Succssfully Inserted");
			
			return new ResponseEntity<UserContactDetailsEntity>(entity,HttpStatus.OK);
		}
		catch (Exception e)
		{
			log.error("In UserConstactController GetUserContact() Method Error Message Is:"+e.getMessage());
			return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);


			
		}
	}
	
}

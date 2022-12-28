package com.gosmart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gosmart.constants.ContactOwnerConstants;
import com.gosmart.repository.entity.ContactOwnerEntity;
import com.gosmart.service.ContactOwnerService;

import lombok.extern.slf4j.Slf4j;
/**
 * 
 * @author NazeerBasha
 *
 */
@RestController
@Slf4j
@RequestMapping("/api/v1")
public class ContactOwnerController {
	
	@Autowired
	private ContactOwnerService contactOwnerService;
	
	@PostMapping("/contactowner/save")
	public ResponseEntity<Integer> insertContactOwner(@RequestBody ContactOwnerEntity contactOwnerEntity)
	{
		log.info("{}-ContactOwnerController insertContactOwner() started contactOwnerdatails in repositoty",
				ContactOwnerConstants.CONTACT_OWNER);
		try {
			log.info("{}-ContactOwnerController insertContactOwner() saved contactOwnerdatails in repositoty",
					ContactOwnerConstants.CONTACT_OWNER);
			Integer contactOwnerId=contactOwnerService.insertContactOwner(contactOwnerEntity);
			return new ResponseEntity<>(contactOwnerId,HttpStatus.CREATED);
			
		} catch (Exception e) {
			log.error("{}-ContactOwnerController insertContactOwner() exception occured-{}",
					ContactOwnerConstants.CONTACT_OWNER,e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/property/properties/{contactOwners}")
	public ResponseEntity<List<ContactOwnerEntity>> getContactOwners(@PathVariable Integer contactOwnerId)
	{	log.info("{}-ContactOwnerController getContactOwner() started contactOwnerdatails in repositoty",
			ContactOwnerConstants.CONTACT_OWNER);
		try {
			log.info("{}-ContactOwnerController getContactOwners() getting contactOwnerdatails in repositoty",
					ContactOwnerConstants.CONTACT_OWNER);
			List<ContactOwnerEntity> contactOwners=contactOwnerService.getContactOwners(contactOwnerId);
			return new ResponseEntity<>(contactOwners,HttpStatus.OK);
		} catch (Exception e) {
			log.error("{}-ContactOwnerController getContactOwner() exception occured-{}",
					ContactOwnerConstants.CONTACT_OWNER,e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/property/property/{propertyId}")
	public ResponseEntity<ContactOwnerEntity>getContactOwners1(@PathVariable Integer propertyId)
	{
		log.info("{}-ContactOwnerController getContactOwner() started",ContactOwnerConstants.CONTACT_OWNER);
		try {
			log.info("{}-ContactOwnerController getContactOwners() getting contactOwnerdatails in repositoty",
					ContactOwnerConstants.CONTACT_OWNER);
			ContactOwnerEntity contactOwners1=contactOwnerService.getContactOwners1(propertyId);
			return new ResponseEntity<>(contactOwners1,HttpStatus.OK);
		} catch (Exception e) {
			log.error("{}-ContactOwnerController getContactOwner() exception occured-{}",
				ContactOwnerConstants.CONTACT_OWNER,e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

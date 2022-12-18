package com.gosmart.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gosmart.constants.UserContactConstants;
import com.gosmart.exception.GoSmartException;
import com.gosmart.repository.UserContactRepository;
import com.gosmart.repository.entity.UserContactDetailsEntity;
import com.gosmart.service.UserContactService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserContactServiceImpl implements UserContactService
{
	@Autowired
	private UserContactRepository repository;
	
	/**
	 * This Method Is Used
	 * 
	 * For The UserContactDetailsEntity
	 * @param this returns UserContactDetailsEntity this is the
	 * @return this return UserContactDetails
	 */
	
	@Override
	public Integer insertUserContact(UserContactDetailsEntity userContactDetailsEntity)
	{
		Integer userContactId=0;
		try {
			UserContactDetailsEntity entity=null;
			
			log.info("In {}-ServiceImpl... InsertUserContact() Method Started",UserContactConstants.USER_CONTACT);
			
			entity=repository.save(userContactDetailsEntity);
			if(entity!=null)
			{
				userContactId=entity.getUserConstactId();
			}
			log.info("In {}-ServiceImpl... UserContact Details Successfully Inserted",UserContactConstants.USER_CONTACT);
			
		} catch (Exception e) {
			log.error("In {}-ServiceImpl...exception occured-{}",UserContactConstants.USER_CONTACT,e.getMessage());
			throw new GoSmartException(e.getMessage());
			
			
			
		}

		return userContactId;
	}

	@Override
	public UserContactDetailsEntity getUserContact(Integer UserConstactId) 
	{
		
		try
		{
			UserContactDetailsEntity entity=null;
			log.info("In {}-ServiceImpl... getUserContact() Method Started",UserContactConstants.USER_CONTACT);
			entity=repository.findById(UserConstactId).get();
			log.info("In {}-ServiceImpl... gettUserContact Details Successfully Inserted",UserContactConstants.USER_CONTACT);
			return entity;
			
		} 
		catch (Exception e) 
		{
			log.error("In {}-ServiceImpl...exception occured-{}",UserContactConstants.USER_CONTACT,e.getMessage());
			throw new GoSmartException(e.getMessage());

		}
		
		
	}

}

package com.gosmart.service;

import java.util.List;

import com.gosmart.repository.entity.UserContactDetailsEntity;

public interface UserContactService 
{
	public Integer insertUserContact(UserContactDetailsEntity userContactDetailsEntity);
	
	public UserContactDetailsEntity getUserContact(Integer UserConstactId);
}

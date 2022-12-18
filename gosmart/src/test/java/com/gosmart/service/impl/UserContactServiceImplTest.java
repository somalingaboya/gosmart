package com.gosmart.service.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import com.gosmart.repository.UserContactRepository;
import com.gosmart.repository.entity.UserContactDetailsEntity;

@RunWith(SpringJUnit4ClassRunner.class)
public class UserContactServiceImplTest 
{
	@InjectMocks
	private UserContactServiceImpl service;
	
	@Mock
	private UserContactRepository repository;
	
	@Test
	public void testInsertUserContact() throws Exception
	{
		UserContactDetailsEntity userContactDetailsEntity2=Mockito.mock(UserContactDetailsEntity.class);
		UserContactDetailsEntity userContactDetailsEntity=new UserContactDetailsEntity();
		
		when(repository.save(userContactDetailsEntity)).thenReturn(userContactDetailsEntity2);
		
		Integer userContactId=service.insertUserContact(userContactDetailsEntity);
		
		assertNotNull(userContactId);
			 
	} 

	@Test(expected=Exception.class)
	public void testInsertUserContact_Exception() throws Exception
	{
		UserContactDetailsEntity userContactDetailsEntity2=new UserContactDetailsEntity();
		
		when(repository.save(userContactDetailsEntity2)).thenThrow(NullPointerException.class);
		
		service.insertUserContact(userContactDetailsEntity2); 

			
	}
	
	@Test
	public void testGetUserContact() throws Exception
	{
		UserContactDetailsEntity userContactDetailsEntity=Mockito.mock(UserContactDetailsEntity.class);
		
		when(repository.findById(Mockito.any())).thenReturn();
	}
}

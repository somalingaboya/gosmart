package com.gosmart.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gosmart.repository.entity.UserContactDetailsEntity;
import com.gosmart.service.UserContactService;

@RunWith(SpringJUnit4ClassRunner.class)
public class UserContactControllerTest 
{
	@InjectMocks
	private UserContactController controller;
	
	@Mock
	private UserContactService service;
	
	@Test()
	public void testInsertUserContact() throws Exception
	{
		UserContactDetailsEntity userContactDetailsEntity=new UserContactDetailsEntity();
		
		Integer userContactId=1; 
		
		when(service.insertUserContact(userContactDetailsEntity)).thenReturn(userContactId);
		
		ResponseEntity<Integer> response=controller.insertUserContact(userContactDetailsEntity);
		
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
	}
	
	@Test
	public void testInsertUserContact_Exception() throws Exception
	{
		UserContactDetailsEntity userContactDetailsEntity=new UserContactDetailsEntity();
		
		when(service.insertUserContact(userContactDetailsEntity)).thenThrow(NullPointerException.class);
		
		ResponseEntity<Integer> response=controller.insertUserContact(userContactDetailsEntity);
		
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
	}
	
	@Test
	public void testgetUserContact() throws Exception
	{
		Integer userContactId=1;
		UserContactDetailsEntity userContactDetailsEntity=new UserContactDetailsEntity();
		when(service.getUserContact(userContactId)).thenReturn(userContactDetailsEntity);
		
		ResponseEntity<UserContactDetailsEntity> response=controller.getUserContact(2);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	@Test
	public void testgetUserContact_Exception() throws Exception
	{
		Integer userContactId=1;
		UserContactDetailsEntity userContactDetailsEntity=new UserContactDetailsEntity();
		when(service.getUserContact(userContactId)).thenThrow(NullPointerException.class);
		
		ResponseEntity<UserContactDetailsEntity> response=controller.getUserContact(2);
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
	}
}

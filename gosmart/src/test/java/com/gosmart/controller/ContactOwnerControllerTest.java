package com.gosmart.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.when;

import java.lang.ModuleLayer.Controller;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gosmart.repository.ContactOwnerRepository;
import com.gosmart.repository.entity.ContactOwnerEntity;
import com.gosmart.service.ContactOwnerService;


@RunWith(SpringJUnit4ClassRunner.class)
public class ContactOwnerControllerTest {
	@InjectMocks
	private ContactOwnerController contactOwnerController;
	@Mock
	private ContactOwnerService contactOwnerService;
	@Test
	public void testInsertContactOwner() throws Exception
	{
		ContactOwnerEntity contactOwnerEntity=new ContactOwnerEntity();
		Integer contactOwnerId=1;
		when(contactOwnerService.insertContactOwner(contactOwnerEntity)).thenReturn(contactOwnerId);
		ResponseEntity<Integer> response=contactOwnerController.insertContactOwner(contactOwnerEntity);
		assertEquals(HttpStatus.CREATED,response.getStatusCode());
	}
	@Test
	public void testInsertContactOwner_Exception() throws Exception
	{
		ContactOwnerEntity contactOwnerEntity=new ContactOwnerEntity();
		when(contactOwnerService.insertContactOwner(contactOwnerEntity)).thenThrow(NullPointerException.class);
		ResponseEntity<Integer> response=contactOwnerController.insertContactOwner(contactOwnerEntity);
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR,response.getStatusCode());
	}
	
	@Test
	public void testGetContactOwner() throws Exception
	{
		Integer contactOwnerId=1;
		List<ContactOwnerEntity> contactOwnerList=new ArrayList<>();
		when(contactOwnerService.getContactOwners(contactOwnerId)).thenReturn(contactOwnerList);
		ResponseEntity<List<ContactOwnerEntity>> responseEntity=contactOwnerController.getContactOwners(contactOwnerId);
		assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
	}
	@Test
	public void testGetContactOwner_Exception() throws Exception
	{
		Integer contactOwnerId=1;
		when(contactOwnerService.getContactOwners(contactOwnerId)).thenThrow(NullPointerException.class);
		ResponseEntity<List<ContactOwnerEntity>> responseEntity=contactOwnerController.getContactOwners(contactOwnerId);
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR,responseEntity.getStatusCode());
	}
	@Test
	public void testGetContactOwners1() throws Exception
	{
		ContactOwnerEntity contactOwnerEntity=new ContactOwnerEntity();
		Integer contactOwnerId=1;
		when(contactOwnerService.getContactOwners1(contactOwnerId)).thenReturn(contactOwnerEntity);
		ResponseEntity<ContactOwnerEntity> response=contactOwnerController.getContactOwners1(contactOwnerId);
		assertNotEquals(HttpStatus.CREATED,response.getStatusCode());
	}
	@Test
	public void testGetContactOwners1_Exception() throws Exception
	{
		Integer contactOwnerId=1;
		when(contactOwnerService.getContactOwners1(contactOwnerId)).thenThrow(NullPointerException.class);
		ResponseEntity<ContactOwnerEntity> response=contactOwnerController.getContactOwners1(contactOwnerId);
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR,response.getStatusCode());
	}

}

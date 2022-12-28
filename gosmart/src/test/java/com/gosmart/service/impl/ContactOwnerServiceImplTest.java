package com.gosmart.service.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gosmart.exception.GoSmartException;
import com.gosmart.repository.ContactOwnerRepository;
import com.gosmart.repository.entity.ContactOwnerEntity;


@RunWith(SpringJUnit4ClassRunner.class)

public class ContactOwnerServiceImplTest 
{
	@InjectMocks
	private ContactOwnerServiceImpl service;
	@Mock
	private ContactOwnerRepository repository;
	@Test
	public void testInsertContactOwner() throws Exception{
		ContactOwnerEntity contactOwnerEntity=new ContactOwnerEntity();
		ContactOwnerEntity contactOwnerEntity2=Mockito.any();
		when(repository.save(contactOwnerEntity)).thenReturn(contactOwnerEntity2);
		Integer contactOwnerId=service.insertContactOwner(contactOwnerEntity);
		assertNotNull(contactOwnerId);
	}
	@Test(expected = GoSmartException.class)
	public void testInsertContactOwner_Exception() throws Exception{
		ContactOwnerEntity contactOwnerEntity=new ContactOwnerEntity();
		when(repository.save(contactOwnerEntity)).thenThrow(NullPointerException.class);
		service.insertContactOwner(contactOwnerEntity);	
	}
	@Test
	public void testGetContactOwner() throws Exception
	{
		Integer contactOwnerId=1;
		List<ContactOwnerEntity> contactOwnerList=new ArrayList<>();
		when(repository.findAllByPropertyId(contactOwnerId)).thenReturn(contactOwnerList);
		List<ContactOwnerEntity> contactOwner=service.getContactOwners(1);
		assertNotNull(contactOwner);	
	}
	
	
	@Test(expected = GoSmartException.class)
	public void testGetContactOwner_Exception() throws Exception
	{
		Integer contactOwnerId=1;
		when(repository.findAllByPropertyId(contactOwnerId)).thenThrow(NullPointerException.class);
		service.getContactOwners(1);
	}
	@Test
	public void testGetContactOwners1() throws Exception
	{
		Integer contactOwnerId=1;
		ContactOwnerEntity contactOwnerEntity=new ContactOwnerEntity();
		ContactOwnerEntity contactOwnerEntity2=Mockito.any();
		when(repository.findByContactOwnerId(contactOwnerId)).thenReturn(contactOwnerEntity);
		contactOwnerEntity=service.getContactOwners1(contactOwnerId);
		assertNotNull(contactOwnerEntity);
	}
	@Test(expected = GoSmartException.class)
	public void testGetContactOwners1_Exception() throws Exception
	{
		Integer contactOwnerId=1;
		when(repository.findByContactOwnerId(contactOwnerId)).thenThrow(NullPointerException.class);
		service.getContactOwners1(1);
	}
}

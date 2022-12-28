package com.gosmart.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import com.gosmart.repository.entity.PropertyImageEntity;
import com.gosmart.service.PropertyImageService;

@RunWith(SpringJUnit4ClassRunner.class)
public class PropertyImageControllerTest {
	@InjectMocks
	private PropertyImageController controller;
	@Mock
	private PropertyImageService service;
	@Test
	public void testInsertPropertyImage()throws Exception
	{
		PropertyImageEntity propertyImageEntity=new PropertyImageEntity();
		Integer propertyImageId=1;
		when(service.insertPropertyImage(propertyImageEntity)).thenReturn(propertyImageId);
		ResponseEntity<Integer> response=controller.insertPropertyImage(propertyImageEntity);
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
		
	} 
	@Test
	public void testInsertPropertyImage_Exception()throws Exception
	{
		PropertyImageEntity propertyImageEntity=new PropertyImageEntity();
		when(service.insertPropertyImage(propertyImageEntity)).thenThrow(NullPointerException.class);
		ResponseEntity<Integer> response=controller.insertPropertyImage(propertyImageEntity);
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
		
	} 
	@Test
	public void testGetPropertyImages()throws Exception
	{
		Integer propertyId=1;
		List<PropertyImageEntity> propertyImageList=new ArrayList<>();
		when(service.getPropertyImages(propertyId)).thenReturn(propertyImageList);
		ResponseEntity<List<PropertyImageEntity>> responseEntity=controller.getPropertyImages(propertyId);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		
	}
	@Test
	public void testGetPropertyImages_Exception()throws Exception
	{
		Integer propertyId=1;
		when(service.getPropertyImages(propertyId)).thenThrow(NullPointerException.class);
		ResponseEntity<List<PropertyImageEntity>> responseEntity=controller.getPropertyImages(propertyId);
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
		
	}
	@Test
	public void testGetPropertyImage()throws Exception
	{
		Integer propertyImageId=1;
		PropertyImageEntity propertyImageEntity=Mockito.any();
		when(service.getPropertyImage(propertyImageId)).thenReturn(propertyImageEntity);
		ResponseEntity<PropertyImageEntity> responseEntity=controller.getPropertyImage(propertyImageId);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		
	}
	@Test
	public void testGetPropertyImage_Exception()throws Exception
	{
		Integer propertyImageId=1;
		
		when(service.getPropertyImage(propertyImageId)).thenThrow(NullPointerException.class);
		ResponseEntity<PropertyImageEntity> responseEntity=controller.getPropertyImage(propertyImageId);
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
		
	}
	
}

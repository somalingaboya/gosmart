package com.gosmart.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import com.gosmart.exception.GoSmartException;
import com.gosmart.repository.entity.AdminEntity;
import com.gosmart.service.AdminService;

@RunWith(SpringJUnit4ClassRunner.class)
public class AdminControllerTest {
	@InjectMocks
	private AdminController adminController;
	@Mock
	private AdminService service;
	@Test
	public void testGetAdmin()throws Exception{
		AdminEntity adminEntity=new AdminEntity();
		AdminEntity admin=new AdminEntity();
		when(service.getAdmin("1", "2")).thenReturn(admin);
		ResponseEntity<AdminEntity>response=adminController.getAdmin(adminEntity);
		assertEquals(HttpStatus.OK,response.getStatusCode());
	}
	@Test
	public void testGetAdmin_Exception()throws Exception{
		AdminEntity adminEntity=new AdminEntity();
		
		when(service.getAdmin("1", "2")).thenThrow(NullPointerException.class);
		ResponseEntity<AdminEntity>response=adminController.getAdmin(adminEntity);
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR,response.getStatusCode());
	}
	@Test
	public void testGetAdmin2()throws Exception{
		AdminEntity adminEntity=new AdminEntity();
		AdminEntity admin=new AdminEntity();
		when(service.getAdmin("1", "2")).thenReturn(admin);
		ResponseEntity<AdminEntity>response=adminController.getAdmin(adminEntity);
		assertEquals(HttpStatus.OK,response.getStatusCode());
		
	}
	@Test
	public void testGetAdmin2_Exception()throws Exception{
		AdminEntity adminEntity=new AdminEntity();
		
		when(service.getAdmin("1", "2")).thenThrow(NullPointerException.class);
		ResponseEntity<AdminEntity>response=adminController.getAdmin(adminEntity);
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR,response.getStatusCode());
	}
}

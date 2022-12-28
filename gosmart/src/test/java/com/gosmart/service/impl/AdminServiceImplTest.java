

package com.gosmart.service.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gosmart.exception.GoSmartException;
import com.gosmart.repository.AdminRepository;
import com.gosmart.repository.entity.AdminEntity;

@RunWith(SpringJUnit4ClassRunner.class)
public class AdminServiceImplTest {
	
	@InjectMocks
	private AdminServiceImpl service;
	@Mock
	private AdminRepository repository;
	@Test
	public void testGetAdmin()throws Exception
	{
		String emailId="emailId";
		String password="password";
		AdminEntity adminEntity=new AdminEntity();
		when(repository.findByAdminEmailIdAndAdminPassWord(emailId,password)).thenReturn(adminEntity);
		AdminEntity entity=service.getAdmin(emailId, password);
		assertNotNull(entity);
		
	}
	@Test(expected =GoSmartException.class)
	public void testGetAdmin_Exception()throws Exception
	{
		String emailId="emailId";
		String password="password";
		when(repository.findByAdminEmailIdAndAdminPassWord(emailId,password)).thenThrow(NullPointerException.class);
		service.getAdmin(emailId, password);
		
	}
	@Test
	public void testGetAdminByEmailId()throws Exception
	{
		String emailId="emailId";
		AdminEntity adminEntity=new AdminEntity();
		when(repository.findByAdminEmailId(emailId)).thenReturn(adminEntity);
		AdminEntity entity=service.getAdmin(emailId);
		assertNotNull(entity);
	}
	@Test(expected =GoSmartException.class)
	public void testGetAdminByEmailId_Exception()throws Exception
	{
		String emailId="emailId";
	
		when(repository.findByAdminEmailId(emailId)).thenThrow(NullPointerException.class);
		service.getAdmin(emailId);
		
	}
	@Test
	public void testUpdateAdmin()throws Exception
	{
		
		AdminEntity adminEntity=new AdminEntity();
		when(repository.save(adminEntity)).thenReturn(adminEntity);
		service.updateAdmin(adminEntity);
			assertTrue(true);
	}
	@Test(expected = GoSmartException.class)
	public void testUpdateAdmin_Exception()throws Exception
	{
		
		AdminEntity adminEntity=new AdminEntity();
		when(repository.save(adminEntity)).thenThrow(NullPointerException.class);
		service.updateAdmin(adminEntity);
		
	}
	
	
	
}

package com.gosmart.service.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gosmart.repository.BranchRepository;
import com.gosmart.repository.entity.BranchEntity;

@RunWith(SpringJUnit4ClassRunner.class)
public class BranchServiceImplTest {
	@InjectMocks
	private BranchServiceImpl  service;
	@Mock
	private BranchRepository repository;
	@Test
	public void testInsertBranch() throws Exception{
		BranchEntity branchEntity=new BranchEntity();
		BranchEntity branchEntity2=Mockito.any();
		when(repository.save(branchEntity)).thenReturn(branchEntity2);
		Integer branchId=service.insertBranch(branchEntity);
		assertNotNull(branchId);
		
	}
	@Test(expected = Exception.class)
	public void testInsertBranch_Exception() throws Exception{
		BranchEntity branchEntity=new BranchEntity();
		when(repository.save(branchEntity)).thenThrow(NullPointerException.class);
		service.insertBranch(branchEntity);
	}
	
	@Test
	public void testGetAllBranches() throws Exception{
		List<BranchEntity> branchList=new ArrayList<>();
		when(repository.findAll()).thenReturn(branchList);
		List<BranchEntity> branches=service.getAllBranches();
		assertNotNull(branches);
	}
	
	@Test(expected = Exception.class)
	public void testGetAllBranches_Exception() throws Exception{
		List<BranchEntity> branchList=new ArrayList<>();
		when(repository.findAll()).thenThrow(NullPointerException.class);
		service.getAllBranches();
	}
	@Test
	public void testGetBranch() throws Exception{
		Integer branchId=1;
		BranchEntity branchEntity=new BranchEntity();
		Optional<BranchEntity> branchEntity2=Mockito.any();
		when(repository.findById(branchId)).thenReturn(branchEntity2);
		branchEntity= service.getBranch(branchId);
		assertNotNull(branchId);
		
	}
	@Test
	public void testGetBranch_Exception() throws Exception{
		Integer branchId=1;
		when(repository.findById(branchId)).thenThrow(NullPointerException.class);
		 service.getBranch(branchId);
		
		
	}
}

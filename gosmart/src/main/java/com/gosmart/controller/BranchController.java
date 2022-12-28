package com.gosmart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gosmart.constants.BranchConstants;
import com.gosmart.repository.entity.BranchEntity;
import com.gosmart.service.BranchService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/v1")
public class BranchController {
	@Autowired
	private BranchService branchService;
	
	@PostMapping("/branch/save")
	public ResponseEntity<Integer> insertBranch(@RequestBody BranchEntity branchEntity)
	{
		log.info("{}-serviceController insertBranch() started",BranchConstants.BRANCH_ENTITY);
		try {
			log.info("{}-serviceController insertBranch() Saving branch",BranchConstants.BRANCH_ENTITY);
			Integer branchId=branchService.insertBranch(branchEntity);
			return new ResponseEntity<>(branchId,HttpStatus.CREATED);
		} catch (Exception e) {
			log.error("{}-serviceControllerExceptionOccer-{}",BranchConstants.BRANCH_ENTITY,e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/branch/branches")
	public ResponseEntity<List<BranchEntity>> getAllBranches()
	{
		log.info("{}-Controller getAllranches() started",BranchConstants.BRANCH_ENTITY);
		try {
			log.info("{}-serviceController getAllranches() Saving branch",BranchConstants.BRANCH_ENTITY);
			List<BranchEntity> branches=branchService.getAllBranches();
			return new ResponseEntity<>(branches,HttpStatus.OK);
		} catch (Exception e) {
			log.error("{}-serviceControllerExceptionOccer-{}",BranchConstants.BRANCH_ENTITY,e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	public ResponseEntity<BranchEntity> getBranch(@PathVariable Integer branchId)
	{
		log.info("{}-serviceController getBranch() started",BranchConstants.BRANCH_ENTITY);
		
		try {
			log.info("{}-serviceController getBranch() Saving branch",BranchConstants.BRANCH_ENTITY);
			BranchEntity branch=branchService.getBranch(branchId);
			return new ResponseEntity<>(branch,HttpStatus.OK);
		} catch (Exception e) {
			log.error("{}-serviceControllerExceptionOccer-{}",BranchConstants.BRANCH_ENTITY,e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

}

package com.gosmart.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gosmart.constants.BranchConstants;
import com.gosmart.exception.GoSmartException;
import com.gosmart.repository.BranchRepository;
import com.gosmart.repository.entity.BranchEntity;
import com.gosmart.service.BranchService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BranchServiceImpl implements BranchService{
	@Autowired
	private BranchRepository repository;
	/**
	 * This method is used for The gettingBranchDetails byUsing BranchId
	 * @param branchId This is the First parameter to insertBranch()
	 * @return BranchEntity this is return BranchDetails
	 * */

	@Override
	public Integer insertBranch(BranchEntity branchEntity) {
		log.info("{}-serviceImpl insertBranch() started()",BranchConstants.BRANCH_ENTITY);
		Integer branchId=0;
		
		try {
			log.info("{}-serviceImpl insertBranches() saving()",BranchConstants.BRANCH_ENTITY);
			BranchEntity branchEntity2=repository.save(branchEntity);
			if(branchEntity2!=null)
			{
				branchId=branchEntity2.getBranchId();
			}
		} catch (Exception e) {
			log.error("{}-serviceImpl insertBranch()-{}",BranchConstants.BRANCH_ENTITY,e.getMessage());
			throw new GoSmartException(e.getMessage());
		}
		return branchId;
	}
	@Override
	public List<BranchEntity> getAllBranches() {
		log.info("{}-serviceImpl getAllBranches() started()",BranchConstants.BRANCH_ENTITY);
		List<BranchEntity> branches=null;
		try {
			log.info("{}-serviceImpl getAllBranches() saving()",BranchConstants.BRANCH_ENTITY);
			branches=repository.findAll();
		} catch (Exception e) {
			log.error("{}-serviceImpl getAllBranches()-{}",BranchConstants.BRANCH_ENTITY,e.getMessage());
			throw new GoSmartException(e.getMessage());
		}
		return branches;
	}
	@Override
	public BranchEntity getBranch(Integer branchId) {
		log.info("{}-serviceImpl getBranch() started()",BranchConstants.BRANCH_ENTITY);
		BranchEntity branchEntity=null;
		try {
			log.info("{}-serviceImpl getBranch() saving()",BranchConstants.BRANCH_ENTITY);
			branchEntity=repository.findByBranchId(branchId);
		} catch (Exception e) {
			log.error("{}-serviceImpl getBranch()-{}",BranchConstants.BRANCH_ENTITY,e.getMessage());
			throw new GoSmartException(e.getMessage());
		}
		return branchEntity;
	
	}
}

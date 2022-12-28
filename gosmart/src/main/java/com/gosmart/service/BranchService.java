package com.gosmart.service;

import java.util.List;

import com.gosmart.repository.entity.BranchEntity;

public interface BranchService {
	public Integer insertBranch(BranchEntity branchEntity);
	public List<BranchEntity> getAllBranches();
	public BranchEntity getBranch(Integer branchId);
}

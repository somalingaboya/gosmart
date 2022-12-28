package com.gosmart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gosmart.repository.entity.BranchEntity;
@Repository
public interface BranchRepository extends JpaRepository<BranchEntity, Integer>{
	public BranchEntity findByBranchId(Integer branchId);  
}

package com.gosmart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gosmart.repository.entity.UserContactDetailsEntity;
@Repository
public interface UserContactRepository extends JpaRepository<UserContactDetailsEntity, Integer> 
{
	
}

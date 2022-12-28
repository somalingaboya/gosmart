package com.gosmart.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gosmart.repository.entity.PropertyImageEntity;
/* *
^<h2>PropertyImageRepository</h2>
* ThisRepository interface Maps2 Property_Image_Repository
* 
* @author yerramala
* version 1.0
* since 2022-12-17
*/
@Repository
public interface PropertyImageRepository extends JpaRepository<PropertyImageEntity, Integer>{
	public List<PropertyImageEntity> findAllByPropertyId(Integer propertyId);
	
}

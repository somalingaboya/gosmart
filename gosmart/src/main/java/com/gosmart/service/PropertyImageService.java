package com.gosmart.service;
import java.util.List;
import com.gosmart.repository.entity.PropertyImageEntity;
/* *
^<h2>PropertyImageEntity</h2>
* ThisEntityClassMaps to Property_Iamge_Service
* 
* @author yerramala
* version 1.0
* since 2022-12-17
*/
public interface PropertyImageService {

	public Integer insertPropertyImage(PropertyImageEntity propertyImageEntity);
	public List<PropertyImageEntity> getPropertyImages(Integer propertyId);
	public PropertyImageEntity getPropertyImage(Integer propertyImageId);
	
}

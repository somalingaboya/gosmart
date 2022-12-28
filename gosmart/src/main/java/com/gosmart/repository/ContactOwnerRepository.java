package com.gosmart.repository;
/**
 * <h1>ContactOwnerRepository</h2>
 * This interface maps to CONTACT_OWNER_REPOSITORY
 */

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gosmart.repository.entity.ContactOwnerEntity;
@Repository
public interface ContactOwnerRepository extends JpaRepository<ContactOwnerEntity, Integer> 
{
	public List<ContactOwnerEntity> findAllByPropertyId(Integer propertyId);
	public ContactOwnerEntity findByContactOwnerId(Integer contactOwnerId);
}

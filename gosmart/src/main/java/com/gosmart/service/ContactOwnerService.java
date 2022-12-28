package com.gosmart.service;
import java.util.List;
import com.gosmart.repository.entity.ContactOwnerEntity;
/**
 * 
 * @author AKHM SOLUTIONS
 *
 */
public interface ContactOwnerService {
	public Integer insertContactOwner(ContactOwnerEntity contactOwnerEntity);
	public List<ContactOwnerEntity>getContactOwners(Integer propertyId);
	public ContactOwnerEntity getContactOwners1(Integer contactOwnerId);
}

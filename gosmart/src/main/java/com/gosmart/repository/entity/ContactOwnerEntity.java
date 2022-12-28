package com.gosmart.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
/**
 * <h2>ContactOwnerEntity</h2>
 * This Entity class maps to CONTACT_OWNER_ENTITY
 * @author NazeerBasha
 * @version 1.0
 * @since 2022-12-17
 * */
@Entity
@Data
@Table(name="CONTACT_OWNER_ENTITY")
public class ContactOwnerEntity {
	//primary key
	@Id
	@GeneratedValue
	@Column(name="CONTACT_OWNER_ID")
	private Integer contactOwnerId;
	// name of the property
	@Column(name="PROPERTY_ID")
	private Integer propertyId;
	// userId of the contactOwner
	@Column(name="USER_ID")
	private Integer userId;
	//Name of the contactOwner
	@Column(name="NAME")
	private String name;
	//emailId of the contactOwner
	@Column(name="EMAIL_ID")
	private String emailId;
	//mobileNumber of the contact Owner
	@Column(name="MOBILE_NUMBER")
	private String mobileNumber;
}

package com.gosmart.repository.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 <h2>UserContactDetailsEntity</h2>
 * This EntityClass Maps To USERCONTACTDETAILS_TL 
 * 
 * @author SOM
 * @version 1.0
 * @since 2022-12-17
 * 
 */
@Entity
@Data
@Table(name="USERCONTACTDETAILS_TL")

public class UserContactDetailsEntity 
{
	//primary key
	
	@Id
	@GeneratedValue
	
	//Name Of The UserContactId
	@Column(name="USERCONSTACT_ID")
	private Integer userConstactId;
	
	//Name Of The UserId
	@Column(name="USER_ID")
	private Integer userId;
	
	//Name Of The AddressProof
	@Column(name="ADDRESS_PROOF")
	private String addressProof;
	
	//Name Of The Address
	@Column(name="ADDRESS")
	private String  address;
	
	//Name Of The SelfiImage
	@Column(name="SELFI_IMAGE")
	private String selfiImage;
	
	
	//Name Of The cityId
	@Column(name="CITY_ID")
	private String cityId;
	
	//Name Of The StateId
	@Column(name="STATE_ID")
	private String stateId;
	
	
	//Name Of The Status
	@Column(name="STATUS")
	private String status;
	
	
	//Name Of The UpdatedOn
	@Column(name="UPDATED_ON")
	private Date updatedOn;

	//Name Of The CreatedOn
	@Column(name="CREATED_ON")
	private Date createdOn;
	
	//Name Of The updatedBy
	@Column(name="UPDATED_BY")
	private Integer updatedBy;

	
	//Name Of The CreatedBy
	@Column(name="CREATED_BY")
	private Integer createdBy;
	
}

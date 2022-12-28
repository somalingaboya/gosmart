package com.gosmart.repository.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
/**
 * <h2>ADMINENTITY</h2>
 * This An Entity classMapsTo ADMIN_TL
 * @author vishnupriya
 * @version 1.0
 * @since 2022-12-17
 
   */
@Entity
@Data
@Table(name="ADMIN_TL")
public class AdminEntity {
	
	//primary key
	
	@Id
	@Column(name="ADMIN_ID")
	@GeneratedValue
	private Integer adminId;
	//name of the adminFirstName
	@Column(name="ADMIN_FIRST_NAME")
	private String adminFirstName;
	//name of the adminLastName
	@Column(name="ADMIN_LAST_NAME")
	private String adminLastName;
	//name of the adminEmailId
	@Column(name="ADMIN_EMAIL_ID")
	private String adminEmailId;
	//name of the adminPassword
	@Column(name="ADMIN_PASSWORD")
	private String adminPassWord;
	//name of the adminMobileNumber
	@Column(name="ADMIN-MOBILE_NUMBER")
	private String adminMobileNumber;
	//name of the adminStatus
	@Column(name="ADMIN_STATUS")
	private String adminStatus;
	//name of the adminUpdatedon
	@Column(name="ADMIN_UPDATEDON")
	private Date adminUpdatedon;
	

}

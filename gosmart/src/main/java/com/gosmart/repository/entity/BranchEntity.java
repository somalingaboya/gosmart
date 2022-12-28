package com.gosmart.repository.entity;
import java.sql.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/* *
 * <h2> BranchEntity </h2>
 * This An Entity class MapssTo BRANCH_TL
 * @Authour CHANDRA
 * @version 1.0
 * @since 2023-12-17
  */
@Entity
@Data
@Table(name="BRANCH_TL")
public class BranchEntity {
	
	//primaryKey
	@Id
	@Column(name="BRANCH_ID")
	@GeneratedValue
	private Integer branchId;
	//nameOf the BranchName
	@Column(name="BRANCH_NAME")
	private String branchName;
	//nameOf the BranchDescription
	@Column(name="BRANCH_DESCRIPTION")
	private String branchDescription;
	//nameOf the BranchCreatedOn
	@Column(name="BRANCH_CREATED_ON")
	private Date branchCreatedOn;
	//nameOf the BranchCreatedBy
	@Column(name="BRANCH_CREATED_BY")
	private Date branchCreatedBy;
	//nameOf the BranchUpdatedOn
	@Column(name="BRANCH_UPDATED_ON")
	private Date branchUpdatedOn;
	//nameOf the BranchUpdatedBy
	@Column(name="BRANCH_UPDATED_BY")
	private Date branchUpdatedBy;
	//nameOf the BranchStatus
	@Column(name="BRANCH_STATUS")
	private String branchStatus;
	//nameOf the stateId
	@Column(name="STATE_ID")
	private String stateId;
	//nameOf the cityId
	@Column(name="CITY_ID")
	private String cityId;
	//nameOf the BranchAddress
	@Column(name="BRANCH_ADDRESS")
	private String branchAddress;
}

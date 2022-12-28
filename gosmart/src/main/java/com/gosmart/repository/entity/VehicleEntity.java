package com.gosmart.repository.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
/*
 * <h2>VehicleEntity</h2>
 *  This entity class maps to Vehicle_Tl 
 *  @author Devendra
 *  @version 1.0
 *  @Since 2022-12-17
 *  */
@Entity
@Table(name="VEHICLE_TL")
@Data
public class VehicleEntity {
   //primary key
   @Id
   @GeneratedValue
   @Column(name="VEHICLE_ID")
   private Integer vehicleId;
   @Column(name="VEHICLE_TYPE_ID")
   private Integer vehicleTypeId;
   //Name of the vehicle
   @Column(name="VEHICLE_NAME")
   private String vehicleName;
   //status of the vehicle
   @Column(name="VEHICLE_STATUS")
   private String vehicleStatus;
   //Model of the vehicle
   @Column(name="VEHICLE_MODEL")
   private String vehicleModel;
   //Description of the vehicle 
   @Column(name="VEHICLE_DESCRIPTION")
   private String vehicleDescription;
   //created on of the vehicle
   @Column(name="CREATED_ON")
   private Date createdOn;
   @Column(name="CREATED_BY")
   //created by of the vehicle
   private Integer createdBy; 
}

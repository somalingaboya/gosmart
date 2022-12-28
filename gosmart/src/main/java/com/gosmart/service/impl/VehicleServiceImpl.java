package com.gosmart.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gosmart.constants.VehicleConstants;
import com.gosmart.exception.GoSmartException;
import com.gosmart.repository.VehicleRepository;
import com.gosmart.repository.entity.VehicleEntity;
import com.gosmart.service.VehicleService;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class VehicleServiceImpl implements VehicleService {
   @Autowired
   private VehicleRepository vehicleRepositary;
   @Override
   /*
    * This method is used for the insertVehicle
    * @param vehicleEntity  This is the Parameter to insertVehicle()
    * @return Integer this returns vehicleId
    * */
   public Integer insertVehicle(VehicleEntity vehicleEntity) {
      Integer vehicleId=0;
      log.info("{}-ServiceImpl insertVehicle() Started",VehicleConstants.VEHICLE);
      try {
         log.info("{}-ServiceImpl insertVehicle() saving Vehicle",VehicleConstants.VEHICLE);
         VehicleEntity vehicleEntity2=vehicleRepositary.save(vehicleEntity);
         if(vehicleEntity2!=null)
         {
            vehicleId=vehicleEntity2.getVehicleId();
         }
      } catch (Exception e) {
         log.error("{}-ServiceImpl-insertVehicle()-exception occured-{}",VehicleConstants.VEHICLE,e.getMessage());
         throw new GoSmartException(e.getMessage());  
      }
      return vehicleId;
   }
}

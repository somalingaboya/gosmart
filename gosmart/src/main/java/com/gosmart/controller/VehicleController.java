package com.gosmart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gosmart.constants.VehicleConstants;
import com.gosmart.repository.entity.VehicleEntity;
import com.gosmart.service.VehicleService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/v1")
public class VehicleController {
   @Autowired
   private VehicleService vehicleService;
   @PostMapping("/;vehicle/save")
   public ResponseEntity<Integer> insertVehicle(@RequestBody VehicleEntity vehicleEntity)
   {
      log.info("{}-Controller insertVehicle() Started",VehicleConstants.VEHICLE);
      try {
         log.info("{}-Controller insertVehicle() saving Vehicle",VehicleConstants.VEHICLE);
         Integer vehicleId=vehicleService.insertVehicle(vehicleEntity);
         
         return new ResponseEntity<>(vehicleId,HttpStatus.CREATED);
         
      } catch (Exception e) {
         log.error("{}-Controller-insertVehicle()-exception occured-{}",VehicleConstants.VEHICLE,e.getMessage());
         return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
      }
   }   
}

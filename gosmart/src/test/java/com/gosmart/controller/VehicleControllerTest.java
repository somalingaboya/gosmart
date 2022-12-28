package com.gosmart.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gosmart.exception.GoSmartException;
import com.gosmart.repository.entity.VehicleEntity;
import com.gosmart.service.VehicleService;

@RunWith(SpringJUnit4ClassRunner.class)
public class VehicleControllerTest {
   @InjectMocks
   private VehicleController vehicleController;
   @Mock
   private VehicleService service;
   @Test
   public void testInsertVehicle() throws Exception
   {
      VehicleEntity vehicleEntity=new VehicleEntity();
      Integer vehicleId=1;
      when(service.insertVehicle(vehicleEntity)).thenReturn(vehicleId);
      ResponseEntity<Integer> response=vehicleController.insertVehicle(vehicleEntity);
      assertEquals(HttpStatus.CREATED, response.getStatusCode());
   }
   @Test
   public void testInsertVehicle_Exception() throws Exception
   {
      VehicleEntity vehicleEntity=new VehicleEntity();
      when(service.insertVehicle(vehicleEntity)).thenThrow(NullPointerException.class);
      ResponseEntity<Integer> response=vehicleController.insertVehicle(vehicleEntity);
      assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
   }
}

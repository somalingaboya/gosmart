package com.gosmart.service.impl;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gosmart.exception.GoSmartException;
import com.gosmart.repository.VehicleRepository;
import com.gosmart.repository.entity.VehicleEntity;

@RunWith(SpringJUnit4ClassRunner.class)
public class VehicleServiceImplTest {
   @InjectMocks
   private VehicleServiceImpl service;
   @Mock
   private VehicleRepository repository;
   @Test
   public void testInsertVehicle()throws Exception
   {
      VehicleEntity vehicleEntity=new VehicleEntity();
      VehicleEntity vehicleEntity2=Mockito.any();
      when(repository.save(vehicleEntity)).thenReturn(vehicleEntity2);
      Integer vehicleId=service.insertVehicle(vehicleEntity);
      assertNotNull(vehicleId);
      
   } 
   @Test(expected = GoSmartException.class)
   public void testInsertVehicle_Exception()throws Exception
   {
      VehicleEntity vehicleEntity=new VehicleEntity();
      VehicleEntity vehicleEntity2=Mockito.any();
      when(repository.save(vehicleEntity)).thenThrow(NullPointerException.class);
      service.insertVehicle(vehicleEntity);
   } 
   }

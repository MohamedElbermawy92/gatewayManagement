package com.starter.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.starter.ExceptionHandler.ConflictException;
import com.starter.ExceptionHandler.GatewayMaxNumberException;
import com.starter.ExceptionHandler.NotFoundException;
import com.starter.entities.GatewayDevice;
import com.starter.entities.PeripheralDevice;
import com.starter.repositry.DeviceRepo;
import com.starter.repositry.GatewayRepo;

@Service
public class DeviceService {

	@Autowired
	private DeviceRepo deviceReop;
	
	@Autowired
	private GatewayRepo gatewayRepo;
	
public PeripheralDevice addDevice(int id , PeripheralDevice device){
		
		
		Optional<GatewayDevice> gateway = gatewayRepo.findById(id);
		if(gateway != null){
			int deviceNumber = gateway.get().getPeripheralDeviceList().size();
			if(deviceNumber<10)
			{
				device.setGateway(gateway.get());
				if(deviceReop.findByUid(device.getUID())== null)
					deviceReop.save(device);
				else
					throw new ConflictException("this device already exist in database!!!");
			}
			else{
				throw new GatewayMaxNumberException("this gateway serial number "+id+"  have 10 devices");
			}
		}
		else{
			throw new NotFoundException("this gateway serial number "+id+"  doesn't exist");
		}
		
		return device;
	}
}

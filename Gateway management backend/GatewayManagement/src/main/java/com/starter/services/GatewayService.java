package com.starter.services;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.starter.ExceptionHandler.ConflictException;
import com.starter.ExceptionHandler.GatewayMaxNumberException;
import com.starter.ExceptionHandler.NotFoundException;
import com.starter.ExceptionHandler.PatternException;
import com.starter.entities.GatewayDevice;
import com.starter.entities.PeripheralDevice;
import com.starter.repositry.DeviceRepo;
import com.starter.repositry.GatewayRepo;

@Service
public class GatewayService {


	@Autowired
	private GatewayRepo gatewayRepo;
	
	
	
	public GatewayDevice addGatewayDevice(GatewayDevice gatewayDevice){
		
		if(gatewayRepo.findBySerialNumber(gatewayDevice.getSerialNumber())== null)
			gatewayRepo.save(gatewayDevice);
		else
			throw new ConflictException("this gateway already exist in database!!!");
		
		return gatewayDevice;
	}
	
	public List<GatewayDevice> findAllGatewayDeviced(){
		
		List<GatewayDevice> gatewayList = gatewayRepo.findAll();
		if(gatewayList != null && gatewayList.size()>0)
			return gatewayList;
		else
			throw new NotFoundException("There is no gateway devices found");

			
	}
	
	public GatewayDevice getGatewayDevice(int id){
		
		Optional<GatewayDevice> result = gatewayRepo.findById(id);
		return result.get(); 
	}
	
	public void deleteGatewayDevice(int id){
		
		gatewayRepo.deleteById(id);
	}
	
	

	
	 
}

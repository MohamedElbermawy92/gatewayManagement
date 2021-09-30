package com.starter.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.starter.entities.GatewayDevice;
import com.starter.entities.PeripheralDevice;
import com.starter.services.DeviceService;
import com.starter.services.GatewayService;

@RestController
@RequestMapping("/api")
@Api(tags ={"Apis"})
public class Controller {

	@Autowired
	GatewayService gatewayService;
	
	@Autowired
	DeviceService deviceService;
	
	@ApiOperation("Add Gateway")
	@PostMapping(value={"/addGateway"})
	public ResponseEntity<GatewayDevice> addGatewayDevice(@Valid @RequestBody GatewayDevice gatewayDevice){
	
		GatewayDevice result = gatewayService.addGatewayDevice(gatewayDevice);
		return new ResponseEntity<>(result,HttpStatus.CREATED);
	}
	
	@ApiOperation("Find All Gateway Device")
	@GetMapping(value={"/findallgateway"})
	public ResponseEntity<List<GatewayDevice>> findAllGateways(){
	
		List<GatewayDevice> result = gatewayService.findAllGatewayDeviced();
		return new ResponseEntity<>(result , HttpStatus.OK);
	}

	
	@ApiOperation("Find Gateway Device By Id")
	@GetMapping(value={"/findgateway/{id}"})
	public ResponseEntity<List<PeripheralDevice>> findGatewaysById(@PathVariable int id){
	
		List<PeripheralDevice> result = gatewayService.getGatewayDevice(id).getPeripheralDeviceList();
		return new ResponseEntity<>(result , HttpStatus.OK);
	}
	
	@ApiOperation("Delete Gateway Device")
	@DeleteMapping(value={"/deletegateway/{id}"})
	public ResponseEntity<String> deleteGateways(@PathVariable int id){
	
		 gatewayService.deleteGatewayDevice(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@ApiOperation("Add Device")
	@PostMapping(value={"/addDevice"},  produces = "application/json")
	public ResponseEntity<PeripheralDevice> addDevice(@RequestBody Map<String, Object> payload){
			
		 ObjectMapper mapper = new ObjectMapper(); // jackson's objectmapper
		 PeripheralDevice peripheralDevice = mapper.convertValue(payload.get("device"), PeripheralDevice.class);
		 PeripheralDevice result = deviceService.addDevice((int)payload.get("id") ,peripheralDevice);
		return new ResponseEntity<>(result , HttpStatus.OK);
	}

	
}

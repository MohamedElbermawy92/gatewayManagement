package com.starter.services;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JsonObject {

	
	@JsonProperty("getwayID")
	private int gatewayId;
	
	@JsonProperty("device")
	private int device;

	public int getGatewayId() {
		return gatewayId;
	}

	public void setGatewayId(int gatewayId) {
		this.gatewayId = gatewayId;
	}

	public int getDevice() {
		return device;
	}

	public void setDevice(int device) {
		this.device = device;
	}
	
	
	
}

package com.starter.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.starter.entities.GatewayDevice;

@Repository
public interface GatewayRepo extends JpaRepository<GatewayDevice, Integer> {

	public GatewayDevice findBySerialNumber(String serialNumber);
}

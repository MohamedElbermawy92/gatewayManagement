package com.starter.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.starter.entities.PeripheralDevice;

@Repository
public interface DeviceRepo extends JpaRepository<PeripheralDevice, Integer> {

	public PeripheralDevice findByUid(int UID);

}

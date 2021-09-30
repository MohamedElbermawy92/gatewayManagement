package com.starter.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Entity
@Data
@Table(name = "Gateway_Device")
public class GatewayDevice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name ="serial_number",unique=true, nullable = false)
	private String serialNumber;
	
	@Column(name = "human_readable_name")
	private String humanName;
	
	@Pattern(regexp = "^[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}$")	
	@Column(name="IPv4_address")
	private String IPv4Address;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "gateway",
			cascade= CascadeType.ALL)
	private List<PeripheralDevice> PeripheralDeviceList;
	
	
	
	public List<PeripheralDevice> getPeripheralDeviceList() {
		return PeripheralDeviceList;
	}
	public void setPeripheralDeviceList(List<PeripheralDevice> peripheralDeviceList) {
		PeripheralDeviceList = peripheralDeviceList;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getHumanName() {
		return humanName;
	}
	public void setHumanName(String humanName) {
		this.humanName = humanName;
	}
	public String getIPv4Address() {
		return IPv4Address;
	}
	public void setIPv4Address(String iPv4Address) {
		IPv4Address = iPv4Address;
	}

	
	
	
}

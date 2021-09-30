package com.starter.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name = "peripheral_device")
@Data
public class PeripheralDevice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "UID")
	private int uid;
	
	@Column(name = "Vendor")
	private String vendor;
	
	@Column(name="date")
	private Date date;
	
	@Column(name = "status")
	private String status;
	
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name = "gateway_id")
	@JsonIgnore
	private GatewayDevice gateway;
	
	public int getUID() {
		return uid;
	}
	public void setUID(int uid) {
		uid = uid;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public GatewayDevice getGateway() {
		return gateway;
	}
	public void setGateway(GatewayDevice gateway) {
		this.gateway = gateway;
	}
	
	
}

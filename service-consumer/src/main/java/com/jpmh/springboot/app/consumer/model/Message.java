package com.jpmh.springboot.app.consumer.model;

import java.util.Date;

public class Message {

	private String registration;
	private VehicleType vehicleType;
	private Integer speed;
	private Date dateTime;
	
	public Message() {
	}

	public Message(String registration, VehicleType vehicleType, Integer speed, Date dateTime) {
		this.registration = registration;
		this.vehicleType = vehicleType;
		this.speed = speed;
		this.dateTime = dateTime;
	}

	public String getRegistration() {
		return registration;
	}

	public void setRegistration(String registration) {
		this.registration = registration;
	}

	public VehicleType getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}

	public Integer getSpeed() {
		return speed;
	}

	public void setSpeed(Integer speed) {
		this.speed = speed;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	@Override
	public String toString() {
		return String.format("Message{registration=%s, vehicleType=%s, speed=%s; dateTime=%s,}", getRegistration(), getVehicleType(), getSpeed(), getDateTime());
	}
	
}

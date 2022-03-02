package com.jpmh.springboot.app.publisher.model;

import org.apache.commons.lang3.RandomStringUtils;
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

	public Message(Builder builder) {
		this.registration = builder.registration;
		this.vehicleType = builder.vehicleType;
		this.speed = builder.speed;
		this.dateTime = builder.dateTime;
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


	/**
	 * The builder class.
	 */
	public static class Builder {
		private String registration;
		private VehicleType vehicleType;
		private Integer speed;
		private Date dateTime;

		public Builder() {

		}
		public Builder registration(String registration) {
			this.registration = registration;
			return this;
		}
		public Builder vehicleType(VehicleType vehicleType) {
			this.vehicleType = vehicleType;
			return this;
		}
		public Builder speed(Integer speed) {
			this.speed = speed;
			return this;
		}
		public Builder dateTime(Date dateTime) {
			this.dateTime = dateTime;
			return this;
		}

		public Builder random() {
			this.registration = RandomStringUtils.random(10, true, true);;
			this.vehicleType = VehicleType.values()[((int) (Math.random() * VehicleType.values().length))];
			this.speed = (int) (Math.random() * 200);
			this.dateTime = new Date();
			return this;
		}
	}
}
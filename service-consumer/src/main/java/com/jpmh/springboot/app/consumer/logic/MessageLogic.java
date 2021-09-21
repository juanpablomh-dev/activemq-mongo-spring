package com.jpmh.springboot.app.consumer.logic;

import com.jpmh.springboot.app.consumer.gral.Properties;
import com.jpmh.springboot.app.consumer.model.Message;
import com.jpmh.springboot.app.consumer.model.VehicleType;


public class MessageLogic {
	private Message message;
	
	public MessageLogic(Message message) {
		this.message = message;
	}
	
	
	public boolean trafficViolation() {
		if((message.getVehicleType()==VehicleType.MOTORCYCLE) && (message.getSpeed() >= Properties.K_MOTORCYCLE_SPEED_LIMIT)) {
			return true;
		}		
		if((message.getVehicleType()==VehicleType.CAR) && (message.getSpeed() >= Properties.K_CAR_SPEED_LIMIT)) {
			return true;
		}
		if((message.getVehicleType()==VehicleType.PICKUP) && (message.getSpeed() >= Properties.K_PICKUP_SPEED_LIMIT)) {
			return true;
		}	
		if((message.getVehicleType()==VehicleType.TRUCK) && (message.getSpeed() >= Properties.K_TRUCK_SPEED_LIMIT)) {
			return true;
		}			
		return false;
	}	
}

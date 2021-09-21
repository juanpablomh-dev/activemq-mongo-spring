package com.jpmh.springboot.app.consumer.logic;

import org.apache.commons.lang3.RandomStringUtils;
import com.jpmh.springboot.app.consumer.model.Message;
import com.jpmh.springboot.app.consumer.model.Ticket;
import com.jpmh.springboot.app.consumer.model.VehicleType;

public class TicketGenerator{

	private Message message;
	
	public TicketGenerator(Message message) {
		this.message = message;
	}

	public Ticket generateTicket() {
		Ticket ticket = new Ticket();
		ticket.setId(RandomStringUtils.random(10, false, true));
		ticket.setRegistration(message.getRegistration());
		ticket.setConcept("Ticket for exceeding speed limit");
		ticket.setAmount(calculateAmount());
		ticket.setPaid(false);
		return ticket;
	}
	
	private Double calculateAmount() {
		if(message.getVehicleType()==VehicleType.MOTORCYCLE) {
			return 1000.0;
		}
		if(message.getVehicleType()==VehicleType.CAR) {
			return 2000.0;
		}
		if(message.getVehicleType()==VehicleType.PICKUP) {
			return 2500.0;
		}
		if(message.getVehicleType()==VehicleType.TRUCK) {
			return 4000.0;
		}
		return 0.0;
	}
}

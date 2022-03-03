package com.jpmh.springboot.app.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import com.jpmh.springboot.app.consumer.domain.gral.Properties;
import com.jpmh.springboot.app.consumer.domain.logic.TicketGenerator;
import com.jpmh.springboot.app.consumer.domain.Message;
import com.jpmh.springboot.app.consumer.persistence.service.TicketService;

@Component
public class Receiver {
	
	@Autowired
	private TicketService ticketService;
	
	@JmsListener(destination = Properties.K_QUEUE, containerFactory = Properties.K_FACTORY)
	public void receiveMessage(Message message) {
		if(message.exceedSpeedLimit()) {
			ticketService.save((new TicketGenerator(message)).generateTicket());
		}
	}
}

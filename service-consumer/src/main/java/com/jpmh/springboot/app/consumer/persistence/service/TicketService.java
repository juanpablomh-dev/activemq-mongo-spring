package com.jpmh.springboot.app.consumer.persistence.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jpmh.springboot.app.consumer.domain.Ticket;
import com.jpmh.springboot.app.consumer.persistence.repository.TicketRepository;

@Service
public class TicketService implements ITicketService{
	
	@Autowired
	private TicketRepository ticketRepository;

	@Override
	public List<Ticket> findAll() {
		return ticketRepository.findAll();
	}

	@Override
	public Optional<Ticket> findById(String id) {
		return ticketRepository.findById(id);
	}

	@Override
	public Ticket save(Ticket t) {
		return ticketRepository.save(t);
	}
	 
}

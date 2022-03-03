package com.jpmh.springboot.app.consumer.persistence.service;

import java.util.List;
import java.util.Optional;
import com.jpmh.springboot.app.consumer.domain.Ticket;

public interface ITicketService {
	public List<Ticket>findAll();
	public Optional<Ticket>findById(String id);
	public Ticket save(Ticket t);
}

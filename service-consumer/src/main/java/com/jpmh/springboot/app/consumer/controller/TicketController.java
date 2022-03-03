package com.jpmh.springboot.app.consumer.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpmh.springboot.app.consumer.model.Ticket;
import com.jpmh.springboot.app.consumer.service.TicketService;

@RestController
@RequestMapping("/tickets")
public class TicketController {
 
	@Autowired
	private TicketService service;
	
	@GetMapping()
	public List<Ticket> findAll() {
		return service.findAll();
	}
	
	@GetMapping(path = "/{id}")
	public Optional<Ticket> findById(@PathVariable("id") String id) {
		return service.findById(id);
	}
	
}

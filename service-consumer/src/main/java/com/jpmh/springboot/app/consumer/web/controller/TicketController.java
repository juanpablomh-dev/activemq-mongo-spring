package com.jpmh.springboot.app.consumer.web.controller;

import java.util.List;
import java.util.Optional;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpmh.springboot.app.consumer.domain.Ticket;
import com.jpmh.springboot.app.consumer.persistence.service.TicketService;

@RestController
@RequestMapping("/tickets")
public class TicketController {
 
	@Autowired
	private TicketService service;
	
	@GetMapping()
	@ApiOperation("Get all generated tickets")
	@ApiResponse(code = 200, message = "OK")
	public ResponseEntity findAll() {
		return new ResponseEntity(service.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(path = "/{id}")
	@ApiOperation("Get a ticket whit an ID")
	@ApiResponses({
			@ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 404, message = "Ticket not found")
	})
	public ResponseEntity<Ticket> findById(
			@ApiParam(value = "The id of de ticket", required = true, example = "4858440184")
			@PathVariable("id") String id
	) {
		return service.findById(id)
				.map(ticket -> new ResponseEntity<>(ticket, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
}

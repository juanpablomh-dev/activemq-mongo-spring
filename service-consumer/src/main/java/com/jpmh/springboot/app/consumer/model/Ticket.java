package com.jpmh.springboot.app.consumer.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tickets")
public class Ticket {

	@Id
	private String id;
	private String registration;
	private String concept;
	private Double amount;
	private Boolean paid;
	
	public Ticket() {}

	public Ticket(String id, String registration, String concept, Double amount, Boolean paid) {
		this.id = id;
		this.registration = registration;
		this.concept = concept;
		this.amount = amount;
		this.paid = paid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRegistration() {
		return registration;
	}

	public void setRegistration(String registration) {
		this.registration = registration;
	}

	public String getConcept() {
		return concept;
	}

	public void setConcept(String concept) {
		this.concept = concept;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Boolean getPaid() {
		return paid;
	}

	public void setPaid(Boolean paid) {
		this.paid = paid;
	}
	
	@Override
	public String toString() {
		return String.format("Ticket{id=%s}", getId());
	}
		
	
	
}

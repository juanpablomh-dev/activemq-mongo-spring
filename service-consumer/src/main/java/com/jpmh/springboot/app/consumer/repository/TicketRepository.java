package com.jpmh.springboot.app.consumer.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


import com.jpmh.springboot.app.consumer.model.Ticket;

@Repository
public interface TicketRepository extends MongoRepository<Ticket, String> {

}

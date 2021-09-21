package com.jpmh.springboot.app.publisher.logic;

import org.springframework.jms.core.JmsTemplate;

public interface IDataGenerator {
	
	public void generateData(JmsTemplate jmsTemplate);
	
}

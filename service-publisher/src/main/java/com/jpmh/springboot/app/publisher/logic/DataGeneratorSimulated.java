package com.jpmh.springboot.app.publisher.logic;

import org.springframework.jms.core.JmsTemplate;
import com.jpmh.springboot.app.publisher.gral.Properties;
import com.jpmh.springboot.app.publisher.model.Message;

import java.util.stream.IntStream;

// ------------------------------------------------------------
// -- Simulates the information obtained by a traffic sensor --
// ------------------------------------------------------------

public class DataGeneratorSimulated implements IDataGenerator{
    
    public DataGeneratorSimulated() {	
    }

	@Override
	public void generateData(JmsTemplate jmsTemplate) {
		IntStream.range(0, 5000).forEach(i -> {
			System.out.println("sending ...");
			jmsTemplate.convertAndSend(Properties.K_QUEUE, createMessage());
			try {
				sleep();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
	}

	private void sleep() throws InterruptedException {
		Thread.sleep(5000);
	}

	private Message createMessage() {
		Message message = new Message();
		message.random();
		return message;
	}
}

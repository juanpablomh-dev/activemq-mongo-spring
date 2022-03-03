package com.jpmh.springboot.app.publisher.logic;

<<<<<<< HEAD
import org.springframework.jms.core.JmsTemplate;
import com.jpmh.springboot.app.publisher.gral.Properties;
import com.jpmh.springboot.app.publisher.model.Message;

import java.util.stream.IntStream;
=======
import com.google.gson.Gson;
import org.springframework.jms.core.JmsTemplate;
import com.jpmh.springboot.app.publisher.gral.Properties;
import com.jpmh.springboot.app.publisher.model.Message;
>>>>>>> 2094a9489a2b68861fa38d0a518c5fda70070aa1

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
<<<<<<< HEAD
				sleep();
=======
				System.out.println("sending ...");
				jmsTemplate.convertAndSend(Properties.K_QUEUE, getData());
				iterator+=1;
				Thread.sleep(3000);
>>>>>>> 2094a9489a2b68861fa38d0a518c5fda70070aa1
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
	}

<<<<<<< HEAD
	private void sleep() throws InterruptedException {
		Thread.sleep(5000);
	}

	private Message createMessage() {
		Message message = new Message();
		message.random();
		return message;
=======
	private String getData(){
		return new Gson().toJson(new Message.Builder().random());
>>>>>>> 2094a9489a2b68861fa38d0a518c5fda70070aa1
	}
}

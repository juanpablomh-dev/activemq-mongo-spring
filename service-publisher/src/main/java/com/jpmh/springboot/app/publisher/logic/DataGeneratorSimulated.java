package com.jpmh.springboot.app.publisher.logic;

import com.google.gson.Gson;
import org.springframework.jms.core.JmsTemplate;
import com.jpmh.springboot.app.publisher.gral.Properties;
import com.jpmh.springboot.app.publisher.model.Message;

// ------------------------------------------------------------
// -- Simulates the information obtained by a traffic sensor --
// ------------------------------------------------------------

public class DataGeneratorSimulated implements IDataGenerator{

	public DataGeneratorSimulated() {
	}

	@Override
	public void generateData(JmsTemplate jmsTemplate) {
		int iterator = 0;
		while(iterator<5000) {
			try {
				System.out.println("sending ...");
				jmsTemplate.convertAndSend(Properties.K_QUEUE, getData());
				iterator+=1;
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private String getData(){
		return new Gson().toJson(new Message.Builder().random());
	}
}

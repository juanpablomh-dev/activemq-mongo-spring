package com.jpmh.springboot.app.publisher.logic;

import java.util.Date;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.jms.core.JmsTemplate;
import com.jpmh.springboot.app.publisher.gral.Properties;
import com.jpmh.springboot.app.publisher.model.Message;
import com.jpmh.springboot.app.publisher.model.VehicleType;

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
				jmsTemplate.convertAndSend(Properties.K_QUEUE, createMessage());
				iterator+=1;
				sleep();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void sleep() throws InterruptedException {
		Thread.sleep(5000);
	}	
	
	private Message createMessage() {
		return new Message(getID(),getVehicleType(),getSpeed(),new Date());
	}	
     
	private String getID() {
		return RandomStringUtils.random(10, true, true);
	}
	
	private VehicleType getVehicleType() {
		int type = (int) (Math.random() * VehicleType.values().length);
		return VehicleType.values()[type];
	}
	
	private Integer getSpeed() {
		return (int) (Math.random() * 200);
	}


}

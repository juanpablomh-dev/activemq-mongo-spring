package com.jpmh.springboot.app.publisher;

import com.jpmh.springboot.app.publisher.gral.Properties;
import com.jpmh.springboot.app.publisher.logic.DataGeneratorSimulated;
import com.jpmh.springboot.app.publisher.logic.IDataGenerator;
import com.jpmh.springboot.app.publisher.model.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import java.util.HashMap;
import java.util.Map;

@EnableJms
@SpringBootApplication
public class ServicePublisherApplication {
    private static final Logger logger = LoggerFactory.getLogger(ServicePublisherApplication.class);

<<<<<<< HEAD
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(ServicePublisherApplication.class, args);
        publisher(context);
	}

    private static void publisher(ConfigurableApplicationContext context) {
=======
    private static final Logger logger = LoggerFactory.getLogger(ServicePublisherApplication.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ServicePublisherApplication.class, args);
        sendDataToBroker(context);
    }

    private static void sendDataToBroker(ConfigurableApplicationContext context) {
>>>>>>> 2094a9489a2b68861fa38d0a518c5fda70070aa1
        logger.info("Sending message to Broker...");
        JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);
        IDataGenerator data = new DataGeneratorSimulated();
        data.generateData(jmsTemplate);
    }

    @Bean
    public MessageConverter jacksonJmsMessageConverter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        Map<String, Class<?>> typeIdMappings = new HashMap<String, Class<?>>();
        typeIdMappings.put(Properties.K_ID_MAPPINGS, Message.class);
        converter.setTypeIdMappings(typeIdMappings);
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName(Properties.K_ID_MAPPINGS);
        return converter;
    }
}

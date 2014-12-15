package ru.udm.jms.subscribes;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class DurableSubscriber implements MessageListener{

	private static Logger LOGGER = LoggerFactory
			.getLogger(DurableSubscriber.class);
	
	@Override
	public void onMessage(Message message){
		if (message instanceof TextMessage) {
			try {
				LOGGER.debug("Durable subscriber: {}",((TextMessage) message).getText());
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
	}
}

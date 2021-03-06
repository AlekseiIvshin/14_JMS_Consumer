package ru.udm.jms.subscribes;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import ru.udm.jms.queue.HelloMessageListner;

@Component
public class Subscriber implements MessageListener{
	
	private static Logger LOGGER = LoggerFactory
			.getLogger(HelloMessageListner.class);

	@Override
	public void onMessage(Message message) {
		if (message instanceof TextMessage) {
			try {
				LOGGER.debug("Subscriber: {}",((TextMessage) message).getText());
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
	}
}

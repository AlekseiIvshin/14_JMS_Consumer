package ru.udm.jms.queue;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class HelloMessageListner implements MessageListener {
	private static Logger LOGGER = LoggerFactory
			.getLogger(HelloMessageListner.class);

	@Override
	public void onMessage(Message message) {
		if (message instanceof TextMessage) {
			String value = null;
			try {
				value = ((TextMessage) message).getText();
			} catch (JMSException e) {
				LOGGER.error("Get message text error", e);
			}
			LOGGER.debug("QueueListner: {}", value);
		}
	}

}

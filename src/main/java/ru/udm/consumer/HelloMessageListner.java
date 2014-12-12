package ru.udm.consumer;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class HelloMessageListner implements MessageListener {

	@Override
	public void onMessage(Message message) {
		if (message instanceof TextMessage) {
			try {
				System.out.println(((TextMessage) message).getText());
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
	}

}

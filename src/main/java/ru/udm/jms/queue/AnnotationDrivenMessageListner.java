package ru.udm.jms.queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class AnnotationDrivenMessageListner {
	private static Logger LOGGER = LoggerFactory
			.getLogger(AnnotationDrivenMessageListner.class);

	@JmsListener(destination = "HelloQueue")
	public void processMessage(String message){
		LOGGER.debug("Annotation driven listner recieve: ",message);
	}
}

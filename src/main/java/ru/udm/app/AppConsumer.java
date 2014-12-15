package ru.udm.app;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppConsumer {

	private static Logger LOGGER = LoggerFactory.getLogger(AppConsumer.class);
	private ApplicationContext context;

	public static void main(String[] args) {
		director(new AppConsumer());
	}

	public void init() {
		context = new ClassPathXmlApplicationContext("beans.xml");
	}

	public void close() {
		if (context != null) {
			((AbstractApplicationContext) context).close();
		}
	}

	public static void director(AppConsumer app) {
		app.init();
		try (Scanner sc = new Scanner(System.in)) {
			String line = "";
			while ((line = sc.next()) != null && !line.isEmpty()) {
				switch (line) {
				case "exit":
					app.close();
					LOGGER.debug("AppConsumer closed");
					System.exit(1);
					break;
				default:
					break;
				}
			}
		}
	}
}

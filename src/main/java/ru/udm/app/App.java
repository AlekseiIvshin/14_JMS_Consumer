package ru.udm.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ru.udm.consumer.HelloMessageListner;


public class App {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		ctx.getBean(HelloMessageListner.class);
	}

}

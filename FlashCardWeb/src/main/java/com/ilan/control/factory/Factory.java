package com.ilan.control.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Factory {
	private static ApplicationContext factory = new ClassPathXmlApplicationContext(
			"applicationContext.xml");

	public static IFactory getFactory(String id, Class<? extends IFactory> clazz) {

		return (IFactory) factory.getBean(clazz);
	}
}

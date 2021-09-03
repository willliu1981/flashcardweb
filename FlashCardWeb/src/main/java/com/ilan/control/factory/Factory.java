package com.ilan.control.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ilan.control.config.Config;

public class Factory {

	private static ApplicationContext factory = new ClassPathXmlApplicationContext(
			IFactory.config.getFactory());

	public static IFactory getFactory(String id, Class<? extends IFactory> clazz) {

		return (IFactory) factory.getBean(clazz);
	}
}

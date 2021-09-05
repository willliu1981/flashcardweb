package com.ilan.control.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ilan.appinitialization.Config;

public class FactoryBuilder {

	private static ApplicationContext factory = new ClassPathXmlApplicationContext(
			Config.config.getFactoryXml());

	public static IFactory getFactory(String id, Class<? extends IFactory> clazz) {

		return (IFactory) factory.getBean(clazz);
	}
}

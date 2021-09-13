package com.flashcard.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanFactory {

	private static ApplicationContext factory = null;

	private static ApplicationContext getFactory() {
		if (factory == null) {
			factory = new ClassPathXmlApplicationContext(
					Factory.getBeansXmlReferers());
		}
		return factory;
	}

	public static <T> T getBean(String id, Class<? extends T> clazz) {
		return (T) getFactory().getBean(id, clazz);
	}

	public static <T> T getBean(IFactoryType<T> type) {
		return (T) getFactory().getBean(type.getId(), type.getClassType());
	}

	public static ApplicationContext getApplicationContext(String xmlName) {
		return new ClassPathXmlApplicationContext(xmlName);
	}

}

package com.flashcard.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanFactory {

	private static ApplicationContext factory = new ClassPathXmlApplicationContext(
			Factory.getBeansXmlReferers());

	public static <T> T getBean(String id, Class<? extends T> clazz) {
		return (T) factory.getBean(id, clazz);
	}

	public static <T> T getBean(IFactoryType<T> type) {
		return (T) factory.getBean(type.getId(), type.getClassType());
	}
	

	
}

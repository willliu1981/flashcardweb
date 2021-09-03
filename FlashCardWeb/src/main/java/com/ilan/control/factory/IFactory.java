package com.ilan.control.factory;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ilan.control.config.Config;

public interface IFactory {
	public static Config config = new ClassPathXmlApplicationContext("config/config.xml")
			.getBean(Config.class);

}

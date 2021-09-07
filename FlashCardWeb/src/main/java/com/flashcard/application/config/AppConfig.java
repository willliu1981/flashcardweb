package com.flashcard.application.config;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppConfig {

	public static AppConfig config = null;
	private static FactoryConfig factoryConfig;

	private String thisConfigXml;

	public static void init(String configXml) {
		config = new ClassPathXmlApplicationContext(configXml).getBean(AppConfig.class);
		config.setThisConfigXml(configXml);
	}

	private AppConfig() {
	}

	public String getThisConfigXml() {
		return thisConfigXml;
	}

	private void setThisConfigXml(String thisXml) {
		this.thisConfigXml = thisXml;
	}

	public static FactoryConfig getFactoryConfig() {
		return factoryConfig;
	}

	public void setFactoryConfig(FactoryConfig factoryConfig) {
		AppConfig.factoryConfig = factoryConfig;
	}

}

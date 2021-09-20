package com.flashcard.factory;

import com.flashcard.application.config.AppConfig;

public class Factory {
	public static String [] getBeansXmlReferers() {
		return AppConfig.getFactoryConfig().getBeansXmlReferers();
	}
	
	public static String getConfigXmlPath() {
		return AppConfig.config.getThisConfigXml();
	}
	
	public static String getSessionName(String key) {
		return AppConfig.getFactoryConfig().getSessionName(key);
	}
}

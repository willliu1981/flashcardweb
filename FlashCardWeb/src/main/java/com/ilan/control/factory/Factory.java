package com.ilan.control.factory;

import com.flashcard.application.config.AppConfig;

public class Factory {
	public static String [] getBeansXmlReferers() {
		return AppConfig.getFactoryConfig().getBeansXmlReferers();
	}
}

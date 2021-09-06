package com.ilan.control.factory;

import com.ilan.appinitialization.AppConfig;

public class Factory {
	public static String [] getBeansXmlReferers() {
		return AppConfig.getFactoryConfig().getBeansXmlReferers();
	}
}

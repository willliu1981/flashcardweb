package com.ilan.control.factory;

import com.ilan.appinitialization.Config;

public class Factory {
	public static String [] getBeansXmlReferers() {
		return Config.getFactoryConfig().getBeansXmlReferers();
	}
}

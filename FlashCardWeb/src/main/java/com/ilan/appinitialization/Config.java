package com.ilan.appinitialization;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ilan.appinitialization.factory.FactoryConfig;

public class Config {

	public static Config config = null;
	private static FactoryConfig factoryConfig;

	private String thisConfigXml;
	private String factoryXml;
	private String daoFactoryXml;
	private String connectionXml;


	public static void init(String configXml) {
		config = new ClassPathXmlApplicationContext(configXml).getBean(Config.class);
		config.setThisConfigXml(configXml);
	}

	private Config() {
	}

	public String getThisConfigXml() {
		return thisConfigXml;
	}

	private void setThisConfigXml(String thisXml) {
		this.thisConfigXml = thisXml;
	}

	public String getFactoryXml() {
		return factoryXml;
	}

	public void setFactoryXml(String factoryXml) {
		this.factoryXml = factoryXml;
	}

	public String getDaoFactoryXml() {
		return daoFactoryXml;
	}

	public void setDaoFactoryXml(String daoFactoryXml) {
		this.daoFactoryXml = daoFactoryXml;
	}

	public String getConnectionXml() {
		return connectionXml;
	}

	public void setConnectionXml(String connectionXml) {
		this.connectionXml = connectionXml;
	}

	public static FactoryConfig getFactoryConfig() {
		return factoryConfig;
	}

	public  void setFactoryConfig(FactoryConfig factoryConfig) {
		Config.factoryConfig = factoryConfig;
	}



}

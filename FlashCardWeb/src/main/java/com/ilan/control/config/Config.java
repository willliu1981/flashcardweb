package com.ilan.control.config;

import javax.sql.DataSource;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Config {
	public static Config config = null;

	private String factoryXml;
	private String daoFactoryXml;
	private String connectionXml;


	public static void init(String configXml) {
		config = new ClassPathXmlApplicationContext(configXml).getBean(Config.class);
	}

	private Config() {
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



}

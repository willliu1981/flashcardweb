package com.ilan.control.config;

public class Config {

	private String factory;
	private String daoFactory;
	
	private Config() {}

	public String getFactory() {
		return factory;
	}

	public void setFactory(String factory) {
		this.factory = factory;
	}

	public String getDaoFactory() {
		return daoFactory;
	}

	public void setDaoFactory(String daoFactory) {
		this.daoFactory = daoFactory;
	}

}

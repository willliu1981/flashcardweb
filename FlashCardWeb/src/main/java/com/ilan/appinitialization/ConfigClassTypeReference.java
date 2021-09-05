package com.ilan.appinitialization;

public class ConfigClassTypeReference<T> {
	private String name;
	private Class<T> classType;

	public ConfigClassTypeReference(String name, Class<T> classType) {
		this.name = name;
		this.classType = classType;
	}

	public String getName() {
		return name;
	}

	public Class<T> getClassType() {
		return classType;
	}

}

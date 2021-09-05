package com.ilan.appinitialization;

public class ConfigClassTypeReference<T> {
	private String id;
	private Class<? extends T> classType;

	public ConfigClassTypeReference(String id, Class<? extends T> classType) {
		this.id = id;
		this.classType = classType;
	}

	public String getId() {
		return id;
	}

	public Class<? extends T> getClassType() {
		return classType;
	}

}
